package com.mustafazorbaz.mapping;

import java.util.Date;

public class Calisan {
	
	private int calisanId;
	private String calisanAdi;
	private String calisanSoyadi;
	private Date calisanDogumTarihi;
	private String calisanTelefonNo;
	private Departman departman;
	//--------------------------------------
	public Calisan() {
	}
	
	public Calisan(String calisanAdi, String calisanSoyadi) {	
		this.calisanAdi = calisanAdi;
		this.calisanSoyadi = calisanSoyadi;
	}
	
	public Calisan(String calisanAdi, String calisanSoyadi, String calisanTelefonNo) {	
		this.calisanAdi = calisanAdi;
		this.calisanSoyadi = calisanSoyadi;
		this.calisanTelefonNo = calisanTelefonNo;
	}
	
	
	public Calisan(String calisanAdi, String calisanSoyadi, Date calisanDogumTarihi, String calisanTelefonNo) {
		this.calisanAdi = calisanAdi;
		this.calisanSoyadi = calisanSoyadi;
		this.calisanDogumTarihi = calisanDogumTarihi;
		this.calisanTelefonNo = calisanTelefonNo;
	}

	//--------------------------------------

	public int getCalisanId() {
		return calisanId;
	}

	public void setCalisanId(int calisanId) {
		this.calisanId = calisanId;
	}

	public String getCalisanAdi() {
		return calisanAdi;
	}

	public void setCalisanAdi(String calisanAdi) {
		this.calisanAdi = calisanAdi;
	}

	public String getCalisanSoyadi() {
		return calisanSoyadi;
	}

	public void setCalisanSoyadi(String calisanSoyadi) {
		this.calisanSoyadi = calisanSoyadi;
	}

	public Date getCalisanDogumTarihi() {
		return calisanDogumTarihi;
	}

	public void setCalisanDogumTarihi(Date calisanDogumTarihi) {
		this.calisanDogumTarihi = calisanDogumTarihi;
	}

	public String getCalisanTelefonNo() {
		return calisanTelefonNo;
	}

	public void setCalisanTelefonNo(String calisanTelefonNo) {
		this.calisanTelefonNo = calisanTelefonNo;
	}

	public Departman getDepartman() {
		return departman;
	}

	public void setDepartman(Departman departman) {
		this.departman = departman;
	}


}
