<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 리스트</title>
</head>
<body>

<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>댓글수</th>
			<th>조회수</th>
		</tr>
	</thead>
	
	<tbody>
	
		<c:forEach items="${boardList }" var="list">
			<tr>
				<th>${list.bNo }</th>
				<th>${list.title }</th>
				<th>${list.writer }</th>
				<th>${list.bDate }</th>
				<th>${list.replyCnt }</th>
				<th>${list.viewCnt }</th>
			</tr>
		</c:forEach>
	
	</tbody>
</table>

</body>
</html>