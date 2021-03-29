<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
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

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<meta charset="UTF-8">
<title>seller product_list</title>
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

      <form action="product_list" method="get" enctype="multipart/form-data">
        <table class="table table-bordered table-hover" style="text-align: center; border: 1px solid #dddddd">
          <thead>
            <tr>
              <th colspan="9">
                <h4>판매자 제품 리스트</h4>
              </th>
            </tr>
            <tr>
              <th>제품번호</th>
              <th>제품명</th>
              <th>제품가격</th>
              <th>제품할인가격</th>
              <th>제품재고수량</th>
              <th>배송비</th>
              <th>제품클릭수량</th>
              <th>제품판매수량</th>
              <th>제품등록일</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="vo" items="${sellerProductList }">
              <tr>
                <td>${vo.pID }</td>
                <td>
                  <a href="product_update?pID=${vo.pID }&page=${pageMaker.criteria.page}">${vo.pNAME }</a>
                </td>
                <td>${vo.pPRICE }</td>
                <td>${vo.pDISCOUNT }</td>
                <td>${vo.pSTOCK }</td>
                <td>${vo.pDELIVERY }</td>
                <td>${vo.pHIT }</td>
                <td>${vo.pSELL }</td>
                <fmt:formatDate value="${vo.pCDATE }" pattern="yyyy-MM-dd HH:mm:ss" var="pCDATE" />
                <td>${pCDATE }</td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </form>
      <hr>
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

<script type="text/javascript">
      $(document).ready(function() {
        $('.pager li a').click(function() {
          // pager 클래스의 하위 li 요소의 a 요소를 찾아감
          event.preventDefault(); // a 태그의 기본 동작(페이지 이동)을 금지
          var targetPage = $(this).attr('href'); // a 태그 href 속성의 값을 저장
          console.log(targetPage);

          var frm = $('#pagingForm'); // form의 정보를 frm에 저장
          frm.find('[name="page"]').val(targetPage);
          // name="page"인 요소를 찾아서 value값을 저장
          frm.attr('action', 'list'); // form에 action 속성-값 추가
          frm.attr('method', 'get'); // form에 method 속성 추가
          frm.submit(); // form 데이터 전송
        }); // end click()

        confirmInsertResult();
        function confirmInsertResult() {
          var result = $('#insertAlert').val();
          if (result === 'success') {
            alert('새 글 작성 성공');
          } else if (result === 'fail') {
            alert('새 글 작성 실패')
          }
        }
      }); // end document
    </script>


</body>
</html>