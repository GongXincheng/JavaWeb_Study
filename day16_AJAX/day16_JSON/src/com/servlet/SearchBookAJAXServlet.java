package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Book;
import com.service.BookServiceImpl;

public class SearchBookAJAXServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8"); 
		
		String name = new String(request.getParameter("name").getBytes("ISO-8859-1"), "UTF-8");
		BookServiceImpl bs = new BookServiceImpl();
		List<Object> list = bs.searchBookByName(name);
		
		//把集合中的数据转换为字符串返回到
		String str = "";
		for (int i = 0; i < list.size(); i++) {
			if(i>0){
				str+=","+list.get(i);
			}else{
				str+=list.get(i);
			}
		}
		
		//把数据直接响应带客户端
		response.getWriter().print(str);
		
		/*request.setAttribute("str", str);
		request.getRequestDispatcher("/index.jsp").forward(request, response);*/
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
