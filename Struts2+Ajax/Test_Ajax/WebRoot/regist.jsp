<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#sub").click(function(){
			$.ajax({
				url : "${pageContext.request.contextPath}/action2",
				data : $("#Form").serialize(),
				dataType:"json",
				type: "POST",
				success : function(data){
					$("#sp").html(eval("("+data+")").username);
				},
				error : function(){
					alert(data);
				}
			});
		});
	});
</script>
</head>
<body>
	<form id="Form">
		<input type="text" name="username" /><span id="sp"></span><br/>
		<input type="password" name="password" /><br/>
		<button id="sub" type="button">注册</button>
	</form>
</body>
</html>