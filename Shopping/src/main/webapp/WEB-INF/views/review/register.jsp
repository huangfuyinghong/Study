<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 작성 페이지</title>
</head>
<body>
  <h2>문의글 작성 페이지</h2>
  <form action="register" method="post"> 
  <div>
    <p> 주문번호 : 
    <input type="text" name="oID" value="주문 아이디">
  </div>
  <div>
    <p> 제품번호 : 
    <input type="text" name="pID" value="주문 아이디">
  </div>
  <div>
      <p>리뷰 제목 : 
      <input type="text" name="rTITLE" placeholder="제목 입력" required="required">
      </p>
   </div>
   <div>
      <p>작성자 : 
      <input type="text" name="rWRITER" placeholder="작성자 입력" required="required">
      </p>
   </div>
   <div>
      <p>댓글 입력 : <br>
      <textarea rows="20" cols="120" name="rCONTENT" placeholder="내용 입력" required="required"></textarea>
      </p>
   </div>
   <div>
      <input type="file" name="rIMG" placeholder="파일 첨부1">
      <input type="file" name="rIMG2" placeholder="파일 첨부2">
   </div>
   <br>
   <div>
      <input type="submit" value="등록">
   </div>
  
  </form>
  

</body>
</html>