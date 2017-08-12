package com.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import com.domain.User;
import com.domain.UserForm;
import com.exception.UserExistException;
import com.service.dao.UserService;
import com.service.impl.UserServiceImpl;

public class RegServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//1.获取表单数据,并验证
		UserForm uf = new UserForm();
		try {
			BeanUtils.populate(uf, request.getParameterMap());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		if(!uf.validate()){//如果验证类UserForm中的map不为空，则说明有错误信息
			request.setAttribute("uf", uf);
			request.getRequestDispatcher("/reg.jsp").forward(request, response);
			return;
		}
		
		//如果格式正确往下走
		User user = new User();
		try {
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			BeanUtils.populate(user, request.getParameterMap());
		
			//2.调用业务逻辑
			UserService us = new UserServiceImpl();
			//判断用户名是已被注册
			us.findUserByName(user.getUsername());
			//注册
			us.register(user);
		}
		catch(UserExistException e){
			request.setAttribute("error", "用户名已存在");
			request.getRequestDispatcher("/reg.jsp").forward(request, response);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//分发转向
		response.getWriter().write("注册成功!1秒钟跳到主页");
		System.out.println(request.getRemoteAddr());
		response.setHeader("refresh", "1;url="+request.getContextPath()+"/index.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
