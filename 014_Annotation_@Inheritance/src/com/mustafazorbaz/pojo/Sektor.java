package com.mustafazorbaz.pojo;

import javax.persistence.Entity;

@Entity
public class Sektor extends Meslek{
	private String sectorAdi;

	public String getSectorAdi() {
		return sectorAdi;
	}

	public void setSectorAdi(String sectorAdi) {
		this.sectorAdi = sectorAdi;
	}
	

}
