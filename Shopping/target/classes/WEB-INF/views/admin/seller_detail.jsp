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
<title>seller 회원가입</title>
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
      <div id="container_box">
        <div class="container">
          <form action="seller_detail" method="get" enctype="multipart/form-data">
            <table class="table table-bordered table-hover" style="text-align: center; border: 1px solid #dddddd">
              <thead>
                <tr>
                  <th colspan="2"><h4>내 정보</h4></th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td style="width: 120px;">
                    <h5>판매자 번호</h5>
                  </td>
                  <td>
                    <p>${sellerVO.sNO }</p>
                  </td>
                </tr>
                <tr>
                  <td style="width: 120px;">
                    <h5>아이디</h5>
                  </td>
                  <td>
                    <p>${sellerVO.sID }</p>
                  </td>
                </tr>

                <tr>
                  <td style="width: 120px;">
                    <h5>연락처</h5>
                  </td>
                  <td>
                    <p>${sellerVO.sPHONE }</p>
                  </td>
                </tr>
                <tr>
                  <td style="width: 120px;">
                    <h5>이메일</h5>
                  </td>
                  <td>
                    <p>${sellerVO.sEMAIL }</p>
                  </td>
                </tr>
                <tr>
                  <td style="width: 120px;">
                    <h5>우편번호</h5>
                  </td>
                  <td>
                    <p>${sellerVO.sADDRESS }</p>
                  </td>
                </tr>
                <tr>
                  <td style="width: 120px;">
                    <h5>주소</h5>
                  </td>
                  <td>
                    <p>${sellerVO.sBUILD }</p>
                  </td>
                </tr>
                <tr>
                  <td style="width: 120px;">
                    <h5>상세주소</h5>
                  </td>
                  <td>
                    <p>${sellerVO.sBUILDNO }</p>
                  </td>
                </tr>
                <tr>
                  <td style="width: 120px;">
                    <h5>사업자등록증</h5>
                  </td>
                  <td>
                    <div>
                      <a href="display?fileName=/${sellerVO.sLICENCE }" target="_blank">
                        <img class='max-small' src="display?fileName=/${sellerVO.sLICENCE }" alt="사업자등록증" />
                      </a>
                    </div>
                  </td>
                </tr>
                <tr>
                  <td style="width: 120px;">
                    <h5>통장사본</h5>
                  </td>
                  <td>
                    <div>
                      <a href="display?fileName=/${sellerVO.sBANK }" target="_blank">
                        <img class='max-small' src="display?fileName=/${sellerVO.sBANK }" alt="통장사본" />
                      </a>
                    </div>
                  </td>
                </tr>
                <tr>
                  <td style="width: 120px;">
                    <h5><p>승인 여부</p> <p>(0: 미승인 / 1: 승인)</p></h5>
                  </td>
                  <td>
                    <p>${sellerVO.sLEVEL }</p>
                  </td>
                </tr>
                <tr>
                  <td style="width: 120px;">
                    <h5><p>탈퇴 여부</p> <p>(0: 사용중)</p></h5>
                  </td>
                  <td>
                    <p>${sellerVO.sDROP }</p>
                  </td>
                </tr>
              </tbody>
            </table>
            <div>
              <a href="seller_info_update?sID=${sellerVO.sID }">
                <input type="button" value="정보수정">
              </a>
              <a href="seller_list?page=${page }">
                <input type="button" value="판매자 목록">
              </a>
            </div>
          </form>
        </div>
      </div>
    </section>


    <footer id="footer">
      <div id="footer_box">
        <%@ include file="include/footer.jsp"%>
      </div>
    </footer>
  </div>

  <script type="text/javascript">
      // 회원 탈퇴
    </script>


</body>
</html>