package com.web.action;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.validation.SkipValidation;

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
	
	/**
	 * 如果重写了该方法，那么动作类中的所有动作方法都执行验证
	 * 解决方法：
	 * 	1.添加 SkipValidating 注解
	 * 	2.定义验证方法的名称： validate + 动作名称
	 */
	/*public void validate() {
		if(StringUtils.isBlank(user.getUsername())){
			//直接调用父类的 addFieldError()方法，存入错误信息,第一个参数是表单name属性的值。第二个参数是错误信息
			super.addFieldError("username", "请输入用户名");
		}
	}*/
	
	public void validateExecute() {
		if(StringUtils.isBlank(user.getUsername())){
			//直接调用父类的 addFieldError()方法，存入错误信息,第一个参数是表单name属性的值。第二个参数是错误信息
			super.addFieldError("username", "请输入用户名");
		}
	}
	
	//@SkipValidation
	public String findAll(){
		
		return SUCCESS;
	}
	
	
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
