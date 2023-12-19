<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		alert("${result}");
	})
</script>
</head>

<body>
	<table border="1">
		<tr>
			<th>bno</th>
			<th>title</th>
			<th>content</th>
			<th>writer</th>
			<th>regdate</th>
		</tr>
		<c:forEach var="vo" items="${boardList}">
			<tr>
				<td><c:out value="${vo.bno}"/></td>
				<td><c:out value="${vo.title}"/></td>
				<td><a href="/board/get?bno=${vo.bno}"><c:out value="${vo.content}"/></a></td>
				<td><c:out value="${vo.writer}"/></td>
				<td><c:out value="${vo.regdate}"/></td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="/board/register">글쓰기</a>
</body>
</html>