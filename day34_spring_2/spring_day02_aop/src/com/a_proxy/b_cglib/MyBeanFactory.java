package com.a_proxy.b_cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class MyBeanFactory {

	public static UserServiceImpl createUserService(){
		
		//1.目标类
		final UserServiceImpl userService = new UserServiceImpl();
		
		//2.切面类
		final MyAspect myAspect = new MyAspect();
			
		//3.代理类,采用cglib，底层创建目标子类
		//3.1 核心类
		Enhancer enhancer = new Enhancer();
		
		//3.2 确定父类
		enhancer.setSuperclass(userService.getClass());
		
		/* 3.3 设置回调函数，MethodInterceptor接口等效 jdk InvocationHandler接口
		 * 
		 * 		intercept 等效于jdk的 invoke()方法
		 * 			参数1，参数2，参数3 与invoke()一样
		 * 			参数4：方法的代理
		 */
		enhancer.setCallback(new MethodInterceptor(){
			
			@Override
			public Object intercept(Object proxy, Method method, Object[] args,
					MethodProxy methodProxy) throws Throwable {
				//前方法
				myAspect.before();
				
				//执行目标类的方法
				Object object = method.invoke(userService, args);
				//执行代理类的父类->目标类(目标类和代理类为父子关系	)
				methodProxy.invokeSuper(proxy, args);
				//后方法
				myAspect.after();
				
				return object;
			}});
		
		//3.4 创建代理
		UserServiceImpl proxyService = (UserServiceImpl) enhancer.create();
		
		return proxyService;
	}
	
}
