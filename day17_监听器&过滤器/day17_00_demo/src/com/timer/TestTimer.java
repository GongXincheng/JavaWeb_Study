package com.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {
	public static void main(String[] args) {
		
		//创建一个计数器对象
		Timer t = new Timer();
		
		t.schedule(new TimerTask() {	//要执行的任务
			
			@Override
			public void run() {
				System.out.println(new Date().toLocaleString());
			}
		}, 2000, 1000); //两秒之后 ， 每1秒执行一次
	}
}
