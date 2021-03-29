<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;" charset="UTF-8">
<!-- 반응형 웹베이지 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>seller 회원가입</title>
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

aside {
  float: left;
  width: 200px;
}

div#container_box {
  float: right;
  width: calc(100% - 200px - 20px);
}

aside ul li {
  text-align: center;
  margin-bottom: 10px;
}

aside ul li a {
  display: block;
  width: 100%;
  padding: 10px 0;
}

aside ul li a:hover {
  background: #eee;
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

</head>

<body>
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
      <div id="container_box">
        <div class="container">
          <form action="product_register" method="post" role="form" autocomplete="off" enctype="multipart/form-data">
            <table class="table table-bordered table-hover" style="text-align: center; border: 1px solid #dddddd">
              <thead>
                <tr>
                  <th colspan="2"><h4>상품등록</h4></th>
                </tr>
              </thead>
              <tbody>
                <c:if test="${seller != null }">
                  <tr>
                    <td style="width: 120px;">
                      <h5>판매자 아이디</h5>
                    </td>
                    <td>
                      <input class="form-contorl" type="text" id="sID" name="sID" value=${seller.sID } readonly />
                    </td>
                  </tr>
                </c:if>
                <tr>
                  <td style="width: 120px;">
                    <h5>카테고리 선택</h5>
                  </td>
                  <td>
                    <label>1차분류</label>
                    <select class="category1">
                      <option value="">전체</option>
                    </select>
                    <label>2차분류</label>
                    <select class="category2" id="cateCode" name="cateCode">
                      <option value="">전체</option>
                    </select>
                  </td>
                </tr>
                <tr>
                  <td style="width: 120px;">
                    <h5>상품명</h5>
                  </td>
                  <td>
                    <input class="form-contorl" type="text" id="pNAME" name="pNAME" placeholder="제품명" required />
                  </td>
                </tr>
                <tr>
                  <td style="width: 120px;">
                    <h5>상품가격</h5>
                  </td>
                  <td>
                    <input class="form-contorl" type="number" id="pPRICE" name="pPRICE" placeholder="상품가격" required />
                  </td>
                </tr>
                <tr>
                  <td style="width: 120px;">
                    <h5>할인가격</h5>
                  </td>
                  <td>
                    <input class="form-contorl" type="number" id="pDISCOUNT" name="pDISCOUNT" placeholder="할인가격" required />
                  </td>
                </tr>
                <tr>
                  <td style="width: 120px;">
                    <h5>상품수량</h5>
                  </td>
                  <td>
                    <input class="form-contorl" type="number" id="pSTOCK" name="pSTOCK" placeholder="상품수량" required />
                  </td>
                </tr>
                <tr>
                  <td style="width: 120px;">
                    <h5>상품메인 사진</h5>
                  </td>
                  <td>
                    <input class="form-contorl" type="file" id="pIMG1" name="files" placeholder="상품수량" multiple="multiple" />
                  </td>
                </tr>
                <tr>
                  <td style="width: 120px;">
                    <h5>상품 사진1</h5>
                  </td>
                  <td>
                    <input class="form-contorl" type="file" id="pIMG2" name="files" placeholder="상품수량" multiple="multiple" />
                  </td>
                </tr>
                <tr>
                  <td style="width: 120px;">
                    <h5>상품 사진2</h5>
                  </td>
                  <td>
                    <input class="form-contorl" type="file" id="pIMG3" name="files" placeholder="상품수량" multiple="multiple" />
                  </td>
                </tr>
                <tr>
                  <td style="width: 120px;">
                    <h5>상품상세</h5>
                  </td>
                  <td>
                    <input class="form-contorl" type="file" id="pDETAIL" name="files" placeholder="상품수량" multiple="multiple" />
                  </td>
                </tr>
                <tr>
                  <td style="width: 120px;">
                    <h5>배송</h5>
                  </td>
                  <td>
                    <input class="form-contorl" type="number" id="pDELIVERY" name="pDELIVERY" placeholder="배송" required />
                  </td>
                </tr>

              </tbody>
            </table>
            <table>
              <tr>
                <td style="text-align: center" colspan="2">
                  <input class="btn btn-primary pull-right" type="submit" value="상품등록" />
                </td>
              </tr>
            </table>
          </form>
        </div>
      </div>
    </section>

    <footer id="footer">
      <div id="footer_box">
        <%@ include file="include/footer.jsp"%>
      </div>
    </footer>
  </div>

  <script type="text/javascript">
  // 카테고리 
      // 컨트롤러에서 데이터 받기
      var jsonData = JSON.parse('${category}');
      console.log(jsonData);

      var cate1Arr = new Array();
      var cate1Obj = new Object();

      // 1차 분류 셀렉트 박스에 삽입할 데이터 준비
      for (var i = 0; i < jsonData.length; i++) {

        if (jsonData[i].level == "1") {
          cate1Obj = new Object(); //초기화
          cate1Obj.cateCode = jsonData[i].cateCode;
          cate1Obj.cateName = jsonData[i].cateName;
          cate1Arr.push(cate1Obj);
        }
      }

      // 1차 분류 셀렉트 박스에 데이터 삽입
      var cate1Select = $("select.category1")

      for (var i = 0; i < cate1Arr.length; i++) {
        cate1Select.append("<option value='" + cate1Arr[i].cateCode + "'>"
            + cate1Arr[i].cateName + "</option>");
      }

      $(document)
          .on(
              "change",
              "select.category1",
              function() {

                var cate2Arr = new Array();
                var cate2Obj = new Object();

                // 2차 분류 셀렉트 박스에 삽입할 데이터 준비
                for (var i = 0; i < jsonData.length; i++) {

                  if (jsonData[i].level == "2") {
                    cate2Obj = new Object(); //초기화
                    cate2Obj.cateCode = jsonData[i].cateCode;
                    cate2Obj.cateName = jsonData[i].cateName;
                    cate2Obj.cateCodeRef = jsonData[i].cateCodeRef;

                    cate2Arr.push(cate2Obj);
                  }
                }

                var cate2Select = $("select.category2");

                /*
                for(var i = 0; i < cate2Arr.length; i++) {
                  cate2Select.append("<option value='" + cate2Arr[i].cateCode + "'>"
                       + cate2Arr[i].cateName + "</option>");
                }
                 */

                cate2Select.children().remove();

                $("option:selected", this)
                    .each(
                        function() {

                          var selectVal = $(this).val();
                          cate2Select.append("<option value='" + selectVal +"'>전체</option>");

                          for (var i = 0; i < cate2Arr.length; i++) {
                            if (selectVal == cate2Arr[i].cateCodeRef) {
                              cate2Select
                                  .append("<option value='" + cate2Arr[i].cateCode + "'>"
                                      + cate2Arr[i].cateName + "</option>");
                            }
                          }

                        });

              });
    </script>

</body>
</html>