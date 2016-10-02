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
			
			//Fiyatý 45 tl den küçük olanlarý listele
			String sql5 = "SELECT u.urunId, u.urunAdi, u.urunFiyati FROM Urun AS u "
					+ "WHERE u.urunFiyati < :pUrunFiyati";
			Query query5 = session.createSQLQuery(sql5).addEntity(Urun.class).setParameter("pUrunFiyati", 45.0);

			List<?> urunlerListesi = query5.list();
			for (Object o : urunlerListesi) {
				System.out.println(((Urun) o).getUrunId() + " - " + ((Urun) o).getUrunAdi() + "  - "
						+ ((Urun) o).getUrunFiyati() + "\n---------------------------------");
			}
			System.out.println("...Listeleme BAÞARILI...");		
			transaction.commit();	
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
