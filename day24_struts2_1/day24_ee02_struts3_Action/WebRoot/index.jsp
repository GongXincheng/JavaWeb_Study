<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Struts2的配置文件</title>
  </head>
  
  <body>
	<a href="${pageContext.request.contextPath }/action1.action">以.action结尾的</a><br>
	<a href="${pageContext.request.contextPath }/action1">没有后缀</a><br>
	<a href="${pageContext.request.contextPath }/action1.do">以.do结尾</a><br>
	<a href="${pageContext.request.contextPath }/action1.abc">以.abc结尾</a><br>
	<a href="${pageContext.request.contextPath }/action1.abcd">以.abcd结尾</a><br>
  </body>
</html>
