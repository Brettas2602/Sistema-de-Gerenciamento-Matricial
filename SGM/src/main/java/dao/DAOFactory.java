package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DAOFactory {
	
	private static Session session = null;
	private static SessionFactory sessionFactory = null;
	
	public static Session getSession() {
		if (session == null) {
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			session = sessionFactory.openSession();
		}
		return session;
	}
	
	public static void closeSession() {
		session.close();
		sessionFactory.close();
		session = null;
		sessionFactory = null;
	}
}
