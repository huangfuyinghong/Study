<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>

<script src="/resources/jquery/jquery-3.3.1.min.js"></script>
<meta charset="UTF-8">
<title>buyer product detail</title>
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

div.product div.imgBox {
  float: left;
  width: 350px;
}

div.product div.imgBox img {
  width: 350px;
  height: auto;
}

div.product div.info {
  float: right;
  width: 330px;
  font-size: 22px;
}

div.product div.info p {
  margin: 0 0 20px 0;
}

div.product div.info p span {
  display: inline-block;
  width: 100px;
  margin-right: 15px;
}

div.product div.info p.oSTOCK input {
  font-size: 22px;
  width: 50px;
  padding: 5px;
  margin: 0;
  border: 1px solid #eee;
}

div.product div.info p.oSTOCK button {
  font-size: 26px;
  border: none;
  background: none;
}

div.product div.info p.oSTOCK button {
  font-size: 26px;
  border: none;
  background: none;
}

div.product div.info p.addToCart {
  text-align: right;
}

div.product div.info img {
  float: center;
}
</style>
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
        <form action="cartAdd" method="post" enctype="multipart/form-data">
          <input type="hidden"  name="pID" value="${productVO.pID }" />

          <div class="product">
            <div class="imgBox">
              <img src="display?fileName=/${productVO.pIMG1 }" alt="메인 사진" />
            </div>

            <div class="info">
              <p class="pNAME">
                <span>상품명</span>${productVO.pNAME }</p>
                <input type="hidden" name="bID" value="${buyerVO.bID }">
              <P class="pPRICE">
                <span>판매가격</span>
                <fmt:formatNumber pattern="###,###,###" value="${productVO.pPRICE }" />
                원
              </P>
              <P class="pDISCOUNT">
                <span>판매가격</span>
                <fmt:formatNumber pattern="###,###,###" value="${productVO.pDISCOUNT }" />
                원
              </P>
              <P class="pSTOCK">
                <span>재고 수량</span>
                <fmt:formatNumber pattern="###,###,###" value="${productVO.pSTOCK }" />
                EA
              </P>
              <P class="cQTY">
                <span>구입수량</span>
                <input type="number" id="cQTY" name="cQTY"  value="1" min="1" max="${productVO.pSTOCK }"/>
              </P>

              <input type="submit" value="카트담기">

              <img src="display?fileName=/${productVO.pDETAIL }" alt="상품상세" />

            </div>
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

<script>

/* $(".addCart_btn").click(function(){
  var pID = $("#pID").val();
  var cQTY = $("#cQTY").val();
     
  var data = {
    pID : pID,
    cQTY : cQTY
    };
  
  $.ajax({
   url : "cartAdd",
   type : "post",
   data : data,
   success : function(result){
    alert("카트 담기 성공");
    $(".cQTY").val("1");
   },
   error : function(){
    alert("카트 담기 실패");
   }
  });
 }); */

 </script>

</html>