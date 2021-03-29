<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>문의글 답변</title>
</head>
<body>


    <table class="table table-bordered table-hover" style="text-align: center; border: 1px solid #dddddd">
    <tbody>
      <tr style="hidden">
        <td style="width: 120px; ">
        <p>답변</p>
          <input type="hidden" id="qnaID" value=${bqnaVO.bqID }>
          <input type="hidden" id="replyWRITER" value="관리자" placeholder="아이디 입력">
          <input type="hidden" id="replyCONTENT" placeholder="내용 입력" required="required">
        </td>
        <th>
          <div style="text-align: center;">
            <div id="replies"></div>
          </div>
        </th>
      </tr>
    </tbody>
  </table>

   <script type="text/javascript">
   $(document)
   .ready(
       function() {
         var qnaID = $('#qnaID').val(); // 게시판 번호 값
         getAllReplies(); // 메소드 호출
         // 댓글 입력 기능
         $('#btn_add').click(function() {
                  var replyCONTENT = $('#replyCONTENT').val(); // 댓글 내용
                  var replyWRITER = $('#replyWRITER').val(); // 댓글 아이디
                  var obj = {
                    'qnaID' : qnaID,
                    'replyCONTENT' : replyCONTENT,
                    'replyWRITER' : replyWRITER
                  };
                  console.log(obj);
                  
                  // $.ajax로 송신
                  $.ajax({
                    type : 'post',
                    url : 'replies',
                    headers : {
                      'Content-Type' : 'application/json',
                      'X-HTTP-Method-Override' : 'POST'
                    },
                    data : JSON.stringify(obj),
                    success : function(result, status) {
                      console.log(result);
                      console.log(status);
                      if(result == 1) {
                        alert('댓글 입력 성공');
                        getAllReplies();
                        $('#replyCONTENT').val('');
                        $('#replyWRITER').val('');
                      }
                    } // end success
                  }); // end ajax()
                }); // end btn_add()
                
                // 게시판의 댓글 전체 가져오기
                function getAllReplies() {
                  var url = 'replies/all/' + qnaID;
                  $
                      .getJSON(
                          url,
                          function(jsonData) {
                            console.log(jsonData);
                            var list = ''; // JSON 데이터를 표현할 변수
                            $(jsonData)
                                .each(
                                    function() { // jsonData를 사용하는 each 반복문
                                      var replyCDATE = new Date(this.replyCDATE);
                                      var writer = $('#replyWRITER').val();
                                      // this : jsonData
                                      console.log(this.replyWRITER);
                                      var disabled = '';
                                      if (writer == this.replyWRITER) {
                                        disabled = '';
                                      }
                                      list += '<div class="reply_item">'
                                          + '<pre>'
                                          + '<input type="hidden" id="replyID" value="' + this.replyID + '" />'
                                          + '<input type="hidden" id="replyWRITER" value="' + this.replyWRITER + '" />'
                                          + '&nbsp;&nbsp;&nbsp;&nbsp;' // 공백
                                          + '<input type="hidden" id="replyCONTENT" value="' + this.replyCONTENT + '" />'
                                          + this.replyCONTENT
                                          + '&nbsp;&nbsp&nbsp;&nbsp;' // 공백
                                          + replyCDATE
                                          + '&nbsp;&nbsp;' // 공백
                                          + '</pre>' + '</div>';
                                    }); // end each()
                            $('#replies').html(list);
                          } // end callback()
                      ); // end getJSON()
                } // end getAllReplies()
                
                // 수정 버튼을 클릭하면 선택된 댓글 수정
                $('#replies')
                    .on(
                        'click',
                        '.reply_item .btn_update',
                        function() {
                          console.log(this);

                          // 선택된 댓글 replyID, replyCONTENT 값을 저장
                          var replyID = $(this).prevAll('#replyID').val();
                          var replyCONTENT = $(this).prevAll('#replyCONTENT')
                              .val();
                          console.log("선택된 댓글 번호 : " + replyID + ", 댓글 내용 : "
                              + replyCONTENT);

                          // ajax 요청
                          $.ajax({
                            type : 'put',
                            url : 'replies/' + replyNo,
                            headers : {
                              'Content-Type' : 'application/json',
                              'X-HTTP-Method-Override' : 'PUT'
                            },
                            data : JSON.stringify({
                              'qnaID' : qnaID,
                              'replyCONTENT' : replyCONTENT
                            }),
                            success : function(result) {
                              if (result == 'success') {
                                alert('댓글 수정성공');

                                getAllReplies();
                              }
                            } // end success
                          }); // end ajax()
                        }); // end btn_update()
                        
                // 삭제 버튼을 클릭하면 선택된 댓글 삭제
                $('#replies').on('click', '.reply_item .btn_delete',
                    function() {
                      console.log(this);

                      // 선택된 댓글 replyID
                      var replyID = $(this).prevAll('#replyID').val();
                      console.log("선택된 댓글 번호 : " + replyID);

                      // ajax 요청
                      $.ajax({
                        type : 'delete',
                        url : 'replies/' + replyID,
                        headers : {
                          'Content-Type' : 'application/json',
                          'X-HTTP-Method-Override' : 'DELETE'
                        },
                        data : JSON.stringify({
                          'qnaID' : qnaID
                        }),
                        success : function(result) {
                          if (result == 'success') {
                            alert('댓글 삭제성공');

                            getAllReplies();
                          }
                        } // end success
                      }); // end ajax()
                    }); // end btn_update()
              }); // end ready()
                        
    </script>

</body>
</html>