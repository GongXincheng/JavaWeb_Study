package com.service.impl;

import com.dao.AccountDao;
import com.dao.impl.AccountDaoImpl;
import com.service.AccountService;

public class AccountServiceImpl implements AccountService {
	AccountDao accountDao = new AccountDaoImpl();
	
	@Override
	public void transfer(String fromname, String toname, double money)
			throws Exception {
		
		accountDao.updateAccount(fromname, toname, money);
		
	}

}
