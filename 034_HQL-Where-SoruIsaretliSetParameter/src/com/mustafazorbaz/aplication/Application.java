package com.mustafazorbaz.aplication;
 
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mustafazorbaz.mapping.Urun;
 

public class Application {


	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		Query sorgu = null;
	
		try {
			SessionFactory factory =new Configuration().configure().buildSessionFactory();
		     session=factory.openSession();
			transaction = session.beginTransaction();

			String hql3 = "FROM Urun AS T WHERE   T.urunFiyati <= ?    OR   T.urunId > ?";
			
		    sorgu = session.createQuery(hql3);
		    
			sorgu.setParameter(0, 15.0);
			sorgu.setParameter(1, 2);
		    
		
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