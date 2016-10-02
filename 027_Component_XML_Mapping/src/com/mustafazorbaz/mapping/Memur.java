package com.mustafazorbaz.mapping;
 
 
public class Memur {
	 
	private Long memurId;
	 
	private String memurAdi;
	
 
	private Adres memurAdres;
	
	
	//--------------------------------------
	public Memur() {
	}


	public Memur(String memurAdi, Adres memurAdres) {
		this.memurAdi = memurAdi;
		this.memurAdres = memurAdres;
	}


	public Long getMemurId() {
		return memurId;
	}


	public void setMemurId(Long memurId) {
		this.memurId = memurId;
	}


	public String getMemurAdi() {
		return memurAdi;
	}


	public void setMemurAdi(String memurAdi) {
		this.memurAdi = memurAdi;
	}


	public Adres getMemurAdres() {
		return memurAdres;
	}


	public void setMemurAdres(Adres memurAdres) {
		this.memurAdres = memurAdres;
	}

	//--------------------------------------


	

}
