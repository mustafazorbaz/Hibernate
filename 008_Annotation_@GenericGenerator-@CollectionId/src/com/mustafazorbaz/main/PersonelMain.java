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
		
		
		Adres adres1=new Adres();
		adres1.setIl("Antalya");
		adres1.setIlce("Konyaalt�");
		adres1.setMahalle("Arap suyu");
		personel.getAdresListesi().add(adres1);
		
		Adres adres2=new Adres();
		adres2.setIl("Trabzon");
		adres2.setIlce("�aykara");
		adres2.setMahalle("Uzung�l");
		personel.getAdresListesi().add(adres2);
		
		Adres adres3=new Adres();
		adres3.setIl("�stanbul");
		adres3.setIlce("Pendik");
		adres3.setMahalle("Merkez K�y");
		personel.getAdresListesi().add(adres3);
		
		/*

		Personel personel2 = new Personel();
		personel2.setAd("Serhat");
		personel2.setSoyad("Ko�ak");
		personel2.setKayitTarihi(new Date());
		//---------------------------------------------
		Adres adres4 =  new Adres();
		adres4.setIl("�stanbul");
		adres4.setIlce("Kad�k�y");
		adres4.setMahalle("cadde12");
	 
		
		personel2.getAdresListesi().add(adres4);
		
		
		Adres adres5 =  new Adres();
		adres5.setIl("�stanbul");
		adres5.setIlce("Fatih");
		adres5.setMahalle("cadde1040");
		 
		personel2.getAdresListesi().add(adres5);
	*/
		
		try {
			SessionFactory factory =new Configuration().configure().buildSessionFactory();
			Session session=factory.openSession();
			session.beginTransaction();
			session.save(personel);
			//session.save(personel2);
			session.getTransaction().commit();
			session.close();
			
		} catch (SessionException e) {
			System.out.println("Sistemde istenilmeyen bir hata olu�tu l�tfen daha sonra tekrar deneyiniz...HATA !"+e);
		}
		
		
		
	}
}
