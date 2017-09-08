package com.interceptor;

import java.util.Scanner;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class Demo1Interceptor extends AbstractInterceptor {

	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("Demo1Interceptor拦截器，拦截了..执行动作方法之前");
		
		String rtVale = invocation.invoke();
		
		System.out.println("Demo1Interceptor拦截器，拦截了..执行动作方法之后...."+rtVale);
		
		return rtVale;
	}

}
