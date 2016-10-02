package com.mustafazorbaz.pojo;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany; 
import javax.persistence.Table;

@Entity
@Table(name = "meslektablosu")
public class Meslek {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String ad;

    @ManyToMany(mappedBy="meslek") // Çoktan çoða iliþki
    private Collection<Personel> personelListe=new ArrayList<Personel>();
    
 

	// ----------------------
 
	public Collection<Personel> getPersonelListe() {
		return personelListe;
	}

	public void setPersonelListe(Collection<Personel> personelListe) {
		this.personelListe = personelListe;
	}

	// -----------------------
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

}
