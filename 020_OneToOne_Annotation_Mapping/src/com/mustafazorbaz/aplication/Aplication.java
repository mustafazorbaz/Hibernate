package com.mustafazorbaz.aplication;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mustafazorbaz.mapping.Muhendis;
import com.mustafazorbaz.mapping.MuhendisBilgisi;
import com.mustafazorbaz.until.HibernateUntil;

 
public class Aplication {
	public static void main(String[] args) {
		Session session = HibernateUntil.openSessionFactory();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Muhendis muhendis = new Muhendis("Mustafa", "Zorbaz");
			MuhendisBilgisi muhBilgisi = new MuhendisBilgisi();
			muhBilgisi.setAlan("Yazýlým");
			muhBilgisi.setTecrubeYili(5);
			muhBilgisi.setUzmanlikAlani("JAVA");

			muhBilgisi.setMuhendis(muhendis);
			muhendis.setMuhendisBilgisi(muhBilgisi);
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
