package com.b_factory_bean;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/*切面类
 * 
 * 切面类中需要确定通知,需要实现不同的接口(环绕通知),
 * 接口就是规范，确定方法名称
 * 
 * 	MethodInterceptor -> 环绕通知  
 */
public class MyAspect implements MethodInterceptor{
	
	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		
		System.out.println("前方法");
		
		//手动执行目标方法
		Object object = mi.proceed();
		
		System.out.println("后方法");
		
		return object;
	}
}
