<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/userAction_register" method="post">
		<s:textfield name="username" label="用户名"></s:textfield>
		<s:password name="password" label="密  码"></s:password>
		<s:textfield name="age" label="年  龄"></s:textfield>
		<s:submit value="注  册"></s:submit>
	</form>
</body>
</html>