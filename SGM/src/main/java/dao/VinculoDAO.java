package dao;

import org.hibernate.Transaction;

import bean.Vinculo;

public class VinculoDAO {

	public void insert(Vinculo vinculo) {
		Transaction transaction = DAOFactory.getSession().beginTransaction();
		DAOFactory.getSession().persist(vinculo);
		transaction.commit();
		DAOFactory.closeSession();
	}
	
	public void update(Vinculo vinculo) {
		Transaction transaction = DAOFactory.getSession().beginTransaction();
		transaction.begin();
		Vinculo update = DAOFactory.getSession().get(Vinculo.class, vinculo.getId());
		update.setIdcurso(vinculo.getIdcurso());
		update.setIddisciplina(vinculo.getIddisciplina());
		update.setIdsemestre(vinculo.getIdsemestre());
		DAOFactory.getSession().merge(update);
		transaction.commit();
		DAOFactory.closeSession();
	}
	
	public void delete(int id) {
		Transaction transaction = DAOFactory.getSession().beginTransaction();
		transaction.begin();
		Vinculo delete = DAOFactory.getSession().get(Vinculo.class, id);
		DAOFactory.getSession().remove(delete);
		transaction.commit();
		DAOFactory.closeSession();
	}
	
}