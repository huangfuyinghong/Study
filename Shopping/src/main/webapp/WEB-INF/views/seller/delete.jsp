<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
<!-- 반응형 웹베이지 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>seller</title>
</head>
<body>
  <div id="root">
    <header id="header">
      <div id="header_box">
        <%@ include file="include/header.jsp"%>
      </div>
    </header>

    <h3>판매자 회원탈퇴</h3>
    <section id="content">
      <div id="container_box">

        <form action="delete" method="post" sutocomplete="off">
          <input type="text" name="sID" placeholder="아이디" value="${sellerVO.sID }" autofocus>
          <br>
          <input type="password" name="sPW" placeholder="비밀번호" required>
          <br>
          <p></p>
          <input class="btn btn-primary" type="submit" value="회원탈퇴" >
          <a href="info?sID=${seller.sID }"><input class="btn btn-primary" type="button" value="취소"></a>

          <c:if test="${msg == false}">
            <p style="color: #f00;">회원탈퇴에 실패했습니다.</p>
          </c:if>
          
        </form>

      </div>
    </section>
    <br> <br> <br> <br> <br>
    <footer id="footer">
      <div id="footer_box">
        <%@ include file="include/footer.jsp"%>
      </div>
    </footer>
  </div>


  
</body>
</html>