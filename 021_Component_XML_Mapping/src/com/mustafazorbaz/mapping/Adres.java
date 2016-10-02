package com.mustafazorbaz.mapping;

import java.io.Serializable;

public class Adres implements Serializable{
	private static final long  serialVersionUID=1L;
	private String il;
	private String ilce;
	private String Mahalle;
	private String Sokak;
	
	public Adres(String il, String ilce, String mahalle, String sokak) {
		super();
		this.il = il;
		this.ilce = ilce;
		Mahalle = mahalle;
		Sokak = sokak;
	}	
	public String getIl() {
		return il;
	}
	public void setIl(String il) {
		this.il = il;
	}
	public String getIlce() {
		return ilce;
	}
	public void setIlce(String ilce) {
		this.ilce = ilce;
	}
	public String getMahalle() {
		return Mahalle;
	}
	public void setMahalle(String mahalle) {
		Mahalle = mahalle;
	}
	public String getSokak() {
		return Sokak;
	}
	public void setSokak(String sokak) {
		Sokak = sokak;
	}
	
	
}
