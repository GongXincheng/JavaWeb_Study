package com.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import com.util.DBUtil;


public class TestTransation {
	@Test
	public void Test1(){
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false); //相当于begin 开启事务
			ps = conn.prepareStatement("update account set money=money-100 where name='aaa'");
			ps.executeUpdate();
			ps.close();
			//int i = 10/0;
			ps = conn.prepareStatement("update account set money=money+100 where name='bbb'");
			ps.executeUpdate();
			conn.commit();//提交事务
		} catch (SQLException e) {
			try {
				conn.rollback();//回滚事务 rollback
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally{
			DBUtil.closeAll(null, ps, conn);
		}
	}
	
}
