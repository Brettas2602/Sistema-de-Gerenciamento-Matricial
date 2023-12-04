package dao;

import java.util.List;

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
		Transaction transaction = DAOFactory.getSession().getTransaction();
		transaction.begin();
		Curso update = DAOFactory.getSession().get(Curso.class, curso.getId());
		update.setDescricao(curso.getDescricao());
		DAOFactory.getSession().merge(update);
		transaction.commit();
		DAOFactory.closeSession();
	}
	
	public void delete(int id) {
		Transaction transaction = DAOFactory.getSession().getTransaction();
		transaction.begin();
		Curso delete = DAOFactory.getSession().get(Curso.class, id);
		DAOFactory.getSession().remove(delete);
		transaction.commit();
		DAOFactory.closeSession();
	}
	
	public List<Curso> findById(int id){
		Transaction transaction = DAOFactory.getSession().beginTransaction();
		List<Curso> cursos = DAOFactory.getSession().createQuery("FROM Curso WHERE id = " + id, Curso.class).getResultList();
		transaction.commit();
		DAOFactory.closeSession();
		return cursos;
	}
	
	public List<Curso> findAll(){
		Transaction transaction = DAOFactory.getSession().beginTransaction();
		List<Curso> cursos = DAOFactory.getSession().createQuery("FROM Curso", Curso.class).getResultList();
		transaction.commit();
		DAOFactory.closeSession();
		return cursos;
	}
}