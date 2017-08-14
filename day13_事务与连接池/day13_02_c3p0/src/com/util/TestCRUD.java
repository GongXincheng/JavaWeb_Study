package com.util;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

public class TestCRUD {
	
	@Test
	public void test1(){
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("insert into account(name, money) values('ggg',2000)");
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			C3P0Util.release(conn, ps, null);
		}
	}
}
