<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>seller 문의글 작성 페이지</title>
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
<title>buyer ${sqnaVO.sqTITLE }</title>
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
        <form action="bqna_update" method="post" enctype="multipart/form-data">
          <input type="hidden" name="page" value="${page }">
          <table class="table table-bordered table-hover" style="text-align: center; border: 1px solid #dddddd">
            <thead>
              <tr>
                <th colspan="2">
                  <h4>문의글 수정</h4>
                </th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td style="width: 120px;">
                  <h5>문의글 번호</h5>
                  
                </td>
                <td>
                  <p>${bqnaVO.bqID }</p>
                  <input type="hidden" name="bqID" value="${bqnaVO.bqID }">
                </td>
              </tr>
              <tr>
                <td style="width: 120px;">
                  <h5>문의글 종류</h5>
                </td>
                <td>
                  <p>${bqnaVO.bqCATE}</p>
                </td>
              </tr>
              <tr>
                <td style="width: 120px;">
                  <h5>제목</h5>
                </td>
                <td>
                  <input type="text" name="bqTITLE" value="${bqnaVO.bqTITLE }" required>
                </td>
              </tr>
              <tr>
                <td style="width: 120px;">
                  <h5>작성자</h5>
                </td>
                <td>
                  <p>${bqnaVO.bqWRITER }</p>
                </td>
              </tr>
              <tr>
                <td style="width: 120px;">
                  <h5>작성일</h5>
                </td>
                <td>
                  <p>${bqnaVO.bqCDATE }</p>
                </td>
              </tr>
              <tr>
                <td style="width: 120px;">
                  <h5>문의 내용</h5>
                </td>
                <td>
                  <textarea rows="10" cols="80" name="bqCONTENT" required>${bqnaVO.bqCONTENT }</textarea>
                </td>
              </tr>
              <tr>
                <td style="width: 120px;">
                  <h5>사진 첨부</h5>
                </td>
                <td>
                  <input class="form-contorl" type="file" id="bqFILE" name="files" value="${bqnaVO.bqFILE }" multiple="multiple">
                </td>
              </tr>
            </tbody>
          </table>
          <div>
            <input type="submit" value="등록">
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