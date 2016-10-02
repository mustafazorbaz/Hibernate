package com.mustafazorbaz.mapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sepet {
	
	@Id
	@GeneratedValue
	private int siparisId;
	private int siparisUrunId;
	private String siparisUrunAdi;
	private double siparisUrunFiyati;
	//-------------------------------------
	public int getSiparisId() {
		return siparisId;
	}
	public void setSiparisId(int siparisId) {
		this.siparisId = siparisId;
	}
	public int getSiparisUrunId() {
		return siparisUrunId;
	}
	public void setSiparisUrunId(int siparisUrunId) {
		this.siparisUrunId = siparisUrunId;
	}
	public String getSiparisUrunAdi() {
		return siparisUrunAdi;
	}
	public void setSiparisUrunAdi(String siparisUrunAdi) {
		this.siparisUrunAdi = siparisUrunAdi;
	}
	public double getSiparisUrunFiyati() {
		return siparisUrunFiyati;
	}
	public void setSiparisUrunFiyati(double siparisUrunFiyati) {
		this.siparisUrunFiyati = siparisUrunFiyati;
	}

	

}
