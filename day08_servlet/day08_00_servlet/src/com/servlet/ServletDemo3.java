package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo3 extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
//		System.out.println("Hello ******** doGet");
//		System.out.println(req.getRemoteAddr());
		
		String username = req.getParameter("username");
		String pwd = req.getParameter("password");
		System.out.println("帐号："+username);
		System.out.println("密码："+pwd);

		PrintWriter out = resp.getWriter();
		out.print("帐号被盗用");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("Hello ******** doPost");
	}
	
}
