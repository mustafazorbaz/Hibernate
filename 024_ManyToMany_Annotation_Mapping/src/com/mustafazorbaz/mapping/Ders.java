package com.mustafazorbaz.mapping;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DERS")
public class Ders implements Serializable {
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue
	@Column(name="DERS_ID")
	private Long dersId;
	
	@Column(name="DERS_ADI",nullable=false)
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
