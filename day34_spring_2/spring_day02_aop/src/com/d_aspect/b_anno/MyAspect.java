package com.d_aspect.b_anno;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/**
 * 切面类，含有多个通知
 */

@Component
@Aspect
public class MyAspect {

//	@Before("execution(* com.d_aspect.b_anno.UserServiceImpl.*(..))")
	public void myBefore(JoinPoint joinPoint){
		System.out.println("before...."+joinPoint.getSignature().getName());
	}
	
	
	/**
	 * 声明公共的切入点
	 */
	@Pointcut("execution(* com.d_aspect.b_anno.UserServiceImpl.*(..))")
	private void myPointCut(){
		
	}
	
	
//	@AfterReturning(value="myPointCut()", returning="ret")
	public void myAfterReturning(JoinPoint joinPoint, Object ret){
		System.out.println("AfterReturning..."+joinPoint.getSignature().getName()+" --->"+ret);
	}
	
	
//	@Around(value="myPointCut()")
	public Object myAround(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("前");
		//手动执行目标方法	
		Object object = joinPoint.proceed();
		System.out.println("后 ");
		return object;
	}
	
	
//	@AfterThrowing(value="myPointCut()", throwing="e")
	public void myAfterThrowing(JoinPoint joinPoint,Throwable e){
		System.out.println("AfterThrowing..."+e.getMessage());
	}

	
	@After(value="myPointCut()")
	public void myAfter(){
		System.out.println("finally");
	}
}
