<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <title>여행 병아리들을 위한 여행계획사이트 티피~~</title>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link
            href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700'
            rel='stylesheet' type='text/css'>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet"
          href="<%=request.getContextPath()%>/asset/css/style.css">

<style>
    #ftco-nav > ul > li.nav-item.active > a{
        margin-left: 150px;
    }
    /*body > div:nth-child(8) > section > div:nth-child(1) > div{*/
    /*    background-image: url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRKF8XyvX-leAzEl2t_jCMDPkEAV3z0E_BtXg&usqp=CAU");*/
    /*    background-repeat:no-repeat;*/
    /*    background-size: cover;*/
    /*}*/
    body > div:nth-child(8) > section{
        background-image: url('data:image/jpeg;base64,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');
        background-repeat:no-repeat;
        background-size: 2543px 360px;
    }
    body > div:nth-child(8) > section > div:nth-child(2) > div > div:nth-child(1) > a > span{
        font-color: white;
    }
</style>
	

</head>
<body>
<div>
<div id="mainimg"></div>
<section class="ftco-section">


    <div  class="container">
        <div class="row justify-content-center">
            <div class="col-md-6 text-center mb-5">
                <h2 class="heading-section">TP</h2>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="row justify-content-between">
            <div class="col">
                <a class="navbar-brand" href="/SIST2_Travel/index.do">TP<span>여행
							병아리들을 위한 여행계획사이트 티피</span></a>
            </div>
<!--             <div class="col d-flex justify-content-end">
                <div class="social-media">
                    <p class="mb-0 d-flex">
                        <a href="#"
                           class="d-flex align-items-center justify-content-center"><span
                                class="fa fa-facebook"><i class="sr-only">Facebook</i></span></a> <a
                            href="#"
                            class="d-flex align-items-center justify-content-center"><span
                            class="fa fa-twitter"><i class="sr-only">Twitter</i></span></a> <a
                            href="#"
                            class="d-flex align-items-center justify-content-center"><span
                            class="fa fa-instagram"><i class="sr-only">Instagram</i></span></a>
                        <a href="#"
                           class="d-flex align-items-center justify-content-center"><span
                                class="fa fa-dribbble"><i class="sr-only">Dribbble</i></span></a>
                    </p>
                </div>
            </div> -->
            <div class="col d-flex justify-content-end" style="margin-bottom: 5px;">
                    <c:if test="${empty id}">
	                    <button type="button" class="btn btn-warning form-control" style="width: 90px;"
	                            onclick="location.href='/SIST2_Travel/login/login.do';">로그인
	                    </button>
	                    <button type="button" class="btn btn-primary form-control" style="width:110px;"
	                            onclick="location.href='/SIST2_Travel/login/signup.do';">회원가입
	                    </button>
                    </c:if>
             </div>
        </div>
    </div>

    <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light"
            id="ftco-navbar">
            
        <div class="container">
            <button class="navbar-toggler" type="button" data-toggle="collapse"
                    data-target="#ftco-nav" aria-controls="ftco-nav"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="fa fa-bars"></span> Menu
            </button>
            <!-- 검색 -->
<%--            <form action="#" class="searchform order-lg-last">--%>
<%--                <div class="form-group d-flex">--%>
<%--                    <input type="text" class="form-control pl-3" placeholder="Search">--%>
<%--                    <button type="submit" placeholder="도시/장소를 찾아보세요." class="form-control search">--%>
<%--                        <span class="fa fa-search"></span>--%>
<%--                    </button>--%>
<%--                </div>--%>
<%--            </form>--%>
            <!-- 메뉴 -->
            <div class="collapse navbar-collapse" id="ftco-nav">
                <ul class="navbar-nav mr-auto">
                
                    <li class="nav-item active"><a href="/SIST2_Travel/index.do" class="nav-link">Home</a></li>
