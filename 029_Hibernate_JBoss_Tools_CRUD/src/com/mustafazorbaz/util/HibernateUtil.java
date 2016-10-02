package com.mustafazorbaz.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory  sessionFactory=setSessionFactory();
	

	private static SessionFactory setSessionFactory() {

		try {
			sessionFactory =new Configuration().configure().buildSessionFactory();
			return sessionFactory;
		} 
		catch (Throwable e) {
			System.out.println("SessionFactory oluþturulamadý. " + e);
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	
	public static Session openSessionFactory() {
		return getSessionFactory().openSession();
	}
	
	

}
