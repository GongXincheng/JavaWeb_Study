package com.web.action;

import com.domain.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private User user = new User();
	private UserService us = new UserServiceImpl();
	
	public User getModel() {
		return user;
	}

	@Override
	public String execute() {
		System.out.println(user.getUsername());
		//根据用户名获取User对象
		User dbUser = us.findUserByUsername(user.getUsername());
		//判断User对象是否为空
		if(dbUser!=null){
			//如果不为空,跳转
			return "message";
		}
		
		//如果为空，则添加用户
		int i = us.register(user);
		if(i>0)
			return "success";
		
		return null;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
