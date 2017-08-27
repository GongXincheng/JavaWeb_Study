package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		//通过事件源对象 得到事件源
		ServletContext application = arg0.getServletContext();
		//创建一个集合 存放所有的session对象
		final List<HttpSession> list = Collections.synchronizedList( new ArrayList<HttpSession>());
		
		//把集合放到application中
		application.setAttribute("sessions", list);
		
		//创建一个计数器对象
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("开始扫描......");
				for (Iterator iterator = list.iterator(); iterator.hasNext();) {
					HttpSession session = (HttpSession) iterator.next();
					long l = System.currentTimeMillis() - session.getLastAccessedTime();
					if(l > 5000){//如果最后访问时间和当前差大于5秒
						System.out.println("Session移除了："+session.getId());
						session.invalidate();//销毁session
						iterator.remove();
					}
				}
				/*for (HttpSession session : list) {
					long l = System.currentTimeMillis() - session.getLastAccessedTime();
					if(l > 5000){//如果最后访问时间和当前差大于5秒
						session.invalidate();//销毁session
						list.remove(session);//从集合中移除
					}
				}*/
			}
		}, 2000, 5000);	//延迟2秒后执行，没5秒执行一次
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {

	}

}
