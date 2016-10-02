package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ogrenciler database table.
 * 
 */
@Entity
@NamedQuery(name="Ogrenciler.findAll", query="SELECT o FROM Ogrenciler o")
public class Ogrenciler implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer num;

	private String aciklama;

	private String ad;

	private Integer sinif;

	private String soyad;

	public Ogrenciler() {
	}

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getAciklama() {
		return this.aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	public String getAd() {
		return this.ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public Integer getSinif() {
		return this.sinif;
	}

	public void setSinif(Integer sinif) {
		this.sinif = sinif;
	}

	public String getSoyad() {
		return this.soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

}