<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>제품 리뷰</title>
</head>
<body>

  <div id="review">

    <c:if test="${buyer == null }">
      <p>
        리뷰는 <a href="buyer/login">로그인</a> 후 남겨주세요.
    </c:if>

    <c:if test="${buyer != null }">
      <section class="reviewForm">
        <form role="form" method="post" autocomplete="off">
        
        <input type="hidden" name="pID" value="${productVO.pID }">
        
          <div class="input_area">
            <textarea name="rCONTENT" id="rCONTENT"></textarea>
            <button type="submit" id="review_btn">제품 리뷰</button>
          </div>
        </form>
      </section>
    </c:if>

    <section class="reviewList">
      <ol>
        <li>댓글 목록</li>
      </ol>
    </section>


  </div>





</body>
</html>