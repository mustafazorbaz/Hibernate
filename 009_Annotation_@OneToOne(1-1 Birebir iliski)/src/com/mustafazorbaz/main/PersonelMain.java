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
		personel.setMeslek(meslek1);
		
		
		try {
			SessionFactory factory =new Configuration().configure().buildSessionFactory();
			Session session=factory.openSession();
			session.beginTransaction();
			session.save(personel);
			session.save(meslek1);
		 
			session.getTransaction().commit();
			session.close();
			
		} catch (SessionException e) {
			System.out.println("Sistemde istenilmeyen bir hata oluþtu lütfen daha sonra tekrar deneyiniz...HATA !"+e);
		}
		
		
		
	}
}
