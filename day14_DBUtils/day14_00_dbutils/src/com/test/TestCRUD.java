package com.test;

import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.util.C3P0Util;

public class TestCRUD {
	
	@Test
	public void testInsert() throws SQLException{
		//创建QueryRunner对象
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		int x = qr.update("insert into users(username,password,email,birthday) value(?,?,?,?)", "jerry","123","c10@163.com",new Date());
		if(x>0){
			System.out.println("插入成功");
		}
	}
	
	@Test
	public void testUpdate()throws SQLException{
		//创建QueryRunner对象
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		int x = qr.update("update users set password=? where id=?","456789",2);
		if(x>0){
			System.out.println("修改成功");
		}
	}
	
	@Test
	public void testDelete()throws SQLException{
		//创建QueryRunner对象
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		int x = qr.update("delete from users where id=?", 3);
		if(x>0){
			System.out.println("删除成功");
		}
	}
	
	@Test	//batch()  批处理，只能处理相同的sql语句 
	public void testBatch()throws SQLException{
		//创建QueryRunner对象
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		Object[][] params = new Object[10][];	//高纬代表执行多少次sql语句
		for (int i = 0; i < params.length; i++) {
			params[i] = new Object[]{"jerry"+i,"123","c10@163.com",new Date()};//给每次执行的sql中的？赋值
		}
		qr.batch("insert into users(username,password,email,birthday) value(?,?,?,?)", params);
	}
	
}
