<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	
		List list = new ArrayList();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		
		request.setAttribute("list", list);
		
		Map map = new HashMap();
		map.put("a", "aaaaaaa");
		map.put("b", "bbbbbbb");
		map.put("c", "ccccccc");
		request.setAttribute("m", map);
	 %>
	 
	 ${list[1] }<br/>		<!-- bbb -->
	 ${m["b"] } 			<!-- bbbbbbb -->
	 ${m.c }				<!-- ccccccc -->
	 
</body>
</html>