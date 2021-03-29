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
<title>admin</title>
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

div#container_box {
  float: right;
  width: calc(100%);
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
      <div id="container_box" class="container">

        <form action="buyer_info_update" method="post" enctype="multipart/form-data">
          <table class="table table-bordered table-hover" style="text-align: center; border: 1px solid #dddddd">
            <thead>
              <tr>
                <th colspan="3"><h4>내 정보 수정</h4></th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td style="width: 120px;">
                  <h5>판매자 번호</h5>
                </td>
                <td>
                  <p>${buyerVO.bNO }</p>
                </td>
                <td></td>
              </tr>
              <tr>
                <td style="width: 120px;">
                  <h5>아이디</h5>
                </td>
                <td>
                  <input class="form-contorl" type="text" id="bID" name="bID" placeholder="아이디" value=${buyerVO.bID } readonly>
                </td>
                <td></td>
              </tr>
              <tr>
                <td style="width: 120px;">
                  <h5>연락처</h5>
                </td>
                <td>
                  <input class="form-contorl" type="tel" id="bPHONE" name="bPHONE" placeholder="00*-000*-0000" pattern="[0-9]{2,3}[0-9]{3,4}[0-9]{3,4}" maxlength="13" value=${buyerVO.bPHONE } onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" required />
                </td>
                <td>
                  <font id="chkPhone" size="2"></font>
                </td>
              </tr>
              <tr>
                <td style="width: 120px;">
                  <h5>이메일</h5>
                </td>
                <td>
                  <input class="form-contorl" type="email" id="bEMAIL" name="bEMAIL" placeholder="이메일" value=${buyerVO.bEMAIL } required />
                </td>
                <td></td>
              </tr>
              <tr>
                <td style="width: 120px;">
                  <h5>주소</h5>
                </td>
                <td>
                  <input class="form-contorl" type="text" id="bPOST" name="bPOST" placeholder="우편번호" value=${buyerVO.bPOST } required />
                </td>
                <td style="width: 120px;">
                  <button class="btn btn-primary" onclick="openSearch()" type="button">주소 검색</button>
                </td>
              </tr>
              <tr>
                <td style="width: 120px;">
                  <h5>주소</h5>
                </td>
                <td>
                  <input class="form-contorl" type="text" id="bADDRESS" name="bADDRESS" placeholder="주소" value=${buyerVO.bADDRESS } required />
                </td>
                <td></td>
              </tr>
              <tr>
                <td style="width: 120px;">
                  <h5>생년월일</h5>
                </td>
                <td>
                  <input class="form-contorl" type="date" id="bBIRTH" name="bBIRTH" placeholder="생년월일" value=${buyerVO.bBIRTH }  />
                </td>
                <td></td>
              </tr>
              <tr>
                <td style="width: 120px;">
                  <h5>사업자등록증</h5>
                </td>
                <td colspan="2">
                  <input class="form-contorl" type="file" id="bLICENSE" name="files" placeholder="사업자등록증 수정" multiple="multiple" />
                  <p hidden>${buyerVO.bLICENSE }</p>
                </td>
              </tr>
              <tr>
                <td style="width: 120px;">
                  <h5>
                    <p>승인 여부</p>
                    <p>(0: 미승인 / 1: 승인)</p>
                  </h5>
                </td>
                <td>
                  <input class="form-contorl" type="text" id="bLEVEL" name="bLEVEL" placeholder="미승인" value=${buyerVO.bLEVEL }  />
                </td>
                <td><button type="button" id="change" class="btn btn-primary" >승인</button></td>
              </tr>
              <tr>
                <td style="width: 120px;">
                  <h5>
                    <p>탈퇴 여부</p>
                    <p>(0: 사용중)</p>
                  </h5>
                </td>
                <td>
                 <input class="form-contorl" type="text" id="bDROP" name="bDROP" placeholder="탈퇴여부" value=${buyerVO.bDROP } />
                </td>
                <td></td>
              </tr>
            </tbody>
          </table>
        </form>
        <table>
          <tbody>
            <tr>
              <td style="text-align: center" colspan="3">
                <input class="btn btn-primary" type="submit" id="btn" onclick="registerCheckFunction()" value="수정" />
                <a href="buyer_detail?bID=${buyerVO.bID }">
                  <input class="btn btn-primary" type="button" value="취소">
                </a>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </section>


    <footer id="footer">
      <div id="footer_box">
        <%@ include file="include/footer.jsp"%>
      </div>
    </footer>
  </div>

  <script type="text/javascript">
      //회원정보 수정 유효성 체크 
      function registerCheckFunction() {
        if ($.trim($('#bPHONE').val()) == '') {
          alert("연락처을(를) 입력해주세요.");
          return false;
        }
        if ($.trim($('#bEMAIL').val()) == '') {
          alert("이메일을(를) 입력해주세요.");
          return false;
        }
        if ($.trim($('#bPOST').val()) == '') {
          alert("주소을(를) 입력해주세요.");
          return false;
        }
        if ($.trim($('#bADDRESS').val()) == '') {
          alert("상세주소을(를) 입력해주세요.");
          return false;
        }
        if (confirm("회원 정보수정을 하시겠습니까?")) {
          alert("회원 정보수정이 완료되었습니다. 감사합니다.");
          $("form").submit();
        }
      }

      // 연락처 
      $(function() {
        $('#bPHONE').keyup(function() {
          var bPHONE = $('#bPHONE').val();
          var phpatt = bPHONE.search(/[0-9]{2,3}[0-9]{3,4}[0-9]{3,4}/g);

          if (phpatt < 0) {
            $('#chkPhone').html('연락처를 정확히 입력해주세요. - 부호없이 입력해주세요.');
            $('#chkPhone').attr('color', '#f82a2aa3');
            return false;
          } else {
            $('#chkPhone').html('');
            console.log("연락처 통과");
          }
        });
      });

      // 주소 코드 (OK)
      function openSearch() {
        new daum.Postcode({
          oncomplete : function(data) {
            $('[name=null]').val(data.zonecode); // 우편변호 (5자리)
            $('[name=bPOST]').val(data.address); // 주소 
            $('[name=bADDRESS]').val(data.buildingName); // 상세주소/ 호수
          }
        }).open();
      }
      
      // buyer 사용 승인  
      $(document).ready(function(){
        $('#change').on('click', function(){
          $('#bLEVEL').val(1);
          alert("승인완료를 위해 수정버튼 눌러주세요.")
        });
      });
    </script>


</body>
</html>