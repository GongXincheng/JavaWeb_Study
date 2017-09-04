package com.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.web.domain.User;

public class Demo3Action extends ActionSupport{
	User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		System.out.println(user.getUsername());
		System.out.println(user.getAge());
		return null;
	}
	
	
}
