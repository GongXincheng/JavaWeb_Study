<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>取ActionContext数据</title>
</head>
<body>
	<s:debug/>
	
	<%-- 使用s:property来获取ActionContext中的数据 --%>
	
	<br>----------获取大Map中的数据--------------<br>
	<%--获取大Map中的数据：#Key --%>
	<s:property value="#contextMap"/>	${contextMap }
	
	<br>----------获取小Map中的数据--------------<br>
	<%--获取大Map中小Map中的数据 --%>
	<s:property value="#session.SessionMap"/>	${sessionScope.SessionMap }<br>
	<s:property value="#application.ServletContext"/>	 ${applicationScope.ServletContext }
	
</body>
</html>