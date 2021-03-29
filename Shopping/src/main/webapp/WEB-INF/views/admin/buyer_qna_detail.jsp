<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>seller 문의글 상세</title>
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
</head>
<title>admin</title>
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
        <form action="buyer_qna_detail" method="post" enctype="multipart/form-data">
          <table class="table table-bordered table-hover" style="text-align: center; border: 1px solid #dddddd">
            <thead>
              <tr>
                <th colspan="2">
                  <h4>문의글 보기</h4>
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
                </td>
              </tr>
              <tr>
                <td style="width: 120px;">
                  <h5>문의글 종류</h5>
                </td>
                <td>
                  <p>${bqnaVO.bqCATE }</p>
                </td>
              </tr>
              <tr>
                <td style="width: 120px;">
                  <h5>제목</h5>
                </td>
                <td>
                  <p>${bqnaVO.bqTITLE }</p>
                </td>
              </tr>
              <tr>
                <td style="width: 120px;">
                  <h5>작성자</h5>
                </td>
                <td>
                  <p>${bqnaVO.bqWRITER }</P>
                </td>
              </tr>
              <tr>
                <td style="width: 120px;">
                  <h5>작성일</h5>
                </td>
                <td>
                  <fmt:formatDate value="${bqnaVO.bqCDATE }" pattern="yyyy-MM-dd HH:mm:ss" var="bqCDATE" />
                  <P>작성일 : ${bqCDATE }</P>
                </td>
              </tr>
              <tr>
                <td style="width: 120px;">
                  <h5>문의 내용</h5>
                </td>
                <td>
                  <textarea rows="5" cols="60" readonly="readonly">${bqnaVO.bqCONTENT }</textarea>
                </td>
              </tr>
              <tr>
                <td style="width: 120px;">
                  <h5>첨부 사진</h5>
                </td>
                <td>
                  <!-- 보완 필요 : 사진이 있으면 표시 없으면 첨부파일 없음으로 표시하는 functiond을 만들어야함   -->
                  <a href="display?fileName=/${bqnaVO.bqFILE }" target="_blank">
                    <img class='max-small' src="display?fileName=/${bqnaVO.bqFILE}" alt="첨부 사진" />
                  </a>
                </td>
              </tr>

            </tbody>
          </table>
        </form>
        <div id="replyarea">
          <%@ include file="include/bqna_reply.jsp"%>
        </div>

        <div>
          <a href="buyer_qna_list?page=${page }">
            <input type="button" value="글 목록">
          </a>
        </div>
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