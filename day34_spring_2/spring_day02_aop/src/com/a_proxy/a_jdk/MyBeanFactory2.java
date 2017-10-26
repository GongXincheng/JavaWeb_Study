package com.a_proxy.a_jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyBeanFactory2 {
	
	public static UserService getUserService(){
		//目标类 (target)
		final UserService userService = new UserServiceImpl();
		//切面类(advice)
		final MyAspect myAspect = new MyAspect();
		
		//生成代理类对象
		UserService userProxy = (UserService)Proxy.newProxyInstance(
				MyBeanFactory2.class.getClassLoader(), 
				userService.getClass().getInterfaces(),  //处理类
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						
						myAspect.before();
						Object object = method.invoke(userService, args);
						myAspect.after();
						
						return object;
					}
				});
		
		return userProxy;
	}
}
