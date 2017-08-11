package com.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.domain.User;
import com.service.dao.UserService;
import com.service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		User user = new User();
		try {
			//获取表单数据
			BeanUtils.populate(user, request.getParameterMap());
			
			//调用业务逻辑
			UserService us = new UserServiceImpl();
			User u = us.login(user);
			
			//分发转向
			if(u!=null){//如果登录成功，就把user对象放到session中
				request.getSession().setAttribute("user", u);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			else{
				response.sendRedirect(request.getContextPath()+"/login.jsp");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
