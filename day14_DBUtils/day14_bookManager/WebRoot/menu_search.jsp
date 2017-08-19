<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript"src="${pageContext.request.contextPath}/js/my.js"></script>
<script type="text/javascript">
	/* function fillNameValue(subDiv) {
		document.getElementById("name").value = subDiv.innerHTML;
		
		document.getElementById("content").style.display="none";
	}

	function searchName() {
		var nameElement = document.getElementById("name");
		//获取输入的信息
		var nameValue = nameElement.value;

		var div = document.getElementById("content");
		div.innerHTML = "";
		//1.获取XMLHttpRequest对象
		var xmlhttp = getXMLHttpRequest();

		//2.绑定回调函数
		xmlhttp.onreadystatechange = function() {

			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {

				var jsonObj = eval("(" + xmlhttp.responseText + ")");
				
				if(jsonObj.length>0){
					document.getElementById("content").style.display="block";
					for ( var i = 0; i < jsonObj.length; i++) {
						div.innerHTML += "<div onclick='fillNameValue(this)' onmouseover='changeBackground_over(this)' onmouseout='changeBackground_out(this)'>"
								+ jsonObj[i] + "</div>"
					}
				}

			}
		};
		//3.open
		xmlhttp.open("GET",
				"${pageContext.request.contextPath}/findProductName?name="
						+ window.encodeURIComponent(nameValue, "utf-8")
						+ "&time=" + new Date().getTime());
		//4.send
		xmlhttp.send(null);
	};
	
	function changeBackground_over(div){
		div.style.background="gray";
	}
	
	function changeBackground_out(div){
		div.style.background="white";
	}*/
 
 window.onload = function(){
	//得到搜索框对象
	var searchElement = document.getElementById("name");
	//得到DIV元素
	var div = document.getElementById("context1");
	searchElement.onkeyup = function(){	//给搜索框注册按键弹起事件
		//获取文本框的值
		var name = this.value;
		
		if(name==""){
			div.style.display = "none";
			return;
		}
		
		//获取xhr对象
		var xhr = getXMLHttpRequest();
		
		//处理结果
		xhr.onreadystatechange = function(){
			if(xhr.readyState==4){
				if(xhr.status==200){
					var str = xhr.responseText;	//得到服务器返回的数据
					var ss = str.split(",");
					var childDivs = "";
					for(var i=0; i<ss.length; i++){
						childDivs = childDivs + "<div onclick='writeText(this)' onmouseover='changBackground_over(this)' onmouseout='changBackground_out(this)'>"+ss[i]+"</div>" //把数组中的每个元素放在div中
					}
					div.innerHTML = childDivs;
					div.style.display = "block";
				}
			}
		}
		
		xhr.open("get", "${pageContext.request.contextPath}/servlet/searchBookAJAXServlet?name="+name+"&time="+new Date().getTime());
		xhr.send(null);
	}
}

	function changBackground_over(div){
		div.style.backgroundColor = "#ccc";
	}
	function changBackground_out(div){
		div.style.backgroundColor = "";
	}
	//填充文本到文本框
	function writeText(div){
		//得到文本框对象
		var searchElement = document.getElementById("name");
		searchElement.value = div.innerHTML;
		//把父节点隐藏
		div.parentNode.style.display = "none";
	}
</script>

<div id="divmenu">
	<a
		href="${pageContext.request.contextPath}/showProductByPage?category=文学">文学</a>
	<a
		href="${pageContext.request.contextPath}/showProductByPage?category=生活">生活</a>
	<a
		href="${pageContext.request.contextPath}/showProductByPage?category=计算机">计算机</a>
	<a
		href="${pageContext.request.contextPath}/showProductByPage?category=外语">外语</a>
	<a
		href="${pageContext.request.contextPath}/showProductByPage?category=经营">经管</a>
	<a
		href="${pageContext.request.contextPath}/showProductByPage?category=励志">励志</a>
	<a
		href="${pageContext.request.contextPath}/showProductByPage?category=社科">社科</a>
	<a
		href="${pageContext.request.contextPath}/showProductByPage?category=学术">学术</a>
	<a
		href="${pageContext.request.contextPath}/showProductByPage?category=少儿">少儿</a>
	<a
		href="${pageContext.request.contextPath}/showProductByPage?category=艺术">艺术</a>
	<a
		href="${pageContext.request.contextPath}/showProductByPage?category=原版">原版</a>
	<a
		href="${pageContext.request.contextPath}/showProductByPage?category=科技">科技</a>
	<a
		href="${pageContext.request.contextPath}/showProductByPage?category=考试">考试</a>
	<a
		href="${pageContext.request.contextPath}/showProductByPage?category=生活百科">生活百科</a>
	<a href="${pageContext.request.contextPath}/showProductByPage"
		style="color:#FFFF00">全部商品目录</a>
</div>
<div id="divsearch">
	<form action="${pageContext.request.contextPath}/servlet/searchBookAJAXServlet"
		method="post">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td style="text-align:right; padding-right:220px">
				Search <input
					type="text" name="name" class="inputtable" id="name" /> 
					<input type="image" src="${pageContext.request.contextPath }/images/serchbutton.gif"
					border="0" style="margin-bottom:-4px">
				</td>
			</tr>
		</table>

	</form>
</div>
	<div id="context1" style="display:block; width:128px;position:absolute;left:945px;top:133px;background-color:white;">
		
	</div>