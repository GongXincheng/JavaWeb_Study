<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
    <!-- 声明一个变量 num -->
   	<c:set var="num" value="10" scope="session"></c:set>
  	<c:out value="${num }"></c:out>
 	
 移除后：  	
  <!-- 移除session中的变量 num -->
   	<c:remove var="num" scope="session"/>
   	<c:out value="${num }"></c:out>
  </body>
</html>
