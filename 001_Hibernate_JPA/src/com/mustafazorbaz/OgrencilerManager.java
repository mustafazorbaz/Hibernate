package com.mustafazorbaz;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import model.Ogrenciler;

public class OgrencilerManager {

	public static void main(String[] args) {
		EntityManagerFactory emf;
		EntityManager em;
		
		Ogrenciler ogrenciler=new Ogrenciler();
		ogrenciler.setAd("Orhannnn");
		ogrenciler.setSoyad("Lak��");
		ogrenciler.setAciklama("Yaz�l�m M�hendisli�i ��rencisi");
		ogrenciler.setSinif(3);
		
		emf=Persistence.createEntityManagerFactory("001_H�bernate_JPAA");
		em=emf.createEntityManager();
		
		EntityTransaction et=em.getTransaction();
		
		et.begin();
			em.persist(ogrenciler);
		et.commit();
		
		System.out.println("\nID :"+ogrenciler.getNum()
				+"\nADI :"+ogrenciler.getAd()
				+"\nSOYADI :"+ogrenciler.getSoyad()
				+"\nSINIF :"+ogrenciler.getSinif()
				+"\nA�IKLAMA :"+ogrenciler.getAciklama()
			
				);
		em.close();
		emf.close();

	}

}
