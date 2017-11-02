package com.web.action;

import com.domain.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private static final long serialVersionUID = 5291021988882876820L;
	
	//1.封装数据
	User user = new User();
	
	@Override
	public User getModel() {
		return user;
	}

	//2.service
	UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	///////////////////////////////////////////////////
	
	/**
	 * 注册
	 * @return
	 */
	public String register(){
		userService.register(user);
		return SUCCESS;
	}
	
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
