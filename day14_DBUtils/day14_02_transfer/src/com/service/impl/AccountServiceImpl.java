package com.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.dao.AccountDao;
import com.dao.impl.AccountDaoImpl;
import com.domain.Account;
import com.service.AccountService;
import com.util.C3P0Util;

public class AccountServiceImpl implements AccountService {
	
	
	@Override
	public void transfer(String fromname, String toname, double money) {
		//accountDao.updateAccount(fromname, toname, money);
		Connection conn = C3P0Util.getConnection();
		AccountDao ad = new AccountDaoImpl(conn);
		try {
			conn.setAutoCommit(false);	//begin
			//分别得到转出和转入账户对象
			Account fromAccount = ad.findAccountByName(fromname);
			Account toAccount = ad.findAccountByName(toname);
			
			//修改账户各自的金额
			fromAccount.setMoney(fromAccount.getMoney()-money);
			toAccount.setMoney(toAccount.getMoney()+money);
			
			//完成转账操作
			ad.updateAccount(fromAccount);
//			int i = 10/0;
			ad.updateAccount(toAccount);
			
			conn.commit();//事务提交
		} catch (Exception e) {
			try {
				conn.rollback();//回滚事务
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				conn.close(); //关闭
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
