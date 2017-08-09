package com.cookie.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		//获取表单数据
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		String remember = request.getParameter("remember");
		
		Cookie ck = new Cookie("userName", userName);
		ck.setPath("/");
		//处理业务逻辑
		
		//分发转向
		if("tom".equals(userName)&&"123".equals(pwd)){
			if(remember!=null){
				ck.setMaxAge(Integer.MAX_VALUE);
			}else{
				ck.setMaxAge(0);//删除Cookie
			}
			
			response.addCookie(ck);
			out.write("登陆成功");
		}
		else{
			out.write("登陆失败，2秒跳转");
			//设置2秒钟跳到重新登录
			response.setHeader("refresh", "2;url="+request.getContextPath()+"/servlet/login");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
