package com.d_aspect.a_xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;


/**
 * 切面类，含有多个通知
 * @author GXC
 */
public class MyAspect {

	//前置通知
	public void myBefore(JoinPoint joinPoint){
		System.out.println("before...."+joinPoint.getSignature().getName());
	}
	
	//后置通知
	public void myAfterReturning(JoinPoint joinPoint, Object ret){
		System.out.println("AfterReturning..."+joinPoint.getSignature().getName()+" --->"+ret);
	}
	
	/**
	 * 环绕通知
	 * 		返回值必须为：object
	 * 		参数必须为：JoinPoint的子接口ProceedingJoinPoint
	 * 		必须抛异常：throws Throwable
	 * 
	 * 		手动执行目标方法	(返回object)	
	 * 
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	public Object myAround(ProceedingJoinPoint joinPoint) throws Throwable{
		
		System.out.println("前");
		
		//手动执行目标方法	
		Object object = joinPoint.proceed();
		
		System.out.println("后 ");
		return object;
	}
	
	//异常通知
	public void myAfterThrowing(JoinPoint joinPoint,Throwable e){
		System.out.println("AfterThrowing..."+e.getMessage());
	}
	
	//最终通知
	public void myAfter(){
		System.out.println("finally");
	}
}
