package com.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.entity.User;
import com.util.C3P0Util;

public class TestSelect {
	
//查询版本 -> 1
	@Test
	public void testSelect1() throws SQLException{
		//创建QueryRunner对象
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		
		List<User> list = qr.query("select * from users", new ResultSetHandler<List<User>>(){//匿名内部累
			//当query方法执行select语句后，将结果集以参数的形式传递
			@Override
			public List<User> handle(ResultSet rs) throws SQLException {
				List<User> list = new ArrayList<User>();
				while(rs.next()){
					User u = new User();
					u.setId(rs.getInt(1));
					u.setUsername(rs.getString(2));
					u.setPassword(rs.getString(3));
					u.setEmail(rs.getString(4));
					u.setBirthday(rs.getDate(5));
					list.add(u);
				}
				return list;
			}
		});
		
		for (User user : list) {
			System.out.println(user);
		}
	}
	
	
//查询版本 -> 2
	@Test
	public void testSelect2() throws SQLException{
		//创建QueryRunner对象
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		//执行查询语句，并获取数据并封装到list集合中
		List<User> list = qr.query("select * from users where username = ?", new BeanListHandler<User>(User.class), "tom");
		//遍历
		for (User user : list) {
			System.out.println(user);
		}
	}
}	
