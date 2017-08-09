package com.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Book;
import com.util.DBUtil;

public class AddCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//根据id得到书
		String id = request.getParameter("id");
		Book book = DBUtil.findBookById(id);
		
		//从session中取出List(购物车)
		List<Book> list = (List<Book>)session.getAttribute("cart");
		if(list==null){
			list = new ArrayList<Book>();
		}
		list.add(book);
		session.setAttribute("cart", list);//把list放回到session域中
		
		out.print("购买成功");
		response.setHeader("refresh", "2;url="+request.getContextPath()+"/servlet/showAllBooksServlet");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
