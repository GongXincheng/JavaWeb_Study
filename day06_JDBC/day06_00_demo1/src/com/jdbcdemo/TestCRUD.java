package com.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.Test;

public class TestCRUD {

	@Test
	public void testInsert() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06","root","123");
		
		Statement stmt = conn.createStatement();
		
		int x = stmt.executeUpdate("INSERT INTO users VALUES(5,'gxc1','123','gxc@qq.com','2017-08-04')");
		
		if(x>0){
			System.out.println(x);
			System.out.println("success");
		}		
		
		stmt.close();
		conn.close();
	}
	

	@Test
	public void testUpdate() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06","root","123");
		
		Statement stmt = conn.createStatement();
		
		int x = stmt.executeUpdate("UPDATE users SET PASSWORD = '123456' WHERE id=3");
		
		if(x>0){
			System.out.println(x);
			System.out.println("success");
		}		
		
		stmt.close();
		conn.close();
	}
	
	@Test
	public void testDelete() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06","root","123");
		
		Statement stmt = conn.createStatement();
		
		int x = stmt.executeUpdate("delete from users where id = 5");
		
		if(x>0){
			System.out.println(x);
			System.out.println("success");
		}		
		
		stmt.close();
		conn.close();
	}
	
}
