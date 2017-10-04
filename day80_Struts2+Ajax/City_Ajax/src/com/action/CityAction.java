package com.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.dao.impl.CityDaoImpl;
import com.entity.City;
import com.opensymphony.xwork2.ActionSupport;

public class CityAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private String result;
	private String prov;
	
	public String execute() throws Exception {
		CityDaoImpl cityDao = new CityDaoImpl();
		List<City> cityList = cityDao.getCityByProvinceCode(prov);
		
		JSONArray jsonArray = JSONArray.fromObject(cityList);
		result = jsonArray.toString();
		
		return SUCCESS;
	}
	
	
	public String getProv() {
		return prov;
	}
	public void setProv(String prov) {
		this.prov = prov;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}
