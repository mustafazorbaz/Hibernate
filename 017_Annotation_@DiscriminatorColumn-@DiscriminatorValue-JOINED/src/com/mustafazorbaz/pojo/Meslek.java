package com.mustafazorbaz.pojo;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED) //Artýk Her varlýklar için yani POJO sýnýflar için  bir tablo oluþur.
@DiscriminatorColumn(name="MESLEK_TIPI",
					discriminatorType=DiscriminatorType.STRING
					)
@DiscriminatorValue(value="MESLEK")
public class Meslek {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE) //NOT:Bundan dolayý ek tablo gelir.
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
