package com.mustafazorbaz.main;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mustafazorbaz.pojo.Meslek;
import com.mustafazorbaz.pojo.Personel;

public class PersonelMain {
	public static void main(String[] args) {

		Personel personel = new Personel();
		personel.setAd("Mustafa");
		personel.setSoyad("Zorbaz");
		personel.setKayitTarihi(new Date());

		Meslek meslek1 = new Meslek();
		meslek1.setAd("Yazýlým Mühendisi");
		personel.getMeslek().add(meslek1);

		Meslek meslek2 = new Meslek();
		meslek2.setAd("JAVA Mühendisi");
		personel.getMeslek().add(meslek2);

		personel.getMeslek().add(meslek1);
		personel.getMeslek().add(meslek2);
		
		meslek1.getPersonelListe().add(personel);
		meslek2.getPersonelListe().add(personel);
		
		
		

		try {
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();
			session.beginTransaction();
			session.save(personel);
			session.save(meslek1);
			session.save(meslek2);

			session.getTransaction().commit();
			session.close();

		} catch (SessionException e) {
			System.out.println("Sistemde istenilmeyen bir hata oluþtu lütfen daha sonra tekrar deneyiniz...HATA !" + e);
		}

	}
}
