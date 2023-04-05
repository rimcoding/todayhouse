<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <jsp:include page="/layout/header.jsp"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<style type="text/css">
h1{
text-align: center;
margin-top: 50px;
font-family: 'Nanum Pen Script', cursive;
font-weight: lighter;
}
.uploadbox{
	display: flex;
	justify-content: center;
	align-items: center;
	border: 1px solid black;
	width: 500px;
	padding: 50px;
}
.button{
border: 0;
outline: 0;
margin-left: 243px;
height: 40px;
width: 100px;
border-radius: 4px;
background-color: rgb(53, 197, 240);
color: rgb(255,255,255);
font-size: 14px;
}
filebox .upload-name {
    display: inline-block;
    height: 40px;
    padding: 0 10px;
    vertical-align: middle;
    border: 1px solid #dddddd;
    width: 78%;
    color: #999999;
}
.filebox label {
	margin-left: 50px;
    display: inline-block;
    padding: 10px 20px;
	height: 40px;
	width: 100px;
	border-radius: 4px;
	background-color: rgb(53, 197, 240);
	color: rgb(255,255,255);
	font-size: 14px;
}
.filebox input[type="file"] {
    position: absolute;
    width: 0;
    height: 0;
    padding: 0;
    overflow: hidden;
    border: 0;
}
textarea {
			width: 100%;
			height: 200px;
			padding: 10px;
			box-sizing: border-box;
			border: solid 2px #1E90FF;
			border-radius: 5px;
			font-size: 16px;
			resize: both;
		}
.container{
margin-top: 100px;
margin-left: 500px;
justify-content: center;
align-items: center;
}
</style>
</head>
<body>
<div class="container">
<div class="uploadbox">
<form action="/borderService?cmd=upload" method="post" enctype="multipart/form-data">
<h1>글쓰기</h1>
<input type ="hidden" name = "userId" value="${sessionScope.principal.id}">
<div>
<textarea cols="40" placeholder="설명" autofocus="autofocus" name="content"></textarea>
</div>
<div>
	<div class="filebox">
    <input class="upload-name" value="첨부파일" placeholder="첨부파일" >
    <label for="file">파일찾기</label> 
    <input type="file" id="file" name="photo">
	</div>
	</div>
	<button type = "submit" class="button">올리기</button>
</div>
</form>

</div>

