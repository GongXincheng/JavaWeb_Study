package com.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.web.domain.User;

public class Demo4Action extends ActionSupport implements ModelDriven<User>{

	private User user = new User();
	
	public User getModel() {
		return user;
	}
	
	public String execute() {
		System.out.println(user.getUsername());
		System.out.println(user.getAge());
		return null;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

}
