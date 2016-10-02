package jpaTest;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Ogrenciler;

public class JpaDeneme {

	public static void main(String[] args) {
		EntityManagerFactory emf;
		EntityManager em;
		
		Ogrenciler ogrenciler=new Ogrenciler();
		ogrenciler.setAd("Hakan");
		ogrenciler.setSoyad("Aslan");
		ogrenciler.setAciklama("Yazýlým Mühendisliði Öðrencisi");
		ogrenciler.setSinif(3);
		
		emf=Persistence.createEntityManagerFactory("PU_AyarlaDosyasi");
		em=emf.createEntityManager();
		
		EntityTransaction et=em.getTransaction();
		
		et.begin();
			em.persist(ogrenciler);
		et.commit();
		
		Query query = em.createNamedQuery("tumOgrencileriGetir");
		List<?> list=query.getResultList();
		
		
		for(Object obj:list) {
			ogrenciler= (Ogrenciler) obj;
			
			System.out.println("\nID :"+ogrenciler.getNum()
			+"\nADI :"+ogrenciler.getAd()
			+"\nSOYADI :"+ogrenciler.getSoyad()
			+"\nSINIF :"+ogrenciler.getSinif()
			+"\nAÇIKLAMA :"+ogrenciler.getAciklama()	);
		}
		
			
		em.close();
		emf.close();

	}

}
