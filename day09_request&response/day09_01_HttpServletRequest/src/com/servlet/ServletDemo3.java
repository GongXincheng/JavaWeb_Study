package com.servlet;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.entity.User;

public class ServletDemo3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置编码方式,浏览器用的什么样的编码传过来的就是什么样的编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
//		test1(request);	//根据表单name 获取表单数据, request,getParameter(name);
//		test2(request);	//获取所有表单的name的值,request.getParameterNames();	
//		test3(request);	//获取表单的map , request.getParameterMap(); 运用ForEach循环遍历 map集合！ 映射
		
		try {
			User user = new User();
			System.out.println("封装数据前：" + user);

			Map<String, String[]> map = request.getParameterMap();	//使用BeanUtils框架
			BeanUtils.populate(user, map);
			
			System.out.println("封装数据后：" + user);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	
	private void test3(HttpServletRequest request) {
		try {
			//获取表单数据
			Map<String, String[]> map = request.getParameterMap();

			User user = new User();
			System.out.println("封装数据前：" + user);

			//ForEach循环遍历 map集合！
			for (Map.Entry<String, String[]> me : map.entrySet()) {
				String name = me.getKey();
				String[] value = me.getValue();

				//创建一个属性描述器
				PropertyDescriptor pd = new PropertyDescriptor(name, User.class);
				//得到setter属性
				Method setter = pd.getWriteMethod();
				
				if (value.length == 1) {
					setter.invoke(user, value[0]);	//给一个值的变量赋值
				} else {
					setter.invoke(user, (Object)value);	//相等于给复选框赋值
				}
			}
			
			System.out.println("封装数据后：" + user);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	private void test2(HttpServletRequest request) {
		//获取所有表单的name的值
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()){
			//得到每一个name名
			String name = names.nextElement();	
			System.out.print(name+" : ");
			
			//根据name名 得到value值
			String[] values = request.getParameterValues(name);
			for (int i = 0; values != null & i < values.length; i++) {
				System.out.print(values[i]+" ");
			}
			System.out.println();
		}
	}

	
	private void test1(HttpServletRequest request) {
		//获取表单数据
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		String sex = request.getParameter("sex");
		String[] hobbys = request.getParameterValues("hobby");
		String city = request.getParameter("city");
		
		System.out.println("用户名：" + userName);
		System.out.println("密码：" + pwd);
		System.out.println("性别：" + sex);
		System.out.print("爱好：");
		for(String hobby:hobbys){
			System.out.print(hobby+"  ");
		}
		System.out.println();
		System.out.println("城市：" + city);
	}

	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
