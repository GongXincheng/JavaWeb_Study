package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;
		
		try {
			conn = DBUtils.getConnection();	//得到连接对象
			String sql = "select * from users where name=? and password=? ";
			pstmt = conn.prepareStatement(sql);	//得到执行sql语句的对象
			
			//给？赋值
			pstmt.setString(1, name);
			pstmt.setString(2, pwd);
			
			rs = pstmt.executeQuery();//执行sql语句
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
			DBUtils.closeAll(rs,pstmt,conn);
		}
		return user;
	}
	
}
