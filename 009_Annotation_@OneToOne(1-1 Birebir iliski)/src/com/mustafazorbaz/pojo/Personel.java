package com.mustafazorbaz.pojo;


 
import java.util.Date; 
import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn; 
import javax.persistence.OneToOne; 


@Entity
public class Personel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String ad; 
	
	@Column(name="Soyad") // //Veritaba'nýnda  görünece olan kolon adý Soyad
	private String soyad;
	
	@Column(name="KayitTarihi") 
	private Date kayitTarihi;
	 
	@OneToOne //1-1  Burada bire bir iliþki oluþturmaktadýr.
	@JoinColumn(name="MESLEK_ID")
	private Meslek meslek;
	
	
	public Meslek getMeslek() {
		return meslek;
	}
	public void setMeslek(Meslek meslek) {
		this.meslek = meslek;
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
