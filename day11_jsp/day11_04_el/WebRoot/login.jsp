<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title>el</title>
  </head>
<body>
	<form action="${pageContext.request.contextPath }/success.jsp" method="post">
		用户名：<input type="text" name="userName"><br/>
		密码：<input type="password" name="pwd"><br/>
		<input type="submit" value="登录">
	</form>
</body>
</html>