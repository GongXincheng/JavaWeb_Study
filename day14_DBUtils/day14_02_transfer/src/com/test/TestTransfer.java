package com.test;

import com.service.AccountService;
import com.service.impl.AccountServiceImpl;

public class TestTransfer {

	public static void main(String[] args) throws Exception {
		
		AccountService as = new AccountServiceImpl();
		as.transfer("aaa", "bbb", 100);
	}
	
}
