<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <!--  jstl 라이브러리중 fmt(포맷) 라이브러리를 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 조회</title>
</head>
<body>

<div id="nav">
	<%@ include file="../include/nav.jsp" %>
</div>

<form method="post">

<label>제목</label>
${boardVO.title }<br>

<label>작성자</label>
${boardVO.writer }<br>

<label>내용</label>
${boardVO.content }<br>

<div>
<a href="update?bNo=${boardVO.bNo }">게시물 수정</a>, <a href="delete?bNo=${boardVO.bNo }">게시물 삭제</a>
</div>

</form>

</body>
</html>