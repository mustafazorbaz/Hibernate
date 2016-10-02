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
			dersler1.add(new Ders("Yaz�l�m Gereksinim M�hendisli�i"));
			dersler1.add(new Ders("Yaz�l�m M�hendisli�ine Giri�"));
			dersler1.add(new Ders("�leri Web Programlama"));
			
			Set <Ders> dersler2 = new HashSet<Ders>();
			dersler2.add(new Ders("Hibernate"));
			dersler2.add(new Ders("Spring"));
			
			
			Ogrenci ogrenci1 = new Ogrenci("Mustafa ZORBAZ", dersler2);	
			Ogrenci ogrenci2 = new Ogrenci("Hakan AK", dersler1);
			Ogrenci ogrenci3 = new Ogrenci("�smail LALE", dersler2);
			
			session.save(ogrenci1);
			session.save(ogrenci2);
			session.save(ogrenci3);
			
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
