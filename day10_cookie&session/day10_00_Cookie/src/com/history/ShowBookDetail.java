package com.history;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Book;
import com.util.DBUtil;

public class ShowBookDetail extends HttpServlet {
	//显示图书的详细信息
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//获得id，并显示图书
		String id = request.getParameter("id");
		Book book = DBUtil.findBookById(id);
		out.print(book);
		
		
		//把当前浏览过得书的id写回到客户端
		String historyBookId = OrganizeId(id,request);
		
		//创建Cookie 
		Cookie ck = new Cookie("historyBookId", historyBookId);
		ck.setPath("/");
		ck.setMaxAge(Integer.MAX_VALUE);
		
		response.addCookie(ck);//写回客户端
	}

	/**
	 * 		客户端						showAllBooks				showBookDetail
	 * 没有cookie							1						historyBookId=1
	 * 有Cookie但没有historyBookId			1						historyBookId=1
	 * historyBookId=1						2						historyBookId=2-1
	 * historyBookId=2-1					2						historyBookId=2-1
	 * historyBookId=3-2-1					2						historyBookId=2-3-1
	 * historyBookId=2-3-1					4						historyBookId=4-2-3
	 */
	private String OrganizeId(String id, HttpServletRequest request) {
		//得到客户端的Cookie
		Cookie[] cookies = request.getCookies();
		if(cookies==null){
			return id;
		}
		
		//查找有没有name叫做historyBookId的Cookie
		Cookie historyBook = null;
		for (int i = 0; i < cookies.length; i++) {
			if( "historyBookId".equals(cookies[i].getName()) ){
				historyBook = cookies[i];
			}
		}
		
		//如果没有historyBookId的Cookie，则返回id
		if(historyBook==null){
			return id;
		}
		
		//解析name为historyBook的值
		String value = historyBook.getValue();//2-1-3
		String[] values = value.split("-");
		LinkedList<String>	list = new LinkedList<String>(Arrays.asList(values));
		
		if(list.size()<3){//1 2
			if(list.contains(id)){
				list.remove(id);	//如果包含当前id的值，则删除这个id
			}
		}
		else{
			if(list.contains(id)){
				list.remove(id);
			}else{	//说明有3本书的id了
				list.removeLast();//把最后一个id删除
			}
		}
		
		list.addFirst(id);//最新的书的id添加到最前面
		
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<list.size(); i++){
			if(i>0){
				sb.append("-");
			}
			sb.append(list.get(i));
		}
		System.out.println(sb.toString());
		
		return sb.toString();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
