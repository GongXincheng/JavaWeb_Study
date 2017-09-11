package com.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Demo1Action extends ActionSupport {
	private static final long serialVersionUID = 1L;

	public String execute() throws Exception {
		//1.获取ActionContext对象
		ActionContext context = ActionContext.getContext();
		
		//2.往map中存入数据
		context.put("contextMap", "hello ContextMap !");	//把数据直接存到了大Map中
		
		//-----------往session中存数据
		//第一种方式：获取key为session的Map
		Map<String, Object> sessionAttribute = context.getSession(); //获取key为session的小map
		sessionAttribute.put("SessionMap", "hello SessionMap!");
		//第二种方式：直接使用原始的HttpSession方式
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("HttpSession", "Hello___HttpSession!");
		
		//-----------往application中存数据
		//方法1：
		Map<String, Object> applicationAttribute = context.getApplication();
		applicationAttribute.put("applicationAttribute", "Hello_ApplicationAttribute!");
		//方法2：
		ServletContext application = ServletActionContext.getServletContext();
		application.setAttribute("ServletContext", "Hello---ServletContext!!");
		
		return SUCCESS;
	}
	
}
