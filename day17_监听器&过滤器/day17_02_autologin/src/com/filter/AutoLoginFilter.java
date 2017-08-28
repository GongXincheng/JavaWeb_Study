package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.User;
import com.service.UserService;

public class AutoLoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		// 1、把request,response两个对象转为HttpServletRequest,HttpServletResponse
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String uri = req.getRequestURI(); // /day17_02_autologin/login.jsp
		String path = req.getContextPath(); // /day17_02_autologin
		path = uri.substring(path.length()); // /login.jsp

		if (!("/login.jsp".equals(path) || "/servlet/loginServlet".equals(path))) {
			System.out.println("aaaaaaaaaaaaaaaaaaaaa");
			User user = (User) req.getSession().getAttribute("user");
			
			// 如果用户没有登陆过，才执行自动登录
			if (user == null) {
				// 2、处理业务逻辑
				// 得到cookies
				Cookie[] cookies = req.getCookies();
				String username = "";
				String password = "";

				for (int i = 0; cookies != null && i < cookies.length; i++) {
					if (cookies[i].getName().equals("user")) {
						String value = cookies[i].getValue();
						String[] values = value.split("&");
						username = values[0]; // tom
						password = values[1]; // 123
					}
				}

				// 登录操作
				UserService us = new UserService();
				User u = us.findUser(username, password);

				// 如果登陆成功，把用户信息封装到session中
				if (u != null) {
					req.getSession().setAttribute("user", u);
				}
			}
		}
		// 3、放行
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}

}
