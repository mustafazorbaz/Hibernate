package jpaTest;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query; 
import model.Personeller;

public class JpaDeneme {

	public static void main(String[] args) {
		EntityManagerFactory emf;
		EntityManager em;
		
		Personeller personeller=new Personeller();
		personeller.setId(3);
		personeller.setAd("Hakan");
		personeller.setSoyad("Aslan");
		personeller.setTelefon(545645899); 
 
		
		emf=Persistence.createEntityManagerFactory("PU_AyarlaDosyasi");
		em=emf.createEntityManager();
		
		EntityTransaction et=em.getTransaction();
		
		et.begin();
			em.persist(personeller);
		et.commit();
		
		int gelenDeger=5;
		Query query = em.createNamedQuery("secilenSorgu").setParameter("p_id", gelenDeger);
		List<?> list=query.getResultList();
		
		
		for(Object obj:list) {
			personeller= (Personeller) obj;
			
			System.out.println("\nID :"+personeller.getId()
			+"\nADI :"+personeller.getAd()
			+"\nSOYADI :"+personeller.getSoyad()
			+"\nSINIF :"+personeller.getTelefon());
		}
		
			
		em.close();
		emf.close();

	}

}
