package com.mustafazorbaz.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
 
import javax.persistence.Column;
 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
 
import javax.persistence.ManyToMany;
 

@Entity
public class Personel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String ad;

	@Column(name = "Soyad") // //Veritaba'nýnda görünece olan kolon adý Soyad
	private String soyad;

	@Column(name = "KayitTarihi")
	private Date kayitTarihi;

	@ManyToMany //Çoktan çoða bir iliþki  M-M
	@JoinTable( 
			name="PERSONEL_MESLEK",
			// Ana tabloya - hakim tarafa ait id kolon bilgisi
			joinColumns = @JoinColumn(name = "PERSONEL_ID"),
			// Çoçuk Tabloya - Hakim olmayan alt id kolon bilgisi
			inverseJoinColumns = @JoinColumn(name = "MESLEK_ID"))
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
