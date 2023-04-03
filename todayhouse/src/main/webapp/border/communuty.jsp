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
.photo_box{
	margin-top: 50px;
	display: flex;
	justify-content: center;
	align-content: center;
	flex-direction: row;
	flex-wrap: wrap;
	margin-left: 280px;
	margin-right: 200px;
	left: 20%;
	right: 25%;
	}
.container{
width: 250px;
height: 250px;
}
.img{
width: 150px;
height: 150px;
}
h3{
text-align: center;
}
.nickname{
font-family: 'Nanum Pen Script', cursive;
font-size: 20px;
margin-left: 60px;
}
.content{
font-family: 'Nanum Pen Script', cursive;
font-size: 20px;
}
.textbox{
height: 50px;
width: 150px;
font-family: 'Nanum Pen Script', cursive;
text-align: center;
}
.replybutton{
border: 0;
height: 20px;
width: 50px;
border-radius: 2px;
background-color: rgb(53, 197, 240);
color: rgb(255,255,255);
font-size: 10px;
}
</style>

<main>
<h1>커뮤니티</h1>
<div class="photo_box">
<c:forEach var="board" items="${boards2}">
<div class="container">
<form action="/borderService/cmd=oneclick" method="get">
<div class="nickname">${board.nickname}</div>
<a href="/detailboard.jsp" onclick="reload();">
<input type =>
<img src="/images/${board.photoImage}" class = "img"></a>
</form>
<form action="/replyService" method="post">
<input type ="hidden" name = "uu" value="${sessionScope.principal.id}">
<input type="hidden" name = "boardId" value="${board.id}">
<div class="content">${board.content}</div>
<input type="text" class="textbox" placeholder="댓글을 달아주세요." name ="rr">
<input type="submit" value="등록" class="replybutton" >
</form>
</div>
</c:forEach>
</div>

</main>
<br>

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