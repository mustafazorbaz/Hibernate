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
import org.hibernate.criterion.Order;

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
			
			//Urun Ad�na g�re A dan Z ye kadar s�rala ve Ayn� isimdeki �r�nleride Fiyat� b�y�kten k����e g�re s�rala
			Criteria criteria = session.createCriteria(Urun.class).addOrder(Order.asc("urunAdi"))
					.addOrder(Order.desc("urunFiyati"));
		
			List<?> urunlerListesi = criteria.list();
			for (Object o : urunlerListesi) {
				System.out.println(((Urun) o).getUrunId() + " - " + ((Urun) o).getUrunAdi() + "  - "
						+ ((Urun) o).getUrunFiyati() + "\n---------------------------------");
			}
			transaction.commit();
			System.out.println("BA�ARILI OLARAK Listelendi.");

		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
