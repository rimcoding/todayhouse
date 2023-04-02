<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!-- 구글폰트 적용 -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">


<jsp:include page="/layout/header.jsp"/>
<style>
*{
margin: 0;
padding: 0;
box-sizing: border-box;

}
h1{
text-align: center;
margin-top: 50px;
font-family: 'Nanum Pen Script', cursive;
font-weight: lighter;
}
footer{
	display: flex;
	justify-content: center;
	background-color: #ccc;
}
.photo_box{
	margin-top: 50px;
	margin-left: 200px;
	margin-right: 200px;
	left: 20%;
	right: 25%;
	display: flex;
	}
.container{
width: 250px;
height: 250px;
}
.img{
width: 100px;
height: 100px;
}
h3{
text-align: center;
}
</style>

<main>
<h1>커뮤니티</h1>
<img src="/imges/${dto.photoImage}">

</main>
<br>
   <footer>
   <pre>
   JSP란 (Java Server Pages)
   	웹 컨테이너(WAS) 안에 동적 컴파일 과정은
   	xxx_jsp -> xxx_jsp.java -> xxx_jsp.class -> xxx_jsp.obj
   	ⓒ rim Corp.
   </pre>
	</footer>
</body>
</html>