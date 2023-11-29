package dao;

import org.hibernate.Transaction;

import bean.Curso;

public class CursoDAO {
	
	public void insert(Curso curso) {
		Transaction transaction = DAOFactory.getSession().beginTransaction();
		DAOFactory.getSession().persist(curso);
		transaction.commit();
		DAOFactory.closeSession();
	}
	
	public void update(Curso curso) {
		Transaction transaction = DAOFactory.getSession().beginTransaction();
		transaction.begin();
		Curso update = DAOFactory.getSession().get(Curso.class, curso.getId());
		update.setDescricao(curso.getDescricao());
		DAOFactory.getSession().merge(update);
		transaction.commit();
		DAOFactory.closeSession();
	}
	
	public void delete(int id) {
		Transaction transaction = DAOFactory.getSession().beginTransaction();
		transaction.begin();
		Curso delete = DAOFactory.getSession().get(Curso.class, id);
		DAOFactory.getSession().remove(delete);
		transaction.commit();
		DAOFactory.closeSession();
	}
}