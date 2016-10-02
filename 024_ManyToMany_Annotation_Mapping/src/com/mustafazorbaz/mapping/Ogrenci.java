package com.mustafazorbaz.mapping;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="OGRENCÝ")
public class Ogrenci implements Serializable{
	
	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue
	@Column(name ="Ogrenci_ID")
	private Long ogrenciId;
	@Column (name = "OGRENCI_ADI", nullable= false, length = 80)
	private String ogrenciAdi;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="OGRENCI_DERS",
	joinColumns={@JoinColumn(name="OGRENI_ID")},//hakim taraf
	inverseJoinColumns={@JoinColumn(name="DERS_ID")}//Hakim olmayan taraf
    )
	private Set<Ders> dersler = new HashSet<Ders>(0);
	
	
	//--------------------------------------
	public Ogrenci() {
	}


	public Ogrenci(String ogrenciAdi, Set<Ders> dersler) {
		this.ogrenciAdi = ogrenciAdi;
		this.dersler = dersler;
	}

	//--------------------------------------

	public Long getOgrenciId() {
		return ogrenciId;
	}


	public void setOgrenciId(Long ogrenciId) {
		this.ogrenciId = ogrenciId;
	}


	public String getOgrenciAdi() {
		return ogrenciAdi;
	}


	public void setOgrenciAdi(String ogrenciAdi) {
		this.ogrenciAdi = ogrenciAdi;
	}


	public Set<Ders> getDersler() {
		return dersler;
	}


	public void setDersler(Set<Ders> dersler) {
		this.dersler = dersler;
	}
	


	

}
