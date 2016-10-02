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
			
			Adres adres = new Adres("cadde", "sehir", "semt", "postakodu");
			
			Memur memur1 = new Memur("Alihan Garcý", adres);	
			Memur memur2 = new Memur("Murat Tapan", adres);
			Memur memur3 = new Memur("Poyraz Þiþeci", adres);
			
			session.save(memur1);
			session.save(memur2);
			session.save(memur3);
			
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
