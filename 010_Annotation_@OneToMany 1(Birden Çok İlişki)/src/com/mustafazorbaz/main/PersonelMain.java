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

		Personel personel =new Personel();
		personel.setAd("Mustafa");
		personel.setSoyad("Zorbaz");
		personel.setKayitTarihi(new Date());
	  
		Meslek meslek1=new  Meslek();
		meslek1.setAd("Yazýlým Mühendisi");
		personel.getMeslek().add(meslek1);
		
		Meslek meslek2=new  Meslek();
		meslek2.setAd("JAVA Mühendisi");
		personel.getMeslek().add(meslek2);
		
		Personel personel2 =new Personel();
		personel2.setAd("Süleyman");
		personel2.setSoyad("Okka");
		personel2.setKayitTarihi(new Date());
	  
		Meslek meslek3=new  Meslek();
		meslek3.setAd("Öðretmen");
		personel2.getMeslek().add(meslek3);
		
		Meslek meslek4=new  Meslek();
		meslek4.setAd("Emlakçý");
		personel2.getMeslek().add(meslek4);
		
		try {
			SessionFactory factory =new Configuration().configure().buildSessionFactory();
			Session session=factory.openSession();
			session.beginTransaction();
			session.save(personel);
			session.save(meslek1);
			session.save(meslek2);
			session.save(personel2);
			session.save(meslek3);
			session.save(meslek4);
			session.getTransaction().commit();
			session.close();
			
		} catch (SessionException e) {
			System.out.println("Sistemde istenilmeyen bir hata oluþtu lütfen daha sonra tekrar deneyiniz...HATA !"+e);
		}
		
		
		
	}
}
