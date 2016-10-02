package com.mustafazorbaz.mapping;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="muhendis",catalog="CALISMAORTAMI")
public class Muhendis {
	/*
	 * <class name="com.mustafazorbaz.mapping.Muhendis" table="muhendis"
		catalog="CALISMAORTAMI">
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="MUHENDIS_ID",unique=true,nullable=false)
	private int muhendisId;
	/*
	 * <id name="muhendisId" type="java.lang.Integer">
			<column name="MUHENDIS_ID" />
			<generator class="identity" />
		</id>
	 */
	@Column(name="MUHENDIS_ADI",length=50,nullable=false,unique=true)
	private String muhendisAdi;
	/*
	 * <property name="muhendisAdi" type="string">
			<column name="MUHENDIS_ADI" length="50" not-null="true"
				unique="true" />
		</property>
	 */
	
	@Column(name="MUHENDIS_SOYADI",length=50,nullable=false,unique=true)
	private String muhendisSoyadi;
	/*
	 * 	<property name="muhendisSoyadi" type="string">
			<column name="MUHENDIS_SOYADI" length="80" not-null="true"
				unique="true" />
		</property>
	 */
	
	@OneToOne(mappedBy="muhendis",cascade=CascadeType.ALL)
	private MuhendisBilgisi muhendisBilgisi;
	/*
	 * <one-to-one name="muhendisBilgisi"
			class="com.mustafazorbaz.mapping.MuhendisBilgisi" cascade="save-update" />
	 */
	
	
	public Muhendis(String muhendisAdi, String muhendisSoyadi ) {
		super();		
		this.muhendisAdi = muhendisAdi;
		this.muhendisSoyadi = muhendisSoyadi; 
	}

	public int getMuhendisId() {
		return muhendisId;
	}

	public void setMuhendisId(int muhendisId) {
		this.muhendisId = muhendisId;
	}

	public String getMuhendisAdi() {
		return muhendisAdi;
	}

	public void setMuhendisAdi(String muhendisAdi) {
		this.muhendisAdi = muhendisAdi;
	}

	public String getMuhendisSoyadi() {
		return muhendisSoyadi;
	}

	public void setMuhendisSoyadi(String muhendisSoyadi) {
		this.muhendisSoyadi = muhendisSoyadi;
	}

	public MuhendisBilgisi getMuhendisBilgisi() {
		return muhendisBilgisi;
	}

	public void setMuhendisBilgisi(MuhendisBilgisi muhendisBilgisi) {
		this.muhendisBilgisi = muhendisBilgisi;
	}
	
}
