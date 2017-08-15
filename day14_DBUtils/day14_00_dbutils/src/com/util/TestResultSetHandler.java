package com.util;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.entity.User;

public class TestResultSetHandler {
	
	@Test	//ArrayHandler：适合取1条记录。把该条记录的每一列的值封装到一个数组Object[]中
	public void test1() throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		Object[] arr = qr.query("select * from users where id = ?", new ArrayHandler(), 2);
		for (Object object : arr) {
			System.out.println(object);
		}
	}
	
	@Test	//ArrayListHandler：适合取多条记录。把该条记录的每一列的值封装到一个数组Object[]中，把数组封装到List中
	public void test2() throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		List<Object[]> list = qr.query("select * from users", new ArrayListHandler());
		
		for (Object[] os : list) {
			for (Object o : os) {
				System.out.print(o+"  ");
			}
			System.out.println();
		}
	}
	
	@Test	//ColumnListHandler：取某一列的数据。封装到List中
	public void test3() throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		List<Object> list = qr.query("select * from users", new ColumnListHandler(2));
		for (Object o : list) {
			System.out.println(o);
		}	
	}
	
	
	@Test	//KeyedHandler:取多条记录，每一条记录封装到一个Map中，再把每一个Map封装到另外一个Map中，key为指定的字段值
	public void test4() throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		
		//大Map的key是表中的某一列数据，小Map的key是列名，所以大Map的key为Object类型，小Map的key为String类型
		Map<Object,Map<String,Object>> map = qr.query("select * from users", new KeyedHandler(1));
		
		for (Map.Entry<Object, Map<String,Object>> m : map.entrySet()) {
			System.out.println(m.getKey());
			for (Map.Entry<String, Object> mm : m.getValue().entrySet()) {
				System.out.println(mm.getKey()+" : "+mm.getValue());
			}
			System.out.println("-----------------");
		}
	}
	
	@Test 	//MapHandler:适合取1条记录。把当前记录的列名和列值放到一个Map中
	public void test5() throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		Map<String, Object> map = qr.query("select * from users", new MapHandler());
		
		for (Map.Entry<String, Object> m : map.entrySet()) {
			System.out.println(m.getKey()+" : "+m.getValue());
		}
	}
	
	
	@Test 	//MapListHandler:适合取多条记录。把每条记录封装到一个Map中，再把Map封装到List中
	public void test6() throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		List<Map<String, Object>> list = qr.query("select * from users", new MapListHandler());
		for (Map<String, Object> map : list) {
			for (Map.Entry<String, Object> m : map.entrySet()) {
				System.out.println(m.getKey()+" : "+m.getValue());
			}
			System.out.println("-----------------");
		}
	}
	
	
	@Test	////ScalarHandler:适合取单行单列数据
	public void test7() throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		Object o = qr.query("select count(*) from users", new ScalarHandler(1));
		System.out.println(o.getClass().getName());	// java.lang.Long
	}
	
	
	@Test //BeanHandler: 获取第一行数据封装到指定的实体类
	public void test8() throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		User user = qr.query("select * from users", new BeanHandler<User>(User.class));
		System.out.println(user);	//User [id=1, username=tom, password=123, email=tom@163.com, birthday=2015-10-22]
	}
	
	@Test //BeanListHandler: 获取第一行数据封装到指定的实体类
	public void test9() throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		List<User> list = qr.query("select * from users where id=?", new BeanListHandler<User>(User.class), 99);
		
		for (User user : list) {
			System.out.println(user);
		}
		
		/*
		   	User [id=1, username=tom, password=123, email=tom@163.com, birthday=2015-10-22]
			User [id=2, username=jerry, password=456789, email=c10@163.com, birthday=2017-08-15]
		 */
	}
	
}
















