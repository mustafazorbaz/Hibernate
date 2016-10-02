package com.mustafazorbaz.mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MuhendisBilgisi {
	/*
	 * 	<class name="com.mustafazorbaz.mapping.MuhendisBilgisi"
			table="muhendis_bilgisi"
			catalog="CALISMAORTAMI"	>
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="MUHENDIS_ID",unique=true,nullable=false)
	private int muhBilgiId;
	/*
	 * <id name="muhBilgiId" type="java.lang.Integer">
		<column name="MUHENDIS_ID"/>
		<generator class="foreign">
			<param name="property">muhendis</param>
		</generator>
	
		</id>
	 */
	private String alan;
	private String uzmanlikAlani;
	private int tecrubeYili;
	private Muhendis  muhendis;
	
	public int getMuhBilgiId() {
		return muhBilgiId;
	}
	public void setMuhBilgiId(int muhBilgiId) {
		this.muhBilgiId = muhBilgiId;
	}
	public String getAlan() {
		return alan;
	}
	public void setAlan(String alan) {
		this.alan = alan;
	}
	public String getUzmanlikAlani() {
		return uzmanlikAlani;
	}
	public void setUzmanlikAlani(String uzmanlikAlani) {
		this.uzmanlikAlani = uzmanlikAlani;
	}
	public int getTecrubeYili() {
		return tecrubeYili;
	}
	public void setTecrubeYili(int tecrubeYili) {
		this.tecrubeYili = tecrubeYili;
	}
	public Muhendis  getMuhendis () {
		return muhendis;
	}
	public void setMuhendis(Muhendis  muhendis ) {
		this.muhendis = muhendis ;
	}
	
			
}
