package com.action;

import java.util.List;

import com.dao.impl.ProvinceDaoImpl;
import com.entity.Province;
import com.opensymphony.xwork2.ActionSupport;

public class showProvAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private List<Province> provList;
	
	public String execute(){
		System.out.println("Action......");
		ProvinceDaoImpl provDao = new ProvinceDaoImpl();
		provList = provDao.getAllProvince();
		return SUCCESS;
	}

	public List<Province> getProvList() {
		return provList;
	}

	public void setProvList(List<Province> provList) {
		this.provList = provList;
	}
}