<!--                     <li class="nav-item dropdown"><a
                            class="nav-link dropdown-toggle" href="/SIST2_Travel/plan/plan.do" id="dropdown04"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">일정계획</a>
                        <div class="dropdown-menu" aria-labelledby="dropdown04">
                            <a class="dropdown-item" href="/SIST2_Travel/plan/plan.do">새로운 일정</a>                        
                        </div>
                        </li> -->
                    <li class="nav-item"><a href="/SIST2_Travel/plan/plan.do" class="nav-link">일정계획</a></li>  
                    <li class="nav-item"><a href="/SIST2_Travel/management/travelplan.do" class="nav-link">여행관리</a></li>
                            
                    <li class="nav-item dropdown">
                    	<a class="nav-link dropdown-toggle" href="#" id="dropdown04"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">커뮤니티</a>
                        <div class="dropdown-menu" aria-labelledby="dropdown04">
                            <a class="dropdown-item" href="/SIST2_Travel/community/question/list.do">질문게시판</a> 
                            <a class="dropdown-item" href="/SIST2_Travel/community/freeboard/list.do">자유게시판</a> 
                            <a class="dropdown-item" href="/SIST2_Travel/community/clubboard/list.do">여행소모임게시판</a> 
                            <a class="dropdown-item" href="/SIST2_Travel/community/event/list.do">이벤트게시판</a> 
                            <a class="dropdown-item" href="/SIST2_Travel/community/suggest/list.do">건의게시판</a> 
                            <a class="dropdown-item" href="#">여행후기게시판</a> 
                        </div>
                    </li>
                    
                    <li class="nav-item"><a href="/SIST2_Travel/service/list.do" class="nav-link">서비스</a></li>
                    
                    <li class="nav-item dropdown">
                    	<a class="nav-link dropdown-toggle" href="#" id="dropdown04"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">예약</a>
                        <div class="dropdown-menu" aria-labelledby="dropdown04">
                            <%-- 메뉴만 만들어 놓죠ㅎㅅㅎ  넵 ^.^--%>
                            <a class="dropdown-item" href="#">항공권</a> 
                            <a class="dropdown-item" href="#">숙소</a> 
                            <a class="dropdown-item" href="/SIST2_Travel/tour/tour.do">투어</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="dropdown04_"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">검색</a>
                        <div class="dropdown-menu" aria-labelledby="dropdown04">
                            <%-- 메뉴만 만들어 놓죠ㅎㅅㅎ  넵 ^.^--%>
                            <a class="dropdown-item" href="/SIST2_Travel/search/weather.do">날씨 검색</a>
                            <a class="dropdown-item" href="/SIST2_Travel/search/keyword.do">키워드 검색</a>
                        </div>
                    </li>

                    <li class="nav-item dropdown">
                    	<a class="nav-link dropdown-toggle" href="#" id="dropdown04"
                                      data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">마이페이지</a>
                        <div class="dropdown-menu" aria-labelledby="dropdown04">
                            <a class="dropdown-item" href="/SIST2_Travel/mypage/profile.do">개인정보 조회</a>
                            <a class="dropdown-item" href="/SIST2_Travel/mypage/travelplan.do">내 여행 일정 조회</a>
                            <a class="dropdown-item" href="/SIST2_Travel/mypage/basket.do">장바구니</a>
                            <a class="dropdown-item" href="/SIST2_Travel/mypage/rev.do">결제 및 예약 내역</a>
                        </div>
                    </li>

<%--                    관리자는 삭제..--%>
                    <li class="nav-item"><a href="#" class="nav-link"></a></li>
<%--                    <c:if test="${not empty id }">--%>
<%--                        <div style="color: white;">이름 : ${name }(id : ${id})</div>--%>

<%--                        <div class="btn-auth"--%>
<%--                             onclick="location.href='/SIST2_Travel/login/logout.do';"--%>
<%--                             title="로그아웃" style="color: white; cursor: pointer;">Logout--%>
<%--                        </div>--%>
<%--                    </c:if>--%>
<%--                    <c:if test="${empty id }">--%>
<%--                        <div class="btn-auth"--%>
<%--                             onclick="location.href='/SIST2_Travel/login/login.do';"--%>
<%--                             title="로그인" style="color: white; cursor: pointer;">Login--%>
<%--                        </div>--%>
<%--                    </c:if>--%>

<%--                     <c:if test="${empty id}">
	                    <button type="button" class="btn btn-warning form-control"
	                            onclick="location.href='/SIST2_Travel/login/login.do';">로그인
	                    </button>
	                    <button type="button" class="btn btn-primary form-control"
	                            onclick="location.href='/SIST2_Travel/login/signup.do';">회원가입
	                    </button>
                    </c:if> --%>

                    <c:if test="${not empty id}">
                        <li class="nav-item dropdown">
                            <img src="https://www.earthtory.com/res/img/common/mobile/img_profile.png" style="width:50px;">
<%--                            <a class="nav-link dropdown-toggle" href="#" id="mypage"--%>
<%--                                                         data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">마이페이지</a>--%>
                            <div class="dropdown-menu" aria-labelledby="dropdown04">
                                <a class="dropdown-item" href="/SIST2_Travel/mypage/profile.do">개인정보 조회</a>
                                <a class="dropdown-item" href="/SIST2_Travel/mypage/travelplan.do">내 여행 일정 조회</a>
                                <a class="dropdown-item" href="/SIST2_Travel/mypage/basket.do">장바구니</a>
                                <a class="dropdown-item" href="/SIST2_Travel/mypage/pay.do">결제내역</a>
                                <a class="dropdown-item" href="/SIST2_Travel/mypage/rev.do">예약 내역</a>
                                <a class="dropdown-item" href="/SIST2_Travel/login/logout.do">로그아웃</a>
                            </div>
                        </li>
                    </c:if>


                </ul>
            </div>
        </div>


    </nav>
    <!-- END nav -->
    <%@ include file="/inc/init.jsp" %>
</section>
</div>
<script src="<%=request.getContextPath()%>/asset/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/asset/js/popper.js"></script>
<script src="<%=request.getContextPath()%>/asset/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/asset/js/main.js"></script>
</body>
</html>

