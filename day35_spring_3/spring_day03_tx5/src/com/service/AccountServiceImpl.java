package com.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dao.AccountDao;

@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT)
public class AccountServiceImpl implements AccountService {

	//注入 AccountDao
	private AccountDao accountDao;
	public AccountDao getAccountDao() {
		return accountDao;
	}
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@SuppressWarnings("unused")
	@Override
	public void transfer(String outer, String inner, Integer money) {
		
		accountDao.out(outer, money);
		int i = 1/0;
		accountDao.in(inner, money);
		
	}

}
