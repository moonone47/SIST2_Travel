<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lnag="ko">
<head>
    <meta charset="UTF-8">
    <title>네이버 : 회원가입</title>
    <%@ include file="/inc/asset.jsp" %>
    <!-- <link rel="stylesheet" href="/SIST2_Travel/login/new_main.css"> -->
</head>
<style>
	#content > form > div {
		margin-bottom: 20px; 
	}
</style>
<body>
<%@ include file="/inc/header.jsp" %>
<!-- header -->

<div id="header">
    <a href="https://nid.naver.com/user2/V2Join.nhn?m=agree#agreeBottom" target="_blank" title="네이버 회원가입 페이지 보러가기"><!-- <img
            src="/SIST2_Travel/asset/images/NAVER_CI_Green.png" id="logo"> --></a>
</div>


<!-- wrapper -->
<div id="wrapper">

    <!-- content-->
    <div id="content">
        <form method="POST" action="/SIST2_Travel/login/signupok.do">
            <!-- ID -->
            <div class="contents">
                <h3 class="join_title">
                    <label for="id">아이디</label>
                </h3>
                <span class="box int_id">
                        <input type="text" id="id" name="id" class="int" maxlength="20">
                        <span class="step_url">아이디를 입력하세요</span>
                    </span>
                <span class="error_next_box"></span>
                <span ><button type="button" class="btn btn-primary" id="idcheck">아이디 중복 검사</button></span>
            </div>

            <!-- PW1 -->
            <div class="contents">
                <h3 class="join_title"><label for="pswd1">비밀번호</label></h3>
                <span class="box int_pass">
                        <input type="text" id="pswd1" name="pw" class="int" maxlength="20">
                        <span class="step_url">비밀번호를 입력하세요</span>
                        <span id="alertTxt">사용불가</span>
                        <img src="/SIST2_Travel/asset/images/m_icon_pass.png" id="pswd1_img1" class="pswdImg">
                    </span>
                <span class="error_next_box"></span>
            </div>

            <!-- PW2 -->
            <div class="contents">
                <h3 class="join_title"><label for="pswd2">비밀번호 재확인</label></h3>
                <span class="box int_pass_check">
                        <input type="text" id="pswd2" class="int" maxlength="20">
                        <img src="/SIST2_Travel/asset/images/m_icon_check_disable.png" id="pswd2_img1" class="pswdImg">
                    </span>
                <span class="error_next_box"></span>
            </div>

            <!-- NAME -->
            <div class="contents">
                <h3 class="join_title"><label for="name">이름</label></h3>
                <span class="box int_name">
                        <input type="text" id="name" name="name" class="int" maxlength="20">
                    </span>
                <span class="error_next_box"></span>
            </div>
            <!-- NAME -->
            <div class="contents">
                <h3 class="join_title"><label for="nick">별명</label></h3>
                <span class="box int_name">
                        <input type="text" id="nick" name="nick" class="int" maxlength="20">
                    </span>
                <span class="error_next_box"></span>
            </div>

            <!-- BIRTH -->
            <div class="contents">
                <h3 class="join_title"><label for="yy">생년월일</label></h3>

                <div id="bir_wrap">
                    <!-- BIRTH_YY -->
                    <div id="bir_yy">
                            <span class="box">
                                <input type="text" id="yy" name="yy" class="int" maxlength="4" placeholder="년(4글자)">
                            </span>
                    </div>

                    <!-- BIRTH_MM -->
                    <div id="bir_mm">
                            <span class="box">
                                <select id="mm" class="sel" name="mm">
                                    <option>월</option>
                                    <option value="01">1</option>
                                    <option value="02">2</option>
                                    <option value="03">3</option>
                                    <option value="04">4</option>
                                    <option value="05">5</option>
                                    <option value="06">6</option>
                                    <option value="07">7</option>
                                    <option value="08">8</option>
                                    <option value="09">9</option>                                    
                                    <option value="10">10</option>
                                    <option value="11">11</option>
                                    <option value="12">12</option>
                                </select>
                            </span>
                    </div>

                    <!-- BIRTH_DD -->
                    <div id="bir_dd">
                            <span class="box">
                                <input type="text" id="dd" name="dd" class="int" maxlength="2" placeholder="일">
                            </span>
                    </div>

                </div>
                <span class="error_next_box"></span>
            </div>

            <!-- GENDER -->
            <div class="contents">
                <h3 class="join_title"><label for="gender">성별</label></h3>
                <span class="box">
                        <select id="gender" class="sel" name="gender">
                            <option>성별</option>
                            <option value="m">남자</option>
                            <option value="f">여자</option>
                        </select>                            
                    </span>
                <span class="error_next_box">필수 정보입니다.</span>
            </div>

            <!-- EMAIL -->
            <div class="contents">
                <h3 class="join_title"><label for="email">본인확인 이메일<span class="optional"></span></label></h3>
                <span class="box int_email">
                        <input type="text" id="email" name="email" class="int" maxlength="100" placeholder="">
                    </span>
                <span class="error_next_box">이메일 주소를 다시 확인해주세요.</span>
            </div>

            <!-- MOBILE -->
            <div class="contents">
                <h3 class="join_title"><label for="phoneNo">휴대전화</label></h3>
                <span class="box int_mobile">
                        <input type="tel" id="mobile" class="int" name="phone" maxlength="16"
                               placeholder="하이픈(-)을 뺀 휴대전화 번호">
                    </span>
                <span class="error_next_box"></span>
            </div>


            <%-- 우편번호 --%>
            <div class="contents">

                <input type="text" id="sample3_postcode" name="zip" placeholder="우편번호" class="intxx">
                <input type="button" onclick="sample3_execDaumPostcode()" value="우편번호 찾기" class="intxx"><br>
                <input type="text" id="sample3_address" name="add1" placeholder="주소" class="intxx"><br>
                <input type="text" id="sample3_detailAddress" name="add2" placeholder="상세주소" class="intxx">
                <input type="text" id="sample3_extraAddress" name="add3" placeholder="참고항목" class="intxx">

                <div id="wrap"
                     style="display:none;border:1px solid;width:500px;height:300px;margin:5px 0;position:relative">
                    <img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnFoldWrap"
                         style="cursor:pointer;position:absolute;right:0px;top:-1px;z-index:1"
                         onclick="foldDaumPostcode()" alt="접기 버튼">
                </div>
            </div>


            <!-- JOIN BTN-->
            <div class="btn_area">
                <button type="submit" id="btnJoin">
                    <span>가입하기</span>
                </button>
            </div>


        </form>
    </div>
    <!-- content-->

