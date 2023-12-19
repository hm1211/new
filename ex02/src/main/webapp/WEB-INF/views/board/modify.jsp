<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/board/modify" method="post">
		<label>BNO</label>
		<input type="text" name="bno" value="${vo.bno }" readonly="readonly">
		<label>Title</label>
		<input type="text" name="title" value="${vo.title}"/>
		
		<label>Content</label>
		<textarea rows="3" cols="50" name="content">
			${vo.content}
		</textarea>
		
		<label>Writer</label>
		<input type="text" name="writer" value="${vo.writer}" readonly="readonly"/>
	
		<button type="submit">글수정</button>
		
		<a href="/board/remove?bno=${vo.bno}">삭제</a>
		<a href="/board/list">목록으로</a>
	</form>
</body>
</html>