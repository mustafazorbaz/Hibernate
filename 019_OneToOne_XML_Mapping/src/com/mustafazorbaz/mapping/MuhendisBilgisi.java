package com.mustafazorbaz.mapping;

public class MuhendisBilgisi {
	private int muhBilgiId;
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
