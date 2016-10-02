package com.mustafazorbaz.pojo;

import javax.persistence.Entity;

@Entity
public class Tecrube  extends Sektor{
	private int tecrubeYili;

	public int getTecrubeYili() {
		return tecrubeYili;
	}

	public void setTecrubeYili(int tecrubeYili) {
		this.tecrubeYili = tecrubeYili;
	}
	

}
