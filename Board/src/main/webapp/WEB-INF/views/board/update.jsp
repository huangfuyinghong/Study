<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <!--  jstl 라이브러리중 fmt(포맷) 라이브러리를 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 수정</title>
</head>
<body>

<div id="nav">
	<%@ include file="../include/nav.jsp" %>
</div>

<form method="post">

<label>제목</label>
<input type="text" name="title" value="${boardVO.title }"><br>


<label>작성자</label>
<input type="text" name="writer" value="${boardVO.writer }"><br>

<label>내용</label>
<textarea cols="50" rows="5" name="content">${boardVO.content }</textarea>

<button type="submit">완료</button>

</form>

</body>
</html>