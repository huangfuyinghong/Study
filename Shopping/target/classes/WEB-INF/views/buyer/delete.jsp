<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
<!-- 반응형 웹베이지 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script
  src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <title>buyer</title>
</head>

<body>
  <div id="root">
    <header id="header">
      <div id="header_box">
        <%@ include file="include/header.jsp"%>
      </div>
    </header>

    <h1>회원탈퇴</h1>
    <section id="content">
      <div id="container_box">

        <form action="delete" method="post" sutocomplete="off">
          <input type="text" name="bID" placeholder="아이디"
            value="${buyerVO.bID }" autofocus> <br> <input
            type="password" name="bPW" placeholder="비밀번호" required>
          <br>
          <p></p>
          <input class="btn btn-primary" type="submit"
            onclick="registerCheckFunction()" value="회원탈퇴"> <a
            href="info?bID=${buyer.bID }"><input
            class="btn btn-primary" type="button" value="취소"></a>

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

  <script type="text/javascript">
      function registerCheckFunction() {
        if (confirm("회원 탈퇴를 하시겠습니까?")) {
          alert("회원탈퇴 중 입니다.");
          $("form").submit();
        }
      }
    </script>



</body>
</html>
