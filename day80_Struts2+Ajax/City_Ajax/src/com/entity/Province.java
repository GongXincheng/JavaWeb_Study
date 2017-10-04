package com.entity;

import java.io.Serializable;

public class Province implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String privinceCode;
	private String privinceName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrivinceCode() {
		return privinceCode;
	}
	public void setPrivinceCode(String privinceCode) {
		this.privinceCode = privinceCode;
	}
	public String getPrivinceName() {
		return privinceName;
	}
	public void setPrivinceName(String privinceName) {
		this.privinceName = privinceName;
	}
	

}
