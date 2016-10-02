package com.mustafazorbaz.main;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory; 
import org.hibernate.cfg.Configuration;

import com.mustafazorbaz.pojo.Adres;
import com.mustafazorbaz.pojo.Personel;

public class PersonelMain {
	public static void main(String[] args) {

		Personel personel =new Personel();
		personel.setAd("Mustafa");
		personel.setSoyad("Zorbaz");
		personel.setKayitTarihi(new Date());
		
		Adres evAdres=new Adres();
		evAdres.setIl("Antalya");
		evAdres.setIlce("Konyaaltý");
		evAdres.setMahalle("Arap Suyu");
		personel.setEvAdresi(evAdres);
		
		Adres isAdres=new Adres();
		isAdres.setIl("Tranzon");
		isAdres.setIlce("Of");
		isAdres.setMahalle("Merkez");
		personel.setIsAdresi(isAdres);
		
		try {
			SessionFactory factory =new Configuration().configure().buildSessionFactory();
			Session session=factory.openSession();
			session.beginTransaction();
			session.save(personel);
			session.getTransaction().commit();
			session.close();
			
		} catch (SessionException e) {
			System.out.println("Sistemde istenilmeyen bir hata oluþtu lütfen daha sonra tekrar deneyiniz...HATA !"+e);
		}
		
		
		
	}
}
