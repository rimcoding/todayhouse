<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
main{
display: flex;
justify-content: center;
align-items: center;
flex-direction: column;
}
.main-box{
margin: 15px;
padding: 30px;
border: 1px solid black;
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
.box td{
border: 1px solid black;
font-family: 'Nanum Pen Script', cursive;
font-weight: lighter;
font-size: 15px;
}
p{
font-family: 'Nanum Pen Script', cursive;
font-weight: lighter;
}
.replybox{
margin-top: 10px;
border: 1px solid black;
width: 300px;
}

.a{
border: 0;
height: 20px;
width: 50px;
border-radius: 2px;
background-color: rgb(53, 197, 240);
color: rgb(255,255,255);
font-size: 10px;
margin-left: 60px;
}
.boardcontroller{
margin-top: 10px;
margin-left: 190px;
}
.replydelete{

border: 0;
height: 20px;
width: 50px;
border-radius: 2px;
background-color: rgb(53, 197, 240);
color: rgb(255,255,255);
font-size: 10px;
margin-left: 10px;
margin-top: 10px;
}
.replybutton{

}

</style>

<main>
<div class="main-box">
<h1>게시물</h1>
<h2 class = "upload_nickname">작성자 = ${dto.nickname}</h2>
<div class="img">
<b><img src="/images/${dto.photoImage}"></b>
</div>
<div>
<div class="boardcontroller">
<form action="/borderService?cmd=delete" method="post">
<input type="hidden" name = "userId" value="${sessionScope.principal.id}">
<input type="hidden" name = "photoImage" value="${dto.photoImage}">
<input type="submit" value="삭제" class="a">
</form>
</div>
</div>
<c:forEach items="${replyList}" var="replyList">
<div class="replybox">
<p>댓글</p>
<p>nickname : ${replyList.nickname}</p>
<p>내용 : ${replyList.content}</p>
<div class="replybutton">
<form action="/replyService?cmd=update" method="post">
<input type="text" name = "content" value="${replyList.content}" class="update" autocomplete="off" placeholder="수정할 내용을 입력하세요">
<input type="hidden" name = "userid" value="${sessionScope.principal.id}">
<input type="hidden" name = "id" value="${replyList.id}">
<input type ="submit" value="수정" class="replydelete">
</form>
<form action="/replyService?cmd=replydelete" method="post">
<div class="content" name = "content">${board.content}</div>
<input type ="hidden" name = "userInfo" value="${sessionScope.principal.id}">
<input type ="hidden" name = "replyId" value="${replyList.id}">
<input type="submit" value="삭제" class="replydelete">
</form>
</div>
</div>
</c:forEach>
</div>
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