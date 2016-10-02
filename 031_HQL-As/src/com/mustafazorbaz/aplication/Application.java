package com.mustafazorbaz.aplication;
 
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mustafazorbaz.mapping.Urun;
 

public class Application {


	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;

	
		try {
			SessionFactory factory =new Configuration().configure().buildSessionFactory();
		     session=factory.openSession();
			transaction = session.beginTransaction();
			
			/*
			List<?> urunler = session.createQuery("FROM Urun").list();
			
			for (Iterator<?> iterator = urunler.iterator(); iterator.hasNext();) {
				Urun urun = (Urun) iterator.next();
				System.out.println(urun.getUrunAdi() + " " + urun.getUrunFiyati());
			}
			*/
			
		   /*
		    Query sorgu = session.createQuery("from Urun    u");
			Query sorgu = session.createQuery("FROM Urun    u");
			Query sorgu = session.createQuery("from Urun AS u");
			Query sorgu = session.createQuery("FROM Urun as u");
			Query sorgu = session.createQuery("FROM Urun AS u");
			*/
			
			String hql = "FROM Urun AS u";
			Query sorgu = session.createQuery(hql);
			
			List <?> liste = sorgu.list();
		
			System.out.println("Kayýt sayýsý : "+ liste.size());
			
			
			Iterator<? > iterator = liste.iterator();
			
			while (iterator.hasNext()) {
				Urun  urun = (Urun) iterator.next();
				System.out.println(urun.getUrunId() + " - " + urun.getUrunAdi() + "  - " + urun.getUrunFiyati() 
						+ "\n---------------------------------");
				
			}
			
		
			
			//session.getTransaction().commit();
			transaction.commit();
			
			System.out.println("BAÞARILI OLARAK Listelendi.");
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
		   session.close();
		} 
	}


}
