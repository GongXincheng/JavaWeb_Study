package com.web.action;

//动作类
public class HelloAction {
	
	/**
	 * 在动作类中指定的动作方法
	 * 动作方法的书写要求：
	 * 		1.都是public
	 * 		2.返回值必须是String
	 * 		3.必须都没有参数
	 * @return
	 */
	public String sayHello(){
		System.out.println("HelloAction的sayHello执行了...");
		return "success";	
	}
}
