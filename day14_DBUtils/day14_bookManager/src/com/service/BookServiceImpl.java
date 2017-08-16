package com.service;

import java.util.List;

import com.dao.BookDaoImpl;
import com.domain.Book;

public class BookServiceImpl {
	//创建一个BookDaoImpl对象
	BookDaoImpl bookDao = new BookDaoImpl();
	
	/**
	 * 查找所有的图书
	 * @return
	 */
	public List<Book> findAllBooks(){
		try {
			return bookDao.findAllBooks();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 添加图书信息
	 */
	public void addBook(Book book){
		try {
			bookDao.addBook(book);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据id查找图书
	 * @param id
	 * @return
	 */
	public Book findBookById(String id) {
		try {
			return bookDao.finBookById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateBook(Book book) {
		try {
			bookDao.updateBook(book);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
