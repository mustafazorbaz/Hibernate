package com.mustafazorbaz.pojo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="TECRÜBE") //Tablodaki ilk sütunun adý TECRÜBE olarak yer almaktadýr.
public class Tecrube  extends Sektor{
	private int tecrubeYili;

	public int getTecrubeYili() {
		return tecrubeYili;
	}

	public void setTecrubeYili(int tecrubeYili) {
		this.tecrubeYili = tecrubeYili;
	}
	

}
