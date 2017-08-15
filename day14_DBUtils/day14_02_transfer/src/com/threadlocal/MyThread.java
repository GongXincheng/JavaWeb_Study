package com.threadlocal;

public class MyThread extends Thread{

	private ThreadLocal tl;

	public MyThread(ThreadLocal tl) {
		// TODO Auto-generated constructor stub
		this.tl = tl;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(tl.get()+"aaaaaaaa");
	}
	
}
