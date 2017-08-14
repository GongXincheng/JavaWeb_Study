package com.pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class Test {
	public static void main(String[] args) {
		
		DataSource ds = new MyDataSource();
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
				conn = ds.getConnection();
				ps = conn.prepareStatement("");
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				conn.close();	//不能关
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
