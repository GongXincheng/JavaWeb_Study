package com.gxc.web.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {
	private static final long serialVersionUID = 1858570299297672345L;
 
	@Override
	public String doIntercept(ActionInvocation invocation) throws Exception {
		
		//判断session作用域是否有用户信息
		Object object = ActionContext.getContext().getSession().get("loginStaff");
		if(object==null){
			//友好提示信息
			//1. 获得当前运行的action
			Object action = invocation.getAction();
			//2.判断运行时是否是 ActionSupport
			if(action instanceof ActionSupport){
				ActionSupport actionSupport = (ActionSupport)action;
				actionSupport.addFieldError("", "请登录... ");
			}
			
			//没有登录需要登录
			return "login";
		}
		//放行
		return invocation.invoke();
	}

}
