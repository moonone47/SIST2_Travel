<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>여행 병아리들을 위한 여행계획사이트 티피~~</title>

<%@ include file="/inc/asset.jsp" %>

  <style>
    body{
      border: 0;
      font: inherit;
      line-height: 1;
      margin: 0;
      padding: 0;
      width: 100%;
      height: 100%;
      font-size: 12px;
      font-family: nanum;
    }
    form {
      outline: 0;
      float: left;
      -webkit-box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
      box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
      -webkit-border-radius: 4px;
      border-radius: 4px;
    }

    form > .textbox {
      outline: 0;
      height: 42px;
      width: 244px;
      line-height: 42px;
      padding: 0 16px;
      background-color: rgba(255, 255, 255, 0.8);
      color: #212121;
      border: 0;
      float: left;
      -webkit-border-radius: 4px 0 0 4px;
      border-radius: 4px 0 0 4px;
    }

    form > .textbox:focus {
      outline: 0;
      background-color: #FFF;
    }

    form > .button {
      outline: 0;
      background: none;
      background-color: rgba(38, 50, 56, 0.8);
      float: left;
      height: 42px;
      width: 42px;
      text-align: center;
      line-height: 42px;
      border: 0;
      color: #FFF;
      font: normal normal normal 14px/1 FontAwesome;
      font-size: 16px;
      text-rendering: auto;
      text-shadow: 0 1px 1px rgba(0, 0, 0, 0.2);
      -webkit-transition: background-color .4s ease;
      transition: background-color .4s ease;
      -webkit-border-radius: 0 4px 4px 0;
      border-radius: 0 4px 4px 0;
    }

    form > .button:hover {
      background-color: rgba(0, 150, 136, 0.8);
    }

    .con1{
      margin: 0;
      padding: 0;
      border: 0;
      font-size: 100%;
      font: inherit;
      box-sizing: border-box;
      height: 454px;
      /*background: url('/res/img/main/key_bg_1.jpg') no-repeat;*/
      background-size: cover;
    }
    .con1-title{
      margin: 0;
      padding: 0;
      border: 0;
      font: inherit;
      box-sizing: border-box;
      /*color: white;*/
      font-size: 44px;
      font-weight: bold;
      text-align: center;
      padding-top: 75px;
    }

    .cont1-desc{
      margin: 0;
      padding: 0;
      border: 0;
      font: inherit;
      box-sizing: border-box;
      text-align: center;
      padding-top: 20px;
      font-size: 24px;
      /*color: white;*/
      font-weight: bold;
    }

    .search_area{
      border: 0;
      font-size: 100%;
      font: inherit;
      box-sizing: border-box;
      width: 640px;
      height: 138px;
      border-radius: 3px;
      /*background: url('/res/img/component/bg/bgb_60.png') repeat;*/
      margin: 0 auto;
      margin-top: 60px;
      padding: 20px;
      position: relative;
    }

    .search_input{
      font-family: '나눔바른고딕',NanumBarunGothic,'nanum','돋움',Dotum,'맑은고딕','Malgun Gothic','굴림',Gulim,Helvetica,sans-serif;
      box-sizing: border-box;
      width: 100%;
      height: 50px;
      padding-left: 15px;
      border: none;
      font-size: 20px;
      color: #b3b3b3;
      /*background: url('/res/img/area/area_search_ico.gif') no-repeat white;*/
      background-position: center right;
      margin-bottom: 10px;
    }

    .logged_box{
      margin: 0;
      padding: 0;
      border: 0;
      font-size: 100%;
      font: inherit;
      box-sizing: border-box;
      width: 100%;
      background: #f6f6f6;
      border-top: 1px solid #e4e4e4;
      border-bottom: 1px solid #e4e4e4;
      padding-top: 10px;
      padding-bottom: 10px;
    }

    .logged_user_img{
      margin: 0;
      padding: 0;
      border: 0;
      font-size: 100%;
      font: inherit;
      float: left;
      width: 70px;
      height: 70px;
      border-radius: 50%;
      margin-top: 7px;
    }
    .logged_left{
      margin: 0;
      padding: 0;
      border: 0;
      font-size: 100%;
      font: inherit;
      box-sizing: border-box;
      float: left;
      width: 720px;
      height: 100%;
      margin-left: 15px;
    }

    .logged_name{
      margin: 0;
      padding: 0;
      border: 0;
      font: inherit;
      box-sizing: border-box;
      font-size: 16px;
      color: #555555;
      font-weight: bold;
      margin-top: 10px;
      margin-bottom: 12px;
    }

    .clear{
      margin: 0;
      padding: 0;
      border: 0;
      font-size: 100%;
      font: inherit;
      box-sizing: border-box;
      clear: both;
    }

    .logged_cnt_box{
      margin: 0;
      padding: 0;
      border: 0;
      font-size: 100%;
      font: inherit;
      text-decoration: none;
      box-sizing: border-box;
      display: block;
      float: left;
      text-align: center;
      min-width: 46px;
    }

    .logged_line{
      margin: 0;
      padding: 0;
      border: 0;
      font-size: 100%;
      font: inherit;
      text-decoration: none;
      box-sizing: border-box;
      display: block;
      float: left;
      text-align: center;
      min-width: 46px;
    }

    .logged_btn_box{
      margin: 0;
      padding: 0;
      border: 0;
      font-size: 100%;
      font: inherit;
      text-decoration: none;
      box-sizing: border-box;
    }

    .logged_btn{
      margin: 0;
      padding: 0;
      border: 0;
      font: inherit;
      box-sizing: border-box;
      float: right;
      text-align: center;
      display: inline-block;
      color: #808080;
      font-size: 13px;
      margin-left: 10px;
      margin-right: 10px;
    }

    .logged_btn_ico{
      text-align: center;
      color: #808080;
      padding: 0;
      border: 0;
      font-size: 100%;
      font: inherit;
      box-sizing: border-box;
      width: 60px;
      height: 60px;
      border-radius: 50%;
      background: #b3b3b3;
      margin: 0 auto;
      margin-bottom: 10px;
    }

    body > div.page.silver.logged_box > div > a > div > div > img{
      text-align: center;
      color: #808080;
      margin: 0;
      padding: 0;
      border: 0;
      font-size: 100%;
      font: inherit;
    }
    body > section.main-section > div.page.silver.logged_box > div > a > div > div > img{
      padding-top: 8px;
    }

    .recruiting_advertisers{
      text-align: center;
      margin-bottom: 100px;
    }

  </style>

