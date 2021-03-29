<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cartList</title>
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
      
      <form action="order" method="post" enctype="multipart/form-data">
        <ul>
          <c:forEach items="${cartList }" var="vo">
              
            <div class="productThumb">
            <a href="product_detail?pID=${vo.pID }&page=${pageMaker.criteria.page}">
                  <img src="display?fileName=/${vo.pIMG1 }" alt="썸네일 사진">
            </a>
            <p>${vo.pNAME }</p>
            <P>판매가 : ${vo.pPRICE }</P>
            <p>할인가격 : ${vo.pDISCOUNT }</p>
            
            </div>
          
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