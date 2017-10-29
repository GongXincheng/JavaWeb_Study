package com.service;

import com.dao.AccountDao;

public class AccountServiceImpl implements AccountService {

	//注入 AccountDao
	private AccountDao accountDao;
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
	@Override
	public void transfer(String outer, String inner, Integer money) {
		
		accountDao.in(inner, money);
		int i = 1/0;
		accountDao.out(outer, money);
	}

}
