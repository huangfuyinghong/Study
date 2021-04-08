<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <!--  jstl 라이브러리중 fmt(포맷) 라이브러리를 -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 리스트</title>
</head>
<body>

<div id="nav">
	<%@ include file="../include/nav.jsp" %>
</div>

<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성일</th>
			<th>작성자</th>
			<th>댓글수</th>
			<th>조회수</th>
		</tr>
	</thead>
	
	<tbody>
	
		<c:forEach items="${boardList }" var="list">
			<tr>
				<td>${list.bNo }</td>
				<td>
					<a href="info?bNo=${list.bNo }">${list.title }</a>
				</td>
				<td>
					<fmt:formatDate value="${list.bDate }" pattern="yyyy-MM-dd"/>
				</td>
				
				<td>${list.writer }</td>
				<td>${list.replyCnt }</td>
				<td>${list.viewCnt }</td>
			</tr>
		</c:forEach>
	
	</tbody>
</table>


</body>
</html>