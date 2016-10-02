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
		
		Session session = null;
		Transaction transaction = null;
		
		try {
			SessionFactory factory =new Configuration().configure().buildSessionFactory();
		    session=factory.openSession();
			transaction = session.beginTransaction();
			
			Adres adres = new Adres("cadde:�ehidler", "sehir:�zmir", "semt:Alsancak", "postakodu:35220");
			
			Memur memur1 = new Memur("H�lya AKICI", adres);	
			Memur memur2 = new Memur("Merve BABA", adres);
			Memur memur3 = new Memur("�smail KUTLU", adres);
			
			session.save(memur1);
			session.save(memur2);
			session.save(memur3);
			
			//session.getTransaction().commit();
			transaction.commit();
			
			System.out.println("BA�ARILI OLARAK KAYDED�LD�.");
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			 session.close();
			 
		} 
		
		
		
	}

}
