package com.mustafazorbaz.mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Urun {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int urunId;
	private String urunAdi;
	@Column(name="FIYATI")
	private double urunFiyati;
	
	
	public int getUrunId() {
		return urunId;
	}
	public void setUrunId(int urunId) {
		this.urunId = urunId;
	}
	
	
	public String getUrunAdi() {
		return urunAdi;
	}
	public void setUrunAdi(String urunAdi) {
		this.urunAdi = urunAdi;
	}
	
	
	public double getUrunFiyati() {
		return urunFiyati;
	}
	public void setUrunFiyati(double urunFiyati) {
		this.urunFiyati = urunFiyati;
	}
	
}
