package com.history;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Book;
import com.util.DBUtil;

public class ShowAllBooksServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("本网站有以下好书：<br/><br/>");
		
		Map<String, Book> books = DBUtil.findAllBooks();
		for (Map.Entry<String, Book> book : books.entrySet()) {
			out.print("<a href='"+request.getContextPath()+"/servlet/showBookDetail?id="+book.getKey()+"' target='_blank' >"+book.getValue().getName()+"</a><br/><br/>");
		}
		
		
		out.print("<hr/>您最近浏览过的书有：<br/><br/>");
		Cookie[] cookies = request.getCookies();
		for (int i = 0; cookies!=null &&i < cookies.length; i++) {
			
			if( "historyBookId".equals(cookies[i].getName()) ){	//判断是否有historyBookId的cookie
				String value = cookies[i].getValue();	//1-2-3
				String[] ids = value.split("-");
				for (int j = 0; j < ids.length; j++) {
					Book book = DBUtil.findBookById(ids[j]);	//根据id得到指定的书
					out.print(book.getName()+"<br/><br/>");
				}
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
