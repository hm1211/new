<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/board/register" method="post">
		<label>Title</label>
		<input type="text" name="title" 
			value="${vo.title}" disabled="disabled"/>
		<label>Content</label>
		<textarea rows="3" cols="50" name="content" disabled="disabled">
			${vo.content }
		</textarea>
		
		<label>Writer</label>
		<input type="text" name="writer" 
		   value="${vo.writer}"	disabled="disabled"/>
	
		<br/>
		<br/>
		<a href="/board/modify?bno=${vo.bno}">수정</a>
		<a href="/board/remove?bno=${vo.bno}">삭제</a>
		<a href="/board/list">목록으로</a>
	</form>
</body>
</html>