package com.mustafazorbaz.aplication;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mustafazorbaz.mapping.Urun;

public class Application {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		Query sorgu = null;
		String hql = null;
		try {
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			hql = "SELECT urunAdi FROM Urun";								
		    sorgu = session.createQuery(hql);
		    sorgu.setFirstResult(2); //Bu kay�ttan ba�la
		    sorgu.setMaxResults(5); //Bu kadar kay�t git
		    session.flush();
		    System.err.println("---------------------------------");
			List <?> urunler =  sorgu.list();			    
			    for (Object urun : urunler) {
			    	System.out.println(urun);	
				}
			transaction.commit();   
			System.out.println("BA�ARILI OLARAK Listelendi.");	
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
		   session.close();
		} 
	}

}
