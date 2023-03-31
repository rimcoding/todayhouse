<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오늘의 집</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />

<style type="text/css">
.header{
display: flex;
justify-content: center;
align-items: center;
padding: 15px 60px 15px 60px;
border-bottom: 1px solid rgb(234,237,239);
}
.mainLogo{
margin-left: 50px;
}
li{
list-style: none;
}
.header-left{
display: flex;
margin-left: 10px;
}
.header-left li a{
text-decoration: none;
margin-left: 50px;
font-weight: bold;
}
.header-right{
display: flex;
margin-left: 100px;
justify-content: flex-end;
align-items: flex-end;
}
.header-right ul{
display: flex;
}
.header-right ul li{
margin-left: 10px;
}
.header-right li a{
text-decoration: none; 
}
.join{
justify-content: flex-end;
}
.text{
margin-left: 150px;
width:250px;
height:30px;
}
.writebtn{
margin-left: 20px;
border: none;
outline: none;
height: 40px;
width: 100px;
border-radius: 4px;
background-color: rgb(53, 197, 240);
color: rgb(255,255,255);
font-size: 14px;
}
</style>
</head>
<body>
<header>
<div class="header">
<div class="mainLogo">
<a href="#"><img alt="" src="images/pont.png"></a>
</div>
<ul class = "header-left">
<li>
<a href="#">커뮤니티</a>
</li>
<li>
<a href="#">스토어</a>
</li>
</ul>
<input type="text" placeholder="통합검색" class="text">
<div class ="header-right">
<img src="images/cart2.png" width="35" height="30">
<ul class ="join">
<li>
<a href="/todayhouse/login.jsp">로그인</a>
</li>
<li>|</li>
<li>
<a href="/todayhouse/join.jsp">회원가입</a>
</li>
</ul>
</div>
<button class="writebtn" onclick="location.href='board.jsp' ">글쓰기</button>
</div>
</header>
</body>
</html>