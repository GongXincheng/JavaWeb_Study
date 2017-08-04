package com.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * 2017年8月4日 10:14:29
 * 使用JDBC技术实现查询数据库数据
 * 并显示在控制台中
 */
public class Demo2 {

	public static void main(String[] args) throws Exception {

		//加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//获取连接 Connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06", "root", "123");
		
		//得到执行sql语句的对象 statement
		Statement stmt = conn.createStatement();
		
		//执行sql语句，并返回结果
		ResultSet rs = stmt.executeQuery("select * from users");
		
		//处理结果
		while(rs.next()){
			System.out.print(rs.getObject(1)+"\t");
			System.out.print(rs.getObject(2)+"\t");
			System.out.print(rs.getObject(3)+"\t");
			System.out.print(rs.getObject(4)+"\t");
			System.out.print(rs.getObject(5)+"\t");
			System.out.println();
		}
		
		//关闭资源
		rs.close();
		stmt.close();
		conn.close();
	}

}
