<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/myJS.js"></script>
<script type="text/javascript">
		window.onload = function() {
			//1.获取XMLHttpRequest对象 
			var req = getXMLHttpRequest();	
			//4.处理相应结果
			req.onreadystatechange = function(){
				//alert(req.readyState);		
				if(req.readyState==4){	// XMLHttpRequest的状态(请求状态码)
					//alert(req.status);	//查看服务器端响应状态(响应状态码)
					if(req.status==200){	//服务器端响应正常
						alert(req.responseText);
					}	
				}
			}
			
			//2.建立一个连接
			req.open("get", "${pageContext.request.contextPath }/servlet/servletDemo1"); 
			//3.发送请求
			req.send(null);
			//alert(req);
		}
</script>
</head>

<body>
	
</body>
</html>