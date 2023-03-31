<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

</style>
</head>
<body>
<form action="/borderService" method="post" enctype="multipart/form-data">
<input type ="text" name = "userId" placeholder="userId">
<input type = "file" name = "photo">
<div>
<textarea cols="20" placeholder="설명" autofocus="autofocus" name="content"></textarea>
</div>
<div>
	<button type = "submit">올리기</button>
</div>
</form>
</body>
</html>
/JspProject/photo_board?cmd=upload