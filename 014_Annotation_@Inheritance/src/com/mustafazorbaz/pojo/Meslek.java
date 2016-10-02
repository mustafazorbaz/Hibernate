package com.mustafazorbaz.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Meslek {
	@Id
	@GeneratedValue
	private int id;
	private String meslekAdi;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMeslekAdi() {
		return meslekAdi;
	}
	public void setMeslekAdi(String adi) {
		this.meslekAdi = adi;
	}
}
