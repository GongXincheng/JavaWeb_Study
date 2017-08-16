package caom.dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
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
}
