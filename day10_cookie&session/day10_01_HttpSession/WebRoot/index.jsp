<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <script type="text/javascript">
	function changeCode(){
		//得到图片元素
		var img = document.getElementsByTagName("img")[0];
		img.src = "/day09_00_HttpServletResponse/servlet/demo4?time="+new Date().getTime();
	}
</script>
  </head>
  
  <body>
  <%
  		String msg = (String)request.getAttribute("msg");
  		if(msg!=null){
  			out.print(msg);
  		}
   %>
		<form action="/day10_01_HttpSession/servlet/doLogin" method="post">
			用户名：<input type="text" name="userName" ><br>
			密码：	<input type="password" name="pwd" ><br>
			验证码：<input type="text" name="code" >
			<img src="/day10_01_HttpSession/servlet/codeServlet" onclick="changeCode()"/><a href="javascript:changeCode()">换一张</a><br>
			<input type="submit" value="登录">
		</form>
  </body>
</html>
