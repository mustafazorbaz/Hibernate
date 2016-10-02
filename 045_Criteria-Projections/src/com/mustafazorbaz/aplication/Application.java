package com.mustafazorbaz.aplication;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration; 
import org.hibernate.criterion.Projections; 

import com.mustafazorbaz.mapping.Urun;

public class Application {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;

		try {
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();
			Criteria criteria1 = session.createCriteria(Urun.class).setProjection(Projections.max("urunFiyati"));
			Double maxDeger = (Double) criteria1.uniqueResult();
			System.out.println("EN PAHALI URUN  FIYAT= " + maxDeger);

			Criteria criteria2 = session.createCriteria(Urun.class).setProjection(Projections.min("urunFiyati"));
			Double minDeger = (Double) criteria2.uniqueResult();
			System.out.println("EN UCUZ FÝYAT = " + minDeger);

			Criteria criteria3 = session.createCriteria(Urun.class).setProjection(Projections.avg("urunFiyati"));
			Double avgDeger = (Double) criteria3.uniqueResult();
			System.out.println("TUM URUNLARIN FIYAT ORTALAMASI= " + avgDeger);
 
			Criteria criteria4 = session.createCriteria(Urun.class).setProjection(Projections.sum("urunFiyati"));
			Double sumDeger = (Double) criteria4.uniqueResult();
			System.out.println("TUM URUNLARIN TOPLAM FIYATI = " + sumDeger);

			Criteria criteria5 = session.createCriteria(Urun.class).setProjection(Projections.rowCount());
			System.out.println("URUNLARIN SAYISI = " + criteria5.uniqueResult());
 
			transaction.commit();
			System.out.println("...Listeleme BAÞARILI...");		
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
