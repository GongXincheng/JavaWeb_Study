package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//getMethod(); 获取请求方式
		//getRequestURL(); 返回客户端发出请求时的完整URL
		//getRequestURL(); 返回请求行中的资源名部分
		//getContextPath(); 当前应用的虚拟目录 /day09_01_HttpServletRequest
		//getQueryString(); 返回请求行中的参数部分
		
		System.out.println("请求方式："+request.getMethod());	//GET
		System.out.println("URL：" + request.getRequestURL().toString());	//http://localhost:8080/day09_01_HttpServletRequest/servlet/demo1
		System.out.println("URI：" + request.getRequestURI());	///day09_01_HttpServletRequest/servlet/demo1
		System.out.println("虚拟目录："+ request.getContextPath()); // day09_01_HttpServletRequest
		System.out.println("参数部分："+ request.getQueryString());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
