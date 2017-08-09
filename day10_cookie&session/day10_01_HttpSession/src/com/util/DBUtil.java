package com.util;

import java.util.HashMap;
import java.util.Map;
import com.entity.Book;

public class DBUtil {
	private static Map<String, Book> books = new HashMap<String, Book>();
	
	static {
		books.put("1", new Book("1","金瓶梅",20,"王瑞鑫"));
		books.put("2", new Book("2","葵花宝典",20,"郝斌"));
		books.put("3", new Book("3","九阴真经",30,"毕向东"));
		books.put("4", new Book("4","玉女心经",10,"陈光"));
	}
	
	//得到所有的图书列表
	public static Map<String, Book> findAllBooks(){
		return books;
	}
	
	//根据ID查找指定的书
	public static Book findBookById(String id){
		return books.get(id);
	}
}
