<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의글 작성 페이지</title>
</head>
<body>
  <h2>글 작성 페이지</h2>
  <form action="register" method="post">
  
    <div>
      <P> 문의글 종류 :
      <input type="radio" name="pqCATE" value="제품 배송"> 제품 배송
      <input type="radio" name="pqCATE" value="제품 정보"> 제품 정보
      <input type="radio" name="pqCATE" value="기타"> 기타 
      </P>
    </div>
    <div>
      <p>제목 : 
      <input type="text" name="pqTITLE" placeholder="제목 입력" required="required">
      </p>
    </div>
    <div>
      <p>작성자 : 
      <input type="text" name="pqWRITER" placeholder="작성자 입력" required="required">
      </p>
    </div>
    <div>
      <p>제품 번호 입력 : 
      <input type="text" name="pID" placeholder="작성자 입력" required="required">
    </div>
    <div>
      <p>문의글 입력 : <br>
      <textarea rows="20" cols="120" name="pqCONTENT" placeholder="내용 입력" required="required"></textarea>
      </p>
    </div>
    <div>
      <input type="file" name="pqFILE" placeholder="파일 첨부">
    </div>
    <div>
      <p> 문의글 공개 여부
      <input type="radio" name="pqSECRET" value="0" checked="checked"> 공개 
      <input type="radio" name="pqSECRET" value="1"> 비공게
      <input type="password" name="pqPW" palceholder="비밀번호 입력">
      </p>
    </div>
    
    <div>
      <input type="submit" value="등록">
    </div>
  </form>

</body>
</html>