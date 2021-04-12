<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
<!-- 반응형 웹베이지 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>회원가입</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
</style>
<title>buyer</title>
</head>
<body>
  <div id="root">
    <header id="header">
      <div id="header_box">
        <%@ include file="include/header.jsp"%>
      </div>
    </header>
    <br>
    <section id="container">
      <div id="container_box">
        <div class="container">
          <form action="buyer_register" method="post" enctype="multipart/form-data">
            <table class="table table-bordered table-hover" style="text-align: center; border: 1px solid #dddddd">
              <thead>
                <tr>
                  <th colspan="3"><h4>회원가입</h4></th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td style="width: 120px;">
                    <h5>아이디</h5>
                  </td>
                  <td>
                    <input class="form-contorl" type="text" id="bID" name="bID" placeholder="아이디" required />
                  </td>
                  <!-- onclick="bidcheckFunction()" => 아이디 주옥확인을 누르면 sidcheckFunction() 함수를 통해 자바스크립트의 function sidcheckFunction()로 진입 -->
                  <td style="width: 120px;">
                    <button class="btn btn-primary" onclick="bidcheckFunction()" type="button">아이디 중복 체크</button>
                  </td>
                </tr>
                <tr>
                  <td style="width: 120px;">
                    <h5>비밀번호</h5>
                  </td>
                  <td>
                    <input class="form-contorl" type="password" id="bPW" name="bPW" placeholder="비밀번호" required />
                  </td>
                  <td>
                    <font id="chkPwPatten" size="2"></font>
                  </td>
                </tr>
                <tr>
                  <td style="width: 120px;">
                    <h5>비밀번호 확인</h5>
                  </td>
                  <td>
                    <input class="form-contorl" type="password" id="bPW2" name="bPW2" placeholder="비밀번호 확인" required />
                  </td>
                  <td>
                    <font id="chkPw" size="2"></font>
                  </td>
                </tr>
                <tr>
                  <td style="width: 120px;">
                    <h5>연락처</h5>
                  </td>
                  <td>
                    <input class="form-contorl" type="tel" id="bPHONE" name="bPHONE" placeholder="00*-000*-0000" pattern="[0-9]{2,3}[0-9]{3,4}[0-9]{3,4}" maxlength="13" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" required />
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
                    <input class="form-contorl" type="email" id="bEMAIL" name="bEMAIL" placeholder="이메일" required />
                  </td>
                  <td></td>
                </tr>
                <tr>
                  <td style="width: 120px;">
                    <h5>주소</h5>
                  </td>
                  <td>
                    <input class="form-contorl" type="text" id="bPOST" name="bPOST" placeholder="주소" required />
                  </td>
                  <td><button class="btn btn-primary" onclick="openSearch()" type="button">주소 검색</button></td>
                </tr>
                <tr>
                  <td style="width: 120px;">
                    <h5>상세주소</h5>
                  </td>
                  <td>
                    <input class="form-contorl" type="text" id="bADDRESS" name="bADDRESS" placeholder="상세주소" required />
                  </td>
                  <td></td>
                </tr>
                <tr>
                  <td style="width: 120px;">
                    <h5>생년월일</h5>
                  </td>
                  <td>
                    <input class="form-contorl" type="date" id="bBIRTH" name="bBIRTH" placeholder="생년월일" required />
                  </td>
                  <td>
                  </td>
                </tr>
                <tr>
                  <td style="width: 120px;">
                    <h5>사업자등록증</h5>
                  </td>
                  <td colspan="2">
                    <input class="form-contorl" type="file" id="bLICENCE" name="files" multiple="multiple" />
                  </td>
                </tr>
                <tr>
                  <td style="width: 120px;">
                    <h5>약관동의 여부</h5>
                  </td>
                  <td colspan="2">
                    <div class="form-check" style="text-align: left">
                      <label class="form-check-label" for="bTEMRS"> <input type="checkbox" name="bTEMRS" id="bTEMRS" value="" onclick="if(this.checked){stemrsCheckFunction()}" /> 동의
                      </label>
                    </div>
                  </td>
                </tr>
              </tbody>
            </table>
          </form>
          <table>
            <tbody>
              <tr>
                <td style="text-align: center" colspan="3">
                  <input class="btn btn-primary pull-right" type="submit" id="btn" onclick="registerCheckFunction()" value="회원가입" />
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </section>
    <br> 
    
    <footer id="footer">
      <div id="footer_box">
        <%@ include file="include/footer.jsp"%>
      </div>
    </footer>
  </div>


  <script type="text/javascript">
  // 회원가입 유효성 체크  
  function registerCheckFunction() {
    if($.trim($('#bID').val()) =='') {
      alert("아이디을(를) 입력해주세요.");
      return false;
    }
    if($.trim($('#bPW').val()) =='') {
      alert("비밀번호을(를) 입력해주세요.");
      return false;
    }
    if($.trim($('#bPHONE').val()) =='') {
      alert("연락처을(를) 입력해주세요.");
      return false;
    }
    if($.trim($('#bEMAIL').val()) =='') {
      alert("이메일을(를) 입력해주세요.");
      return false;
    }
    if($.trim($('#bPOST').val()) =='') {
      alert("주소을(를) 입력해주세요.");
      return false;
    }
    if($.trim($('#bADDRESS').val()) =='') {
      alert("상세주소을(를) 입력해주세요.");
      return false;
    }
    if($.trim($('#bLICENCE').val()) =='') {
      alert("사업자등록증을(를) 첨부해주세요.");
      return false;
    }
    if($.trim($('#bTEMRS').val()) =='') {
      alert("약관을 동의해 주세요.");
      return false;
    }
    if($.trim($('#bBIRTH').val()) =='') {
      alert("상호명을(를) 입력해주세요.");
      return false;
    }
    if(confirm("회원가입을 하시겠습니까?")){
      alert("회원가입이 완료되었습니다. 감사합니다.");
       $("form").submit();
    }

  }
  
  
  
      //아이디 체크여부 확인 (아이디 중복일 경우 = 0 , 중복이 아닐경우 = 1 )
      function bidcheckFunction() {
        <!--제이쿼리 val() 함수는 아이디에 입력한 값을 가져와서 sID에 담아준다. -->
        var bID = $("#bID").val(); 
        var num = bID.search(/[0-9]/g); <!-- 0~9 패턴  -->
        var eng = bID.search(/[a-zA-Z]/g); <!-- 대소문자 패턴  -->
    <!--if (sID.search(/\s/) != -1)와 if (sID.trim().length != 0) 공백이 있는 데이터를 막아주기-->
        if (bID.search(/\s/) != -1) {
          alert("아이디에는 공백이 들어갈 수 없습니다.")
        } else if(bID.length < 8 || bID.length > 12 ) {
          alert("아이디는 8 ~ 12자리 이내로 입력해주세요.")
        } else if(num < 0 || eng  < 0) {
          alert("아이디는 영문, 숫자을 혼합하여 입력해주세요.")
        } else {
          
          if (bID.trim().length != 0) {
            $.ajax({
              async : true, <!-- true이면 비동기방식을 사용 -->
              type : 'POST', <!-- POST 방식으로 데이터를 보냄 -->
              data : bID, <!-- bID 데이터를 보낼것 -->
              url : 'bidCheck', <!-- controller /sidCheck로 보낼것  -->
              dataType : 'text ', 
              contentType : 'text/plain; charset=UTF-8',
              success : function(count) { <!-- 통신이 성공했을 때 보여줄 내용, ()에는 데이터를 보낸 곳의 리턴값이 들어온다.-->
                if (count > 0) {
                  alert("아이가 존재 합니다.");
                  $("#submit").attr("disabled", "disabled");
                  window.location.reload();
                } else {
                  alert("사용 가능한 아이디입니다.");
                  $("#submit").removeAttr("disabled");
                }
              },
              error : function(error) { <!--통신이 실패했을때 보여줄 내용 -->
                alert("아이디를 입력해주세요.");
              }
            });
          } else {
            alert("아이디를 입력해주세요.")
          }
        }
      }
      
      
      
      // 비밀번호 패턴 및 일치여부 확인 체크(ok)  (8자 이상, 문자, 숫자, 특수문자 포함여부 체크)
      $(function(){
        $('#bPW').keyup(function(){
      	  var bPW = $('#bPW').val();
      	  var num = bPW.search(/[0-9]/g);
      	  var eng = bPW.search(/[a-z]/ig);
      	  var spe = bPW.search(/[~!@#$%^&*()_+|<>?:{}]/gi);
      	  
      	  
      	    if(bPW.length < 10 || bPW.length > 20) {
      	      $('#chkPwPatten').html('10 ~ 20자 이내로 입력해주세요.');
      	      $('#chkPwPatten').attr('color', '#f82a2aa3');
      	      return false;
      	    } else if(bPW.search(/\s/) != -1){
      	      $('#chkPwPatten').html('비밀번호는 공백 없이 입력해주세요.');
      	      $('#chkPwPatten').attr('color', '#f82a2aa3');
      	      return false;
      	    } else if((num < 0 && eng < 0) || (eng < 0 && spe < 0) || (spe < 0 && num < 0)) {
      	      $('#chkPwPatten').html('영문,숫자, 특수문자 중 2가지 이상을 사용해주세요.');
      	      $('#chkPwPatten').attr('color', '#f82a2aa3');
      	      return false;
      	    } else {
      	      $('#chkPwPatten').html('사용가능');
                $('#chkPwPatten').attr('color', '#199894b3');
      	    }
      	    
      	  });

    	$('#bPW2').keyup(function(){
        if($('#bPW').val() != $('#bPW2').val()){
          $('#chkPw').html('비밀번호 일치하지 않음<br><br>');
          $('#chkPw').attr('color', '#f82a2aa3');
          return false;
        } else{
          $('#chkPw').html('비밀번호 일치함<br><br>');
          $('#chkPw').attr('color', '#199894b3');
        }

    });
});
      
      // 연락처 
      $(function(){
        $('#bPHONE').keyup(function(){
          var bPHONE = $('#bPHONE').val();
          var phpatt = bPHONE.search(/[0-9]{2,3}[0-9]{3,4}[0-9]{3,4}/g);
          
          if(phpatt < 0) {
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

      // 약관 동의 코드 (ok)  
      // 문제: 뒤로하기 하면 체크된 데이터가 남아 있는데 실제로는 체크가 안된 상태 임 
      // (즉, 뒤로 돌아가면 체크가 되어 있어 다시 클릭하면 체크가 안된 상태이지만 회원가입 가능) > 젤 좋은 방법은 뒤로가기 하면 모든 데이터 지우는 방법이다.  
      function stemrsCheckFunction() {
        document.getElementById("bTEMRS").value = 1;
        }
      
    </script>
</body>
</html>