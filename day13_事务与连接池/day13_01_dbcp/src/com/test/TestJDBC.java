package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import com.utils.DBCPutil;

public class TestJDBC {
	
	@Test
	public void test1(){
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DBCPutil.getConnection();
			ps = conn.prepareStatement("");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			DBCPutil.release(conn, ps, null);
		}
	}
}
