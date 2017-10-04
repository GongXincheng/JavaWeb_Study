<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

	<!-- 简单搜索表单 -->
	<div style="margin: 15px auto; " >
		<!-- 搜索表单 -->
		<s:form action="TopicAction_search" cssClass="simpleSearchForm" theme="simple">
			<font class="logoLabel">GXC贴吧</font>
			<%-- <s:textfield name="queryString" cssClass="queryString" ></s:textfield> --%>
			<input type="text" name="queryString" class="queryString"/>
			<input type="submit" value="搜 索" />
		</s:form>
	</div>

	<!-- 菜单 -->
	<div class="menubar"></div>

	<!-- 主题列表 -->
	<table cellspacing="0">
		<tbody class="list topicList">
    		<!--显示表头-->
		    <tr class="title">
		        <td width="25">编号</td>
		        <td width="25">回复</td>
		        <td width="500">标题</td>
		        <td width="110">作者</td>
		        <td width="145">最后回复时间</td>
		    </tr>

    		<!-- 显示部门列表 -->
    		<s:iterator value="topicList" var="topic" status="status">
		        <tr class="data">
		            <td class="num">${status.count }</td>
		            <td class="num">2</td>
		            <td>
		            	<s:a action="showTopic_show" ></s:a>
		            	<a href="showTopic.jsp">${topic.title }</a>
		            </td>
		            <td class="info">${topic.ipAddr }</td>
		            <td class="info">${topic.lastReplyDate }</td>
		        </tr>
			</s:iterator>
		    <tr>
		        <td colspan="5" class="num">共有主题数<font color="red">${topicList.size() }</font>个</td>
		    </tr>
   		 </tbody>
	</table>

	<div style="margin-bottom: 15px"></div>

	<!--发表主题表单-->
	<s:form action="TopicAction_add" namespace="/" theme="simple" cssClass="addNewTopicForm">
	    <table class="publishArticleForm">
	        <tr>
	            <td>标　题:</td>
	            <td>
	            	<s:textfield name="topic.title" cssClass="title" />
	            </td>
	        </tr>
	        <tr>
	            <td>内　容:</td>
	            <td>
	           		 <s:textarea name="topic.topicContent" cssClass="content"/>
	            </td>
	        </tr>
	        <tr>
	            <td></td>
	            <td>
	            	<s:submit value="发　表"></s:submit>
	            </td>
	        </tr>
	    </table>
    </s:form>

</body>
</html>