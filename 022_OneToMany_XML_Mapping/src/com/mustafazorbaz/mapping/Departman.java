package com.mustafazorbaz.mapping;
 
public class Departman {
	
	private Long departmanId;
	private String departmanAdi;
 
	private Calisan[] calisanlar; 
//-------------------------------	

	public Long getDepartmanId() {
		return departmanId;
	}

	public void setDepartmanId(Long departmanId) {
		this.departmanId = departmanId;
	}

	public String getDepartmanAdi() {
		return departmanAdi;
	}

	public void setDepartmanAdi(String departmanAdi) {
		this.departmanAdi = departmanAdi;
	}
   
	public Calisan[] getCalisanlar() {
		return calisanlar;
	}

	public void setCalisanlar(Calisan[] calisanlar) {
		this.calisanlar = calisanlar;
	}
	
	
}
