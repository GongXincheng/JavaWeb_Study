package com.a_proxy.a_jdk;

//切面类
public class MyAspect {
	
	public void before(){
		System.out.println("前方法");
	}
	
	public void after(){
		System.out.println("后方法");
	}
}
