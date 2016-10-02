package com.mustafazorbaz.aplication;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mustafazorbaz.mapping.Urun;

public class Application {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		Query sorgu = null;
		String hql = null;
		try {
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			transaction = session.beginTransaction();

			hql = "SELECT U.urunAdi, SUM(U.urunFiyati)" + "FROM Urun AS U " + "GROUP BY  U.urunAdi";
			sorgu = session.createQuery(hql);
			
			List<?> liste = sorgu.list();
			System.out.println("Kayýt sayýsý : " + liste.size());
			Iterator<?> iterator = liste.iterator();
			while (iterator.hasNext()) {
				Object o[] = (Object[]) iterator.next();
				System.out.println("URUN ADI : " + o[0] + " - TOPLAM FIYATI : " + o[1]);
				System.err.println("---------------------------------");
			}
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
