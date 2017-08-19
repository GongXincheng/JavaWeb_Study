package com.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.domain.Book;
import com.service.BookServiceImpl;

public class AddCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String id = request.getParameter("id");
		
		BookServiceImpl bs = new BookServiceImpl();
		Book b = bs.findBookById(id);
		
		//从session中把购物车取出来
		HttpSession session = request.getSession();
		Map<Book, String> cart = (Map<Book, String>) session.getAttribute("cart");
	
		//如果是第一次访问，没有购物车对象,我们就创建一个购物车对象
		if(cart==null){
			cart = new HashMap<Book, String>();
		}
		
		int num = 1;
		//如果该书已经存在(重写Book的hashCode()和equals()方法)，数量+1
		if(cart.containsKey(b)){
			num = Integer.parseInt(cart.get(b)) +1;
		}
		//把图书放入购物车中 
		cart.put(b, num+"");
		
		//把cart对象放回到session的作用域中
		session.setAttribute("cart", cart);
		response.getWriter().print("<a href='"+request.getContextPath()+"/servlet/pageServlet'>继续购物</a>，<a href='"+request.getContextPath()+"/cart.jsp'>查看购物车</a>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
