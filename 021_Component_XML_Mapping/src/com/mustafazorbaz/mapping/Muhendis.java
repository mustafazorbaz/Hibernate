package com.mustafazorbaz.mapping;

import java.io.Serializable;

public class Muhendis implements Serializable{
	private static final long serialVersionUID=1L;
	
	private int muhendisId;
	private String muhendisAdi;
	private String muhendisSoyadi;
	private Adres muhendisAdres;
	
	public Muhendis(String muhendisAdi, String muhendisSoyadi,Adres mAdres ) {
		super();		
		this.muhendisAdi = muhendisAdi;
		this.muhendisSoyadi = muhendisSoyadi; 
		this.muhendisAdres=mAdres;
	}

	public int getMuhendisId() {
		return muhendisId;
	}

	public void setMuhendisId(int muhendisId) {
		this.muhendisId = muhendisId;
	}

	public String getMuhendisAdi() {
		return muhendisAdi;
	}

	public void setMuhendisAdi(String muhendisAdi) {
		this.muhendisAdi = muhendisAdi;
	}

	public String getMuhendisSoyadi() {
		return muhendisSoyadi;
	}

	public void setMuhendisSoyadi(String muhendisSoyadi) {
		this.muhendisSoyadi = muhendisSoyadi;
	}

	public Adres getAdres() {
		return muhendisAdres;
	}

	public void setAdres(Adres adres) {
		this.muhendisAdres = adres;
	} 
	
}
