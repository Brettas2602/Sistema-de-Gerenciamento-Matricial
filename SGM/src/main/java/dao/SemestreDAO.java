package dao;

import org.hibernate.Transaction;

import bean.Semestre;

public class SemestreDAO {

	public void insert(Semestre semestre) {
		Transaction transaction = DAOFactory.getSession().beginTransaction();
		DAOFactory.getSession().persist(semestre);
		transaction.commit();
		DAOFactory.closeSession();
	}
	
	public void update(Semestre semestre) {
		Transaction transaction = DAOFactory.getSession().beginTransaction();
		transaction.begin();
		Semestre update = DAOFactory.getSession().get(Semestre.class, semestre.getId());
		update.setNumero(semestre.getNumero());
		update.setDescricao(semestre.getDescricao());
		DAOFactory.getSession().merge(update);
		transaction.commit();
		DAOFactory.closeSession();
	}
	
	public void delete(int id) {
		Transaction transaction = DAOFactory.getSession().beginTransaction();
		transaction.begin();
		Semestre delete = DAOFactory.getSession().get(Semestre.class, id);
		DAOFactory.getSession().remove(delete);
		transaction.commit();
		DAOFactory.closeSession();
	}
	
}