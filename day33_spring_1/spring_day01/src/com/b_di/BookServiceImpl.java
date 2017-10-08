package com.b_di;

public class BookServiceImpl implements BookService {

	//spring方式：
	private BookDao bookDao;
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	@Override
	public void addBook() {
		this.bookDao.addBook();
	}

}
