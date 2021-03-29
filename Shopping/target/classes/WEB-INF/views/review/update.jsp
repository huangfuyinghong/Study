<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${reviewVO.rTITLE }</title>
</head>
<body>
   <h2>문의글 수정</h2>
   <form action="update" method="post">
   <input type="hidden" name="page" value="${page }">
   <div>
      <p>리뷰 번호 : ${reviewVO.rID }</p>
      <input type="hidden" name="rID" value="${reviewVO.rID }">
   </div>
   <div>
    <p> 주문번호 : 
    <input type="hidden" name="oID" value="${reviewVO.oID }">
  </div>
  <div>
    <p> 제품번호 : 
    <input type="hidden" name="pID" value="${reviewVO.pID }">
  </div>
  <div>
      <p>리뷰 제목 : 
      <input type="text" name="rTITLE" placeholder="${reviewVO.rTITLE }" required>
      </p>
   </div>
   <div>
      <p>작성자 : ${reviewVO.rWRITER }</p>
      <p>작성일 : ${reviewVO.rCDATE }</p>
   </div>
   <div>
      <p>댓글 입력 : <br>
      <textarea rows="20" cols="120" name="rCONTENT" required>${reviewVO.rCONTENT }</textarea>
      </p>
   </div>
   <div>
      <input type="file" name="rIMG" value="reviewVO.rIMG">
      <input type="file" name="rIMG2" value="reviewVO.rIMG2">
   </div>
   <br>
   <div>
      <input type="submit" value="등록">
   </div>
   
  
   </form>

</body>
</html>