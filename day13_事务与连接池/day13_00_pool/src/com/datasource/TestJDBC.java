package com.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;

public class TestJDBC {
	@Test
	public void test1(){
		Connection conn = null;
		PreparedStatement ps = null;
		
		DataSource ds = new MyDataSource();
		
		try {
			conn = ds.getConnection();//从池中取出一个连接 connection
			ps = conn.prepareStatement("...");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				conn.close();//可以关
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
