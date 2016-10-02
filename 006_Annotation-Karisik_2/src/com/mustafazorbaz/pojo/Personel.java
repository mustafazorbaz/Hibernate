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
	@Column(name="Id") //Veritaba'nýnda  görünece olan kolon adý Id
	@TableGenerator(name = "ektablo", table ="tblpersonel", 
	pkColumnName ="maasi", pkColumnValue ="6000",
	allocationSize=1)//Id degerini ek tabloda saklar.
	private int id;

	@Column(name="Ad", table="personelGenelBilgi") //Veritaba'nýnda  ikinci tabloda görüncek olan sütun
	@Basic
	private String ad; 
	
	@Column(name="Soyad") // //Veritaba'nýnda  görünece olan kolon adý Soyad
	private String soyad;
	
	@Column(name="KayitTarihi")
	@Transient //Bu alaný görmezeden gelmesi için
	@Lob //Veritabanýnda büyük alan tutar.
	private Date kayitTarihi;
	
	 //Adres sýnýfýný kullana bilmek için  buraya gömdük 
	@Embedded	
	@ElementCollection //Çoçuk datay tablolarýný oluþturmaya yaramaktadýr.
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
