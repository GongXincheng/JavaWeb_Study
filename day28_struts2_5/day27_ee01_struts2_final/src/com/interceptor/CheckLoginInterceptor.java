package com.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.domain.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class CheckLoginInterceptor extends MethodFilterInterceptor {

	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//获取session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		//在session中找user对象
		User user = (User)session.getAttribute("user");
		//判断user是否为空
		if(user == null){
			return "login";
		}
		return invocation.invoke();
	}

}
