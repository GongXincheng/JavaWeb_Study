<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- EL表达式获取表单数据 --%>
	欢迎你 ：${param.userName }	<%-- ==request.getParameter("userName"); --%>
	
	${paramValues.hobby[0] }
	
	${header["User-agent "]}
	
	${cookie.JSESSIONID.value }
	
	${pageContext.request }
</body>
</html>