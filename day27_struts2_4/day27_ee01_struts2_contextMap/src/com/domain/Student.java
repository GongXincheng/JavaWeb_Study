package com.domain;

import java.io.Serializable;
/**
 * 只是为了演示值栈的存取
 */
public class Student implements Serializable {
	private static final long serialVersionUID = 6145169072212058834L;
	
	private String name;
	private int age;
	
	public Student() {
		
	}

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
