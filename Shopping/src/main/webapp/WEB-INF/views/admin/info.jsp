<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
<!-- 반응형 웹베이지 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>admin 내 정보</title>
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

div#container_box {
  float: right;
  width: calc(100%);
}

footer#footer {
  background: #f9f9f9;
  padding: 20px;
}

footer#footer ul li {
  display: inline-block;
  margin-right: 10px;
}

.max-small {
  width: auto;
  height: auto;
  max-width: 100px;
  max-height: 100px;
}
</style>
<title>admin</title>
</head>
<body>

  <div id="root">
    <header id="header">
      <div id="header_box">
        <%@ include file="include/header.jsp"%>
      </div>
    </header>

    <nav id="nav">
      <div id="nav_box">
        <%@ include file="include/nav.jsp"%>
      </div>
    </nav>

  
  <section id="container">
    <div id="container_box" class="container">
      <form action="info" method="get" enctype="multipart/form-data">
        <table class="table table-bordered table-hover" style="text-align: center; border: 1px solid #dddddd">
          <thead>
            <tr>
              <th colspan="2"><h4>내 정보</h4></th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td style="width: 120px;">
                <h5>관리자 번호</h5>
              </td>
              <td>
                <p>${adminVO.aNO }</p>
              </td>
            </tr>
            <tr>
              <td style="width: 120px;">
                <h5>관리자 아이디</h5>
              </td>
              <td>
                <p>${adminVO.aID }</p>
              </td>
            </tr>
            <tr>
              <td style="width: 120px;">
                <h5>관리자명</h5>
              </td>
              <td>
                <p>${adminVO.aNAME }</p>
              </td>
            </tr>
            <tr>
              <td style="width: 120px;">
                <h5>관리자 권한</h5>
              </td>
              <td>
                <p>${adminVO.aLEVEL }</p>
              </td>
            </tr>
          </tbody>
        </table>
        <div>
          <a href="chPw?aID=${adminVO.aID }">
            <input type="button" value="비밀번호 수정">
          </a>
          <a href="main">
            <input type="button" value="메인 페이지">
          </a>
        </div>
      </form>
    </div>
  </section>

</div>
</body>
</html>