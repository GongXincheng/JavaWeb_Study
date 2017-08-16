package com.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.domain.Book;
import com.service.BookServiceImpl;
import com.util.UUIDUtil;

public class AddBookServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//获取表单数据
		Book book = new Book();
		try {
			BeanUtils.populate(book, request.getParameterMap());
			book.setId(UUIDUtil.getUUID());	//手动生成随机ID
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//调用业务逻辑
		BookServiceImpl bs = new BookServiceImpl();
		bs.addBook(book);
		
		//分发转向
		request.getRequestDispatcher("bookListServlet").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
