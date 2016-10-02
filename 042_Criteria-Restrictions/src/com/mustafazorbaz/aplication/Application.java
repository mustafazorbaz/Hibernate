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
			
			/*-------------------CRITERIA--------------*/
			//Criteria criteria = session.createCriteria(Urun.class).add(Restrictions.eq("urunFiyati", 7.0));
			// == eq    equal   esit
			
			//Criteria criteria = session.createCriteria(Urun.class).add(Restrictions.ne("urunFiyati", 45.0));		
			// !=  <>  ne    not equal   esit degil
    
			//Criteria criteria = session.createCriteria(Urun.class).add(Restrictions.lt("urunFiyati", 45.0));		
			// < lt    less than   kucuk
			
			//Criteria criteria = session.createCriteria(Urun.class).add(Restrictions.gt("urunFiyati", 45.0));		
			// < gt    greater than   buyuk
			
			//Criteria criteria = session.createCriteria(Urun.class).add(Restrictions.le("urunFiyati", 45.0));		
			// <= lt    less than or equal   kucuk esit
			
			//Criteria criteria = session.createCriteria(Urun.class).add(Restrictions.ge("urunFiyati", 45.0));		
			// <= gt    greater than  or equal   buyuk esit
			
			//Criteria criteria = session.createCriteria(Urun.class).add(Restrictions.like("urunAdi", "_a%"));		
			// ILK HARFI onemli degil          2.harfi a olan                devami onemli degil
			
			Criteria criteria = session.createCriteria(Urun.class)
					.add(Restrictions.like("urunAdi", "%a%"))
					.add(Restrictions.between("urunFiyati", 2.0 , 5.0));	
			
		    List <?> urunlerListesi =  criteria.list();
		    
		    for (Object o : urunlerListesi) {
		    	System.out.println(((Urun) o).getUrunId() + " - " + ((Urun) o).getUrunAdi() + "  - " + ((Urun) o).getUrunFiyati() 
						+ "\n---------------------------------");	
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
