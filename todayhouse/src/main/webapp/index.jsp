<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    

    <!-- 구글폰트 적용 -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">


<jsp:include page="/layout/header.jsp"/>
<script type="text/javascript">
function reload() {
	location.reload();
}
</script>
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

</style>
<main>
<h1>오늘의 사진</h1>
<section class="photo_box">
<!-- 쿼리문으로 order by desc로 짜서 역순으로 나오게 해서 최신순으로 찾게하고
c:forEach 조건문을 써서 images 폴더에 저장된 사진이 최신순으로 나오게 해줬다.-->
<c:forEach var="board" items="${boards}">
<div class="container">
<div class="nickname">${board.nickname}</div>
<a href="/borderService?cmd=oneclick&id=${board.id}" onclick="reload();">
<img src="/images/${board.photoImage}" class = "img">
</a>
<div class="content">${board.content}</div>
</div>
</c:forEach>
</section>
</main>
<br>
   <footer>
   <pre>	
   		사업자 : 편용림
		사업자등록번호 220-81-02810
		email : yog4130@gmail.com
		phone : 010-1111-1111
		부산 광역시 수영구 광안동 111-1
   		ⓒ rim Corp.
   </pre>
	</footer>
</body>
</html>

