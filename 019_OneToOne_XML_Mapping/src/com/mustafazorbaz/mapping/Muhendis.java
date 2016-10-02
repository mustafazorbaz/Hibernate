package com.mustafazorbaz.mapping;

public class Muhendis {
	private int muhendisId;
	private String muhendisAdi;
	private String muhendisSoyadi;
	private MuhendisBilgisi muhendisBilgisi;
	
	public Muhendis(String muhendisAdi, String muhendisSoyadi ) {
		super();		
		this.muhendisAdi = muhendisAdi;
		this.muhendisSoyadi = muhendisSoyadi; 
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

	public MuhendisBilgisi getMuhendisBilgisi() {
		return muhendisBilgisi;
	}

	public void setMuhendisBilgisi(MuhendisBilgisi muhendisBilgisi) {
		this.muhendisBilgisi = muhendisBilgisi;
	}
	
}
