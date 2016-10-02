package com.mustafazorbaz.aplication;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mustafazorbaz.mapping.Calisan;
import com.mustafazorbaz.mapping.Departman;


public class Application {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;

		try {
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			session = factory.openSession();
			
			transaction = session.beginTransaction();

			Departman departman1 = new Departman();
			departman1.setDepartmanAdi("Mobil Appication Develop");
			session.save(departman1);

			Departman departman2 = new Departman();
			departman2.setDepartmanAdi("Free Software Develop");
			session.save(departman2);

			Calisan calisan1 = new Calisan("Hakki", "Akgün", "65432345");
			calisan1.setCalisanId(1);
			Calisan calisan2 = new Calisan("Sahap", "Guney", "2244356433");
			calisan2.setCalisanId(2);
			Calisan calisan3 = new Calisan("Mehmet", "Takka", new Date(), "42145689");
			calisan3.setCalisanId(3);
			Calisan calisan4 = null;

			try {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
				Date date = format.parse("1982-04-30");
				calisan4 = new Calisan("Mustafa", "Zorbaz", date, "14531299");
				calisan4.setCalisanId(4);
			} catch (Exception e) {
				e.printStackTrace();
			}
			calisan1.setDepartman(departman1);
			calisan2.setDepartman(departman1);
			calisan3.setDepartman(departman2);
			calisan4.setDepartman(departman2);

			session.save(calisan1);
			session.save(calisan2);
			session.save(calisan3);
			session.save(calisan4);

			transaction.commit();
			System.err.println("Kayýt Baþarýlý");
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
