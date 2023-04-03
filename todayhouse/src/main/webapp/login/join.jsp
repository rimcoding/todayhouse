<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.container{
display: flex;
justify-content: center;
align-items: center;
flex-direction: column;
}
.form-group{
margin-top: 30px;
display: flex;
justify-content: center;
align-items: center;
flex-direction: column;
}

.text{
 display: flex;
 height: 30px;
 width: 250px;
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
<form action="/JoinProgram" method="post">
	<div class = "container">
	<a href="/index2.jsp">
	<img src="/image2/loginlogo.png"></a>
	<div class="form-group">
	<input type="email" placeholder="이메일을 입력하세요"  name="email" id = "email" class = "text">
	<input type="password" placeholder="패스워드를 입력하세요"  name="password" id="password" class = "text">
	<input type="text" placeholder="닉네임을 입력하세요"  name="nickname" id = "nickname" class = "text">
	<button class="item2">회원가입</button>
	</div>
	</div>
</form>
</body>
</html>