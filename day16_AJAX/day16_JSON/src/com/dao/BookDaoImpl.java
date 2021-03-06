package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

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

	/**
	 * 批量删除
	 * @param ids
	 * @throws Exception 
	 */
	public void deleteAllBooks(String[] ids) throws Exception {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		Object[][] params = new Object[ids.length][];
		for (int i = 0; i < params.length; i++) {
			params[i] = new Object[]{ids[i]};	//循环给每一个一维数组的元素赋值，值为id
		}
		qr.batch("delete from book where id=?", params );
	}

	/**
	 * 多条件查询图书
	 * @param id
	 * @param category
	 * @param name
	 * @param minprice
	 * @param maxprice
	 * @return
	 * @throws Exception 
	 */
	public List<Book> searchBooks(String id, String category, String name,
			String minprice, String maxprice) throws Exception {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		String sql = "select * from book where 1=1 ";
		List<String> list = new ArrayList<String>();
		if(!"".equals(id.trim())){
			sql+="and id like ?";
			list.add("%"+id.trim()+"%");
		}
		if(!"".equals(category.trim())){
			sql+="and category = ?";
			list.add(category.trim());
		}
		if(!"".equals(name.trim())){
			sql+="and name like ?";
			list.add("%"+name.trim()+"%");
		}
		if(!"".equals(minprice.trim())){
			sql+="and price>?";
			list.add(minprice.trim());
		}
		if(!"".equals(maxprice.trim())){
			sql+="and price<?";
			list.add(maxprice.trim());
		}
		
		return qr.query(sql, new BeanListHandler<Book>(Book.class), list.toArray());
	}

	/**
	 * 得到总记录数
	 * @return
	 * @throws Exception
	 */
	public int count() throws Exception {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		long l = (Long)qr.query("select count(*) from book", new ScalarHandler(1));
		return (int)l;
	}

	/**
	 * 查找分页数据
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @throws Exception 
	 */
	public List<Book> findBooks(int currentPage, int pageSize) throws Exception {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		List<Book> list = qr.query("SELECT * FROM book LIMIT ?,?", new BeanListHandler<Book>(Book.class), (currentPage-1)*pageSize , pageSize);
		return list;
	}
	
	/**
	 * 根据书名查找图书(模糊查询)
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public List<Object> searchBookByName(String name) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select name from book where name like ?", new ColumnListHandler(), "%"+name+"%");
	}
}
