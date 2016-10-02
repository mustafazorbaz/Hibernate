package com.mustafazorbaz.aplication;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction; 

import com.mustafazorbaz.mapping.Ders;
import com.mustafazorbaz.mapping.Ogrenci;
import com.mustafazorbaz.util.HibernateUtil;

 

public class Application {

	public static void main(String[] args) {
	
		Session session = HibernateUtil.openSessionFactory();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			
			Set <Ders> dersler1 = new HashSet<Ders>();
			dersler1.add(new Ders("JSP"));
			dersler1.add(new Ders("JSF"));
			dersler1.add(new Ders("PF"));
			
			Set <Ders> dersler2 = new HashSet<Ders>();
			dersler2.add(new Ders("Hibernate"));
			dersler2.add(new Ders("Spring"));
			
			
			Ogrenci ogrenci1 = new Ogrenci("Nezir Salih", dersler1);	
			Ogrenci ogrenci2 = new Ogrenci("Murat Baba", dersler1);
			Ogrenci ogrenci3 = new Ogrenci("Mimar Aslan", dersler2);
			
			session.save(ogrenci1);
			session.save(ogrenci2);
			session.save(ogrenci3);
			
			//session.getTransaction().commit();
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
