package com.a_proxy.a_jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyBeanFactory {

	public static UserService createUserService(){
		
		//1.目标类
		final UserService userService = new UserServiceImpl();
		
		//2.切面类
		final MyAspect myAspect = new MyAspect();
		
		 /*3.代理类：将目标类(切入点PoinCut)和切面类(通知advice)结合 --> 切面
		 * 
		 * 	  Proxy.newProxyInstance
		 * 		参数1：ClassLoader loader (类加载器:动态代理类运行时创建,任何类都需要类加载器将其加载到内存)
		 * 			一般情况下：当前类.class.getClassLoader(); 
		 * 					 目标类实例(userService).getClass.getClassLoader(); 
		 * 
		 * 		参数2： Class<?>[] interfaces (代理类需要实现的所有接口)
		 * 			方式一： 目标类实例.getClass.getInterfaces(); 注意：只能获取自己的接口，不能的到父元素的接口
		 * 			方式二： new Class[]{UserService.class};
		 * 
		 * 		参数3：InvocationHandler h (处理类)：是一个接口，必须进行实现类,一般采用匿名内部类
		 * 			 	提供了invoke()方法，代理类的每一个方法执行时都掉用一次invoke
		 * 					参数3-1：Object proxy ：代理对象
		 * 					参数3-2：Method method ：代理对象当前执行的方法的描述对象(反射)
		 * 								1.获取执行的方法名：method.getName();
		 * 								2.执行方法：method.invoke(对象,实际参数);
		 * 					参数3-3：Object[] args ：方法实际参数
		 * */
		 
		
		UserService proxyService = (UserService)Proxy.newProxyInstance(
				MyBeanFactory.class.getClassLoader(), 
				userService.getClass().getInterfaces(), 
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						//将目标类和切面类结合
						//前执行
						myAspect.before();
						
						//执行目标类的方法
						Object object = method.invoke(userService, args);
						
						//后执行
						myAspect.after();
						
						return object;
					}
				});
		
		 /*
		//1.目标类
		final UserService userService = new UserServiceImpl();
		//2.切面类
		final MyAspect myAspect = new MyAspect();
		//3.代理类
		UserService proxyService = (UserService) Proxy.newProxyInstance(
				MyBeanFactory.class.getClassLoader(), 
				userService.getClass().getInterfaces(), 
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						myAspect.before();
						Object object = method.invoke(userService, args);
						myAspect.after();
						return object;
					}
				});
		
		*/
		
		return proxyService;
	}
	
}
