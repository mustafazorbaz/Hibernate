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

	 
		

		try {
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();
			session.beginTransaction();
			//Burada görüldüðü gibi sadece personeli kaydetmek yeterli session.save'de ise her nesneyi kaydediyorduk.
			session.persist(personel);

			session.getTransaction().commit();
			session.close();

		} catch (SessionException e) {
			System.out.println("Sistemde istenilmeyen bir hata oluþtu lütfen daha sonra tekrar deneyiniz...HATA !" + e);
		}

	}
}
