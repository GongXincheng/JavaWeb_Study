package com.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.domain.Book;

public class ChangeNumServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String num = request.getParameter("num");
		Book b = new Book();
		b.setId(id);
		
		//获取购物车
		Map<Book, String> cart = (Map<Book, String> )session.getAttribute("cart");
		//判断如果找到于id相同的书
		if("0".equals(num)){
			cart.remove(b);
		}
		if(cart.containsKey(b)){
			cart.put(b, num);
		}
		
		response.sendRedirect(request.getContextPath()+"/cart.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
