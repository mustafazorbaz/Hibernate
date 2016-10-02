package com.mustafazorbaz.pojo;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

@Entity
@Table(name="Personel_Tablosu")
@SecondaryTable(name="personelGenelBilgi")
public class Personel {
	
	@Id
	@GeneratedValue
	@Column(name="Id") //Veritaba'n�nda  g�r�nece olan kolon ad� Id
	@TableGenerator(name = "ektablo", table ="tblpersonel", 
	pkColumnName ="maasi", pkColumnValue ="6000",
	allocationSize=1)//Id degerini ek tabloda saklar.
	private int id;

	@Column(name="Ad", table="personelGenelBilgi") //Veritaba'n�nda  ikinci tabloda g�r�ncek olan s�tun
	@Basic
	private String ad; 
	
	@Column(name="Soyad") // //Veritaba'n�nda  g�r�nece olan kolon ad� Soyad
	private String soyad;
	
	@Column(name="KayitTarihi")
	@Transient //Bu alan� g�rmezeden gelmesi i�in
	@Lob //Veritaban�nda b�y�k alan tutar.
	private Date kayitTarihi;
	
	 //Adres s�n�f�n� kullana bilmek i�in  buraya g�md�k 
	@Embedded
	/*Bu annotation ayn� s�n�f� tekrar kullanmam�za yaramaktad�r ve bunlaradaki bulunan 
	  fieldlar veritaban� tekrar ayn� isimde bulunmak istedi�inden dolay� hata olu�acakt�r.
	  ��te bunun i�in kullan�lmaktad�r.
	*/
	@AttributeOverrides({ 
		@AttributeOverride(name="il",column=@Column(name="Ev_Icin_Il")),
		@AttributeOverride(name="ilce",column=@Column(name="Ev_Icin_Ilce")),
		@AttributeOverride(name="mahalle",column=@Column(name="Ev_Icin_Mahalle"))
	})
	private Adres evAdresi;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="il",column=@Column(name="Is_Icin_Sehir")),
		@AttributeOverride(name="ilce",column=@Column(name="Is_Icin_Ilce")),
		@AttributeOverride(name="mahalle",column=@Column(name="Is_Icin_Mahelle"))
		
	})
	private Adres isAdresi;
	
	
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
	public Adres getEvAdresi() {
		return evAdresi;
	}
	public void setEvAdresi(Adres evAdresi) {
		this.evAdresi = evAdresi;
	}
	public Adres getIsAdresi() {
		return isAdresi;
	}
	public void setIsAdresi(Adres isAdresi) {
		this.isAdresi = isAdresi;
	}
	
}
