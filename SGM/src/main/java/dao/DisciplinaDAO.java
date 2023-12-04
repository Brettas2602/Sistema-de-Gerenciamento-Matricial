package dao;

import java.util.List;

import org.hibernate.Transaction;

import bean.Disciplina;

public class DisciplinaDAO {
	
	public void insert(Disciplina disciplina) {
		Transaction transaction = DAOFactory.getSession().beginTransaction();
		DAOFactory.getSession().persist(disciplina);
		transaction.commit();
		DAOFactory.closeSession();
	}
	
	public void update(Disciplina disciplina) {
		Transaction transaction = DAOFactory.getSession().getTransaction();
		transaction.begin();
		Disciplina update = DAOFactory.getSession().get(Disciplina.class, disciplina.getId());
		update.setCodigo(disciplina.getCodigo());
		update.setNome(disciplina.getNome());
		update.setNucleo(disciplina.getNucleo());
		update.setChats_distancia(disciplina.getChats_distancia());
		update.setChats_pratica(disciplina.getChats_pratica());
		update.setChats_teorica(disciplina.getChats_teorica());
		update.setChts_distancia(disciplina.getChts_distancia());
		update.setChts_pratica(disciplina.getChts_pratica());
		update.setChts_teorica(disciplina.getChts_teorica());
		DAOFactory.getSession().merge(update);
		transaction.commit();
		DAOFactory.closeSession();
	}
	
	public void delete(int id) {
		Transaction transaction = DAOFactory.getSession().getTransaction();
		transaction.begin();
		Disciplina delete = DAOFactory.getSession().get(Disciplina.class, id);
		DAOFactory.getSession().remove(delete);
		transaction.commit();
		DAOFactory.closeSession();
	}
	
	public List<Disciplina> findById(int id){
		Transaction transaction = DAOFactory.getSession().beginTransaction();
		List<Disciplina> disciplinas = DAOFactory.getSession().createQuery("FROM Disciplina WHERE id = " + id, Disciplina.class).getResultList();
		transaction.commit();
		DAOFactory.closeSession();
		return disciplinas;
	}
	
	public List<Disciplina> findAll(){
		Transaction transaction = DAOFactory.getSession().beginTransaction();
		List<Disciplina> disciplinas = DAOFactory.getSession().createQuery("FROM Disciplina", Disciplina.class).getResultList();
		transaction.commit();
		DAOFactory.closeSession();
		return disciplinas;
	}
	
	public List<Disciplina> findBySemestre(int id){
		Transaction transaction = DAOFactory.getSession().beginTransaction();
		List<Disciplina> result = DAOFactory.getSession().createQuery("SELECT iddisciplina FROM Vinculo WHERE idsemestre.id = " + id, Disciplina.class).getResultList();
		transaction.commit();
		DAOFactory.closeSession();
		return result;
	}
	
	public float findTotal(int tipoCargaHoraria, int tipoPresencial) {
		List<Disciplina> disciplinas = this.findAll();
		float total = 0;
		for (Disciplina disciplina : disciplinas) {
			switch (tipoCargaHoraria) {
				case 1:
					switch (tipoPresencial) {
						case 1:
							total += disciplina.getChats_teorica();
							break;
						
						case 2:
							total += disciplina.getChats_teorica();
							break;
					}
					break;
	
				case 2:
					switch (tipoPresencial) {
						case 1:
							total += disciplina.getChts_teorica();
							break;
						
						case 2:
							total += disciplina.getChts_teorica();
							break;
					}
					break;
			}
		}
		return total;
	}
	
	public float findTotalBySemestre(int id, int tipoCargaHoraria) {
		List<Disciplina> disciplinas = this.findBySemestre(id);
		float total = 0;
		for (Disciplina disciplina : disciplinas) {
			switch (tipoCargaHoraria) {
				case 1:
					total += disciplina.getChats_total();
					break;
	
				case 2:
					total += disciplina.getChts_total();
					break;
			}
		}
		return total;
	}
}