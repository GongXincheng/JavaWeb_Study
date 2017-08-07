package com.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		test1(request);
		
		//获取所有请求消息头的name , getHeaderNames()
		Enumeration<String> names = request.getHeaderNames();
		while(names.hasMoreElements()){
			String e = names.nextElement();
			System.out.println(e + "  ->  " + request.getHeader(e));
		}
	}

	private void test1(HttpServletRequest request) {
		String header = request.getHeader("User-Agent");
		System.out.println(header);
		if(header.toLowerCase().contains("msie")){
			System.out.println("你使用的是IE浏览器");
		}
		else if(header.toLowerCase().contains("firefox")){
			System.out.println("你使用的是火狐浏览器");
		}
		else if(header.toLowerCase().contains("chrome")){
			System.out.println("你使用的是谷歌浏览器");
		}
		else if(header.toLowerCase().contains("qqbrowser")){
			System.out.println("你使用的是腾讯浏览器");
		}
		else{
			System.out.println("你使用的是其他浏览器");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
