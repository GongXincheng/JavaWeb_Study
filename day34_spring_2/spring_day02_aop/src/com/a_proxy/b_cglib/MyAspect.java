package com.a_proxy.b_cglib;

//切面类(通知)
public class MyAspect {
	
	public void before(){
		System.out.println("前方法");
	}
	
	public void after(){
		System.out.println("后方法");
	}
}
