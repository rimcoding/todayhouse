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
	margin-top: 100px;
	display: flex;
	justify-content: center;
	background-color: #ccc;
}
b img {
width: 300px;
height: 300px;
}
h2{
font-family: 'Nanum Pen Script', cursive;
font-weight: lighter;
}
</style>

<main>
<h1>상세페이지</h1>
<h2>작성자 = ${dto.nickname}</h2>
<b><img alt="" src="/images/${dto.photoImage}" ></b>

<h2>댓글 ${reply.nickname} : ${reply.content}</h2>
</main>
<br>
<body>

   <footer>
   <pre>
   		사업자 : 편용림
		사업자등록번호 220-81-02810
		email : yog4130@gmail.com
		phone : 010-1111-1111
		부산 광역시 수영구 광안동 111-1
   </pre>
	</footer>

</body>
</html>