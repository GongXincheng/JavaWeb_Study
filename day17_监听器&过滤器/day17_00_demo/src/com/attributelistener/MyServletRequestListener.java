package com.attributelistener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class MyServletRequestListener implements
		ServletRequestAttributeListener {

	@Override
	public void attributeAdded(ServletRequestAttributeEvent arg0) {
		System.out.println("ServletRequest 添加属性了");
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
		System.out.println("ServletRequest 移除属性了");
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent arg0) {	//参数代表事件源对象
		System.out.println("ServletRequest 替换属性了");
//		System.out.println(arg0.getName()+"\t"+arg0.getValue());
	}

}
