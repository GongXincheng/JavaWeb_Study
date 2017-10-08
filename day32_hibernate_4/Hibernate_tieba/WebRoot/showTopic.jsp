<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<script type="text/javascript">
	function check(){
		
		var rc = document.getElementById("replyContent").value;
		if(rc.length==0){
			alert("请输入回复内容!");
			return false;
		}
		else{
			document.getElementById("form").submit();
		}
	}
</script>
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
	<div class="menubar">
		<s:a action="TopicAction_list">主题列表</s:a>
		<!-- <a href="listTopics.html"></a> -->
	</div>
	
	<!-- 当前主题贴数 -->
	<div style="padding: 10px 30px; font-size: 12px; font-family:'宋体'">
		共有<font color="red">${topic.replySet.size() }</font>篇帖子
	</div>
	
	<!-- 显示主题 -->
	<table class="postList" cellspacing="0">
	    <tr class="title">
	        <td width="20" class="num">1</td>
	        <td>标题：${topic.title}</td>
	    </tr>
	    <tr class="content">
	        <td></td>
	        <td><pre>内容：${topic.topicContent} </pre></td>
	    </tr>
	    <tr class="info">
	        <td></td>
	        <td>
				作者IP：<font color="blue">${topic.ipAddr}</font> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            <font color="#999999">发帖时间：<s:date name="%{topic.createDate}" format="yyyy-MM-dd hh:mm:ss"/> </font>
	        </td>
	    </tr>
	</table>
	
	<!-- 显示回复列表 -->
	<s:iterator value="%{topic.replySet}" var="r" status="status">
		<table class="postList" cellspacing="0">
	        <tr class="title">
	            <td width="20" class="num">${status.count+1 }</td>
	            <td></td>
	        </tr>
	        <tr class="content">
	            <td></td>
	            <td><pre>${r.replyContent }</pre></td>
	        </tr>
	        <tr class="info">
	            <td></td>
	            <td>
					作者：<font color="blue">${r.ipAddr }</font> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                <font color="#999999">回帖时间： <s:date name="#r.createDate" format="yyyy-MM-dd HH:mm:ss"/></font>
	            </td>
	        </tr>
	    </table>
	    </s:iterator>
    
    <div style="margin-bottom: 20px"></div>
	<!-- 发表回复表单 -->
	<s:form action="TopicAction_addReply" cssClass="addNewTopicForm" id="form">
		<table class="publishArticleForm">
	        <tr>
	            <td class="label">内　容:</td>
	            <td>
	            	<textarea id="replyContent" name="reply.replyContent" class="content"></textarea>
	            </td>
	        </tr>
	        <tr>
	            <td></td>
	            <td><input type="button" value="回　贴" onclick="check()" /></td>
	        </tr>
	    </table>
	    <s:hidden name="topic.tid" value="%{topic.tid}"></s:hidden>
	    <s:token></s:token>
	</s:form>
	<s:debug/>
</body>
</html>