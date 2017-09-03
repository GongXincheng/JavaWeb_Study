package com.web.action;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 动态参数封装(第一种情况):
 * 		数据模型与动作类写在一起。
 * @author Administrator
 *
 */
public class Demo2Action extends ActionSupport {
	private String username;
	private int age;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String addUser(){
		System.out.println("username:"+username);
		System.out.println("age:"+age);
		return null;	//不返回任何结果视图，NONE常量
	}
	
}
