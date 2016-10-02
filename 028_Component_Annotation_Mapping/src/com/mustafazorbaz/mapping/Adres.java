package com.mustafazorbaz.mapping;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adres implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
 
	@Column(name = "ADRES_CADDE", nullable= false, length = 250)
	private String cadde;
	
	@Column(name = "ADRES_SEHIR", nullable= false, length = 80)
	private String sehir; 
	
	@Column(name = "ADRES_SEMT", nullable= false, length = 50)
	private String semt; 
	
	@Column(name = "ADRES_POSTAKODU", nullable= false, length = 10)
	private String postakodu;
 
//-------------------------------
	public Adres() {
	}


public Adres(String cadde, String sehir, String semt, String postakodu) {
	this.cadde = cadde;
	this.sehir = sehir;
	this.semt = semt;
	this.postakodu = postakodu;
}
	//-------------------------------


 


public String getCadde() {
	return cadde;
}


public void setCadde(String cadde) {
	this.cadde = cadde;
}


public String getSehir() {
	return sehir;
}


public void setSehir(String sehir) {
	this.sehir = sehir;
}


public String getSemt() {
	return semt;
}


public void setSemt(String semt) {
	this.semt = semt;
}


public String getPostakodu() {
	return postakodu;
}


public void setPostakodu(String postakodu) {
	this.postakodu = postakodu;
}


}
