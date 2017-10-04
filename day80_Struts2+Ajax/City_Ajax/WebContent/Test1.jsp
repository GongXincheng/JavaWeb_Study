<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>二级联动</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function(){
		$("#province").change(function(){
			
			 $.ajax({
				url : "${pageContext.request.contextPath}/action1",
				data : {
					prov : $("#province").val()
				},
				type : 'POST',
				dataType : 'json',
				success : function(data){
					var data1 = eval("("+data+")");	//解析
					$("#city")[0].options.length = 0;	//将option清除			
					
					for(i=0;i<data1.length;i++){
						var option = document.createElement("option");
						option.value = data1[i].cityCode;		
						option.text = data1[i].cityName;
						city.options.add(option);	
					}
				},
				error : function(data){
					alert(data);
					alert("系统繁忙");
				}
			}); 
		});
	});
</script>
</head>
<body>

<!--struts标签---------------------------------------------------------------->	
	<select id="province" onChange="select()">
		<option value="" selected>--请选择--</option>
		<s:iterator value="provList" var="p">
			<option value="<s:property value="#p.privinceCode"/>">
				<s:property value="#p.privinceName"/>
			</option>
		</s:iterator>
	</select>
	
<!--JSTL标签---------------------------------------------------------------->
<%--  	<select id="province" onChange="select()">
		<option value="" selected>--请选择--</option>
		<c:forEach items="${province }" var="p">
			<option value="${p.privinceCode }">${p.privinceName }</option>
		</c:forEach>
	</select>  --%>
<!------------------------------------------------------------------>
	<select id="city">
		<option  value="" selected>--请选择--</option>
	</select>
	<hr/>
	<s:debug/>
</body>
</html>