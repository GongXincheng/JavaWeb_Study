<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
	
		/*	Java语言创建的类
			public class Person(){
				private String name;
				private int age;
				
				public void show(){
				
					}
			}
		*/
		
	/* 	JavaScript创建类1
		function Person(){
			var name = "tom";	//声明一个局部变量
			this.age = 10;	//声明一个成员变量
			this.show = function(){
				document.write(this.age);
			}
		}
		var p = new Person();
		p.show(); 
	*/
	
	//  创建JSON对象
	var pp = {name:"tom", age:18};	//一个JSON对象
	document.write(pp.age);
	
	// JSON数组
	var ppp = [{name:"tom", age:18},{name:"jerry", age:20}];
	document.write(ppp[1].name);
	</script>
</body>
</html>