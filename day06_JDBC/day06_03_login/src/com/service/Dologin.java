package com.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.entity.User;
import com.util.DBUtils;

public class Dologin {
	/**
	 * 根据用户名和密码查询用户对象信息
	 * @param name
	 * @param pwd
	 * @return user
	 */
	public User findUser(String name, String pwd){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		User user = null;
		
		try {
			conn = DBUtils.getConnection();	//得到连接对象
			stmt = conn.createStatement();	//得到执行sql语句的对象
			rs = stmt.executeQuery("select * from users where name='"+name+"' and password='"+pwd+"' ");//执行sql语句
			if(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setBirthday(rs.getDate("birthday"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(rs,stmt,conn);
		}
		return user;
	}
	
}
