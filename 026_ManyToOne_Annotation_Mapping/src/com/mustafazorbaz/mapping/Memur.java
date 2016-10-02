package com.mustafazorbaz.mapping;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="MEMUR")
public class Memur {
	@Id
	@GeneratedValue
	@Column(name = "MEMUR_ID")
	private Long memurId;
	@Column(name = "MEMUR_ADI", nullable= false, length = 100)
	private String memurAdi;
	
	@ManyToOne (cascade = CascadeType.ALL)
	private Adres memurAdres;
	
	
	//--------------------------------------
	public Memur() {
	}


	public Memur(String memurAdi, Adres memurAdres) {
		this.memurAdi = memurAdi;
		this.memurAdres = memurAdres;
	}


	public Long getMemurId() {
		return memurId;
	}


	public void setMemurId(Long memurId) {
		this.memurId = memurId;
	}


	public String getMemurAdi() {
		return memurAdi;
	}


	public void setMemurAdi(String memurAdi) {
		this.memurAdi = memurAdi;
	}


	public Adres getMemurAdres() {
		return memurAdres;
	}


	public void setMemurAdres(Adres memurAdres) {
		this.memurAdres = memurAdres;
	}

	//--------------------------------------


	

}
