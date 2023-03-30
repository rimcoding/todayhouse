<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{
margin: 0;
}
container{
display: flex;
}
.logo{
display: flex;
justify-content: center;
align-items: center;
}
.text{
margin-top: 30px;
display: flex;
justify-content: center;
align-items: center;
flex-direction: column;
}
.text1{
 width: 200px;
 height: 30px;
}
.button{
margin-top: 20px;
}
.item2{
	margin-top: 20px;
	justify-content: center;
	align-items: center;
	width: 300px;
	height: 50px;
	background-color: skyblue;
	border-radius: 5px;
	outline: 0;
	border: 0;
}
</style>
</head>
<body>
	<form action="LoginProgram" method="post">
	<div class = "container">
	<div class = "logo">
	<img alt="" src="images/loginlogo2.png">
	</div>
	<div class = text>
	<input type = "email" placeholder="이메일" name = "email" id ="email" class="text1">
	<input type = "password" placeholder="비밀번호" name = "password" id = "password" class = "text1">
	<button class="item2">로그인</button>
	</div>
	</div>
	</form>
</body>
</html>