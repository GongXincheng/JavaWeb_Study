package com.function;

/**
 * EL表达式的自定义方法
 * EL表达式只能支持静态方法调用
 */
public class MyFunction {
	
	public static String toUpperCase(String str){
		
		return str.toUpperCase();
	}
	
}
