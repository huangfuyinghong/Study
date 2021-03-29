<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table, th, td {
  border-style : solid;
  border-width : 1px;
  text-align : center;
}

ul {
  list-style-type: none;
}

li {
  display: inline-block;
}
</style>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<meta charset="UTF-8">
<title>문의글 메인 페이지</title>
</head>
<body>
  <h1>문의글 작성</h1>
  <hr>
 
  <br>
  <a href="register"><input type="button" value="글작성"></a>
  <br>
  <br>
  <table>
    <thead>
      <tr>
        <th style="width: 60px;">번호</th>
        <th style="width: 700px;">제목</th>
        <th style="width: 60px;">작성자</th>
        <th style="width: 100px;">작성일</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="vo" items="${pqnaList }">
        <tr>
          <td>${vo.pqID }</td>
          <td><a href="detail?pqID=${vo.pqID }&page=${pageMaker.criteria.page}">${vo.pqTITLE }</a></td>
          <td>${vo.pqWRITER }</td>
          <fmt:formatDate value="${vo.pqCDATE }"
            pattern="yyyy-MM-dd HH:mm:ss"
            var="pqCDATE"/>
          <td>${pqCDATE }</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
  <hr>
  <ul class="pager">
    <c:if test="${pageMaker.hasPrev }">
      <li><a href="${pageMaker.startPageNo - 1}">이전</a></li>
    </c:if>
    <c:forEach begin="${pageMaker.startPageNo }" 
      end="${pageMaker.endPageNo }" var="num">
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
  
  <script type="text/javascript">
  	$(document).ready(function(){
  	  $('.pager li a').click(function(){
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
  	    } else if(result === 'fail'){
  	      alert('새 글 작성 실패')
  	    }
  	  }
  	}); // end document
  </script>
</body>
</html>