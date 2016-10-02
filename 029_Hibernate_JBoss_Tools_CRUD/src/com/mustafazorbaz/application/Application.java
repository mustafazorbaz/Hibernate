package com.mustafazorbaz.application;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mustafazorbaz.mapping.Muhendis;
import com.mustafazorbaz.util.HibernateUtil;

public class Application {
	public static void main(String[] args) {

		Session session = HibernateUtil.openSessionFactory();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Muhendis muhendis = new Muhendis();
			muhendis.setAd("Mustafa");
			muhendis.setSoyad("Zorbaz");
			session.save(muhendis);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		Application nesne = new Application(); // INSERT - CREATE
		int muhendis1 = nesne.muhendisKaydet("Yakup", "rakým");
		int muhendis2 = nesne.muhendisKaydet("Pýnar", "Nardýdere");
		int muhendis3 = nesne.muhendisKaydet("Hasbi", "Ölemir");
		int muhendis4 = nesne.muhendisKaydet("Lale", "senli");
		int muhendis5 = nesne.muhendisKaydet("Oya", "benli");
		int muhendis6 = nesne.muhendisKaydet("hasan", "kurt");

		nesne.muhendisListele(); // SELECT - READ
		nesne.muhendisGuncelle(muhendis1, "Faruk", "Olay"); //UPDATE
		nesne.muhendisGuncelle(muhendis2, "Jale", "Þiþman");
		nesne.muhendisSil(muhendis3); //DELETE
		nesne.muhendisSil(muhendis4);
		nesne.muhendisListele();
	}

	private void muhendisSil(int muhendisIdSecilen) {
		Session session = HibernateUtil.openSessionFactory();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			Muhendis muhendis = (Muhendis) session.get(Muhendis.class, muhendisIdSecilen);			
			session.delete(muhendis);
			transaction.commit();
			
			System.out.println("BAÞARILI OLARAK GÜNCELLENDÝ.\n");
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();			
		} 

	}

	private void muhendisGuncelle(int muhendisIdSecilen, String muhendisAdYeni, String muhendisSoyadYeni) {
		Session session = HibernateUtil.openSessionFactory();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
		
			Muhendis muhendis = (Muhendis) session.get(Muhendis.class, muhendisIdSecilen);
			muhendis.setAd(muhendisAdYeni);
			muhendis.setSoyad(muhendisSoyadYeni);
			session.update(muhendis);
			
			//session.getTransaction().commit();
			transaction.commit();
			
			System.out.println("BAÞARILI OLARAK GÜNCELLENDÝ.\n");
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();			
		} 

	}

	private void muhendisListele() {
		Session session = HibernateUtil.openSessionFactory();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			List<?> muhendisler = session.createQuery("FROM Muhendis").list();

			for (Iterator<?> iterator = muhendisler.iterator(); iterator.hasNext();) {
				Muhendis muhendis = (Muhendis) iterator.next();
				System.out.println(muhendis.getAd()  + " " + muhendis.getSoyad());
			}

			// session.getTransaction().commit();
			transaction.commit();

			System.out.println("BAÞARILI OLARAK LÝSTELENDÝ.\n");

		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	private int muhendisKaydet(String muhendisAd, String muhendisSoyad) {
		Session session = HibernateUtil.openSessionFactory();
		Transaction transaction = null;
		int muhendisId = -1;

		try {
			transaction = session.beginTransaction();

			Muhendis muhendis = new Muhendis();
			muhendis.setAd(muhendisAd);
			muhendis.setSoyad(muhendisSoyad);
			muhendisId = (int) session.save(muhendis);

			// session.getTransaction().commit();
			transaction.commit();

			System.out.println("\nBAÞARILI OLARAK KAYDEDÝLDÝ. ---> " + muhendisId);

		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return muhendisId;
	}

}
