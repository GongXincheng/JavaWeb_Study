<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.lang.*"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.gxc.com/function/myfunction" prefix="myfn"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OGNL</title>
</head>

<body>	
	${myfn:toUpperCase("aaaabb") }
	<hr>
	
	<%-- OGNL表达式 --%>
	<s:property value="OGNL-Expression"/>		OGNL表达式<br>
	<s:property value="'OGNL-Expression'"/>		这是一个普通的字符串<br>
	<s:property value="'OGNL-Expression'.length()"/>	使用普通字符串调用获取长度的方法<br>
	
	
	<hr>
	<!-- OGNL表达式访问静态属性
		方法：@全类名@静态属性名称
	 -->
	 <s:property value="@java.lang.Integer@MAX_VALUE" /><br>
	 
	 
	 <%-- OGNL表达式访问静态方法
	 	方法：@全类名@静态方法名
	 	struts2框架默认禁用静态方法调用，可以通过配置开启
	 	struts.ognl.allowStaticMethodAccess=false
	  --%>
	 <s:property value="@java.lang.Math@random()" />
	 <hr>
	 
	 
	 <%--
	 	OGNL 操作 Map和List
	 		使用的是 s:radio标签，创建List集合 ，{}相当于创建了一个List集合
 	  --%>
 	  <s:radio name="gender" list="{'男','女'}"></s:radio><hr>
 	  
 	  <%--
 	  		使用 s:radio标签，创建Map集合 , #{}相当于创建了一个Map集合
 	   --%>
 	   <s:radio name="gender1" list="#{'1':'男','0':'女' }"></s:radio>
</body>
</html>