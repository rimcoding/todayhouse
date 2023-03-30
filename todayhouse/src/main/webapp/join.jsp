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
justify-content: center;
align-items: center;
}

.text{
 width: 200px;
 height: 30px;
 margin-top: 10px;
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
<form action="JoinProgram" method="post">
	<div class = "container">
	<img alt="" src="images/loginlogo2.png">
	<div class="form-group">
	<label for="TEXT">이메일 : </label><input type="email" placeholder="이메일을 입력하세요"  name="email" id = "email" class = "text"><br>
	<label for="TEXT">비밀번호 : </label><input type="password" placeholder="패스워드를 입력하세요"  name="password" id="password" class = "text"><br>
	<label for="TEXT">닉네임 : </label><input type="text" placeholder="닉네임을 입력하세요"  name="nickname" id = "nickname" class = "text"><br>
	<button class="item2">회원가입</button>
	</div>
	</div>
</form>
</body>
</html>