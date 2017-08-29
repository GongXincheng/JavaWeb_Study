package com.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Map;

import javax.mail.Flags.Flag;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

public class MyFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		//解决post编码方式
//		req.setCharacterEncoding("UTF-8");
//		res.setContentType("text/html; charset=UTF-8");
		
		req = new MyRequest(req);
		
		chain.doFilter(req, response);
	}

	@Override
	public void destroy() {
		
	}
}

/*	装饰设计模式
 * 
 * 1. 实现与被包装对象相同的接口
 * 2. 定义一个与被包装类相同对象的引用
 * 3. 定义一个构造方法，把被包装对象传过来
 * 4. 对于不需要该写的方法，直接调用
 * 5. 对于需要该写的方法,写自己的方法
 */
class MyRequest extends HttpServletRequestWrapper{
	HttpServletRequest request;
	
	public MyRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}

/*	@Override
	public String getParameter(String name) {
		name = request.getParameter(name);
		try {
			return new String(name.getBytes("iso-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}*/

	@Override
	public String getParameter(String name) {
		Map<String, String[]> map = this.getParameterMap();
		return map.get(name)[0];
	}
	
	@Override
	public String[] getParameterValues(String name) {
		Map<String, String[]> map = this.getParameterMap();
		return map.get(name);
	}
	
	private boolean flag = true;
	@Override
	public Map<String, String[]> getParameterMap() {
		Map<String, String[]> map = request.getParameterMap();	//可能会乱码
		if(flag){
			for (Map.Entry<String, String[]> me : map.entrySet()) {
				String[] values = me.getValue();
				for (int i = 0; i < values.length; i++) {
					try {
						values[i] = new String(values[i].getBytes("iso-8859-1"),"UTF-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
			}
			flag = false;
		}
		return map;
	}
	
}
