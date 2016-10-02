package com.mustafazorbaz.pojo;


import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob; 
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@Table(name="Personel_Tablosu")

public class Personel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String ad; 
	private String soyad;
	
	@Column(name="KayitTarihi")
	@Transient //Bu alaný görmezeden gelmesi için
	@Lob //Veritabanýnda büyük alan tutar.
	private Date kayitTarihi;
	
	 //Adres sýnýfýný kullana bilmek için  buraya gömdük 
	@Embedded	
	@ElementCollection //Çoçuk detay tablolarýný oluþturmaya yarar.
	@JoinTable(name="personelAdresTablosu", joinColumns=@JoinColumn(name="personel_id"))
	private Set<Adres> adresListesi = new HashSet<>();
	public Set<Adres> getAdresListesi() {
		return adresListesi;
	}
	public void setAdresListesi(Set<Adres> adresListesi) {
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
