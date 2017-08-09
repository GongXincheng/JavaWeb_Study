package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoLogin extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//获取表单数据
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		String code = request.getParameter("code");
		String scode = (String)request.getSession().getAttribute("scode");
		
		//处理处理业务逻辑
		if("tom".equals(userName)&&"123".equals(pwd)){
			if(!code.equalsIgnoreCase(scode)){
				request.setAttribute("msg", "验证码错误");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			out.print("登陆成功");
		}else{
			out.print("密码错误");
		}
		//分发转向
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
