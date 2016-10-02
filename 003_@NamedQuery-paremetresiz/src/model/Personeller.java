package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the personeller database table.
 * 
 */
@Entity
@NamedQuery(name="tumPersoneller", query="SELECT p FROM Personeller p")
@Table(name = "personeller")
public class Personeller implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="\"Ad\"")
	private String ad;

	@Id
	@Column(name="\"Id\"")
	private Integer id;

	@Column(name="\"Soyad\"")
	private String soyad;

	@Column(name="\"Telefon\"")
	private Integer telefon;

	public Personeller() {
	}

	public String getAd() {
		return this.ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSoyad() {
		return this.soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public Integer getTelefon() {
		return this.telefon;
	}

	public void setTelefon(Integer telefon) {
		this.telefon = telefon;
	}

}