</div>

<!-- wrapper -->
<%@ include file="/inc/footer.jsp" %>
<script src="/SIST2_Travel/asset/js/main.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script language="JavaScript">
    $( document ).ready( function() {
    function checkJoinForm() {
        $("#idcheck").click(function () {
            alert('hi');
            var list = new Array();
            <c:forEach items="${dto}" var="user">
            list.push("${user}");
            </c:forEach>

            for (var i = 0; i < list.length; i++) {
                console.log($("#id").val());
                if ($("#id").val.equals(list[i])) {
                    alert("이미 가입된 아이디입니다.");
                    $("#id").focus();
                    return false;
                }
            }
        });
    }
    }
</script>
<script>
    // 우편번호 찾기 찾기 화면을 넣을 element
    var element_wrap = document.getElementById('wrap');

    function foldDaumPostcode() {
        // iframe을 넣은 element를 안보이게 한다.
        element_wrap.style.display = 'none';
    }

    function sample3_execDaumPostcode() {
        // 현재 scroll 위치를 저장해놓는다.
        var currentScroll = Math.max(document.body.scrollTop, document.documentElement.scrollTop);
        new daum.Postcode({
            oncomplete: function (data) {
                // 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if (data.userSelectedType === 'R') {
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if (data.buildingName !== '' && data.apartment === 'Y') {
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if (extraAddr !== '') {
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample3_extraAddress").value = extraAddr;

                } else {
                    document.getElementById("sample3_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample3_postcode').value = data.zonecode;
                document.getElementById("sample3_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample3_detailAddress").focus();

                // iframe을 넣은 element를 안보이게 한다.
                // (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
                element_wrap.style.display = 'none';

                // 우편번호 찾기 화면이 보이기 이전으로 scroll 위치를 되돌린다.
                document.body.scrollTop = currentScroll;
            },
            // 우편번호 찾기 화면 크기가 조정되었을때 실행할 코드를 작성하는 부분. iframe을 넣은 element의 높이값을 조정한다.
            onresize: function (size) {
                element_wrap.style.height = size.height + 'px';
            },
            width: '100%',
            height: '100%'
        }).embed(element_wrap);

        // iframe을 넣은 element를 보이게 한다.
        element_wrap.style.display = 'block';
    }
</script>
</body>
</html>