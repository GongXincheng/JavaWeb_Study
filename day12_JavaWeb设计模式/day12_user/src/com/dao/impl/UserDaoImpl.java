package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import com.dao.UserDao;
import com.domain.User;
import com.utils.DBUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public void addUser(User user) throws Exception {
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DBUtil.getConnection();

			String sql = "INSERT INTO users(username,PASSWORD,email,birthday) VALUES (?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date = sdf.format(user.getBirthday());
			ps.setString(4, date);

			int i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("添加失败!");
		}
		finally{
			DBUtil.closeAll(null, ps, conn);
		}
		
	}

	@Override
	public User findUser(User user) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User u = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from users where username=? and password=?";
			ps = conn.prepareStatement(sql );
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			rs = ps.executeQuery();
			
			if(rs.next()){
				u = new User();
				u.setId(rs.getInt(1));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				u.setBirthday(rs.getDate("birthday"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			DBUtil.closeAll(rs, ps, conn);
		}
		return u;
	}

	@Override
	public boolean findUserByName(String name) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from users where username=?";
			ps = conn.prepareStatement(sql );
			ps.setString(1, name);
			rs = ps.executeQuery();
			
			if(rs.next()){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			DBUtil.closeAll(rs, ps, conn);
		}
		return false;
	}

	
}
