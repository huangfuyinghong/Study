<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!--  jstl 라이브러리중 fmt(포맷) 라이브러리를 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 리스트</title>
</head>
<body>

	<div id="nav">
		<%@ include file="../include/nav.jsp"%>
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
					<td><a href="info?bNo=${list.bNo }">${list.title }</a></td>
					<td><fmt:formatDate value="${list.bDate }" pattern="yyyy-MM-dd" /></td>

					<td>${list.writer }</td>
					<td>${list.replyCnt }</td>
					<td>${list.viewCnt }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<ul class="pager">
		<!-- 이전 -->
		<c:if test="${pageMaker.hasPrev }">
			<li><a href="${pageMaker.startPageNo - 1 }">이전</a></li>
		</c:if>
		<!-- 표시되는 페이지 갯수 -->
		<c:forEach begin="${pageMaker.startPageNo }" end="${pageMaker.endPageNo }" var="num">
			<li><a href="list?page=${num }">${num }</a></li>
		</c:forEach>
		<!-- 다음 -->
		<c:if test="${pageMaker.hasNext }">
			<li><a href="${pageMaker.endPageNo + 1 }">다음</a></li>
		</c:if>
	</ul>
	
	<!-- 현재 페이지 -->
	<div>
		<form id="pagingForm" style="display: none;">
			<input type="text" name="page">
		</form>
	</div>
	
	<!-- 게시글 추가 성공되면 동작되는 코드 -->
	<input id="insertAlter" type="hidden" value="${insert_result }">
	
</body>
</html>