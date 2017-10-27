package com.c_spring_aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/*切面类
 * 
 * AOP联盟，通知类型
 * 切面类中需要确定通知,需要实现不同的接口(环绕通知),
 * 接口就是规范，确定方法名称
 * 
 * 	MethodInterceptor -> 环绕通知  
 */
public class MyAspect implements MethodInterceptor{
	
	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		
		System.out.println("前方法4");
		
		//手动执行目标方法
		Object object = mi.proceed();
		
		System.out.println("后方法4");
		
		return object;
	}
}
