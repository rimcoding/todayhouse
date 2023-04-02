<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오늘의 집</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />

<style type="text/css">
.header{
display: flex;
width: 1300px;;
justify-content: center;
align-items: center;
padding: 15px 60px 15px 60px;
border-bottom: 1px solid rgb(234,237,239);
}
li{
list-style: none;
}
.header-left{
margin-left: 10px;
}
.header-left li{
float: left;
margin-left: 80px; 
}
.header-left li a{
text-decoration: none;
font-weight: bold;
}
.header-right{
}
.header-right ul li{
float: left;
margin-left: 10px;
}
a{
text-decoration: none; 
}
.text{
margin-left: 70px;
width:250px;
height:30px;
text-align: center;
}
.writebtn{
border: 0;
outline: 0;
margin-left: 20px;
height: 40px;
width: 100px;
border-radius: 4px;
background-color: rgb(53, 197, 240);
color: rgb(255,255,255);
font-size: 14px;
}
.cart{
margin-left: 50px;
}
</style>
</head>
<body>
<header>
<div class="header">
<div class="mainLogo">
<a href="/index2.jsp"><img alt="" src="/image2/pont.png"></a>
</div>
<ul class = "header-left">
<li>
<a href="/border/communuty.jsp">커뮤니티</a>
</li>
<li>
<a href="#">스토어</a>
</li>
</ul>
<input type="text" placeholder="통합검색" class="text">
<div class = "cart">
<img src="/image2/cart2.png" width="35" height="30">
</div>
<div class ="header-right">
<ul class ="join">
<c:choose>
<c:when test="${sessionScope.principal != null}">
<li><%out.println(session.getAttribute("nick"));%>님</li>
<li>
<form action="/LoginProgram?cmd=logout" method="post">
<button>로그아웃</button>
</form>
</li>
</c:when>
<c:otherwise>
<li>
<a href="/login/login.jsp">로그인</a>
</li>
<li>|</li>
<li>
<a href="/login/join.jsp">회원가입</a>
</li>
</c:otherwise>
</c:choose>

</ul>
</div>
<form action="/borderService?cmd=uploadForm" method="post">
<button class="writebtn" >글쓰기</button>
</form>
</div>
</header>
</body>
</html>