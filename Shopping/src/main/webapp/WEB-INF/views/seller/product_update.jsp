<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>product ${productVO.pNAME }</title>
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

.max-small {
  width: auto;
  height: auto;
  max-width: 100px;
  max-height: 100px;
}
</style>
<title>seller product detail</title>
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
        <form action="product_update" method="post" enctype="multipart/form-data">
        <input type="hidden" name="page" value="${page }">
          <table class="table table-bordered table-hover" style="text-align: center; border: 1px solid #dddddd">
            <thead>
              <tr>
                <th colspan="2">
                  <h4>등록제품 수정</h4>
                </th>
              </tr>
            </thead>
            <tbody>
               <tr>
                <td style="width: 120px;">
                  <h5>제품 번호</h5>
                </td>
                <td>
                  <p>${productVO.pID }</p>
                  <input type="hidden" name="pID" value="${productVO.pID }">
                </td>
              </tr>
              <tr>
                <td style="width: 120px;">
                  <h5>제품명</h5>
                </td>
                <td>
                  <input type="text" name="pNAME" value="${productVO.pNAME }" required>
                </td>
              </tr>
              <tr>
                <td style="width: 120px;">
                  <h5>판매가격</h5>
                </td>
                <td>
                  <input type="number" name="pPRICE" value="${productVO.pPRICE }" required>
                </td>
              </tr>
              <tr>
                <td style="width: 120px;">
                  <h5>할인가격</h5>
                </td>
                <td>
                  <input type="number" name="pDISCOUNT" value="${productVO.pDISCOUNT }" required>
                </td>
              </tr>
              <tr>
                <td style="width: 120px;">
                  <h5>제품수량</h5>
                </td>
                <td>
                  <input type="number" name="pSTOCK" value="${productVO.pSTOCK }" required>
                </td>
              </tr>
              <tr>
                <td style="width: 120px;">
                  <h5>상품사진1</h5>
                </td>
                <td>
                   <input class="form-contorl" type="file" id="pIMG1" name="files" value="${productVO.pIMG1 }" multiple="multiple">
                </td>
              </tr>
              <tr>
                <td style="width: 120px;">
                  <h5>상품사진2</h5>
                </td>
                <td>
                   <input class="form-contorl" type="file" id="pIMG2" name="files" value="${productVO.pIMG2 }" multiple="multiple">
                </td>
              </tr>
              <tr>
                <td style="width: 120px;">
                  <h5>상품사진3</h5>
                </td>
                <td>
                   <input class="form-contorl" type="file" id="pIMG3" name="files" value="${productVO.pIMG3 }" multiple="multiple">
                </td>
              </tr>
              <tr>
                <td style="width: 120px;">
                  <h5>상품상세</h5>
                </td>
                <td>
                   <input class="form-contorl" type="file" id="pDETAIL" name="files" value="${productVO.pDETAIL }" multiple="multiple">
                </td>
              </tr>
              <tr>
                <td style="width: 120px;">
                  <h5>배송</h5>
                </td>
                <td>
                   <input type="number" name="pDELIVERY" value="${productVO.pDELIVERY }" required>
                </td>
              </tr>
              <tr>
                <td style="width: 120px;">
                  <h5>등록일</h5>
                </td>
                <td>
                   <P>${productVO.pCDATE }</P>
                </td>
              </tr>
            </tbody>
          </table>
          <div>
            <input type="submit" value="수정">
          </div>
          <hr>
          <div>
          <a href="product_list?sID=${seller.sID }"><input type="button" value="전체 리스트"></a>
          <a href="product_delete?pID=${productVO.pID }&page=${page}"><input type="button" value="삭제"></a>
          </div>
        </form>
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