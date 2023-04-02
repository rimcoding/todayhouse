<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%
		out.println(session.getAttribute("principal"));    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

</style>
</head>
<body>
<form action="/borderService?cmd=upload" method="post" enctype="multipart/form-data">
<input type ="hidden" name = "userId" value="${sessionScope.principal.id}">
<input type = "file" name = "photo">
<div>
<textarea cols="40" placeholder="설명" autofocus="autofocus" name="content"></textarea>
</div>
<div>
	<button type = "submit">올리기</button>
</div>
</form>
