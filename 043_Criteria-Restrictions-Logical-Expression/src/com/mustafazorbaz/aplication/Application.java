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
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

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
			
			//Urun Fiyat� 45.0 den b�y�k yada i�erisinde F harfi ge�enleri listeleyecek.
			Criteria criteria = session.createCriteria(Urun.class);
			Criterion fiyati = Restrictions.gt("urunFiyati", 45.0);
			Criterion adi =    Restrictions.ilike("urunAdi", "F%");
			LogicalExpression orExp = Restrictions.or(fiyati, adi);		 
			criteria.add(orExp);

			List<?> urunlerListesi = criteria.list();
			for (Object o : urunlerListesi) {
				System.out.println(((Urun) o).getUrunId() + " - " + ((Urun) o).getUrunAdi() + "  - "
						+ ((Urun) o).getUrunFiyati() + "\n---------------------------------");
			}
			transaction.commit();
			System.out.println("...Listeleme BA�ARILI....");

		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
