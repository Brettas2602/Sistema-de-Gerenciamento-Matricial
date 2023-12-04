package dao;

import java.util.List;

import org.hibernate.Transaction;

import bean.Disciplina;
import bean.Semestre;

public class SemestreDAO {

	public void insert(Semestre semestre) {
		Transaction transaction = DAOFactory.getSession().beginTransaction();
		DAOFactory.getSession().persist(semestre);
		transaction.commit();
		DAOFactory.closeSession();
	}
	
	public void update(Semestre semestre) {
		Transaction transaction = DAOFactory.getSession().getTransaction();
		transaction.begin();
		Semestre update = DAOFactory.getSession().get(Semestre.class, semestre.getId());
		update.setNumero(semestre.getNumero());
		update.setDescricao(semestre.getDescricao());
		DAOFactory.getSession().merge(update);
		transaction.commit();
		DAOFactory.closeSession();
	}
	
	public void delete(int id) {
		Transaction transaction = DAOFactory.getSession().getTransaction();
		transaction.begin();
		Semestre delete = DAOFactory.getSession().get(Semestre.class, id);
		DAOFactory.getSession().remove(delete);
		transaction.commit();
		DAOFactory.closeSession();
	}
	
	public List<Semestre> findById(int id){
		Transaction transaction = DAOFactory.getSession().beginTransaction();
		List<Semestre> semestres = DAOFactory.getSession().createQuery("FROM Semestre WHERE id = " + id, Semestre.class).getResultList();
		transaction.commit();
		DAOFactory.closeSession();
		return semestres;
	}
	
}