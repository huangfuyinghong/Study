<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
<!-- 반응형 웹베이지 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<ul>
  <c:if test="${seller == null}">
    <div>
      <a href="../seller/login">로그인</a>
    </div>
    <div>
      <a href="../seller/register">회원가입</a>
    </div>
  </c:if>


  <c:if test="${seller != null}">
    <li><a href="../seller/info?sID=${seller.sID }">${seller.sID}님 정보</a></li>
    <li><a href="../seller/logout">로그아웃</a></li>
  </c:if>
</ul>