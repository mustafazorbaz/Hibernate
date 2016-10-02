package com.mustafazorbaz.aplication;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mustafazorbaz.mapping.Adres;
import com.mustafazorbaz.mapping.Muhendis; 
import com.mustafazorbaz.until.HibernateUntil;

 
public class Aplication {
	public static void main(String[] args) {
		Session session = HibernateUntil.openSessionFactory();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			
			Adres adres=new Adres("ANTALYA", "Korkuteli","Kiremitli", "Þehit Ahmet Er Sok.");
			
			Muhendis muhendis = new Muhendis("Mustafa", "Zorbaz",adres);
			 
			session.save(muhendis);

			transaction.commit();
 
			System.out.println("Baþarýlý olarak kayedildi.");
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}

}
