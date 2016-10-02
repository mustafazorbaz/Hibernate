package com.mustafazorbaz.main;
 
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mustafazorbaz.pojo.Meslek;
import com.mustafazorbaz.pojo.Sektor;
import com.mustafazorbaz.pojo.Tecrube;

public class PersonelMain {
	public static void main(String[] args) {

		Meslek meslek=new Meslek();
		meslek.setMeslekAdi("Avukat");
		
		Sektor sektor=new Sektor();
		sektor.setMeslekAdi("Doktor");
		sektor.setSectorAdi("T�p");
		
		Tecrube tecrube =new Tecrube();
		tecrube.setMeslekAdi("Yaz�l�m M�hendisli�i");
		tecrube.setSectorAdi("Java");
		tecrube.setTecrubeYili(4);
		
	 
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		/* SessionFactory bu �ekilde de olu�turula bilir.
		 * Configuration configuration = new Configuration().configure();
		    ServiceRegistryBuilder builder = new  ServiceRegistryBuilder().applySettings(configuration.getProperties());
		    ServiceRegistry serviceRegistry=builder.builderServiceRegistry();
			SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
		 */
		 
		try {
			
			session.beginTransaction();
			 
			session.save(meslek);
			session.save(sektor);
			session.save(tecrube);
			session.getTransaction().commit();
			session.close();

		} catch (SessionException e) {
			System.out.println("Sistemde istenilmeyen bir hata olu�tu l�tfen daha sonra tekrar deneyiniz...HATA !" + e);
		}

	}
}
