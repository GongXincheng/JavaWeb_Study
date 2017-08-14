package com.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBCPutil {
	private static DataSource ds = null;
	
	static{
		Properties prop = new Properties();
		
		try {
			//根据DBCPutil的classes的路径，加载配置文件
			prop.load( DBCPutil.class.getClassLoader().getResourceAsStream("dbcpconfig.properties") );
			
			//通过基础数据源工厂类，得到数据源对象
			ds = BasicDataSourceFactory.createDataSource(prop);
			
		} catch (Exception e) {
			throw new ExceptionInInitializerError("初始化错误,请检查配置文件");
		}
	}
	
	public static Connection getConnection(){
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("服务器繁忙");
		}
	}
	
	public static void release(Connection conn, Statement stmt, ResultSet rs){
		//关闭资源
		if(rs!=null){
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if(conn!=null){
			try {
				conn.close();	//关闭
			} catch (Exception e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
	
}
