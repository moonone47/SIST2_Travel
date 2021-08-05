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
            <form action="#" class="searchform order-lg-last">
                <div class="form-group d-flex">
                    <input type="text" class="form-control pl-3" placeholder="Search">
                    <button type="submit" placeholder="도시/장소를 찾아보세요." class="form-control search">
                        <span class="fa fa-search"></span>
                    </button>
                </div>
            </form>
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
                            <a class="dropdown-item" href="#">투어/입장권</a>
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
                    
                    <li class="nav-item"><a href="#" class="nav-link">관리자</a></li>
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

                    <c:if test="${empty id}">
	                    <button type="button" class="btn btn-warning form-control"
	                            onclick="location.href='/SIST2_Travel/login/login.do';">로그인
	                    </button>
	                    <button type="button" class="btn btn-primary form-control"
	                            onclick="location.href='/SIST2_Travel/login/signup.do';">회원가입
	                    </button>
                    </c:if>

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

</section>
<%@ include file="/inc/init.jsp" %>
</div>
<script src="<%=request.getContextPath()%>/asset/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/asset/js/popper.js"></script>
<script src="<%=request.getContextPath()%>/asset/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/asset/js/main.js"></script>
</body>
</html>

