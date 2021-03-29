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
<title>seller list</title>
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

th {
 text-align: center;
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

aside {
  float: left;
  width: 200px;
}

div#container_box {
  float: right;
  width: calc(100% - 200px - 20px);
}

aside ul li {
  text-align: center;
  margin-bottom: 10px;
}

aside ul li a {
  display: block;
  width: 100%;
  padding: 10px 0;
}

aside ul li a:hover {
  background: #eee;
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
    <aside>
        <%@ include file="include/aside.jsp"%>
      </aside>
      <div id="container_box" class="container">
        <form action="list" method="get" enctype="multipart/form-data">
          <table class="table table-bordered table-hover" style="text-align: center; border: 1px solid #dddddd">
            <thead>
              
              <tr>
                <td>판매자번호</td>
                <td>아이디</td>
                <td>연락처</td>
                <td>이메일</td>
                <td>상호명</td>
                <td>주소</td>
                <td>건물명</td>
                <td>가입일</td>
                <td>승인</td>
                <td>탈퇴</td>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="vo" items="${sellerList }">
                <tr>
                  <td>${vo.sNO }</td>
                  <td>
                    <a href="seller_detail?sID=${vo.sID }&page=${pageMaker.criteria.page}">${vo.sID }</a>
                  </td>
                  <td>${vo.sPHONE }</td>
                  <td>${vo.sEMAIL }</td>
                  <td>${vo.sNAME }</td>
                  <td>${vo.sBUILD}</td>
                  <td>${vo.sBUILDNO}</td>
                  <fmt:formatDate value="${vo.sCDATE }" pattern="yyyy-MM-dd HH:mm:ss" var="sCDATE" />
                  <td>${sCDATE }</td>
                  <td>${vo.sLEVEL}</td>
                  <td>${vo.sDROP}</td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </form>
          <ul class="pager">
    <c:if test="${pageMaker.hasPrev }">
      <li><a href="${pageMaker.startPageNo - 1}">이전</a></li>
    </c:if>
    <c:forEach begin="${pageMaker.startPageNo }" end="${pageMaker.endPageNo }" var="num">
      <li><a href="${num }">${num }</a></li>
    </c:forEach>
    <c:if test="${pageMaker.hasNext }">
      <li><a href="${pageMaker.endPageNo + 1}">다음</a></li>
    </c:if>
  </ul>

  <div>
    <form id="pagingForm" style="display: none;">
      <input type="text" name="page">
    </form>
  </div>

  <input id="insertAlert" type="hidden" value="${insert_result}">
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