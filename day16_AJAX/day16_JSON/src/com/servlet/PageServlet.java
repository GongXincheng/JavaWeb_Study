package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.PageBean;
import com.service.BookServiceImpl;

public class PageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//初始化每页显示的记录数
		int pageSize = 4;
		
		//当前页
		int currentPage = 1;
		String currPage = request.getParameter("currentPage");	//从上一页或下一页得到的数据
		if(currPage!=null){	//第一次访问时，currPage可能为null
			currentPage = Integer.parseInt(currPage);
		}
		BookServiceImpl bs = new BookServiceImpl();
		//分页查询并返回PageBean
		PageBean pb = bs.findBooksPage(currentPage, pageSize);
		
		request.setAttribute("pb", pb);
		request.getRequestDispatcher("/product_list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
