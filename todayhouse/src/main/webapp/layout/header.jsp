<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오늘의 집</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />

<style type="text/css">

.top{
display: flex;
height: 80px;
justify-content: center;
align-items: center;
font-size: 14px;
}
.top-left{
display: flex;
flex-direction: column;
}
.top-left ul{
display: flex;
}
.top-left ul li{
margin: 10px;
list-style: none;
text-decoration: none;
}
.top- right{
display: flex;
}
a{
text-decoration: none;
}
.write{
height: 30px;
width: 80px;
}

.menu{
	margin-left: 10px;
	display: inline-block;
}
.submenu{
	display: none;
	width: 50px;
	position: absolute;
}
.menu:hover .submenu{
	display: block;
	flex-direction: column;
}
h2{
display: flex;
justify-content: flex-start;
}
.item{
	border: 0;
	outline: 0;
}
.item2{
	width: 80px;
	height: 30px;
	background-color: skyblue;
	border-radius: 5px;
	outline: 0;
	border: 0;
}
.material-symbols-outlined{
	margin: 10px;
}
</style>
</head>
<body>
<nav>
<ul></ul>
<div class = "top">
<div>
<img alt="" src="images/pont.png">
</div>
<div class = "top-left">
<div class = "menu">
<button class = "item">커뮤니티</button>
<div class = "submenu">
<a href = "#" class = "write">글쓰기</a>
<a href = "#">보기</a>
</div>
</div>
</div>

<div class = "top-right">
<span class="material-symbols-outlined">shopping_cart</span>
<a href="login.jsp">로그인</a>
<a href="join.jsp">회원가입</a>
<button class="item2"><a href="board.jsp">글쓰기</a></button>
</div>
</div>

</nav>


</body>
</html>