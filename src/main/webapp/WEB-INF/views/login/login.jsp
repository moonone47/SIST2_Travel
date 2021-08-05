<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>

    <%@ include file="/inc/asset.jsp" %>
    <!-- <script src="/SIST2_Travel/jsp/js/cookie.js"></script> 쿠키파일 경로 맞추기  -->
    <style>
    
    	.btn_login {
    		margin-top: 20px;
    		margin-bottom: 20px;
    		background-color: #529AD9;
    		color: white;
    		border-color: #529AD9;
    		width: 420px;
    	}
    
    	.login_menu {
    		margin-top: 10px;
    	}
    	
    	#input_id {
    		margin-bottom: 2px; 
    	}
    	
    	#content {
    		border: 1px solid #CCC;
    		padding: 20px 20px;
    		border-radius: 4%;
    	}
    
    
    </style>
</head>
<body>
<!-- login.jsp  -->
<header>
    <div id="header">
        <div id="logo">
            <a href="/SIST2_Travel/index.do">로고 이미지 넣기 <img src=""
                                                            id="logoImg">
            </a>
        </div>
    </div>
</header>

<section>
    <div id="content">
        <form method="POST" action="/SIST2_Travel/login/loginok.do"
              onsubmit="return checkForm();">

            <div class="input" id="input_id">
					<span class="input_box"> <input name="ide" class="int"
                                                    id="ide" type="text" maxlength="41" placeholder="아이디">
					</span>
            </div>

            <div class="input" id="input_pw">
					<span class="input_box"> <input name="pw" class="int"
                                                    id="pw" type="password" maxlength="41" placeholder="비밀번호">
					</span>
            </div>

            <input title="로그인" class="btn_login" id="login" type="submit"
                   value="로그인"> <span id="loginTxt"></span>
            <div class="autologin">
                <label> <input name="cbid" id="cbid" type="checkbox">
                    아이디 저장
                </label>
            </div>

            <span id="autoTxt"></span>
            <div class="login_menu">
                <a id="idsearch" href="/SIST2_Travel/login/findpw.do" target="_self">아이디
                    찾기</a> <span class="bar">|</span> <a id="pwsearch"
                                                         href="/SIST2_Travel/login/findid.do" target="_self">비밀번호
				찾기</a> <span
                    class="bar">|</span> <a id="join" href="/SIST2_Travel/login/signup.do"
                                            target="_self">회원가입</a>
            </div>
            <input type="hidden" id="autoId" name="autoId" value="0">

        </form>
    </div>

</section>


<script>
    $("#ide").focus();

    function checkForm() {
        if ($("#ide").val() == "" || $("#pw").val() == "") {
            /* $("#loginTxt").css("color", "tomato");
            $("#loginTxt").text("아이디와 비밀번호를 모두 입력해주세요."); */
            alert("아이디와 비밀번호를 모두 입력해주세요.");
        }
    };

    $('#login').click(function () {

        if ($('#cbid').prop('checked')) {
            setCookie('id', $("#ide").val(), 365);
        } else {
            /* setCookie('id','',-1); */
        }
        this.form.submit();
    });


    if (getCookie("id") != "") {
        $("#ide").val(getCookie("id")); //아이디 기억하기
        $("#pw").focus();
        $("#cbid").prop("checked", ture);
    } else {
        $("#ide").focus();
    }

    /* 	if(getCookie('cb') != null && getCookie('cb') != '' ){
            $('#cbid').prop('checked',true);

        } */
</script>
</body>
</html>











