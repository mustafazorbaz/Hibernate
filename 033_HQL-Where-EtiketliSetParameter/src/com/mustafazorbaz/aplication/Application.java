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
					
			String hql = "FROM Urun AS T WHERE T.urunFiyati <= :gelenParametre1 OR T.urunId > :gelenParametre2";
			Query sorgu = session.createQuery(hql);
			sorgu.setParameter("gelenParametre1", 15.0);
			sorgu.setParameter("gelenParametre2", 2);
			
			
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
