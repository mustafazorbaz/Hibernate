package com.mustafazorbaz.pojo;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
 
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
	@ElementCollection //�o�uk datay tablolar�n� olu�turmaya yaramaktad�r.
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
