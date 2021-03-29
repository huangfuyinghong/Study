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
<style>
body {
  font-family: '맑은 고딕', verdana;
  padding: 0;
  margin: 0;
}

ul {
  padding: 0;
  margin: 0;
  list-style: none;
}

div#root {
  width: 90%;
  margin: 0 auto;
}

header#header {
  font-size: 60px;
  padding: 20px 0;
}

header#header h1 a {
  color: #000;
  font-weight: bold;
}

nav#nav {
  padding: 10px;
  text-align: right;
}

nav#nav ul li {
  display: inline-block;
  margin-left: 10px;
}

section#container {
  padding: 20px 0;
  border-top: 2px solid #eee;
  border-bottom: 2px solid #eee;
}

section#container::after {
  content: "";
  display: block;
  clear: both;
}

footer#footer {
  background: #f9f9f9;
  padding: 20px;
}

footer#footer ul li {
  display: inline-block;
  margin-right: 10px;
}
</style>
<title>buyer</title>
</head>
<body>
  <div id="root">
    <header id="header">
      <div id="header_box">
        <%@ include file="include/header.jsp"%>
      </div>
    </header>

    <section id="container">
      <div id="container_box" class="container">
        <form action="login" method="post">
          <table class="table table-bordered table-hover"
            style="text-align: center; border: 1px solid #dddddd">
            <thead>
              <tr>
                <th><h4>로그인</h4></th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td style="width: 120px;"><input
                  class="form-contorl" type="text" name="bID"
                  placeholder="아이디" required autofocus /></td>
              </tr>
              <tr>
                <td style="width: 120px;"><input
                  class="form-contorl" type="password" name="bPW"
                  placeholder="비밀번호" required /></td>
              </tr>
              <tr>
                <td style="width: 120px;"><input
                  class="btn btn-primary" type="submit" value="로그인" />
                  <input class="btn btn-primary" type="button"
                  value="회원가입" onclick="location.href='register'" /></td>
              </tr>
              <tr>
                <td style="width: 120px;"><c:if
                    test="${msg == false}">
                    <p style="color: #f00;">로그인에 실패했습니다.</p>
                  </c:if></td>
              </tr>
            </tbody>
          </table>
        </form>

        <a href="../buyer/find_id">아이디 찾기</a> / <a href="../buyer/find_pw">비밀번호 찾기</a>
      </div>
    </section>
    <footer id="footer">
      <div id="footer_box">
        <%@ include file="include/footer.jsp"%>
      </div>
    </footer>

  </div>
</body>
</html>