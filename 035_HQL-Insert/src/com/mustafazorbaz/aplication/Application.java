package com.mustafazorbaz.aplication;
 
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mustafazorbaz.mapping.Sepet;

public class Application {


	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		Query sorgu = null;
		String hql  = null;
		
		try {
			SessionFactory factory =new Configuration().configure().buildSessionFactory();
		     session=factory.openSession();
			transaction = session.beginTransaction();

			 hql = "INSERT INTO Sepet (siparisUrunId, siparisUrunAdi, siparisUrunFiyati) "
				 		+ "SELECT             U.urunId,       U.urunAdi,      U.urunFiyati  FROM Urun AS U "
				 		+ "WHERE U.urunId = :urun_id ";
									
			    sorgu = session.createQuery(hql);
			   
			    sorgu.setParameter("urun_id", 1 );
			   
			    sorgu.executeUpdate();
			    
			    
				
				 hql = "INSERT INTO Sepet (siparisUrunId, siparisUrunAdi, siparisUrunFiyati) "
					 		+ "SELECT             U.urunId,       U.urunAdi,      U.urunFiyati  FROM Urun AS U "
					 		+ "WHERE U.urunId = ? ";
										
				    sorgu = session.createQuery(hql);
				   
				    sorgu.setParameter(0, 2 );
				    
			    
			   int result = sorgu.executeUpdate();

			    System.out.println("Girilen Kayýt sayýsý : "+ result);
			    session.flush();
			    
			    System.err.println("---------------------------------");
			    
			    
				hql =  "FROM Sepet ";
				sorgu = session.createQuery(hql);
				
				List <?> liste = sorgu.list();
			
				System.out.println("Kayýt sayýsý : "+ liste.size());
				
				
				Iterator<? > iterator = liste.iterator();
				
				while (iterator.hasNext()) {
						
					Sepet  sepet = (Sepet) iterator.next();
	          System.out.println(sepet.getSiparisId() + " --- " + sepet.getSiparisUrunId() + "  - " + sepet.getSiparisUrunAdi() + "  - " + sepet.getSiparisUrunFiyati() 
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
