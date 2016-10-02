package jpadeneme;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Ogrenciler;

public class JpaDeneme {

	public static void main(String[] args) {
		EntityManagerFactory emf;
		EntityManager em;
		
		Ogrenciler ogrenci = new Ogrenciler();
		//ogrenci.setId(1);
		ogrenci.setAd("Salih");
		ogrenci.setSoyad("Aslan");
		ogrenci.setAciklama("TIP");
		ogrenci.setSinif(9);
		//---------------------------------------------

		emf = Persistence.createEntityManagerFactory("PU_AyarDosyasi"); //persistence-unit adi
		em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
			em.persist(ogrenci);
		et.commit();
		
		
		System.out.println("\nID : " + ogrenci.getNum() +
				"\nADI : " + ogrenci.getAd() +
				"\nSOYADI : " + ogrenci.getSoyad() 
				);
		
		em.close();
		emf.close();
		
	}

}
