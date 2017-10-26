package com.a_proxy.b_cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class MyBeanFactory2 {

	public static UserServiceImpl getUserService(){
		
		final UserServiceImpl userServiceImpl = new UserServiceImpl();
		final MyAspect myAspect = new MyAspect();
		
		//1.核心类
		Enhancer enhancer = new Enhancer();
		//2.确定父类
		enhancer.setSuperclass(userServiceImpl.getClass());
		//3.设置回调函数		
		enhancer.setCallback(new MethodInterceptor() {
			@Override
			public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
				
				myAspect.before();
				//执行目标类方法,返回代理对象
				Object object = method.invoke(userServiceImpl, args);
				myAspect.after();
				
				return object;
			}
		});
		
		//4.获得代理对象
		UserServiceImpl userServiceProxy = (UserServiceImpl) enhancer.create();
		
		return userServiceProxy;
	}
	
}
