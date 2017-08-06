package com.servletContext;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletForwardDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("我要办事");
		System.out.println("你的事我办不了，我可以帮你找人办");
		ServletContext application = this.getServletContext();
		//将请求向下传递
		RequestDispatcher rd = application.getRequestDispatcher("/servlet/ServletForwardDemo2");
		rd.forward(request, response);
		System.out.println("事办完了");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
