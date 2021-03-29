<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>buyer main</title>
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

div.productThumb {
  border: 1px solid #eee;
  text-align: center;
  float: left;
  margin: 5px;
}

div.productThumb img {
  width: 200px;
  height: 200px;
}

div.page {
  display: inline-block;
  width: calc(100% - 200px - 20px);
}
</style>

<title>buyer cart add</title>
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
        
        <form action="cartList" method="post" enctype="multipart/form-data">
        
        <ul>
          <c:forEach items="${cartList }" var="cartList">
          <li>
            <div class="thumb">
              <img alt="제품 메인 사진" src="display?fileName=/${cartList.pIMG1 }">
            </div>
            <div class="productInfo">
              <p>
                <span>상품명 : </span>${pName }<br />
                <span>가격 : </span><fmt:formatNumber pattern="###,###,###" value="${cartList.pDISCOUNT }" /><br />
                <span>구입 수량 : </span>${cartList.cQTY }<br />
                <span>최종 가격 : </span><fmt:formatNumber pattern="###,###,###" value="${cartList.pDISCOUNT * cartList.cQTY}" />
              </p>
            </div>
          </li>
          </c:forEach>
        </ul>
        
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