package com.mustafazorbaz.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mustafazorbaz.pojo.Ogrenci;

public class Main {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		try {
			session.beginTransaction();

			Ogrenci personel = (Ogrenci) session.get(Ogrenci.class, 10); 
			personel.setAd("Software");
			personel.setSoyad("Engineer");
			session.update(personel);		//UPDATE - UPDATE
			
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			System.out.println("��lem Ba�ar�s�z...HATA:" + e);
		}

		/*
		 * Ogrenci ogrenci =session.get(Ogrenci.class, 14);
		 * session.delete(ogrenci); System.out.println("S�L�ND�");
		 */

		/*
		 * //14.Kay�d� se�tik 
		 * Ogrenci personel = (Ogrenci)session.get(Ogrenci.class, 14); // SELECT - READ
		 * 
		 * System.out.println("�EK�LEN VER� : " + personel.getAd() +
		 * personel.getSoyad() );
		 */

		/*
		 * for (int i = 1; i < 10; i++) { //Create-Insert Ogrenci ogrenci=new
		 * Ogrenci(); //Her biri ��renci ogrenci.setAd("Mustafa "+i);
		 * ogrenci.setSoyad("Zorbaz "+i); session.save(ogrenci); //��rencimiz
		 * kaydettik }
		 */

	}
}
