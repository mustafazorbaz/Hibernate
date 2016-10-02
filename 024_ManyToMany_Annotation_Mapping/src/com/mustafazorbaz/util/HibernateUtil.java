package com.mustafazorbaz.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory setSessionFactory(){
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable e) {
			System.out.println("SessionFactory oluþturulamadý."+e);
			throw new ExceptionInInitializerError(e);
		}
	}
	public static SessionFactory getSessionFactory()
	{
		return setSessionFactory();
	}
	 
	public static void closeSessionFactory()
	{
		getSessionFactory().close();
	}
	public static Session openSessionFactory(){
		return getSessionFactory().openSession();
	}
	
}