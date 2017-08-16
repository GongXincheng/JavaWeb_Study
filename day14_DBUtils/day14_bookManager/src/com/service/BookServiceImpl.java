package com.service;

import java.util.List;

import caom.dao.BookDaoImpl;

import com.domain.Book;

public class BookServiceImpl {
	//创建一个BookDaoImpl对象
	BookDaoImpl bookDao = new BookDaoImpl();
	
	public List<Book> findAllBooks(){
		try {
			return bookDao.findAllBooks();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
