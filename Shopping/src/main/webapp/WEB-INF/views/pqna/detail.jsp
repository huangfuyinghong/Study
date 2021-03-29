<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
  <h2>문의글 보기</h2>
  <div>
    <p>글 번호 : ${pqnaVO.pqID }</p>
  </div>
  <div>
  <P> 문의글 종류 : 
    <input type="text" value="${pqnaVO.pqCATE }" readonly="readonly">
  </P>
  </div>
  <div>
    <p>
      제목 <input type="text" value="${pqnaVO.pqTITLE }" readonly="readonly">
    </p>
  </div>
   <div>
      <p>작성자 : ${pqnaVO.pqWRITER }</P>
      <p>제품번호 : ${pqnaVO.pID }</p>
      <fmt:formatDate value="${pqnaVO.pqCDATE }" pattern="yyyy-MM-dd HH:mm:ss" var="pqCDATE"/>
      <P>작성일 : ${pqCDATE }</P>
    </div>
     <div>
    <textarea rows="20" cols="120" readonly="readonly">${pqnaVO.pqCONTENT }</textarea>
  </div>
  <div>
    <a href="list?page=${page }"><input type="button" value="글 목록"></a>
    <a href="update?pqID=${pqnaVO.pqID }&page=${page}"><input type="button" value="글 수정"></a> 
    <a href="delete?pqID=${pqnaVO.pqID }"><input type="button" value="글 삭제"></a>
  </div>

</body>
</html>