package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ServletInputStream sis = request.getInputStream();
		int len = 0;
		byte[] b = new byte[1024];
		while( (len=sis.read(b))!=-1 ){
			//System.out.println(new String(new String(b,0,len).getBytes("ISO-8859-1"), "UTF-8"));
			System.out.println(new String(b, 0, len, "UTF-8"));
		}
		
		sis.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
