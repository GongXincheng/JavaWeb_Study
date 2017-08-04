package com.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import com.entity.User;

public class TestCRUD {
//查询
	@Test
	public void testSelect() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06","root","123");
		
		Statement stmt = conn.createStatement();
		
		//执行sql语句，并返回结果
		ResultSet rs = stmt.executeQuery("select * from users");
		
		List<User> list = new ArrayList<User>();
		
		//处理结果
		while(rs.next()){
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));
			user.setEmail(rs.getString("email"));
			user.setBirthday(rs.getDate("birthday"));
			list.add(user);
		}
		
//		Iterator<User> it = list.iterator();
//		while(it.hasNext()){
//			User u = it.next();
//			System.out.println(u.getId());
//		}
		
		for(User user:list){
			System.out.println(user);
		}
		
		//关闭资源
		rs.close();	
		stmt.close();
		conn.close();
	}

//插入
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
	
//更新
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

//删除
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
