package com.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SevletDemo3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//通过路径得到一个输入流
		String path = this.getServletContext().getRealPath("/WEB-INF/classes/蓝色.jpg");
		FileInputStream fis = new FileInputStream(path);
		
		//创建一个字节输出流
		ServletOutputStream sos = response.getOutputStream();
		
		//得到要下载的文件名
		String filename = path.substring(path.lastIndexOf("\\")+1);
		
		//设置文件名的编码,将不安全的文件名改为UTF-8格式
		filename = URLEncoder.encode(filename, "UTF-8");	
		
		//告知客户端要下载文件
		response.setHeader("content-disposition","attachment;filename="+filename);
		response.setHeader("content-type", "image/jpeg");
		
		//执行输出操作
		int len = 1;
		byte[] b = new byte[1024];
		while( (len=fis.read(b)) != -1 ){
			sos.write(b, 0, len);
		}
		
		//关闭流
		sos.close();
		fis.close();
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
