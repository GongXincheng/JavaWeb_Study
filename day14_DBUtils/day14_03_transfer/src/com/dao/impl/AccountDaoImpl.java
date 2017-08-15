package com.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.dao.AccountDao;
import com.domain.Account;
import com.util.C3P0Util;
import com.util.ManagerThreadLocal;

public class AccountDaoImpl implements AccountDao {


	@Override
	public void updateAccount(String fromname, String toname, double money) throws Exception {
		// 创建一个QueryRunner对象
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		
		qr.update("update account set money=money-? where name=?", money, fromname);
		qr.update("update account set money=money+? where name=?", money, toname);
		
	}

	@Override
	public void updateAccount(Account account) throws Exception {
		QueryRunner qr = new QueryRunner();
		qr.update(ManagerThreadLocal.getConnection(),"update account set money=? where name=?",account.getMoney(), account.getName());
	}

	
	@Override
	public Account findAccountByName(String name) throws Exception {
		QueryRunner qr = new QueryRunner();
		Account account = qr.query(ManagerThreadLocal.getConnection(),"select * from account where name=?", new BeanHandler<Account>(Account.class), name);
		return account;
	}

	
	
}
