package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo5 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String str = "aaaa";
		
		System.out.println("A: 我想办事");
		System.out.println("B：我办不了，我可以找人帮你办");
		
		//将非表单的数据添加到request中
		request.setAttribute("str", str);
		
		//将请求转发到 demo7 中,请求转发不能跳转到其他应用，地址栏不变
		//request.getRequestDispatcher("/servlet/demo7").forward(request, response);
		
		//将请求重定向到 demo7 中,请求能跳转到其他应用，地址栏变化
		response.sendRedirect(request.getContextPath()+"/servlet/demo7");
		
		System.out.println("B：事办完了");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