</head>
<body>
<!-- template.jsp -->
<%@ include file="/inc/header.jsp" %>

<section class="main-section">
  <div class="con1">
    <div class="con1-title">나만의 여행 플래너 TP!</div>
    <div class="cont1-desc">쉽고 빠르게 여행을 계획하세요.</div>
    <div class="search_area">
      <input class="search_input" id="city_search" placeholder="국가명, 도시명으로 검색">
      <div id="city_autocomplete"></div>
      <div class="latest_search">
        최근검색 :
      </div>
      <a class="go_map" >지도에서 검색 &gt;</a>
      <div class="clear"></div>
    </div>
  </div>
  <div class="page silver logged_box">
    <div class="wrap logged">
      <img class="logged_user_img" src="https://image.flaticon.com/icons/png/128/1946/1946429.png" >
      <div class="logged_left">
        <div class="logged_name">
          김미르			</div>
        <div class="clear"></div>
        <a href="/ko/mypage/et_2108040709420991881001628071782?type=clipboard" class="logged_cnt_box logged_clip">
          <b>클립보드</b>
          <span>0</span>
        </a>
        <div class="logged_line">&nbsp;</div>
        <a href="/ko/mypage/et_2108040709420991881001628071782?type=plan" class="logged_cnt_box logged_plan">
          <b>여행일정</b>
          <span>0</span>
        </a>
        <div class="logged_line">&nbsp;</div>
        <a href="/ko/mypage/et_2108040709420991881001628071782?type=review" class="logged_cnt_box logged_review">
          <b>리뷰</b>
          <span>0</span>
        </a>
        <div class="logged_line">&nbsp;</div>
        <a href="/ko/mypage/et_2108040709420991881001628071782?type=my_qa" class="logged_cnt_box logged_qa">
          <b>Q&amp;A</b>
          <span>0</span>
        </a>
        <div class="clear"></div>
      </div>
      <a  class="logged_btn_box">
        <div class="logged_btn">
          <div class="logged_btn_ico">
            <img src="https://image.flaticon.com/icons/png/128/1545/1545615.png" width="45px" alt="">
          </div>
          질문하기			</div>
      </a>
      <a  class="logged_btn_box">
        <div class="logged_btn">
          <div class="logged_btn_ico">
            <img src="https://image.flaticon.com/icons/png/128/1159/1159633.png" width="45px" alt="">
          </div>
          리뷰쓰기			</div>
      </a>
      <a class="logged_btn_box">
        <div class="logged_btn">
          <div class="logged_btn_ico">
            <img src="https://image.flaticon.com/icons/png/128/747/747310.png" width="45px" alt="">
          </div>
          일정만들기			</div>
      </a>
      <div class="clear"></div>
    </div>
  </div>
  <div class="recruiting_advertisers">
    <img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbFm8C6%2FbtqvJTJ494C%2F1kCwf2kwJeHAhRpZlWXibK%2Fimg.png" width="400px" alt="광고주모집중">
  </div>
  <div
<%--  <c:if test="${not empty id}">--%>
<%--    <div>--%>
<%--      <span><img src="https://www.earthtory.com/res/img/common/mobile/img_profile.png" alt="회원사진"></span>--%>
<%--      <div class="member_name">회원이름</div>--%>
<%--      <table class="table table-bordered">--%>
<%--        <tr>--%>
<%--          <td>클립보드</td>--%>
<%--          <td>여행일정</td>--%>
<%--          <td>리뷰</td>--%>
<%--          <td>Q&A</td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--          <td>0</td>--%>
<%--          <td>3</td>--%>
<%--          <td>1</td>--%>
<%--          <td>2</td>--%>
<%--        </tr>--%>
<%--      </table>--%>
<%--      <div class="make-schedule"><img src="https://www.earthtory.com/res/img/main/ico_plan.png">일정 만들기</div>--%>
<%--    </div>--%>
<%--  </c:if>--%>
<%--이름정하기........................................--%>
<%--zzz--%>
<%--어스토리 마이리얼트립 스투비플래너 클룩 트리플 프립--%>
<%--어스 리얼 플래너--%>
<%--마이트래블플래너--%>
<%--유어리얼트립--%>
<%--  travel plan--%>
<%--  tp--%>
<%--  sist--%>
<%--  SisTravel--%>
<%--  Schedule--%>

<%--트래블러--%>
<%--티피(아귀엽다) > Travel Plan * 여행 병아리들을 위한 여행계획사이트 티피~~--%>
<%--TCP--%>
</section>


<%@ include file="/inc/init.jsp" %>
<%@ include file="/inc/footer.jsp" %>
<script>

</script>
</body>
</html>















