package com.json;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.domain.Book;
import com.util.C3P0Util;

public class JsonTest {
	
	@Test	//使用JSONObject对象封装对象类型数据
	public void test1(){
		Book b = new Book();
		b.setId("1001");
		b.setName("西游记");
		b.setPrice(20);
		
		String s = JSONObject.fromObject(b).toString();
		System.out.println(s);
	}
	
	
	@Test	//使用JSONArray封装List<Book>对象
	public void test2(){
		List<Book> list = new ArrayList<Book>();
		
		Book b1 = new Book();
		b1.setId("1001");
		b1.setName("西游记");
		b1.setPrice(20);
		Book b2 = new Book();
		b2.setId("1002");
		b2.setName("xml");
		b2.setPrice(10);
		Book b3 = new Book();
		b3.setId("1003");
		b3.setName("afasf");
		b3.setPrice(15);
		
		list.add(b1);
		list.add(b2);
		list.add(b3);
		
		String str = JSONArray.fromObject(list).toString();
		System.out.println(str);
	}
	
	@Test //使用JsonConfig取出不要的字段数据
	public void test3() throws SQLException{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		List<Book> list = qr.query("select * from book", new BeanListHandler<Book>(Book.class));
		
		//过滤掉一些属性
		JsonConfig jc = new JsonConfig();
		jc.setExcludes(new String[]{"pnum","description","id","category"});
		
		String str = JSONArray.fromObject(list,jc).toString();
		System.out.println(str);
	}
	
	
}
