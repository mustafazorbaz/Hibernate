package com.mustafazorbaz.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
 

@Entity
public class Personel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String ad;

	@Column(name = "Soyad") // //Veritaba'n�nda g�r�nece olan kolon ad� Soyad
	private String soyad;

	@Column(name = "KayitTarihi")
	private Date kayitTarihi;

	@OneToMany(cascade=CascadeType.PERSIST) //Burada  personele ait t�m Meslek nesnelerini birbirine ba�lad�k.
	private Collection<Meslek> meslek = new ArrayList<Meslek>();

	public Collection<Meslek> getMeslek() {
		return meslek;
	}

	public void setMeslek(Collection<Meslek> meslek) {
		this.meslek = meslek;
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

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public Date getKayitTarihi() {
		return kayitTarihi;
	}

	public void setKayitTarihi(Date date) {
		this.kayitTarihi = date;
	}

}
