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
	@Column(name="Id") //Veritaba'nýnda  görünece olan kolon adý Id
	private int id;

	@Column(name="Ad"  ) //Veritaba'nýnda  ikinci tabloda görüncek olan sütun
	private String ad; 
	
	@Column(name="Soyad") // //Veritaba'nýnda  görünece olan kolon adý Soyad
	private String soyad;
	
	@Column(name="KayitTarihi")

	private Date kayitTarihi;
	
	  
	@Embedded //BU ALANA BAÞKA BÝR SINIFTAKÝ BÝLGÝLER GÖMÜLECEK - GELECEK
	@ElementCollection //COCUK DETAY TABLOLARINI OLUÞTURMAYA YARAR
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
