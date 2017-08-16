package com.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.domain.Book;
import com.util.C3P0Util;

public class BookDaoImpl {
	
	/**
	 * 查找所有的图书
	 * @return
	 * @throws Exception
	 */
	public List<Book> findAllBooks() throws Exception{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		List<Book> list = qr.query("select * from book", new BeanListHandler<Book>(Book.class));
		return list;
	}
	
	/**
	 * 添加图书信息
	 * @param book
	 * @throws Exception
	 */
	public void addBook(Book book) throws Exception{
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("INSERT INTO book VALUES(?,?,?,?,?,?)",
				book.getId(), book.getName(), book.getPrice(), book.getPnum(), book.getCategory(), book.getDescription());
	}

	/**
	 * 根据id查找图书
	 * @param id
	 * @throws Exception 
	 */
	public Book finBookById(String id) throws Exception {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		Book book = qr.query("select * from book where id=?", new BeanHandler<Book>(Book.class), id);
		return book;
	}

	/**
	 * 修改图书
	 * @param book
	 * @throws Exception 
	 */
	public void updateBook(Book book) throws Exception {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("update book set name=?,price=?,pnum=?,category=?,description=? where id=? ",
				book.getName(),book.getPrice(),book.getPnum(),book.getCategory(),book.getDescription(),book.getId());
	}

	/**
	 * 根据id删除图书
	 * @param id
	 * @throws SQLException 
	 */
	public void delBook(String id) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("delete from book where id = ?", id);
	}
}
