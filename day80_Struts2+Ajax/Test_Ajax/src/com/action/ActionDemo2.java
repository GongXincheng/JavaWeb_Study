package com.action;

import net.sf.json.JSONObject;
import com.domain.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ActionDemo2 extends ActionSupport implements ModelDriven<User>{
	
	private static final long serialVersionUID = 1L;
	private User user = new User();
	private String result;
	
	public User getModel() {
		return user;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}


	@Override
	public String execute() throws Exception {
		String json = JSONObject.fromObject(user).toString();
		System.out.println(json);
		this.result = json;
		return SUCCESS;
	}

	
	
	
}
