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
		sektor.setSectorAdi("Týp");
		
		Tecrube tecrube =new Tecrube();
		tecrube.setMeslekAdi("Yazýlým Mühendisliði");
		tecrube.setSectorAdi("Java");
		tecrube.setTecrubeYili(4);
		
	 
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		/* SessionFactory bu þekilde de oluþturula bilir.
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
			System.out.println("Sistemde istenilmeyen bir hata oluþtu lütfen daha sonra tekrar deneyiniz...HATA !" + e);
		}

	}
}
