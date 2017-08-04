package com.client;

import java.util.Scanner;

import com.entity.User;
import com.service.Dologin;

public class Login {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("请输入用户名：");
		String name = input.nextLine();
		
		System.out.println("请输入密码：");
		String password = input.nextLine();
		
		Dologin dl = new Dologin();
		User user = dl.findUser(name, password);
		if(user!=null){
			System.out.println("欢迎你："+user.getName());
		}else{
			System.out.println("用户名或密码错误！");
		}
		input.close();
	}
}
