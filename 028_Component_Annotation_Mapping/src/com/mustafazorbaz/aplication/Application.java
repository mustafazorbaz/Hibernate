package com.mustafazorbaz.aplication;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mustafazorbaz.mapping.Adres;
import com.mustafazorbaz.mapping.Memur;

public class Application { 
	public static void main(String[] args) {
		
		Session session =null;
		Transaction transaction = null;
		
		try {
			SessionFactory factory =new Configuration().configure().buildSessionFactory();
		     session=factory.openSession();
			transaction = session.beginTransaction();
			
			Adres adres = new Adres("cadde1", "sehir1", "semt1", "postakodu1");
			
			Memur memur1 = new Memur("Nazif GENCER", adres);	
			Memur memur2 = new Memur("Oktay ÇÝL", adres);	
			Memur memur3 = new Memur("Kamile POT", adres);	
			Memur memur4 = new Memur("Nesrin ÞAL", adres);	
			
			session.save(memur1);
			session.save(memur2);
			session.save(memur3);
			session.save(memur4);
			
			transaction.commit();
			
			System.out.println("BAÞARILI OLARAK KAYDEDÝLDÝ.");
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			 
		} 
		
	}
}
