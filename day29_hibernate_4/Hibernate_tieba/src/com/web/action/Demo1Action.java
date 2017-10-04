package com.web.action;

import com.opensymphony.xwork2.ActionSupport;

public class Demo1Action extends ActionSupport{
	private static final long serialVersionUID = 1L;

	public String add(){
		System.out.println("Add--action");
		return SUCCESS;
	}
	
}
