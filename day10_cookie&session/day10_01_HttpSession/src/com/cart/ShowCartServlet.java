package com.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Book;

public class ShowCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print("购物车有以下商品：<br/><br/>");
		//得到session对象
		List<Book> books = (List<Book>)request.getSession().getAttribute("cart");
		if(books==null){
			out.print("你还什么都没买呢..");
			//response.sendRedirect(request.getContextPath()+"/servlet/showAllBooksServlet");
			response.setHeader("refresh", "2;url="+request.getContextPath()+"/servlet/showAllBooksServlet");
			return;
		}
		for (Book book : books) {
			out.write(book.getName()+"<br/><br/>");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
