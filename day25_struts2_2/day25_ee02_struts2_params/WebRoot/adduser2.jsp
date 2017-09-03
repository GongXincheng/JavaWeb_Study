<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>动态参数封装</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/action2.action" method="post">
		<!-- 表单中的name属性取值必须和动作类中数据模型的set方法名相对应 -->
		用户名：<input type="text" name="username"><br>
		年龄：<input type="text" name="age"><br>
		<input type="submit" value="提交"><br>
	</form>
</body>
</html>