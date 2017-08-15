package com.crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.entity.User;
import com.util.C3P0Util;

public class TestCRUD {

//查询
	@Test
	public void testSelect(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = C3P0Util.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from users");
			
			List<User> list = new ArrayList<User>();
			while(rs.next()){
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setBirthday(rs.getDate("birthday"));
				list.add(user);
			}
			
			for(User user:list){
				System.out.println(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			C3P0Util.release(conn, stmt, rs);
		}
		
	}
	
//添加
	@Test
	public void testInsert(){
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = C3P0Util.getConnection();
			stmt = conn.createStatement();
			int x = stmt.executeUpdate("INSERT INTO users VALUES(4,'gxc','123','gxc@qq.com','2017-08-04')");
			if(x>0){
				System.out.println("success!");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			C3P0Util.release(conn, stmt, null);
		}
		
	}

//更新
	@Test
	public void testUpdate(){
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = C3P0Util.getConnection();
			stmt = conn.createStatement();
			int x = stmt.executeUpdate("UPDATE users SET PASSWORD = '757853' WHERE id=3");
			if(x>0){
				System.out.println("success!");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			C3P0Util.release(conn, stmt, null);
		}
		
	}

//删除
	@Test
	public void testDelete(){
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = C3P0Util.getConnection();
			stmt = conn.createStatement();
			int x = stmt.executeUpdate("delete from users where id = 4");
			if(x>0){
				System.out.println("success!");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			C3P0Util.release(conn, stmt, null);
		}
		
	}
	
}
