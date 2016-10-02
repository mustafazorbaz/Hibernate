package com.mustafazorbaz.mapping;


public class Ders {
	
	private Long dersId;
	private String dersAdi;

 
//-------------------------------
	public Ders() {
	}

	
	public Ders( String dersAdi) {
		this.dersAdi = dersAdi;
	}
	//-------------------------------


	public Long getDersId() {
		return dersId;
	}


	public void setDersId(Long dersId) {
		this.dersId = dersId;
	}


	public String getDersAdi() {
		return dersAdi;
	}


	public void setDersAdi(String dersAdi) {
		this.dersAdi = dersAdi;
	}
	
	
}
