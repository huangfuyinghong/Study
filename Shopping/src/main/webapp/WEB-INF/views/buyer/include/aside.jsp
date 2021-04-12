<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>

li { font-size:16px; text-align:center; position:relative; }
li a { color:#000; display:block; padding:10px 0; }
li a:hover { text-decoration:none; background:#eee; }
li:hover { background:#eee; } 
li > ul.sub-menu { display:none; position:absolute; top:0; left:180px;  }
li:hover > ul.sub-menu { display:block; }
li:hover > ul.sub-menu li a { background:#eee; border:1px solid #eee; }
li:hover > ul.sub-menu li a:hover { background:#fff;}
li > ul.sub-menu li { width:180px; }

li > ul.sub-menu2 { display:none; position:absolute; top:0; left:180px;  }
li:hover > ul.sub-menu2 { display:block; }
li:hover > ul.sub-menu2 li a { background:#eee; border:1px solid #eee; }
li:hover > ul.sub-menu2 li a:hover { background:#fff;}
li > ul.sub-menu2 li { width:180px; }



</style>

<!-- 기본경로 + ?c=[번호1]&l=[번호2] ex) /shopping/list?c=101&l=1-->

  <ul class='main-menu'>
    <li><a href="product_list">상품(Product)</a>
      <ul class="sub-menu">
        <li><a href="/shopping/product_list?c=100&l=1">잡화</a>
          <ul class="sub-menu2">
            <li><a href="/shopping/product_list?c=101&l=2">휴대폰케이스</a></li>
            <li><a href="/shopping/product_list?c=102&l=2">패션잡화</a></li>
          </ul></li>
          <!--  
        <li><a href="/shopping/product_list?c=200&l=1">패션잡화</a>
          <ul class="sub-menu2">
            <li><a href="/shopping/product_list?c=201&l=2">여성신발</a></li>
            <li><a href="/shopping/product_list?c=202&l=2">남성신발</a></li>
            <li><a href="/shopping/product_list?c=203&l=2">여성가방</a></li>
            <li><a href="/shopping/product_list?c=204&l=2">남성가방</a></li>
            <li><a href="/shopping/product_list?c=205&l=2">여행용 가방/소품</a></li>
            <li><a href="/shopping/product_list?c=206&l=2">지갑</a></li>
            <li><a href="/shopping/product_list?c=207&l=2">시계</a></li>
            <li><a href="/shopping/product_list?c=208&l=2">주얼리</a></li>
          </ul></li>
        <li><a href="/shopping/product_list?c=300&l=1">화장품/미용</a>
          <ul class="sub-menu2">
            <li><a href="/shopping/product_list?c=301&l=2">스킨케어</a></li>
            <li><a href="/shopping/product_list?c=302&l=2">선케어</a></li>
            <li><a href="/shopping/product_list?c=303&l=2">베이스메이크업</a></li>
            <li><a href="/shopping/product_list?c=304&l=2">색조메이크업</a></li>
            <li><a href="/shopping/product_list?c=305&l=2">크렌징</a></li>
            <li><a href="/shopping/product_list?c=306&l=2">마스크/팩</a></li>
          </ul></li>
        <li><a href="/shopping/product_list?c=500&l=1">출산/육아</a>
          <ul class="sub-menu2">
            <li><a href="/shopping/product_list?c=501&l=2">기저귀</a></li>
            <li><a href="/shopping/product_list?c=502&l=2">물티슈</a></li>
            <li><a href="/shopping/product_list?c=503&l=2">수유용품</a></li>
            <li><a href="/shopping/product_list?c=504&l=2">외출용품</a></li>
            <li><a href="/shopping/product_list?c=505&l=2">목용용품</a></li>
          </ul></li>
        <li><a href="/shopping/product_list?c=600&l=1">스포츠/레저</a>
          <ul class="sub-menu2">
            <li><a href="/shopping/product_list?c=601&l=2">등산</a></li>
            <li><a href="/shopping/product_list?c=602&l=2">캠핑</a></li>
            <li><a href="/shopping/product_list?c=603&l=2">골프</a></li>
            <li><a href="/shopping/product_list?c=604&l=2">헬스</a></li>
            <li><a href="/shopping/product_list?c=605&l=2">요가/필라테스</a></li>
          </ul></li>
        <li><a href="/shopping/product_list?c=700&l=1">생활건강</a>
          <ul class="sub-menu2">
            <li><a href="/shopping/product_list?c=701&l=2">자동차용품</a></li>
            <li><a href="/shopping/product_list?c=702&l=2">주방용품</a></li>
            <li><a href="/shopping/product_list?c=703&l=2">세탁용품</a></li>
            <li><a href="/shopping/product_list?c=704&l=2">수납/정리용품</a></li>
            <li><a href="/shopping/product_list?c=705&l=2">생활용품</a></li>
          </ul></li>
          -->
      </ul></li>

    <li><a href="">신상품(New In))</a></li>
    <li><a href="">밴더(Venders)</a></li>


    <li><a href="../buyer/bqna_list?bID=${buyer.bID }">문의하기</a></li>
  </ul>
