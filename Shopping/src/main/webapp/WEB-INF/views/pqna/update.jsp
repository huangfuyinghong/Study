<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${pqnaVO.pqTITLE }</title>
</head>
<body>
  <h2>문의글 수정</h2>
   <form action="update" method="post">
    <input type="hidden" name="page" value="${page }">
   <div>
      <p>글 번호 : ${pqnaVO.pqID }</p>
      <input type="hidden" name="pqID" value="${pqnaVO.pqID }">
    </div>
    <div>
      <P> 문의글 종류 : 
      <input type="text" name="pqCATE" value="${pqnaVO.pqCATE }" readonly>
      </P>
    </div>
    <div>
      <p>제목 :   
      <input type="text" name="pqTITLE" value="${pqnaVO.pqTITLE }" required>
      </p>
    </div>
    <div>
      <p>작성자 : ${pqnaVO.pqWRITER }</p>
      <p>제품번호 : ${pqnaVO.pID }</p>
      <p>작성일 : ${pqnaVO.pqCDATE }</p>
    </div>
    <div>
      <p>문의글 입력 : <br>
      <textarea rows="20" cols="120" name="pqCONTENT" required>${pqnaVO.pqCONTENT }</textarea>
      </p>
    </div>
    <div>
      <input type="file" name="pqFILE" value="${pqnaVO.pqFILE }">
    </div>
    <div>
      <p> 문의글 공개 여부
      <input type="radio" name="pqSECRET" value="0" checked="checked"> 공개 
      <input type="radio" name="pqSECRET" value="1"> 비공게
      <input type="password" name="pqPW" palceholder="비밀번호 입력">
      </p>
    </div>
     <div>
      <input type="submit" value="제출">
    </div>
   </form>

</body>
</html>