package com.servletConfig;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private ServletConfig config;

	@Override
//	public void init(ServletConfig config) throws ServletException {
//		// TODO Auto-generated method stub
//		this.config = config;
//	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String encoding = config.getInitParameter("encoding");	//获取配置文件的信息
//		System.out.println("配置文件的值："+encoding);
		
		//第二种
		String encoding1 = this.getServletConfig().getInitParameter("encoding");
		System.out.println("配置文件的值："+encoding1); 
		
		//第三种方式
		String encoding = this.getInitParameter("encoding");
		System.out.println("配置文件的值："+encoding);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
