package com.mustafazorbaz.pojo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="TECR�BE") //Tablodaki ilk s�tunun ad� TECR�BE olarak yer almaktad�r.
public class Tecrube  extends Sektor{
	private int tecrubeYili;

	public int getTecrubeYili() {
		return tecrubeYili;
	}

	public void setTecrubeYili(int tecrubeYili) {
		this.tecrubeYili = tecrubeYili;
	}
	

}
