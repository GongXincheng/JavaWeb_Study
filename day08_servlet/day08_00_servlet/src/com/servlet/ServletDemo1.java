package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletDemo1 implements Servlet{

	//Servlet生命周期的方法，实例化
	//在Servlet 第一次 被访问时调用
	public ServletDemo1(){
		System.out.println("****** ServletDemo1 ***** 实例化 ****");
	}
	
	//Servlet生命周期的方法，初始化
	//在Servlet 第一次 被访问时调用
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("****** init ***** 初始 ****");
	}
	
	//Servlet生命周期的方法，服务方法
	//每次访问时都会被调用
	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		System.out.println("service 服务执行 !");
		out.print("service 服务执行 !");
	}
	
	//Servlet生命周期的方法，销毁
	@Override
	public void destroy() {
		System.out.println("****** destroy ***** 销毁 ****");
	}

	
	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}


	
}
