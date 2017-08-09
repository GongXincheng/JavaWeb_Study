package com.cookie.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClearServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie ck = new Cookie("lastAccessTime", "");
		ck.setPath("/");//要设置被删除Cookie的path，否则可能会删错对象
		ck.setMaxAge(0);//相当于删除
		response.addCookie(ck);//将ck写回客户端
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
