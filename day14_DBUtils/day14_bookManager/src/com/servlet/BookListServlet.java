package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Book;
import com.service.BookServiceImpl;

public class BookListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//调用业务逻辑
		BookServiceImpl  bsi = new BookServiceImpl();
		List<Book> list = bsi.findAllBooks();
		//跳转页面
		if(list!=null){
			request.setAttribute("books", list); //把list放入request对象中
			request.getRequestDispatcher("/admin/products/list.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
