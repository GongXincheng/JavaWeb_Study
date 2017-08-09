package com.cookie.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取客户端保存的最后访问时间
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		//获取客户端的所有Cookie对象
		Cookie[] cookies = request.getCookies();	
		
		for (int i = 0; cookies!=null && i < cookies.length; i++) {
			//判断当前Cookie中的name是否是想法要的cookie
			if( "lastAccessTime".equals(cookies[i].getName()) ){
				//lastAccessTime的值为毫秒时间值，需要转换
				long l = Long.parseLong(cookies[i].getValue());
				//将时间毫秒值转换为指定格式的字符串
				SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String time = timeFormat.format(new Date(l));
				
				out.write("最后访问时间为："+time);
			}
		}		
		
		//创建Cookie
		Cookie ck = new Cookie("lastAccessTime", new Date().getTime()+"");//System.currentTimeMillis();
		//设置Cookie的有效时间，单位(s)
		ck.setMaxAge(60*5);//五分钟后清除cookie
		
		//设置Cookie的path
		//ck.setPath("/day10_00_Cookie");
		//ck.setPath(request.getContextPath()+"");	//day10_00_Cookie
		ck.setPath("/");
		
		//把Cookie信息写回到客户端
		response.addCookie(ck);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
