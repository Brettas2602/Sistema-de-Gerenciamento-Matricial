package dao;

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
		Transaction transaction = DAOFactory.getSession().beginTransaction();
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
		Transaction transaction = DAOFactory.getSession().beginTransaction();
		transaction.begin();
		Disciplina delete = DAOFactory.getSession().get(Disciplina.class, id);
		DAOFactory.getSession().remove(delete);
		transaction.commit();
		DAOFactory.closeSession();
	}
}