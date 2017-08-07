package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SevletDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//服务器中 默认的编码为ISO-8859-1，它不支持中文，tomcat规定的
		
//		告诉服务器应该使用 UTF-8 解析文本
//		response.setCharacterEncoding("UTF-8");
		
//		告诉客户端要使用什么编码方式
//		response.setHeader("content-type", "text/html;charset=UTF-8");
		
//		告诉服务器应该使用 UTF-8 解析文本,告诉客户端要使用什么编码方式
		response.setContentType("text/html; charset=UTF-8");	//等价
		
		PrintWriter out = response.getWriter();	//得到一个字符输出流
		out.write("你好！");	//向客户端响应文本内容
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
