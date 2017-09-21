package com.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.IUserService;
import com.service.impl.UserServiceImpl;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private static final long serialVersionUID = 1L;

	private IUserService service = new UserServiceImpl();
	private User user = new User();

//登录
	public String login(){
		User dbUser = service.login(user.getLogonName(), user.getLogonPwd());
		//登录失败
		if(dbUser == null){
			addActionError("用户名不存在，或密码错误!");
			return "input";
		}
		//如果登陆成功将dbuser存到session域中
//		ActionContext.getContext().getSession().put("user", dbUser);
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("user", dbUser);
		
		return SUCCESS;
	}

	
	
	
	public User getModel() {
		return user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
