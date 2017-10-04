package com.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ActionDemo1 extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}



	public String execute() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();	
		PrintWriter out = response.getWriter();
		out.print("Hello World !"
				+ "username:"+username
				+ ",password:"+password);
		
//		String json = JSONObject.fromObject("").toString();
		
		out.flush();
		out.close();
		return null;
	}
	
}
