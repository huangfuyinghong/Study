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
<title>seller</title>
</head>
<body>
  <div id="root">

    <section id="container">

      <div id="container_box" class="container">
        <form action="list" method="get" enctype="multipart/form-data">
          <table class="table table-bordered table-hover" style="text-align: center; border: 1px solid #dddddd">
            <thead>
              <tr>
                <td colspan="10">
                  <h4>seller 회원 리스트</h4>
                </td>
              </tr>
              <tr>
                <th>판매자번호</th>
                <th>아이디</th>
                <th>연락처</th>
                <th>이메일</th>
                <th>상호명</th>
                <th>주소</th>
                <th>건물명</th>
                <th>가입일</th>
                <th>승인</th>
                <th>탈퇴</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="vo" items="${sellerList }">
                <tr>
                  <td>${vo.sNO }</td>
                  <td>
                    <a href="detail?sID=${vo.sID }&page=${pageMaker.criteria.page}">${vo.sID }</a>
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

  </div>

</body>
</html>