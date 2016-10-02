package com.mustafazorbaz.pojo;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;   
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable; 

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
 

@Entity
public class Personel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Id") //Veritaba'n�nda  g�r�nece olan kolon ad� Id
	private int id;

	@Column(name="Ad"  ) //Veritaba'n�nda  ikinci tabloda g�r�ncek olan s�tun
	private String ad; 
	
	@Column(name="Soyad") // //Veritaba'n�nda  g�r�nece olan kolon ad� Soyad
	private String soyad;
	
	@Column(name="KayitTarihi")

	private Date kayitTarihi;
	
	  
	@Embedded //BU ALANA BA�KA B�R SINIFTAK� B�LG�LER G�M�LECEK - GELECEK
	@ElementCollection //COCUK DETAY TABLOLARINI OLU�TURMAYA YARAR
	@JoinTable(name="adreslistesitablosu", //KALITIM TABLOSU
	joinColumns = @JoinColumn(name="PERSONEL_ID")
	//COCUK ALT DETAY TABLODAKI ID KOLONUN ADINI DEGISTIRIR - KALITIM SUTUNU
	)
	@GenericGenerator(name = "hilo-gen", strategy = "hilo")
	@CollectionId(
			columns = { @Column(name="ADRES_ID") }, 
			generator = "hilo-gen", 
			type = @Type(type="long"))
	private Collection<Adres> adresListesi = new ArrayList<Adres>();
	
	public Collection<Adres> getAdresListesi() {
		return adresListesi;
	}

	public void setAdresListesi(Collection<Adres> adresListesi) {
		this.adresListesi = adresListesi;
	}
 
	
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
