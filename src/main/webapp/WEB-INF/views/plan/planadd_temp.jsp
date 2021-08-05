<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
  <%--    <%@ include file="/inc/asset.jsp" %>--%>
  <meta charset="utf-8">
  <title> 플젝 </title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">


  <link href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
  <link rel="stylesheet" href="<%= request.getContextPath() %>/asset/css/plan.css" type="text/css"/>
  <%-- <link rel="stylesheet" href="/SIST2_Travel/asset/css/plan.css" type="text/css"/>--%>

  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

  <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
        integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>

  <%--    <link href="//cdn.jsdelivr.net/gh/gitbrent/bootstrap4-toggle@3.4.0/css/bootstrap4-toggle.min.css" rel="stylesheet">--%>
  <%--    <script src="//cdn.jsdelivr.net/gh/gitbrent/bootstrap4-toggle@3.4.0/js/bootstrap4-toggle.min.js"></script>--%>
  <%--    <link rel="stylesheet" href="//unpkg.com/bootstrap@4/dist/css/bootstrap.min.css">--%>
  <style>
    #xdetail2 {
      position: absolute;
      left: 1500px;
      top: 40px;
      z-index: 2000;
      font-size: 50px;
    }

    #xdetail {
      position: absolute;
      left: 520px;
      top: 12px;
      z-index: 2000;
      font-size: 12px;
    }

    /*  #menu_wrap {
         margin: 0;
         padding: 0;
         border: 0;
         font-size: 100%;
         font: inherit;
         box-sizing: border-box;
         width: 325px;
         z-index: 999;
         position: absolute;
         left: 700px;
         height: 1145px;
         background: #fff;
     } */
    #menu_wrap {
      margin: 0;
      padding: 0;
      border: 0;
      font-size: 100%;
      font: inherit;
      box-sizing: border-box;
      width: 325px;
      z-index: 999;
      position: absolute;
      left: 600px;
      height: 1137px;
      top: 5px;
      background: #fff;
      -ms-overflow-style: none;
    }

    #menu_wrap::-webkit-scrollbar {
      display: none;
    }

    .city_name {
      margin-left: 3px;
      padding: 0;
      border: 0;
      font: inherit;
      box-sizing: border-box;
      width: 300px;
      height: 50px;
      background: #1a7ad9;
      line-height: 50px;
      color: #fff;
      padding-left: 10px;
      font-size: 15px;
      font-weight: bold;
    }

    .search {
      box-sizing: border-box;
      width: 300px;
      height: 31px;
      border: solid #c8c8ca 1px;
      padding-left: 5px;
      font-family: 'nanum';
      /*background: url('/res/img/common/gnb/search_icon.png') no-repeat;*/
      /*background-position: 300px 4px;*/
    }

    #category {
      background: #f7f7f7;
      display: flex;
      margin-left: 5px;
    }

    #category li {
      width: 100%;
      text-align: center;
    }

    #placesList > li > span {
      cursor: pointer;
      margin: 0;
      padding: 0;
      border: 0;
      font-size: 100%;
      font: inherit;
      width: 82px;
      height: 75px;
    }

    #keyword {
      box-sizing: border-box;
      width: 300px;
      height: 31px;
      border: solid #c8c8ca 1px;
      padding-left: 5px;
      font-family: 'nanum';
      /*background: url('/res/img/common/gnb/search_icon.png') no-repeat;*/
      /*background-position: 300px 4px;*/
    }

    /*#placesList > .item > .info{*/
    /*    font-size: 20px;*/
    /*}*/
    #button-addon1 {
      box-sizing: border-box;
      margin: 0;
      font-family: inherit;
      overflow: visible;
      text-transform: none;
      -webkit-appearance: button;
      display: inline-block;
      text-align: center;
      vertical-align: middle;
      user-select: none;
      background-color: transparent;
      border: 1px solid transparent;
      padding: .375rem .75rem;
      font-size: 1rem;
      line-height: 1.5;
      border-radius: .25rem;
      transition: color .15s ease-in-out, background-color .15s ease-in-out, border-color .15s ease-in-out, box-shadow .15s ease-in-out;
      font-weight: 400;
      text-decoration: none;
      color: #007bff !important;
      position: relative;
      z-index: 2;
      cursor: pointer;
      border-top-left-radius: 0;
      border-bottom-left-radius: 0;
      left: 262px;
      top: -37px;
      width: 35px;
    }

    #category li {
      font-size: 16px;
      font-weight: bold;
    }


    #schedule > form > a {
      background-color: #203341;
      border-color: #4383D9;
      margin-bottom: 20px;
    }

    .list-group-item {
      /* background-color: #A2D4F2; */
      background-color: #fff;
    }

    .btn-primary {
      position: relative;
      color: #fff;
      background-color: #529AD9;
      border-color: #fff;
      z-index: 2;
      margin: 0px 0px;
      width: 100%;
    }

    #planlist {
      position: absolute;
      top: 0px;
      left: 300px;
      bottom: 0;
      width: 300px;
      height: auto;
      margin: 10px 0 30px 10px;
      padding: 7px;
      overflow-y: auto;
      background: white;
      z-index: 1;
      font-size: 12px;
      /* border: 1px solid red; */
    }

    #schedule {
      position: absolute;
      top: 0px;
      left: 0px;
      bottom: 0;
      width: 200px;
      height: 1284px;
      margin: 10px 0 30px 10px;
      padding: 5px;
      overflow-y: auto;
      background: rgba(255, 255, 255, 0.7);
      z-index: 1;
      font-size: 13px;

      /* border: 1px solid red; */
    }

    #my_form {
      border: 1px solid #DDD;
      border-radius: 5%;
      color: #black;
      /* list-style: none;
      margin: 0;
      padding: 0;
      border: 0;
      font: inherit;
      box-sizing: border-box;
      width: 100%;
      height: 70px;
      color: #fff;
      text-align: center;
      font-size: 12px;
      cursor: pointer;
      background: #203341;
      border-bottom: solid 1px #1a7ad9; */
    }

    #complete {
      width: 200;
      background-color: #529AD9;
      border-color: #203341;
      margin-bottom: 10px;
    }

    #on_city_close_btn {
      width: 40px;
      height: 40px;
      position: absolute;
      top: 10px;
      right: 10px;
      background: url(/SIST2_Travel/asset/images/city_close_btn.png);
      cursor: pointer;
    }

    #on_city_open_btn {
      width: 40px;
      height: 40px;
      position: absolute;
      top: 10px;
      left: 600px;
      background: url(/SIST2_Travel/asset/images/city_open_btn.png);
      cursor: pointer;
      z-index: 99;
    }

    #detail-box {
      width: 931px;
      height: 1335px;
      position: absolute;
      top: -194px;
      left: 793px;
      /* border: 1px solid red; */
      z-index: 1;
      padding: 0px;
    }
    /*-----------------------------workspace------------------------*/
    html, body{overflow:hidden !important;}
    .tip_box{text-align: center;padding-top: 20px;}
    .map_list_spot_item{padding:15px;height:105px;border-bottom:solid 1px #a7a7a7;cursor:pointer;background:#fff;}
    .map_list_spot_item:hover{background:#f7f7f7}
    .map_list_spot_item.hover{background:#f7f7f7}
    .map_list_spot_item .image_box{width:102px;height:75px;background:#ddd}
    .map_list_spot_item .image_box img{width:102px;height:75px;}
    .map_list_spot_item .content_box{width:215px;height:75px;margin-left:10px;position:relative;}
    .map_list_spot_item .spot_title{font-size:13px;font-weight:bold;color:#363636}
    .map_list_spot_item .spot_tag{font-size:12px;color:#808080;padding-top:6px;}

    .list_item_clip_cnt{height:19px;padding-left:18px;line-height:19px;background:url('/res/map/list_clip_icon.png') no-repeat;}
    .list_sub_info_line{padding:0px 3px;height:19px;line-height:19px;color:#cccccc;}
    .list_item_review_rate{padding-top:2px;}

    #map_spot_list{overflow-y:scroll;height:100%;}
    .left_full_box{border-right:solid 1px #a7a7a7;height:100%;z-index:999;}
    #pn_title_box{width:160px;background:#203341;}
    #pn_title_box li{width:100%;height:50px;line-height:50px;background:#203341;color:#fff;text-align:center;border-bottom:solid 1px #374854;font-size:12px;cursor:pointer;}
    #pn_date_controll_box{width:160px;height:100%;background:#203341;}
    #pn_date_controll_box li{width:100%;height:120px;background:#203341;color:#fff;text-align:center;border-bottom:solid 1px #374854;font-size:12px;cursor:pointer;padding-top:10px;}
    #cat_menu{width:160px;height:100%;background:#203341;overflow-y:auto;}
    #cat_menu li{width:100%;height:70px;background:#203341;color:#fff;text-align:center;border-bottom:solid 1px #374854;font-size:12px;cursor:pointer;}
    #cat_menu li .cat_date_left_box{margin-top:20px;margin-left:18px;}
    #cat_menu li .cat_left_day{color:#fff;font-size:17px;font-weight:bold;margin-bottom:5px;}
    #cat_menu li .cat_left_date{color:#49b2e9;font-size:11px;}
    #cat_menu li .cat_date_right_box{margin-top:20px;margin-left:5px;}
    #cat_menu li .cat_right_weekday{margin-bottom:7px;text-align:left !important;}
    #cat_menu li .cat_right_city{color:#b3b3b3;text-align:left !important;}

    #cat_menu li img{padding-top:17px;padding-bottom:9px;}
    #cat_menu li img.s{padding-top:11px;padding-bottom:3px;}
    #cat_menu li.on{background:#1a7ad9;border-bottom:solid 1px #1a7ad9;}
    #cat_menu li:not(.on):hover{background:#164c88;}
    #schedule_day_list_box{overflow-y:scroll;}

    #top_menu{width:100%;height:45px;background:url(/res/map/mn_top_bg.png);position:absolute;top:74px;left:445px;z-index:2;}
    .pn_title_input_box{
      width:260px;
      height: 30px;
      border: 1px solid #c8c8ca;
      padding-left: 10px;
      padding-right: 40px;
      font-size: 13px;
      color: #808080;
    }
    .pn_title_chg_ok{
      background: #ff9320;
      border: 1px solid #f7870f;
      margin-left: 2px;
      width: 60px;
      height: 30px;
      font-size: 12px;
      color: white;
      cursor: pointer;
    }

    #cat_menu_edit_box{height:100%;background:#203341;overflow-y:auto;}
    #cat_menu_edit_box li{width:100%;height:70px;background:#203341;color:#fff;text-align:center;border-bottom:solid 1px #374854;font-size:12px;cursor:move;}
    #cat_menu_edit_box li .cat_date_left_box{margin-top:20px;margin-left:5px;}
    #cat_menu_edit_box li .cat_left_day{color:#fff;font-size:17px;font-weight:bold;margin-bottom:5px;}
    #cat_menu_edit_box li .cat_left_date{color:#49b2e9;font-size:11px;}
    #cat_menu_edit_box li .cat_date_right_box{margin-top:20px;margin-left:5px;}
    #cat_menu_edit_box li .cat_right_weekday{margin-bottom:7px;}
    #cat_menu_edit_box li .cat_right_city{color:#b3b3b3;max-width:50px;height:15px;line-height:15px;overflow:hidden;}
    #cat_menu_edit_box li .cat_edit_move{width:18px;height:100%;background:url('/res/img/workspace/new/cat_move_icon.png') no-repeat 3px 25px;border-right:solid #2c3e4b 1px;}
    #cat_menu_edit_box li .cat_edit_del{width:22px;height:22px;margin-top:23px;background:url('/res/img/workspace/new/del_icon.png');margin-right:10px;cursor:pointer;}


    #overlay_day_edit{background:rgba(255,255,255,0.8);width:100%;height:100%;position:fixed;z-index:99999999;display:none;}
    .ov_day_edit_full{background:#203341;width:190px;height:100%;}

    #detail_spot_to_inspot{font-size:13px;color:#555555;position:absolute;top:9px;right:15px;cursor:pointer;background: #ff9320;border: solid 1px #f7870f;color:#fff;height:30px;line-height:30px;padding-left:10px;padding-right:10px;}

    .tooltip{
      border:solid 1px #c8c8ca;
      background-color:#fff;
      padding:10px;
      min-width:30px;
      border:solid #aaa 1px;
      width:295px;
      height:97px;
      font-family:'nanum';
    }
    .tooltip_full_box{padding:10px;}
    .tooltip_img{width:80px;height:80px;}
    .tooltip_img img{width:80px;height:80px;}
    .tooltip_info{padding-left:10px;width:240px;height:75px;position:relative;}
    .tooltip_title{font-size:16px;color:#363636;padding-top:3px;font-weight:bold;}
    .tooltip_tag{font-size:12px;color:#808080;padding-top:2px;}
    .tooltip_cnt_info_box{position:absolute;left:10px;bottom:0px;color:#707070;font-size:13px;}
    .tooltip_clip_cnt{height:19px;padding-left:18px;line-height:19px;background:url('/res/map/list_clip_icon.png') no-repeat;}
    .tooltip_star_rank{height:19px;padding-left:18px;line-height:19px;background:url('/res/img/common/hotel_star.png') no-repeat;}
    .tooltip_cnt_line{width:6px;height:13px;margin-top:3px;border-right:solid 1px #d9d9d9;margin-right:5px;}
    .tooltip_review_rate{height:19px;padding-left:18px;line-height:19px;background:url('/res/map/list_review_icon.png') no-repeat;}

    .tooltip_detail_btn{width:158px;height:30px;line-height:30px;color:#fff;background:#555555;border:solid 1px #3b3b3b;font-size:13px;text-align:center;cursor:pointer;}
    .tooltip_add_inspot_btn{width:158px;height:30px;line-height:30px;color:#fff;background:#ff9320;border:solid 1px #f7870f;font-size:13px;text-align:center;cursor:pointer;}
    .tooltip_detail_bottom_box{border-top:solid 1px #dbdbdb;padding-top:10px;margin-top:10px;}

    #clip_view_btn{width:110px;height:20px;font-size:11px;color:#666666;margin-top:10px;margin-left:12px;padding-left:25px;padding-top:6px;cursor:pointer;background:url('/res/map/clip_checkbox_null.png') no-repeat;}
    #clip_view_btn.on{background:url('/res/map/clip_checkbox_checked.png') no-repeat;}

    .go_list_btn{width:110px;height:20px;font-size:11px;color:#666666;margin-top:15px;margin-left:12px;padding-left:16px;padding-top:1px;cursor:pointer;background:url('/res/map/go_list_btn.png') no-repeat;}

    .item_sub_info_box{color:#707070;font-size:13px;position:absolute;bottom:0px;left:0px}

    .clip_btn{padding:0 5px;height:32px;background:#555555;border:solid #3b3b3b 1px;color:#fff;font-size:15px;position:absolute;bottom:0px;right:0px;text-align:center;line-height:30px;cursor:pointer;}
    .clip_btn.on{background:#ff9320;border:solid #f7870f 1px;}


    #select_detail_view_spot{width:380px;position:absolute;left:0px;top:0px;padding-right:4px;padding-bottom:20px;z-index:999;}
    .detail_view_full_box{width:380px;background:#fff;position:relative;}
    #select_detail_view_spot .spot_title{width:100%;height:50px;line-height:50px;padding-left:20px;color:#363636;font-size:15px;font-weight:bold;}
    #select_detail_view_spot .spot_img{width:380px;height:182px;position:relative;}
    #select_detail_view_spot .spot_img img{width:380px;height:182px;}
    #detail_view_menu{width:380px;height:40px;border-bottom:solid #b3b3b3 1px}
    #detail_view_menu .mn_item{width:111px;height:40px;line-height:40px;font-size:15px;color:#b3b3b3;text-align:center;cursor:pointer;font-weight:bold;}
    #detail_view_menu .mn_item.on_clip{width:84px;}
    #detail_view_menu .mn_item.on{color:#363636;border-bottom:solid #1a7ad9 3px;}
    #detail_content{width:100%;overflow-y: scroll;overflow-x: hidden;}
    /*
    #detail_content .info_first{width:100%;height:300px;overflow-y: scroll;overflow-x: hidden;}
    #detail_content .info_second{width:100%;display:none;height:300px;overflow-y: scroll;overflow-x: hidden;}
    #detail_content .info_third{width:100%;display:none;height:300px;overflow-y: scroll;overflow-x: hidden;}
    #detail_content .info_memo{width:100%;display:none;height:300px;overflow-y: scroll;overflow-x: hidden;text-align:center;}
    */
    #detail_content .in_full_box{padding:15px;padding-bottom:0px;}


    #detail_content .tag_box{}
    #detail_content .item_tag {height: 22px;padding: 0px 10px 0px 19px;background: url('/res/img/main/spot_tag_bg.png') no-repeat;background-position: 0px 0px;color: #fff;line-height: 24px;margin-right: 10px;}
    #detail_content .sub_title{padding-top:5px;padding-bottom:10px;width:93px;font-size:12px;color:#555555}
    #detail_content .sub_info{padding-top:5px;padding-bottom:10px;font-size:12px;color:#808080;width:190px;line-height:18px;}
    #detail_content .sub_info a{color:#808080;}
    #detail_content .sub_desc{padding-top:20px;font-size:13px;color:#808080;line-height:24px;padding-bottom:15px;}
    #detail_content .view_more_btn{float:right;margin-right:10px;width:110px;height:31px;text-align:center;color:#555555;line-height:31px;border:solid #c8c8ca 1px;}
    .detail_view_bottom{position:absolute;bottom:0px;height:20px;width:100%;background:#fff;}
    #detail_close_btn{width:40px;height:40px;position:absolute;top:10px;right:-40px;background:url('/res/img/map/info_close_btn.png');cursor:pointer;}
    /*#select_detail_view_spot #detail_close_btn{right:-36px;}*/

    /*.detail_img_overlay{position:absolute;width:333px;height:232px;background:url('/res/map/detail_img_overlay.png');}*/
    .detail_img_overlay{display:none;}
    .spot_cnt_box{position:absolute;bottom:20px;left:20px;color:#fff;font-size:15px;}
    .clip_cnt{height:22px;padding-left:22px;line-height:22px;background:url('/res/map/detail_clip_icon.png')no-repeat;}
    .review_avg{height:22px;padding-left:22px;line-height:22px;background:url('/res/map/detail_review_icon.png')no-repeat;margin-left:10px;}

    .clip_btn_box{width:120px;height:32px;position:absolute;right:20px;bottom:12px;}
    .d_star_rate{width:90px;height:17px;}
    .d_star_rate img{width:90px !important;height:17px !important;}
    .d_review_rate{height: 14px;line-height: 14px;border-left:solid #fff 1px;margin-top:3px;margin-left:8px;padding-left:8px;}

    .d_agent_box{width:100%;height:32px;margin-bottom:10px;}
    .d_agent_img{width:120px;height:32px;line-height:32px;padding-top:5px;}
    .d_agent_img img{width:74px;height:21px;}
    .d_agent_price{width:97px;height:32px;line-height:32px;color:#363636;font-weight:bold;text-align:right;font-size:13px;padding-right:15px;}
    .d_agent_link_btn{width: 60px;height: 32px;line-height: 32px;color: #fff;text-align: center;font-size: 15px;margin: 0 auto;background: #ff9320;border: solid #f7870f 1px;cursor: pointer;float:right;}
    #loading_full_box{position:fixed;width:100%;height:100%;background:url('/res/img/component/bg/bgb_80.png');z-index:999;top:0px;left:0px;display:none;}
    .loading_in_box{position:absolute;top:45%;left:48%;text-align:center;color:#fff;font-size:17px;line-height:25px;display:none;}

    .si_chart_item{padding:0px 7px;padding-top:5px;}
    .chart{position:relative;}
    .chart span{font-size:15px;color:#363636;font-weight:bold;position:absolute;left:30px;top:48px;width:31px;text-align:center;}
    .chart_icon{position:absolute;left:30px;top:20px;}
    .si_chart_item_title{width:100%;text-align:center;font-size:13px;color:#363636;font-weight:bold;padding-top:2px;}

    #guide_overlay{width:100%;height:2000px;position:absolute;top:0px;left:0px;background: url('/res/img/component/bg/bgb_70.png') repeat;z-index:999999999999;display:none;}
    #guide_box{width:654px;height:468px;margin:0 auto;margin-top:180px;position:relative;}
    #guide_box .guide_hidden_box{width:654px;height:468px;overflow:hidden;position:relative;}
    #guide_scroll_box{width:9000px;height:654px;position:absolute;}
    #guide_close_btn {
      width: 40px;
      height: 40px;
      position: absolute;
      top:10px;
      right: -36px;
      background: url('/res/img/map/info_close_btn.png');
      cursor: pointer;
    }

    #guide_box .navi{width:14px;height:29px;position:absolute;z-index:9;}
    #guide_box .navi.left{left:10px;top:156px;background:url('/res/img/workspace/guide_navi_left_a.png');cursor:pointer;}
    #guide_box .navi.left:hover{background:url('/res/img/workspace/guide_navi_left_b.png');}

    #guide_box .navi.right{right:13px;top:156px;background:url('/res/img/workspace/guide_navi_right_a.png');cursor:pointer;}
    #guide_box .navi.right:hover{background:url('/res/img/workspace/guide_navi_right_b.png');}
    #guide_box .guide_indi_box{text-align:center;padding-left:240px;padding-top:10px;}
    #guide_box .guide_indi_box .indi_item{margin:3px;width:12px;height:12px;cursor:pointer;background:url('/res/img/workspace/guide_indi_b.png');}
    #guide_box .guide_indi_box .indi_item.on{background:url('/res/img/workspace/guide_indi_a.png');}






    .info_second .review_writer_img{width:31px;height:31px;border-radius:16px;}
    .info_second .review_writer_img img{width:31px;height:31px;border-radius:16px;}
    .info_second .review_fl_box{width:48px;}
    .info_second .review_fr_box{width:220px;}
    .info_second .review_writer_name{color:#555555;font-size:13px;padding-bottom:15px;padding-top:8px;}
    .info_second .review_writer_desc{color:#555555;font-size:13px;line-height:16px;}




    .hotel_price_th{font-size:13px;color:#363636;font-weight:bold;height:55px;border-bottom:solid 1px #dadada;line-height:16px;padding-top:15px;}
    .hotel_price_th .site{width:179px;padding-left:50px;}
    .hotel_price_th .price{width:100px;}
    .hotel_price_th .price span{font-size:11px;color:#808080;}
    .hotel_price_item{height:70px;color:#363636;font-size:13px;font-weight:bold;padding-top:15px;}
    .hotel_price_item .agent_box{padding-left:25px;width:160px;}
    .hotel_price_item .agent_box img{width:85px;height:auto;}
    .hotel_price_item .price_box{width:90px;height:32px;line-height:32px;}
    .hotel_price_item .go_agent_btn{width:60px;height:32px;background:#fe931f;border:solid #f7870f 1px;font-size:15px;color:#fff;text-align:center;line-height:32px;}



    .main_hotel_agent_box{padding-top:20px;}
    .main_hotel_agent_box .agent_box{width:160px;height:40px;padding-left:20px;}
    .main_hotel_agent_box .agent_box img{width:85px;height:auto;}
    .main_hotel_agent_box .price_box{color:#363636;font-size:13px;font-weight:bold;height:40px;line-height:40px;width:90px;}
    .main_hotel_agent_box .go_agent_btn{width:60px;height:32px;background:#fe931f;border:solid #f7870f 1px;font-size:15px;color:#fff;text-align:center;line-height:32px;}

    .main_desc_box{font-size:13px;line-height:23px;color:#808080;padding:10px 20px;}


    .hi_pop_box{font-size:17px;font-weight:bold;color:#f7870f;text-align:center;padding-top:20px;}
    .hi_review_cnt_box{font-size:13px;color:#808080;text-align:center;padding-top:5px;}
    .hi_title{font-size:15px;color:#363636;font-weight:bold;}

    #review_title_box{font-size:15px;color:#363636;font-weight:bold;padding-bottom:10px;}
    .chart_h{
      margin: 0px 8px;
    }
    .chart_h span {
      position: absolute;
      left: 23px;
      top: 27px;
      font-size: 22px;
      font-weight: 22px;
      color: #9aca40;
      font-weight: bold;
      width: 45px;
      text-align: center;
    }
    .chart_h .chart_desc {
      position: absolute;
      font-size: 12px;
      color: #808080;
      width: 59px;
      text-align: center;
      top: 55px;
      left: 14px;
    }


    #hotel_review .graph{width: 100px;height: 8px;background: #dfdfdf;}
    #hotel_review .graph .full{width: 100px;height: 8px;background: #dfdfdf;}
    #hotel_review .graph .full .data{height: 8px;background: #9aca40;}
    #hotel_review .review_detail_item {
      padding-top: 10px;
      color: #808080;
      font-size: 12px;
      padding-left:10px;
    }
    #hotel_review .title {
      width: 70px;
      height: 25px;
      padding-left: 5px;
    }
    #hotel_review .desc{
      padding-left: 5px;
      color: #afafaf;
    }
    .spot_flight_box{
      width: 26px;
      height: 21px;
      border: solid #cacaca 1px;
      text-align: center;
      line-height: 21px;
      position: absolute;
      margin-top: -25px;
      margin-left: 108px;
      background: #fff;
      padding-top: 2px;
      cursor: pointer;
    }

    #city_list .city_items .city_item .ci_img{width:50px;height:50px;border-radius:25px;margin-top:5px;margin-right:10px;}
    #city_list .city_items .city_item .ci_img img{width:50px;height:50px;border-radius:25px;}
    #city_list .city_items .city_item span{font-size:13px;}

    #city_list .city_search .city_item .ci_img{width:50px;height:50px;border-radius:25px;margin-top:5px;margin-right:10px;}
    #city_list .city_search .city_item .ci_img img{width:50px;height:50px;border-radius:25px;}
    #city_list .city_search .city_item span{font-size:13px;}

    #clip_list .clipboard_change_box .clipboard_item .ci_img{width:32px;height:32px;border-radius:16px;margin-top:5px;margin-right:10px;}
    #clip_list .clipboard_change_box .clipboard_item .ci_img img{width:32px;height:32px;border-radius:16px;}
    #clip_list .clipboard_change_box .clipboard_item span{font-size:13px;}

    .transport_detail_inner_box{width:333px;border:solid #b3b3b3 1px;margin:0 auto;margin-top:15px;margin-bottom:10px;font-size:13px;padding-top:15px;padding-bottom:10px;}
    .transport_detail_inner_left{width:88px;margin-left:13px;color:#555555;min-height:36px;}
    .transport_detail_inner_right{color:#808080;width:184px;min-height:36px;line-height:20px;}
    .info_memo{width:100%;padding:10px;text-align:center;background:#f7f7f7}
    .info_memo textarea{width:270px;height:30px;border:solid #c8c8ca 1px;padding:10px;font-family:'nanum';font-size:12px;line-height:20px;}

    #memo_save{width:298px;background:white;  border: 1px solid #c8c8ca;color: #555555;height:42px;line-height:42px;margin-top:10px;text-align:center;cursor:pointer;display:none;}

    .air_content {
      width:300px;
      margin:0 auto;
      padding-bottom:20px;
      position:relative;
    }
    .air_table {
      width: 100%;
      margin-top: 15px;
      border: 1px solid #898989;
    }
    .air_table th {
      color: white;
      background: #898989;
      font-size: 12px;
      height: 30px;
      line-height: 30px;
    }
    .air_table th:nth-child(2) {
      text-align: right;
      padding-right: 15px;
    }
    .air_table td:first-child {
      color: red;
      font-size: 12px;
      color: #808080;
    }
    .air_table .line1 {
      position: absolute;
      left: 0px;
      top: 0px;
      width: 12px;
      height: 100%;
      /* background: url('/res/img/planbook/air_bg1.gif') repeat-y; */
      border-right: 3px solid #cbcbca;
    }
    .line_img.top {
      position: absolute;
      top: 0px;
      left: 0px;
    }
    .line_img.bottom {
      position: absolute;
      bottom: 0px;
      left: 0px;
    }
    .air_table td:nth-child(3) {
      font-size: 12px;
      color: #7f7f7f;
      line-height: 25px;
      text-align: left;
      padding-left: 10px;
    }
    .air_ca {
      height: 20px;
      overflow: hidden;
      margin-bottom: 5px;
    }
    .ca_img {
      float: left;
      height: 20px;
      margin-right: 5px;
    }
    .air_table td {
      text-align: center;
      height: 30px;
    }
    .air_table td:nth-child(2) {
      position: relative;
    }

    .total_view_item {
      height: 106px;
      background: #f0f0f0;
      font-size: 12px;
      color: #363636;
      padding-top: 26px;
      border-bottom: solid #dcdcdc 1px;
      text-align: center;
      cursor: pointer;
    }
    .total_view_item .total_view_sub_text {
      font-size: 11px;
      color: #555555;
      line-height: 18px;
      padding-top: 5px;
    }

    #hotel_rank_filter_box .item.on{background: url('/res/img/city/tag_check_checked.png')no-repeat;}
    #hotel_type_filter_box .item.on{background: url('/res/img/city/tag_check_checked.png')no-repeat;}

    .air_search_icon{vertical-align: middle;margin-left: 1px;}

    .in_modal_title_box {
      width: 100%;
      height: 60px;
      line-height: 60px;
      border-bottom: 1px solid #b3b3b3;
      font-size: 20px;
      color: #363636;
      padding-left: 13px;
      overflow: hidden;
    }
    .in_modal_btn_close {
      cursor: pointer;
      float: right;
    }
    .in_modal_footer{  width: 100%;  border-top: 1px solid #b3b3b3;  padding-top: 20px;  padding-bottom: 20px;  text-align: center;}
    .in_modal_ok_btn{
      width: 145px;
      height: 42px;
      background: #ff9320;
      border: solid #f7870f 1px;
      cursor: pointer;
      line-height: 42px;
      color: #fff;
      font-size: 15px;
      font-weight: bold;
      margin: 0 auto;
    }
    .in_modal_content {
      width: 100%;
      padding-left: 20px;
      padding-right: 20px;
      padding-top: 20px;
    }


    #opti_start_point{
      width: 318px;
      height: 31px;
      border: solid #c8c8ca 1px;
      color: #808080;
      font-size: 13px;
      padding-left: 12px;
      line-height: 31px;
      cursor: pointer;
      background: #fff url('/res/img/flight/drop_select_arrow_a.png') no-repeat 300px 12px;
    }
    #opti_start_point_box {
      position: absolute;
      width: 318px;
      padding: 10px;
      border: solid 1px #c8c8ca;
      background: #fff;
      padding-bottom: 3px;
      max-height: 252px;
      overflow-y: auto;
      display: none;
      margin-top: -1px;
      z-index: 9;
    }
    #opti_start_point_box .item {
      height: 18px;
      cursor: pointer;

      padding-left: 25px;
      line-height: 18px;
      margin-bottom: 7px;
    }
    #opti_start_point_box .item.on {

    }

    #opti_end_point{
      width: 318px;
      height: 31px;
      border: solid #c8c8ca 1px;
      color: #808080;
      font-size: 13px;
      padding-left: 12px;
      line-height: 31px;
      cursor: pointer;
      background: #fff url('/res/img/flight/drop_select_arrow_a.png') no-repeat 300px 12px;
    }
    #opti_end_point_box {
      position: absolute;
      width: 318px;
      padding: 10px;
      border: solid 1px #c8c8ca;
      background: #fff;
      padding-bottom: 3px;
      max-height: 252px;
      overflow-y: auto;
      display: none;
      margin-top: -1px;
      z-index: 9;
    }
    #opti_end_point_box .item {
      height: 18px;
      cursor: pointer;
      padding-left: 25px;
      line-height: 18px;
      margin-bottom: 7px;
    }
    #opti_end_point_box .item.on {

    }

    .in_modal_item_title{
      height:31px;
      line-height:31px;
      width:100px;
    }
    #in_modal_full_frame{width: 100%;  height: 2000px;  position: absolute;  top: 0px;  left: 0px;  background: url('/res/img/component/bg/bgb_70.png') repeat;  z-index: 999999999999;display:none;}
    #in_modal_opti_a{width:468px;height:257px;background:#fff;margin:0 auto;margin-top:150px;display:none;}
    #in_modal_opti_b{width:729px;min-height:534px;background:#fff;margin:0 auto;margin-top:150px;display:none;position:relative;}

    #opti_before_box{width:323px;min-height:360px;border:solid #d8d8d8 1px;background:#fff;}
    #opti_after_box{width:323px;min-height:360px;border:solid #d8d8d8 1px;background:#fff;}

    #opti_before_box_img{width:321px;height:216px;}
    #opti_after_box_img{width:321px;height:216px;}

    #opti_before_info_text{font-size:13px; color:#808080;line-height:18px;}
    #opti_before_info_text span{color:#ff9320;margin-left:5px;margin-right:5px;}

    #opti_after_info_text{font-size:13px; color:#808080;line-height:18px;}
    #opti_after_info_text span{color:#ff9320;margin-left:5px;margin-right:5px;}

    #opti_route_loading{width:100%;height:100%;position:absolute;left:0px;top:0px;background: url('/res/img/component/bg/bgb_70.png') repeat;z-index:99999;text-align:center;padding-top: 150px;color:#fff;line-height:20px;font-size:15px;display:none;}
    #schedule_detail_title .day_next_btn{width:22px;height:24px;border:solid #fff 1px;background:url('/res/img/workspace/_next_icon.png') no-repeat 6px 6px;margin-top:13px;cursor:pointer;}
    #schedule_detail_title .day_prev_btn{width:22px;height:24px;border:solid #fff 1px;border-right:0px;background:url('/res/img/workspace/_prev_icon.png') no-repeat 6px 6px;margin-top:13px;cursor:pointer;}
    #schedule_detail_title .day_reset_btn{width:20px;height:20px;background:url('/res/img/workspace/_day_reset_icon.png') no-repeat;background-size:20px 20px;margin-top:14px;margin-left:3px;cursor:pointer;}






    .day_item.edit .move_indi{width:20px;height:85px;border-right:solid #e0e0e0 1px;background:url('/res/img/workspace/schedule_move_icon.png')no-repeat 0px 30px;}
    .day_item.edit .del_indi{width:40px;height:85px;border-left:solid #e0e0e0 1px;background:url('/res/img/workspace/schedule_del_icon.png')no-repeat 10px 30px;cursor:pointer;}
    .day_item.edit .day_info{width:170px;height:85px;overflow:hidden;}
    .day_item.edit .day_spot_cnt_box{display:none;}
    .day_info_inbox{width:250px;padding:5px 0px 5px 5px;}
    .day_in_spot_box{padding: 10px 0px 50px 0px;min-height:70px;display:block;}

    .day_in_spot_box div{margin-left:5px;margin-right:5px;margin-top:5px;}
    .inspot_add_indi{width:38px;height:35px;background:url('/res/img/workspace/schedule_day_spot_add.png')no-repeat;}
    .inspot_spot_indi{width:38px;height:35px;}
    .inspot_spot_indi img{width:38px;height:35px;}





    .day_item .info_box{padding:20px 0px 0px 10px;position:relative;width:155px;}
    .day_item .info_box .title{color:#808080;font-size:13px;}
    .day_item .info_box .sub{color:#808080;font-size:13px;padding-top:10px;}
    .day_item .day_spot_cnt_box{background:url('/res/img/workspace/spot_icon.png') no-repeat;height:15px;line-height:15px;padding-left:15px;font-size:13px;color:#808080;position:absolute;right:0px;top:15px;width:50px;}

    .day_spot_item{padding:15px;cursor:move;border-bottom:solid #a7a7a7 1px;background:#fff;width:100%;position:relative;}
    /*.day_spot_item:not(.btn_del){cursor:move;}*/
    .day_spot_item:hover{background:#f7f7f7;}
    .day_spot_item.hover{background:#ddd;}
    .day_spot_item .img_box{width:62px;height:55px;position:relative;cursor:pointer;}
    .day_spot_item .img_box img{width:62px;height:55px;}
    .spot_to_inspot{cursor:pointer;position:absolute;top:15px;right:15px;}

    #city_list .day_spot_item .img_box{width:82px;height:75px;position:relative;cursor:pointer;}
    #city_list .day_spot_item .img_box img{width:82px;height:75px;}

    .day_spot_item .info_box{padding-left:10px; width:153px;}}
    .day_spot_item .info_box .title{font-size:13px;color:#363636;cursor:pointer;}
    .day_spot_item .info_box .sub{font-size:12px;color:#808080;padding-top:8px;}
    /*#schedule_detail_box{display:none;overflow-y:scroll;height:500px;padding-bottom:200px;}*/
    .spot_order_box{width: 18px;height: 18px;border-radius: 9px;position: absolute;left: -3px;top: -3px;background: #223b68;line-height: 19px;text-align: center;color: white;font-size: 10px;}
    .info_box .title{cursor:pointer;}
    .info_box .title:hover{cursor:pointer;text-decoration:underline;}
    #add_transport{width:218px;height:42px;border:solid #c8c8ca 1px;line-height:42px;text-align:center;font-size:15px;color:#555555;margin:0 auto;margin-top:10px;cursor:pointer;}

    .list_search_full_box{background:#fff;}
    .list_search_box{height:75px;border-bottom:solid #dadada 1px;padding-top:10px;background:#fff;text-align:center;}
    #input_search{width:328px;height:31px;border:solid #c8c8ca 1px;padding-left:5px;font-family:'nanum';background: url('/res/img/common/gnb/search_icon.png') no-repeat;background-position:300px 4px;}
    .list_category_box{background:#f7f7f7;height:120px;padding-top:8px;}
    .list_cat_item{width:68px;padding-left:7px;text-align:center;cursor:pointer;}
    .list_tag_box{position:relative;}

    #map_tag_select_box{width:318px;height:31px;border:solid #c8c8ca 1px;background: #fff url('/res/img/flight/drop_select_arrow_a.png') no-repeat 300px 12px;line-height:31px;margin:0 auto;margin-top:5px;padding-left:5px;font-size:13px;color:#808080;cursor:pointer;}
    #map_tag_select_box.on{background: #555555 url('/res/img/flight/drop_select_arrow_b.png') no-repeat 200px 12px;color: #fff;}

    #map_tag_select_sub_box{position: absolute;width: 318px;padding: 10px;border: solid 1px #c8c8ca;background: #fff;padding-bottom: 3px;max-height: 252px;overflow-y: auto;display: none;margin-top: -1px;z-index: 9;left:24px;}
    #map_tag_select_sub_box .item{height: 18px;cursor: pointer;background: url('/res/img/city/tag_check_null.png')no-repeat;padding-left: 25px;line-height: 18px;margin-bottom: 7px;}
    #map_tag_select_sub_box .item.on{background: url('/res/img/city/tag_check_checked.png')no-repeat;}
    .list_title_option_menu{position: absolute;font-size: 12px;color: #fff;top: 12px;right: 15px;font-weight: normal;cursor:pointer;width:76px;height:26px;line-height:26px;text-align:center;border:solid 1px #fff;background:url('/res/img/workspace/w_arrow_down.png')no-repeat 62px 10px;padding-right:6px;}
    .list_title_option_menu.open{background:url('/res/img/workspace/w_arrow_up.png')no-repeat 62px 10px;}
    .clipboard_change_box{background:#fff;width:265px;height:400px;overflow-y:scroll;display:none;position:absolute;z-index:9;}
    .clipboard_change_box .clipboard_item{height:43px;color:#555555;font-size:17px;padding-left:14px;line-height:43px;cursor:pointer;border-bottom:solid #a7a7a7 1px;}
    .clipboard_change_box .clipboard_item.on{color:#1a7ad9;}
    .clipboard_change_box .clipboard_item:hover{background:#eaeaea;}

    .city_change_box{background:#fff;width:365px;height:400px;display:none;position:absolute;z-index:9;}
    .city_change_box .city_text_search_box{height:52px;border-bottom:solid #a7a7a7 1px;text-align:center;padding-top:10px;}
    .city_change_box .city_text_search_input{width:318px;height:31px;border:solid #c8c8ca 1px;background: url('/res/img/common/gnb/search_icon.png') no-repeat;background-position: 290px 4px;}
    .city_change_box .city_items{height: 348px;overflow-y: scroll;}
    .city_change_box .city_items .city_item_title{height:60px;color:#555555;font-size:17px;padding-left:14px;line-height:60px;font-weight:bold;}
    .city_change_box .city_items .city_item{height:60px;color:#555555;font-size:17px;padding-left:14px;line-height:60px;cursor:pointer;}
    .city_change_box .city_items .city_item.on{color:#1a7ad9;}
    .city_change_box .city_items .city_item:hover{background:#eaeaea;}

    .city_change_box .city_search{height: 348px;overflow-y: scroll;}
    .city_change_box .city_search .city_item{height:60px;color:#555555;font-size:17px;padding-left:14px;line-height:60px;cursor:pointer;}
    .city_change_box .city_search .city_item{height:60px;color:#555555;font-size:17px;padding-left:14px;line-height:60px;cursor:pointer;}
    .city_change_box .city_search .city_item.on{color:#1a7ad9;}
    .city_change_box .city_search .city_item:hover{background:#eaeaea;}

    .full_date_info{margin-left:15px;}
    .day_edit_start_btn{margin-top:18px;margin-left:10px;background:url('/res/img/workspace/new/cat_set_icon.png') no-repeat;padding-left:18px;line-height: 15px;}



    .hotel_search_box{background:#fff;border-bottom:solid #a7a7a7 1px;}
    .ht_change_search_box{padding-bottom:10px;}
    .ht_filter_box{background:#f7f7f7;border-top:solid #dadada 1px;padding-bottom:10px;}

    #hotel_search_edit_btn{width:62px;height:55px;color:#555555;font-size:15px;border:solid #c8c8ca 1px;text-align:center;padding-top:12px;cursor:pointer;}


    #hotel_rank_filter {
      width: 218px;
      height: 31px;
      border: solid #c8c8ca 1px;
      background: #fff url('/res/img/flight/drop_select_arrow_a.png') no-repeat 200px 12px;
      line-height: 31px;
      margin: 0 auto;
      margin-top: 5px;
      padding-left: 5px;
      font-size: 13px;
      color: #808080;
      cursor: pointer;
    }
    #hotel_rank_filter_box{position: absolute;width: 218px;padding: 10px;border: solid 1px #c8c8ca;background: #fff;padding-bottom: 3px;max-height: 252px;overflow-y: auto;display: none;margin-top: -1px;z-index: 9;left:24px;}
    #hotel_rank_filter_box .item {
      height: 18px;
      cursor: pointer;
      background: url('/res/img/city/tag_check_null.png')no-repeat;
      padding-left: 25px;
      line-height: 18px;
      margin-bottom: 7px;
    }

    #hotel_type_filter {
      width: 218px;
      height: 31px;
      border: solid #c8c8ca 1px;
      background: #fff url('/res/img/flight/drop_select_arrow_a.png') no-repeat 200px 12px;
      line-height: 31px;
      margin: 0 auto;
      margin-top: 5px;
      padding-left: 5px;
      font-size: 13px;
      color: #808080;
      cursor: pointer;
    }
    #hotel_type_filter_box{position: absolute;width: 218px;padding: 10px;border: solid 1px #c8c8ca;background: #fff;padding-bottom: 3px;max-height: 252px;overflow-y: auto;display: none;margin-top: -1px;z-index: 9;left:24px;}
    #hotel_type_filter_box .item {
      height: 18px;
      cursor: pointer;
      background: url('/res/img/city/tag_check_null.png')no-repeat;
      padding-left: 25px;
      line-height: 18px;
      margin-bottom: 7px;
    }

    .item_ctrl_box{position:absolute;top:55px;right:7px;display:none;}
    .item_ctrl_box div{cursor:pointer;margin-right:3px;}

    #hotel_search_inner_box{display:none;}

    #key_hotelsearch {
      width: 218px;
      height: 31px;
      border: solid #c8c8ca 1px;
      padding-left: 5px;
      font-family: 'nanum';
      background: url('/res/img/common/gnb/search_icon.png') no-repeat;
      background-position: 190px 4px;
    }


    #key_hotelsearch_autocomplete{width:218px;position:absolute;background:#fff;z-index:9;border:solid 0px #c8c8ca;margin-top:0px;display:none;margin-left:20px;text-align:left;}
    #key_hotelsearch_autocomplete .item{width:100px;height:31px;border-bottom:solid 1px #eaeaea;color:#808080;font-size:13px;line-height:31px;padding-left:5px;}
    .f_search.flight {
      background: url('/res/img/common/flight_sym.png') no-repeat;
      background-size: 20px;
      background-origin: content-box;
      background-position: 0px;
    }
    .hotel_item{
      background: url('/res/img/common/mobile/ic_catea5.png') no-repeat;
      background-size: 20px;
      background-origin: content-box;
      background-position: 0px;
    }
    .f_search {
      display: block;
      width: 100%;
      height: 51px;
      border-bottom: 1px solid rgb(178,178,178);
      /*background: rgba(255,255,255,0.8);*/
      background:url('/res/img/component/bg/bgw_80.png') repeat;
      padding-left: 10px;
      position: relative;
      cursor:pointer;
    }
    .list_box_overlay {width:365px;height:100%;position:absolute;z-index:8;background: url('/res/img/component/bg/bgb_70.png') repeat;display:none;}

    #no_result_box {
      text-align: center;
      padding-top: 50px;
      display: none;
    }
    .no_result_text {
      color: #808080;
      font-size: 13px;
      padding-top: 20px;
    }
    #day_controll_btn_box{padding:5px 0;border-bottom: solid #a7a7a7 1px;}
    /*#day_reset_btn{width:108px;height:30px;text-align:center;line-height:30px;border:solid #e7e5e0 1px;border-radius:3px;margin-left:20px;cursor:pointer;background:url('/res/img/workspace/day_con_reset_icon.png') no-repeat 12px 7px;padding-left:7px;background-color:#f1f1f1;}*/
    #day_optimize_btn{width:245px;height:30px;text-align:center;line-height:30px;border:solid #3099dd 1px;margin-left:10px;cursor:pointer;background:#49b2e9;padding-left:5px;color:#fff;}

    .inspot_add_box{border-top: solid #a7a7a7 1px;padding-top:10px;height: 49px;}

    .add_inspot_spot_btn{width:104px;height:30px;background:#555555;border:solid #3b3b3b 1px;line-height:30px;color:#fff;font-size:12px;text-align:center;margin-left:25px;cursor:pointer;}
    .add_inspot_trans_btn{width:104px;height:30px;background:#ff9320;border:solid #f7870f 1px;line-height:30px;color:#fff;font-size:12px;text-align:center;margin-left:5px;cursor:pointer;}

    #show_all_day{line-height:70px;font-size:15px !important;}


    #schedule_full_box{border-right: solid #a9a9a9 1px;}
    .list_title{width:365px;height:50px;background:#1a7ad9;line-height:50px;color:#fff;padding-left:10px;font-size:15px;font-weight:bold;}
    #schedule_full_box .title_box{width:265px;height:50px;background:#707070;color:#fff;line-height:50px;font-size:15px;font-weight:bold;padding:0px 10px;}
    #schedule_full_box .title_box .sub{font-size:13px;color:#fff;font-weight:normal;text-decoration:underline;}
    .day_item{width:100%;height:86px;border-bottom:solid #a7a7a7 1px;padding-left:10px;cursor:pointer;position:relative;overflow:hidden;}
    .day_item.hover{height:auto;}
    .day_item.edit{cursor:move;}
    .day_item:hover{background:#f7f7f7;}
    .day_item_circle{width:73px;height:73px;background:url('/res/img/workspace/schedule_day_box.png');position:relative;}
    .day_item_circle .day{font-size:20px;color:#46b5f1;position:absolute;top:20px;width:73px;text-align:center;}
    .day_item_circle .date{font-size:13px;color:#808080;position:absolute;top:45px;width:73px;text-align:center;}

    #clip_list{width:265px;z-index:999;position:absolute;left:0px;height:100%;background:#fff;display:none;}
    #city_list{width:365px;z-index:999;position:absolute;left:0px;height:100%;background:#fff;}
    #hotel_list{width:265px;z-index:999;position:absolute;left:0px;height:100%;background:#fff;display:none;}
    #transport_list{width:265px;z-index:999;position:absolute;left:0px;height:100%;background:#fff;display:none;}
    .back_btn{width:13px;height:23px;background:url('/res/img/workspace/back_btn.png');margin-top:22px;cursor:pointer;}
    #schedule_detail_title{display:none;}
    #schedule_list_title .sub{cursor:pointer;}

    .ui-sortable-helper{border:solid #1a7ad9 1px;background:#f7f7f7;height:86px;}
    .ui-draggable-dragging{border:solid #1a7ad9 1px;background:#f7f7f7;height:86px;}
    .ui-state-highlight {border-bottom:solid #a7a7a7 1px;background:#fff;height:86px;}

    .list_box{overflow-y:scroll;background:#fff;}
    #add_plan_day{width:218px;height:42px;line-height:42px;text-align:center;color:#46b5f1;border:solid #46b5f1 1px;font-size:15px;margin:0 auto;margin-top:10px;cursor:pointer;}
    .spot_distance_box{height:21px;line-height:21px;background:#fff;border:solid #cacaca 1px;font-size:11px;color:#808080;position:absolute;padding:0px 5px;margin-top:-25px;cursor:pointer;}
    .spot_distance_box:hover{text-decoration:underline;}
    #ddFrame {position: absolute;top:10px !important;right:10px !important;left:initial !important; border: 1px solid #ccc; width: 25%; height: 520px; background: rgb(255, 255, 255); background: rgba(255, 255, 255, 0.8); padding: 0px 0px; z-index: 40;}
    #ddBox {overflow-y: scroll; width: 97%; height: 500px; margin: 0px; border: 2px solid #fff; border-top: 16px solid #fff; }
    #ddBoxClose {background: url(http://earthtory.com/res/img/map/direction_close.png) no-repeat; height: 16px; width: 16px; cursor: pointer;}
    #ddBoxPrint {background: url(http://earthtory.com/images/print.png) no-repeat; height: 16px; width: 26px;padding-left: 20px ;left: 4px !important; cursor: pointer; text-decoration: none; color: #66e}

    .budget_input{
      border: solid #c8c8ca 1px;
      border-left:0px;
      height: 31px;
      width: 220px;
      padding-left:10px;
      ime-mode: disabled;
    }

    #on_city_open_btn{
      width: 40px;
      height: 40px;
      position: absolute;
      top: 10px;
      left: 0px;
      background: url('/res/img/workspace/new/city_open_btn.png');
      cursor: pointer;
      z-index:99;
    }
    #on_city_close_btn{width:40px;height:40px;position:absolute;top:10px;right:-40px;background:url('/res/img/workspace/new/city_close_btn.png');cursor:pointer;}


    .cmmt_content_box {
      margin-top: 20px;
    }
    .cmmt_c_user {
      width: 100%;
    }
    .cmmt_content_uimg {
      width: 37px;
      height: 37px;
      border-radius: 50%;
      float: left;
    }
    .cmmt_c_user_txt {
      float: left;
      margin-left: 10px;
      width: 280px;
    }
    .cmmt_c_user_name {
      font-size: 13px;
      font-weight: bold;
      color: #555555;
      margin-top: 5px;
    }
    .cmmt_c_user_name span {
      font-size: 12px;
      color: #808080;
      font-weight:normal;
    }
    .cmmt_c_user_level {
      margin-top: 5px;
    }
    .cmmt_c_user_level img {
      float: left;
    }
    .cmmt_c_user_level .rv_cnt {
      float: left;
      color: #ff9320;
      font-size: 12px;
      margin-left: 5px;
    }
    .cmmt_content {
      width: 100%;
      padding-left: 47px;
      border-bottom: 1px solid #dbdbdb;
      padding-top: 15px;
      padding-bottom: 15px;
      font-size: 14px;
      color: #808080;
      line-height: 22px;
      padding-right: 10px;
    }
    .cmmt_content_info {
      color: #555555;
      font-size: 13px;
      margin-bottom: 10px;
      font-weight: bold;
    }
    .cmmt_content_info span {
      color: #ff440d;
      font-weight: normal;
    }
    .cmtm_btn_like {
      display: inline-block;
      height: 25px;
      color: #b3b3b3;
      font-size: 11px;
      line-height: 25px;
      padding-left: 20px;
      padding-right: 5px;
      border: 1px solid #c8c8ca;
      cursor: pointer;
      background: url('/res/img/city/cmmt_like_btn.png') no-repeat #f5f5f5;
      background-position: 5px center;
      float: right;
    }


    .map_review_w_btn{
      border: solid #d4d4d4 1px;
      color: #808080;
      padding: 7px 10px;
      width: 70px;
      text-align: center;
      cursor:pointer;
    }


    .blog_item{
      padding-bottom:20px;
      margin-bottom:10px;
      border-bottom:1px solid #dbdbdb;
    }

    .et_modal_layer_80 {
      position: fixed;
      width: 100%;
      height: 100%;
      z-index: 999999;
      /* background: rgba(0,0,0,0.7); */
      background: url('/res/img/component/bg/bgb_80.png') repeat;
    }

    .intro_text{
      font-size:22px;font-weihgt:bold;color:#fff;
    }

    .intro_text span{
      color:#99ff00;
    }
    #schedule_full_box{border-right: solid #a9a9a9 1px;}
    .list_title{width:365px;height:50px;background:#1a7ad9;line-height:50px;color:#fff;padding-left:10px;font-size:15px;font-weight:bold;}
    #schedule_full_box .title_box{width:265px;height:50px;background:#707070;color:#fff;line-height:50px;font-size:15px;font-weight:bold;padding:0px 10px;}
    #schedule_full_box .title_box .sub{font-size:13px;color:#fff;font-weight:normal;text-decoration:underline;}
    .day_item{width:100%;height:86px;border-bottom:solid #a7a7a7 1px;padding-left:10px;cursor:pointer;position:relative;overflow:hidden;}
    .day_item.hover{height:auto;}
    .day_item.edit{cursor:move;}
    .day_item:hover{background:#f7f7f7;}
    .day_item_circle{width:73px;height:73px;background:url('/res/img/workspace/schedule_day_box.png');position:relative;}
    .day_item_circle .day{font-size:20px;color:#46b5f1;position:absolute;top:20px;width:73px;text-align:center;}
    .day_item_circle .date{font-size:13px;color:#808080;position:absolute;top:45px;width:73px;text-align:center;}

    #clip_list{width:265px;z-index:999;position:absolute;left:0px;height:100%;background:#fff;display:none;}
    #city_list{width:365px;z-index:999;position:absolute;left:0px;height:100%;background:#fff;}
    #hotel_list{width:265px;z-index:999;position:absolute;left:0px;height:100%;background:#fff;display:none;}
    #transport_list{width:265px;z-index:999;position:absolute;left:0px;height:100%;background:#fff;display:none;}
    .back_btn{width:13px;height:23px;background:url('/res/img/workspace/back_btn.png');margin-top:22px;cursor:pointer;}
    #schedule_detail_title{display:none;}
    #schedule_list_title .sub{cursor:pointer;}

    #schedule_detail_title .day_next_btn{width:22px;height:24px;border:solid #fff 1px;background:url('/res/img/workspace/_next_icon.png') no-repeat 6px 6px;margin-top:13px;cursor:pointer;}
    #schedule_detail_title .day_prev_btn{width:22px;height:24px;border:solid #fff 1px;border-right:0px;background:url('/res/img/workspace/_prev_icon.png') no-repeat 6px 6px;margin-top:13px;cursor:pointer;}
    #schedule_detail_title .day_reset_btn{width:20px;height:20px;background:url('/res/img/workspace/_day_reset_icon.png') no-repeat;background-size:20px 20px;margin-top:14px;margin-left:3px;cursor:pointer;}
    .item_ctrl_box{position:absolute;top:55px;right:7px;display:none;}
    .item_ctrl_box div{cursor:pointer;margin-right:3px;}
    /*------------------------------workspace---------------------------*/

    /*------------------------------clone------------------------------*/
    .fl {
      margin: 0;
      padding: 0;
      border: 0;
      font-size: 100%;
      font: inherit;
      box-sizing: border-box;
      float: left;
    }

    #pn_title_box {
      margin: 0;
      padding: 0;
      border: 0;
      font-size: 100%;
      font: inherit;
      list-style: none;
      box-sizing: border-box;
      width: 160px;
      /*height: 100%;*/
      background: #203341;
    }

    #pn_title_box li {
      list-style: none;
      margin: 0;
      padding: 0;
      border: 0;
      font: inherit;
      box-sizing: border-box;
      width: 100%;
      height: 50px;
      line-height: 50px;
      background: #203341;
      color: #fff;
      text-align: center;
      border-bottom: solid 1px #374854;
      font-size: 12px;
      cursor: pointer;
    }

    .full_date_info, .fl {
      list-style: none;
      color: #fff;
      text-align: center;
      cursor: pointer;
      margin: 0;
      padding: 0;
      border: 0;
      font-size: 100%;
      font: inherit;
      box-sizing: border-box;
      float: left;
      margin-left: 15px;
    }

    .day_edit_start_btn {
      list-style: none;
      color: #fff;
      text-align: center;
      cursor: pointer;
      margin: 0;
      padding: 0;
      border: 0;
      font-size: 100%;
      font: inherit;
      box-sizing: border-box;
      float: left;
      margin-top: 18px;
      margin-left: 10px;
      background: url('이미지') no-repeat;
      padding-left: 18px;
      line-height: 15px;
    }

    #cat_menu {
      margin: 0;
      padding: 0;
      border: 0;
      font-size: 100%;
      font: inherit;
      list-style: none;
      box-sizing: border-box;
      width: 160px;
      height: 100%;
      background: #203341;
      overflow-y: auto;
      max-height: 983px;
    }

    #show_all_day {
      list-style: none;
      margin: 0;
      padding: 0;
      border: 0;
      font: inherit;
      box-sizing: border-box;
      line-height: 70px;
      font-size: 15px !important;
      width: 100%;
      height: 70px;
      background: #203341;
      color: #fff;
      text-align: center;
      border-bottom: solid 1px #374854;
      cursor: pointer;
    }

    #cat_menu > li.on {
      list-style: none;
      margin: 0;
      padding: 0;
      border: 0;
      font: inherit;
      box-sizing: border-box;
      width: 100%;
      height: 70px;
      color: #fff;
      text-align: center;
      font-size: 12px;
      cursor: pointer;
      background: #1a7ad9;
      border-bottom: solid 1px #1a7ad9;
    }

    #cat_menu li .cat_date_left_box {
      list-style: none;
      color: #fff;
      text-align: center;
      cursor: pointer;
      margin: 0;
      padding: 0;
      border: 0;
      font-size: 100%;
      font: inherit;
      box-sizing: border-box;
      float: left;
      margin-top: 20px;
      margin-left: 18px;
    }

    #cat_menu {
      width: 160px;
      height: 100%;
      background: #203341;
      overflow-y: auto;
    }

    #cat_menu li {
      width: 100%;
      height: 70px;
      background: #203341;
      color: #fff;
      text-align: center;
      border-bottom: solid 1px #374854;
      font-size: 12px;
      cursor: pointer;
    }

    #cat_menu li .cat_date_left_box {
      margin-top: 20px;
      margin-left: 18px;
    }

    #cat_menu li .cat_left_day {
      color: #fff;
      font-size: 17px;
      font-weight: bold;
      margin-bottom: 5px;
    }

    #cat_menu li .cat_left_date {
      color: #49b2e9;
      font-size: 11px;
    }

    #cat_menu li .cat_date_right_box {
      margin-top: 20px;
      margin-left: 5px;
    }

    #cat_menu li .cat_right_weekday {
      margin-bottom: 7px;
      text-align: left !important;
    }

    #cat_menu li .cat_right_city {
      color: #b3b3b3;
      text-align: left !important;
    }


    #schedule_full_box {
      border-right: solid #a9a9a9 1px;
    }

    .list_title {
      width: 365px;
      height: 50px;
      background: #1a7ad9;
      line-height: 50px;
      color: #fff;
      padding-left: 10px;
      font-size: 15px;
      font-weight: bold;
    }

    #schedule_full_box .title_box {
      width: 265px;
      height: 50px;
      background: #707070;
      color: #fff;
      line-height: 50px;
      font-size: 15px;
      font-weight: bold;
      padding: 0px 10px;
    }
    #schedule_detail_title{
      color: #fff;
      margin: 0;
      padding: 0;
      border: 0;
      font-size: 100%;
      font: inherit;
      box-sizing: border-box;
      display: block;
    }

    .schedule_detail_title_text{
      color: #fff;
      margin: 0;
      padding: 0;
      border: 0;
      font: inherit;
      box-sizing: border-box;
      float: left;
      width: 245px;
      padding-left: 10px;
      font-size: 15px;
    }


    #day_controll_btn_box{
      margin: 0;
      border: 0;
      font-size: 100%;
      font: inherit;
      box-sizing: border-box;
      padding: 5px 0;
      border-bottom: solid #a7a7a7 1px;
    }

    #day_optimize_btn{
      margin: 0;
      padding: 0;
      font-size: 100%;
      font: inherit;
      box-sizing: border-box;
      float: left;
      width: 245px;
      height: 30px;
      text-align: center;
      line-height: 30px;
      border: solid #3099dd 1px;
      margin-left: 10px;
      cursor: pointer;
      background: #49b2e9;
      padding-left: 5px;
      color: #fff;
    }

    /*#schedule_detail_box{*/
    /*    margin: 0;*/
    /*    padding: 0;*/
    /*    border: 0;*/
    /*    font-size: 100%;*/
    /*    font: inherit;*/
    /*    box-sizing: border-box;*/
    /*    overflow-y: scroll;*/
    /*    padding-bottom: 200px;*/
    /*    height: 1069px;*/
    /*    display: block;*/
    /*}*/

    #schedule_detail_box .day_spot_item{
      margin: 0;
      border: 0;
      font-size: 100%;
      font: inherit;
      box-sizing: border-box;
      padding: 15px;
      cursor: move;
      border-bottom: solid #a7a7a7 1px;
      background: #fff;
      width: 100%;
      position: relative;
    }
    /*------------------------------clone------------------------------*

</style>
</head>

<%-------------------------------- 카테고리 -----------------------------------%>
<body onload="script();">

<div class="map_wrap">
  <div id="map" style="width:100%;height:100vh;position:relative;overflow:hidden;"></div>
  <%--    100vh--%>

  <div id="menu_wrap" class="bg_white">
    <div id="on_city_close_btn"></div>
    <div class="sticky-top">
      <div class="city_name">${city.name}
        <div id="on_city_close_btn"></div>
      </div>
      <div class="search">
        <form onsubmit="searchPlaces2(); return false;">
          <input type="text" class="textbox form-control" placeholder="키워드를 입력하세요." id="keyword"
                 value="서울 여행">
          <button id="button-addon1" type="submit" class="btn btn-link text-primary"><i
                  class="fa fa-search"></i></button>
          <%--            <input title="Search" value="" type="submit" class="button">--%>
        </form>
      </div>

      <ul id="category">
        <li id="all" data-order="1">
          <span class="category_bg store"></span>
          전체
        </li>
        <li id="AD5" data-order="2">
          <span class="category_bg pharmacy"></span>
          숙박시설
        </li>
        <li id="AT4" data-order="3">
          <span class="category_bg oil"></span>
          관광명소
        </li>
        <li id="FD6" data-order="4">
          <span class="category_bg cafe"></span>
          음식점
        </li>
      </ul>
    </div>

    <div class="option"></div>
    <hr>
    <ul id="placesList"></ul>
    <div id="pagination"></div>
  </div>
  <div id="on_city_open_btn"></div>
  <!--------------------------------------     상세 페이지   ---------------------------->
  <div id="detail-box" style="display:none;">

    <!-- -->
    <iframe id='detail'
            name=naver onload="naver.scrollTo(40,100);"
            class="embed-responsive embed-responsive-16by9"
            style="-webkit-transform:scale(0.7);"
            src=''
            frameborder='0'
            scrolling='yes'>
      <!--  onload="this.style.height=(this.contentWindow.document.body.scrollHeight+20)+'px';">-->
      <%--        <button id="xdetail2" type="button" class="btn-close" aria-label="Close">X</button>--%>
    </iframe>

    <div id="detailbtns">
      <button id="xdetail" type="button">
        <img id="xdetailimg"
             src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pg0KPCEtLSBHZW5lcmF0b3I6IEFkb2JlIElsbHVzdHJhdG9yIDE5LjAuMCwgU1ZHIEV4cG9ydCBQbHVnLUluIC4gU1ZHIFZlcnNpb246IDYuMDAgQnVpbGQgMCkgIC0tPg0KPHN2ZyB2ZXJzaW9uPSIxLjEiIGlkPSJMYXllcl8xIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHhtbG5zOnhsaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rIiB4PSIwcHgiIHk9IjBweCINCgkgdmlld0JveD0iMCAwIDM3OC4zMDIgMzc4LjMwMiIgc3R5bGU9ImVuYWJsZS1iYWNrZ3JvdW5kOm5ldyAwIDAgMzc4LjMwMiAzNzguMzAyOyIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+DQo8cG9seWdvbiBzdHlsZT0iZmlsbDojMjQ4OEZGOyIgcG9pbnRzPSIzNzguMzAyLDI4LjI4NCAzNTAuMDE3LDAgMTg5LjE1MSwxNjAuODY3IDI4LjI4NCwwIDAsMjguMjg0IDE2MC44NjYsMTg5LjE1MSAwLDM1MC4wMTggDQoJMjguMjg0LDM3OC4zMDIgMTg5LjE1MSwyMTcuNDM2IDM1MC4wMTcsMzc4LjMwMiAzNzguMzAyLDM1MC4wMTggMjE3LjQzNSwxODkuMTUxICIvPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPC9zdmc+DQo="/>
        창 닫기
      </button>
      <%---------------------- 일정추가  rdate + 전체 일정 dto 추가----------------------------%>
      <div id="addplan" class="noshow">
        <form method="POST" action="/SIST2_Travel/plan/planadd.do">
          <!-- 	            <span><img src=""></span>
                          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                               class="bi bi-check-lg" viewBox="0 0 16 16">
                              <path d="M13.485 1.431a1.473 1.473 0 0 1 2.104 2.062l-7.84 9.801a1.473 1.473 0 0 1-2.12.04L.431 8.138a1.473 1.473 0 0 1 2.084-2.083l4.111 4.112 6.82-8.69a.486.486 0 0 1 .04-.045z"/>
                          </svg> -->
          <input type="hidden" id="address_name" name="address_name" value="">
          <input type="hidden" id="category_group_code" name="category_group_code" value="">
          <input type="hidden" id="category_group_name" name="category_group_name" value="">
          <input type="hidden" id="category_name" name="category_name" value="">
          <input type="hidden" id="id" name="id" value="">
          <input type="hidden" id="phone" name="phone" value="">
          <input type="hidden" id="place_name" name="place_name" value="">
          <input type="hidden" id="place_url" name="place_url" value="">
          <input type="hidden" id="road_address_name" name="road_address_name" value="">
          <input type="hidden" id="x" name="x" value="">
          <input type="hidden" id="y" name="y" value="">

          <input type="hidden" id="rdateadd" name="rdate" value="${rdate}">

          <input type="hidden" name="cityname" value="${city.name}">
          <input type="hidden" name="cityX" value="${city.cityX}">
          <input type="hidden" name="cityY" value="${city.cityY}">
          <input type="hidden" name="Explain" value="${city.explain}">
          <input type="hidden" name="Cityseq" value="${city.cityseq}">


          <input type="hidden" name="planname" value="${citydto.name}">
          <input type="hidden" name="dayendtravel" value="${citydto.dayendtravel}">
          <input type="hidden" name="daystarttravel" value="${citydto.daystarttravel}">
          <input type="hidden" name="willshare" value="${citydto.willshare}">


          <c:forEach items="${datelist}" var="list">
            <input type="hidden" name="datelist" value="${list}">
          </c:forEach>

          <button id="addplanbtn" type="submit">
            <img id="addplanimg"
                 src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pg0KPCEtLSBHZW5lcmF0b3I6IEFkb2JlIElsbHVzdHJhdG9yIDE5LjAuMCwgU1ZHIEV4cG9ydCBQbHVnLUluIC4gU1ZHIFZlcnNpb246IDYuMDAgQnVpbGQgMCkgIC0tPg0KPHN2ZyB2ZXJzaW9uPSIxLjEiIGlkPSJMYXllcl8xIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHhtbG5zOnhsaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rIiB4PSIwcHgiIHk9IjBweCINCgkgdmlld0JveD0iMCAwIDQ5NSA0OTUiIHN0eWxlPSJlbmFibGUtYmFja2dyb3VuZDpuZXcgMCAwIDQ5NSA0OTU7IiB4bWw6c3BhY2U9InByZXNlcnZlIj4NCjxnPg0KCTxwb2x5Z29uIHN0eWxlPSJmaWxsOiNCRERCRkY7IiBwb2ludHM9IjIyNy41LDM3OS4xMzMgMjI3LjUsMjY3LjUgMTE1Ljg2NSwyNjcuNSAxMTUuODY1LDIyNy41IDIyNy41LDIyNy41IDIyNy41LDExNS44NjcgDQoJCTI0Ny41LDExNS44NjcgMjQ3LjUsMCAwLDAgMCw0OTUgMjQ3LjUsNDk1IDI0Ny41LDM3OS4xMzMgCSIvPg0KCTxwb2x5Z29uIHN0eWxlPSJmaWxsOiM5QkM5RkY7IiBwb2ludHM9IjI0Ny41LDAgMjQ3LjUsMTE1Ljg2NyAyNjcuNSwxMTUuODY3IDI2Ny41LDIyNy41IDM3OS4xMzUsMjI3LjUgMzc5LjEzNSwyNjcuNSAyNjcuNSwyNjcuNSANCgkJMjY3LjUsMzc5LjEzMyAyNDcuNSwzNzkuMTMzIDI0Ny41LDQ5NSA0OTUsNDk1IDQ5NSwwIAkiLz4NCgk8cG9seWdvbiBzdHlsZT0iZmlsbDojMjQ4OEZGOyIgcG9pbnRzPSIyMjcuNSwyMjcuNSAxMTUuODY1LDIyNy41IDExNS44NjUsMjY3LjUgMjI3LjUsMjY3LjUgMjI3LjUsMzc5LjEzMyAyNjcuNSwzNzkuMTMzIA0KCQkyNjcuNSwyNjcuNSAzNzkuMTM1LDI2Ny41IDM3OS4xMzUsMjI3LjUgMjY3LjUsMjI3LjUgMjY3LjUsMTE1Ljg2NyAyMjcuNSwxMTUuODY3IAkiLz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjwvc3ZnPg0K"/>
            일정 추가
          </button>
        </form>
      </div>


      <%-------------------------- 찜추가 ----------------------------%>
      <div id="addWish" class="noshow">
        <!-- <a href="!#">
            <span><img src=""></span>
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-lg"
                 viewBox="0 0 16 16">
                <path d="M13.485 1.431a1.473 1.473 0 0 1 2.104 2.062l-7.84 9.801a1.473 1.473 0 0 1-2.12.04L.431 8.138a1.473 1.473 0 0 1 2.084-2.083l4.111 4.112 6.82-8.69a.486.486 0 0 1 .04-.045z"/>
            </svg>
        </a> -->
        <button type="button" id="addWishbtn">
          <img id="addwishimg"
               src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pg0KPCEtLSBHZW5lcmF0b3I6IEFkb2JlIElsbHVzdHJhdG9yIDE5LjAuMCwgU1ZHIEV4cG9ydCBQbHVnLUluIC4gU1ZHIFZlcnNpb246IDYuMDAgQnVpbGQgMCkgIC0tPg0KPHN2ZyB2ZXJzaW9uPSIxLjEiIGlkPSJMYXllcl8xIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHhtbG5zOnhsaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rIiB4PSIwcHgiIHk9IjBweCINCgkgdmlld0JveD0iMCAwIDUwMS4yOCA1MDEuMjgiIHN0eWxlPSJlbmFibGUtYmFja2dyb3VuZDpuZXcgMCAwIDUwMS4yOCA1MDEuMjg7IiB4bWw6c3BhY2U9InByZXNlcnZlIj4NCjxnPg0KCTxwb2x5Z29uIHN0eWxlPSJmaWxsOiNGRkNEMDA7IiBwb2ludHM9IjUwMS4yOCwxOTQuMzcgMzM1LjI2LDE1OS4zMyAyNTAuNjQsMTIuMjcgMjUwLjY0LDQxOS43NyA0MDUuNTQsNDg5LjAxIDM4Ny41NiwzMjAuMjkgCSIvPg0KCTxwb2x5Z29uIHN0eWxlPSJmaWxsOiNGRkRBNDQ7IiBwb2ludHM9IjE2Ni4wMiwxNTkuMzMgMCwxOTQuMzcgMTEzLjcyLDMyMC4yOSA5NS43NCw0ODkuMDEgMjUwLjY0LDQxOS43NyAyNTAuNjQsMTIuMjcgCSIvPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPC9zdmc+DQo="/>
          찜 추가
        </button>
      </div>
    </div>
  </div>

</div>

<%----------------------------- 추가된 일정 리스트 ----------------------------%>
<form id="getlist" method="POST" action="/SIST2_Travel/plan/plandel.do">

  <div class="plan sortable" id="planlist">
    <%-------------------------------일정 등록 완료------------------------%>
    <div>
      <%--            TODO: 이거 쪼개놨는데.... 2중 form 쪼개주실수 있나요?--%>
      <form id="getlist" method="POST" action="/SIST2_Travel/plan/plandone.do">
        <c:forEach items="${list}" var="dto" varStatus="status">
          <input type="hidden" name="plan2seq" value="${dto.plan2seq}">
          <input type="hidden" name="cityname" value="${city.name}">
          <input type="hidden" name="cityX" value="${city.cityX}">
          <input type="hidden" name="cityY" value="${city.cityY}">
          <input type="hidden" name="Explain" value="${city.explain}">
          <input type="hidden" name="Cityseq" value="${city.cityseq}">
          <input type="hidden" name="planname" value="${citydto.name}">
          <input type="hidden" name="dayendtravel" value="${citydto.dayendtravel}">
          <input type="hidden" name="daystarttravel" value="${citydto.daystarttravel}">
          <input type="hidden" name="willshare" value="${citydto.willshare}">

          <c:forEach items="${datelist}" var="list">
            <input type="hidden" name="datelist" value="${list}">
          </c:forEach>
          <input type="hidden" name="planseq" value="${dto.plan2seq}">
          <input type="hidden" name="seq" value="${status.count}">
        </c:forEach>
        <input class="btn btn-primary" type="submit" value="일정 등록 완료" id="complete">
      </form>
    </div>
    <%--------------------------------------------------------------------%>



    <div class="list-group">
      <div class="list-group-item list-group-item-action">
        <%--                    <div id="seqname">${status.index}</div>--%>
        <%--                    <div class="d-flex w-100 justify-content-between" data-seq="${status.index}">--%>
        <%--                        <h5 class="mb-1" style="font-size: 16px; font-weight: bold;">${dto.place_name}</h5>--%>
        <%--                        <small class="text-muted">${dto.category_group_name}</small>--%>
        <%--                    </div>--%>
        <%--                    <p class="mb-1">${dto.address_name}</p>--%>
        <%--                    <button type="submit" class="close" aria-label="Close" style="float:right;">--%>
        <%--                        <span aria-hidden="true"><i class="fas fa-times"></i></span>--%>
        <%--                    </button>--%>
        <div class="fl" id="schedule_full_box" style="width:265px" data="0">
          <div class="title_box">
            <div id="schedule_detail_title" data-date="08-05" style="display: block;">
              <div class="fl schedule_detail_title_text"
                   style="width:245px;padding-left:10px;font-size:15px;">
                <div class="fl">DAY1 <span style="color:#999999">|</span> 08.05(목요일)</div>
                <div class="fl day_reset_btn" onclick="del_plan_inspot_day_all()"></div>
                <div class="fr day_next_btn" onclick="plan_day_next()"></div>
                <div class="fr day_prev_btn" onclick="plan_day_prev()"></div>
                <div class="clear"></div>
              </div>
              <div class="clear"></div>
            </div>
          </div>


          <div id="day_controll_btn_box">
            <!-- <div id="day_reset_btn" class="fl" onclick="del_plan_inspot_day_all()">일정초기화</div> -->
            <div id="day_optimize_btn" class="fl" onclick="optimize_route()">경로최적화</div>
            <div class="clear"></div>
          </div>

          <!--//(s)스케쥴 디테일 리스트-->
          <div id="schedule_detail_box" class="connectedSortable ui-sortable"
               style="height: 1082px; display: block;">
            <c:forEach items="${list}" var="dto" varStatus="status">
            <div class="day_spot_item" data="1" data-set_day="1" data-rel_srl="7561" data-pl_type="0"
                 data-no="0" data-pl_cat="301" data-latlng="35.09602400,129.00935400" data-ci="311">
              <div class="item_ctrl_box" style="display: none;">
                <div class="fl item_copy_plan" title="장소복사"><img
                        src="/res/img/workspace/new/item_more_icon_a.pngd"></div>
                <div class="fl item_set_plan" title="메모&amp;예산"><img
                        src="/res/img/workspace/new/item_set_icon_a.pngd"></div>
                <div class="fl btn_del" title="삭제"><img
                        src="/res/img/workspace/new/item_del_icon_a.pngd"></div>
                <div class="clear"></div>
              </div>
              <div class="img_box fl">
                <div class="spot_order_box">1</div>
                <img src="http://img.earthtory.com/img/place_img/311/7561_0_et.jpgd">
                <div style="position:absolute;top:35px;left:40px;width:22px;height:20px;"><img
                        src="/res/img/workspace/list_memo_btn_off.pngd" class="memo_indi"
                        style="width:22px;height:20px;"></div>
              </div>
              <div class="fl info_box">
                <div class="title">감천 문화 마을</div>
                <div class="sub">유명한거리/지역, 이색장소</div>
                <div class="sub inspot_day_info_box" style="color:#1a7ad9"></div>
              </div>
              <div class="clear"></div>
            </div>
            <div class="day_spot_item" data="2" data-set_day="1" data-rel_srl="7566" data-pl_type="0"
                 data-no="1" data-pl_cat="301" data-latlng="35.15890900,129.16072100" data-ci="311">
              <div class="item_ctrl_box" style="display: none;">
                <div class="fl item_copy_plan" title="장소복사"><img
                        src="/res/img/workspace/new/item_more_icon_a.pngd"></div>
                <div class="fl item_set_plan" title="메모&amp;예산"><img
                        src="/res/img/workspace/new/item_set_icon_a.pngd"></div>
                <div class="fl btn_del" title="삭제"><img
                        src="/res/img/workspace/new/item_del_icon_a.pngd"></div>
                <div class="clear"></div>
              </div>
              <div class="spot_distance_box"
                   onclick="et_modal('620px','700px','1','0','/ko/modal/directions?from_latlng=35.09602400,129.00935400&amp;from_name=감천 문화 마을&amp;to_latlng=35.15890900,129.16072100&amp;to_name=해운대','2','1')">
                15.43Km 추천경로
              </div>
              <div class="img_box fl">
                <div class="spot_order_box">2</div>
                <img src="http://img.earthtory.com/img/place_img/311/7566_0_et.jpgd">
                <div style="position:absolute;top:35px;left:40px;width:22px;height:20px;"><img
                        src="/res/img/workspace/list_memo_btn_off.pngd" class="memo_indi"
                        style="width:22px;height:20px;"></div>
              </div>
              <div class="fl info_box">
                <div class="title">해운대</div>
                <div class="sub">랜드마크, 해변/항구</div>
                <div class="sub inspot_day_info_box" style="color:#1a7ad9"></div>
              </div>
              <div class="clear"></div>
            </div>
            <div class="day_spot_item" data="3" data-set_day="1" data-rel_srl="7566" data-pl_type="0"
                 data-no="2" data-pl_cat="301" data-latlng="35.15890900,129.16072100" data-ci="311">
              <div class="item_ctrl_box" style="display: none;">
                <div class="fl item_copy_plan" title="장소복사"><img
                        src="/res/img/workspace/new/item_more_icon_a.pngd"></div>
                <div class="fl item_set_plan" title="메모&amp;예산"><img
                        src="/res/img/workspace/new/item_set_icon_a.pngd"></div>
                <div class="fl btn_del" title="삭제"><img
                        src="/res/img/workspace/new/item_del_icon_a.pngd"></div>
                <div class="clear"></div>
              </div>
              <div class="spot_distance_box"
                   onclick="et_modal('620px','700px','1','0','/ko/modal/directions?from_latlng=35.15890900,129.16072100&amp;from_name=해운대&amp;to_latlng=35.15890900,129.16072100&amp;to_name=해운대','2','1')">
                0.00Km 추천경로
              </div>
              <div class="img_box fl">
                <div class="spot_order_box">3</div>
                <img src="http://img.earthtory.com/img/place_img/311/7566_0_et.jpgd">
                <div style="position:absolute;top:35px;left:40px;width:22px;height:20px;"><img
                        src="/res/img/workspace/list_memo_btn_off.pngd" class="memo_indi"
                        style="width:22px;height:20px;"></div>
              </div>
              <div class="fl info_box">
                <div class="title">해운대</div>
                <div class="sub">랜드마크, 해변/항구</div>
                <div class="sub inspot_day_info_box" style="color:#1a7ad9"></div>
              </div>
              <div class="clear"></div>
            </div>
          </div>
          <!--//(e)스케쥴 디테일 리스트-->
          <div class="inspot_add_box">
            <div class="inspot_set_box">
              <div class="fl add_inspot_spot_btn" onclick="my_spot_inspot()">+ My 장소</div>
              <div class="fl add_inspot_trans_btn" onclick="my_transportation_inspot()">+ 교통</div>
              <div class="clear"></div>
            </div>
          </div>
          </c:forEach>

        </div>
        <input type="hidden" name="plan2seq" value="${dto.plan2seq}">
        <input type="hidden" name="cityname" value="${city.name}">
        <input type="hidden" name="cityX" value="${city.cityX}">
        <input type="hidden" name="cityY" value="${city.cityY}">
        <input type="hidden" name="Explain" value="${city.explain}">
        <input type="hidden" name="Cityseq" value="${city.cityseq}">
        <input type="hidden" name="planname" value="${citydto.name}">
        <input type="hidden" name="dayendtravel" value="${citydto.dayendtravel}">
        <input type="hidden" name="daystarttravel" value="${citydto.daystarttravel}">
        <input type="hidden" name="willshare" value="${citydto.willshare}">

        <%--<input type="hidden" name="datelist" value="${datelist}">--%>
      </div>
      <input type="hidden" name="planseq" value="${dto.plan2seq}">
      <input type="hidden" name="seq" value="${status.count}">
    </div>

  </div>
  <c:forEach items="${datelist}" var="list">
    <input type="hidden" name="datelist" value="${list}">
  </c:forEach>

</form>


<%---------------------------------일정---------------------------------%>
<div id="schedule" class="list-group list-group-flush border-bottom scrollarea">
  <form method="POST" action="/SIST2_Travel/plan/planinfo.do">

    <%--        <a href="#" class="list-group-item list-group-item-action active py-3 lh-tight" aria-current="true">--%>
    <%--            <div class="w-100 align-items-center justify-content-between">--%>
    <%--                <strong class="mb-1">전체 일정</strong>--%>
    <%--                <div>일정 이름: <input type="text" id="name" name="name" autocomplete="off" value="${citydto.name}"></div>--%>

    <%--                <label for="from">From</label>--%>
    <%--                <input type="text" id="from" name="daystarttravel" value="${citydto.daystarttravel}">--%>
    <%--                <br>--%>
    <%--                <label for="to">to</label>--%>
    <%--                <input type="text" id="to" name="dayendtravel" value="${citydto.dayendtravel}">--%>

    <%--            </div>--%>
    <%--            <div class="w-100 align-items-center justify-content-between">--%>
    <%--                <fieldset>--%>
    <%--                    <select style="width:200px;" name="cityseq">--%>
    <%--                        <c:forEach items='${citys}' var="citys">--%>
    <%--                            <option value="${city.name}">${citys.name}</option>--%>
    <%--                        </c:forEach>--%>
    <%--                    </select>--%>
    <%--                </fieldset>--%>

    <%--            </div>--%>
    <%--            <div class="col-10 mb-1 small">공유여부:--%>

    <%--                <div class="form-check">--%>
    <%--                    <input class="form-check-input" type="radio" name="willshare" id="flexRadioDefault1" value="y"--%>
    <%--                           checked>--%>
    <%--                    <label class="form-check-label" for="flexRadioDefault1">--%>
    <%--                        공유함--%>
    <%--                    </label>--%>
    <%--                </div>--%>
    <%--                <div class="form-check">--%>
    <%--                    <input class="form-check-input" type="radio" name="willshare" id="flexRadioDefault2" value="n">--%>
    <%--                    <label class="form-check-label" for="flexRadioDefault2">--%>
    <%--                        공유안함--%>
    <%--                    </label>--%>
    <%--                </div>--%>
    <%--            </div>--%>
    <%--            <input type="submit" value="일정 설정 완료">--%>
    <%--        </a>--%>
  </form>
  <%--    ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ전체일정ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ--%>
  <div class="fl">
    <ul id="pn_title_box">
      <li data="pn_date">
        <div class="full_date_info fl">08.5~08.6</div>
        <div class="fl day_edit_start_btn">EDIT</div>
        <div class="clear"></div>
      </li>
    </ul>
    <ul id="cat_menu" style="max-height: 983px;" data-year="2021">
      <li id="show_all_day" data="show_all_day">전체 일정 보기</li>
      <c:forEach items="${datelist}" var="list" varStatus="status">
        <c:if test="${status.count==1}">
          <li data="${status.count}" data-date="08.05" data-day_week="4" class="on">
        </c:if>
        <c:if test="${status.count!=1}">
          <li data="${status.count}" data-date="08.05" data-day_week="4">
        </c:if>
        <div class="fl cat_date_left_box">
          <div class="cat_left_day">DAY${status.count}</div>
          <div class="cat_left_date">${list}</div>
        </div>
        <div class="fl cat_date_right_box">
            <%--                        day of week--%>
          <div class="cat_right_weekday">목요일</div>
          <div class="cat_right_city">${city.name}</div>
        </div>
        <div class="clear"></div>
        </li>
      </c:forEach>
    </ul>
    <ul id="cat_add_box"
        style="width: 160px; background: rgb(32, 51, 65); color: rgb(255, 255, 255); height: 823px;">
      <li style="padding-top:15px;">
        <%--                <div style="width:124px;height:32px;line-height:32px;border:solid 1px #fff;text-align:center;margin:0 auto;cursor:pointer;">--%>
        <%--                    DAY 추가--%>
        <%--                </div>--%>
      </li>
    </ul>
    <ul id="pn_date_controll_box">
      <li data="con_date">
        <div style="text-align:center;border-top:solid #fff 1px;margin-top:10px;padding-top:15px;width:100%;">
          <div style="margin:0 auto;text-align:center;font-size:15px;">
            <img src="/res/img/workspace/new/cat_tuto_icon.png"
                 style="vertical-align:middle;margin-right:5px;"> 이용방법
          </div>
        </div>
      </li>
    </ul>
  </div>
  <c:forEach items="${datelist}" var="list" varStatus="status">
  <div id="schedulelist" class="list-group">
    <form id="my_form" method="POST" action="/SIST2_Travel/plan/planscd.do">
        <%--            <input type="submit" value="${'Day'} ${status.count} ${list}" class="btn btn-primary">--%>

        <%--            <div class="d-flex w-100 align-items-center justify-content-between">--%>
        <%--                <strong class="mb-1">${"Day"} ${status.count}</strong>--%>
        <%--                <small>${list}</small>--%>
        <%--            </div>--%>
        <%--            <div class="col-10 mb-1 small">${city.name}</div>--%>
      <!-- </a> -->
      <input type="hidden" name="city" value="${city}">

      <input type="hidden" name="cityname" value="${city.name}">
      <input id="currX" type="hidden" name="cityX" value="${city.cityX}">
      <input id="currY" type="hidden" name="cityY" value="${city.cityY}">
      <input type="hidden" name="Explain" value="${city.explain}">
      <input type="hidden" name="Cityseq" value="${city.cityseq}">


      <input type="hidden" name="planname" value="${citydto.name}">
      <input type="hidden" name="dayendtravel" value="${citydto.dayendtravel}">
      <input type="hidden" name="daystarttravel" value="${citydto.daystarttravel}">
      <input type="hidden" name="willshare" value="${citydto.willshare}">

        <%--            <input type="text" name="rdate" value="">--%>
      <input type="hidden" name="rdate" id="rdate" value="${list}">
      <c:forEach items="${datelist}" var="list" varStatus="status">
        <input type="hidden" name="datelist" value="${list}">
      </c:forEach>
    </form>
    </c:forEach>

  </div>

  <%--------------------------------------------------JS----------------------------------------------------------%>
  <script>
    $("#placesList").click(function () {
      $("#detail").show();
      $("#detail-box").show();
      $("#xdetail").show();
      $("#addplanbtn").show();
      $("#addWishbtn").show();
      $("#detailbtns").show();
    });
    $("#xdetail").click(function () {
      $("#detail-box").hide();
      $("#detail").hide();
      $("#xdetail").hide();
      $("#addplanbtn").hide();
      $("#addWishbtn").hide();
      $("#detailbtns").hide();
    });

  </script>
  <script>
    $(function () {
      var dateFormat = "yy-mm-dd",
              from = $("#from")
                      .datepicker({
                        defaultDate: "+1w",
                        changeMonth: true,
                        numberOfMonths: 1,
                        dateFormat: 'yy-mm-dd'
                      })
                      .on("change", function () {
                        to.datepicker("option", "minDate", getDate(this));
                      }),
              to = $("#to").datepicker({
                defaultDate: "+1w",
                changeMonth: true,
                numberOfMonths: 1,
                dateFormat: 'yy-mm-dd'
              })
                      .on("change", function () {
                        from.datepicker("option", "maxDate", getDate(this));
                      });

      function getDate(element) {
        var regdate;
        try {
          regdate = $.datepicker.parseDate(dateFormat, element.value);
        } catch (error) {
          regdate = null;
        }

        return regdate;
      }
    });
  </script>
  <%--    <script language='javascript'>--%>

  <%--        function noEvent() {--%>
  <%--            if (event.keyCode == 116) {--%>
  <%--                event.keyCode = 2;--%>
  <%--                return false;--%>
  <%--            } else if (event.ctrlKey && (event.keyCode == 78 || event.keyCode == 82)) {--%>
  <%--                return false;--%>
  <%--            }--%>
  <%--        }--%>

  <%--        document.onkeydown = noEvent;--%>
  <%--    </script>--%>
  <%---------------------------------지도---------------------------------%>

  <script type="text/javascript"
          src="//dapi.kakao.com/v2/maps/sdk.js?appkey=146e5efa152999d1970430f4e8202734&libraries=services"></script>
  <script>
    window.onload = function () {
      $('#all').trigger("click");
    }
    // 마커를 클릭했을 때 해당 장소의 상세정보를 보여줄 커스텀오버레이입니다
    var placeOverlay = new kakao.maps.CustomOverlay({zIndex: 1}),
            contentNode = document.createElement('div'), // 커스텀 오버레이의 컨텐츠 엘리먼트 입니다
            markers = [], // 마커를 담을 배열입니다
            currCategory = ''; // 현재 선택된 카테고리를 가지고 있을 변수입니다

    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
            mapOption = {
              center: new kakao.maps.LatLng(${city.cityY}, ${city.cityX}), // 지도의 중심좌표   ${city.cityX}
              level: 7 // 지도의 확대 레벨

            };

    // 지도를 생성합니다
    var map = new kakao.maps.Map(mapContainer, mapOption);

    // 장소 검색 객체를 생성합니다
    var ps = new kakao.maps.services.Places(map);

    // 지도에 idle 이벤트를 등록합니다
    kakao.maps.event.addListener(map, 'idle', searchPlaces);

    // 커스텀 오버레이의 컨텐츠 노드에 css class를 추가합니다
    contentNode.className = 'placeinfo_wrap';

    // 커스텀 오버레이의 컨텐츠 노드에 mousedown, touchstart 이벤트가 발생했을때
    // 지도 객체에 이벤트가 전달되지 않도록 이벤트 핸들러로 kakao.maps.event.preventMap 메소드를 등록합니다
    addEventHandle(contentNode, 'mousedown', kakao.maps.event.preventMap);
    addEventHandle(contentNode, 'touchstart', kakao.maps.event.preventMap);

    // 커스텀 오버레이 컨텐츠를 설정합니다
    placeOverlay.setContent(contentNode);

    // 각 카테고리에 클릭 이벤트를 등록합니다
    addCategoryClickEvent();

    // 엘리먼트에 이벤트 핸들러를 등록하는 함수입니다
    function addEventHandle(target, type, callback) {
      if (target.addEventListener) {
        target.addEventListener(type, callback);
      } else {
        target.attachEvent('on' + type, callback);
      }
    }

    ////////////////////////////////키워드 검색 시작
    searchPlaces2();

    function searchPlaces2() {

      var keyword = document.getElementById('keyword').value;

      if (!keyword.replace(/^\s+|\s+$/g, '')) {
        alert('키워드를 입력해주세요!');
        return false;
      }

      // 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
      ps.keywordSearch(keyword, placesSearchCB2);
    }

    function placesSearchCB2(data, status, pagination) {
      if (status === kakao.maps.services.Status.OK) {

        // 정상적으로 검색이 완료됐으면
        // 검색 목록과 마커를 표출합니다
        displayPlaces2(data);

        // 페이지 번호를 표출합니다
        displayPagination(pagination);

      } else if (status === kakao.maps.services.Status.ZERO_RESULT) {

        alert('검색 결과가 존재하지 않습니다.');
        return;

      } else if (status === kakao.maps.services.Status.ERROR) {

        alert('검색 결과 중 오류가 발생했습니다.');
        return;

      }
    }

    function displayPlaces2(places) {

      var listEl = document.getElementById('placesList'),
              menuEl = document.getElementById('menu_wrap'),
              fragment = document.createDocumentFragment(),
              bounds = new kakao.maps.LatLngBounds(),
              listStr = '';

      // 검색 결과 목록에 추가된 항목들을 제거합니다
      removeAllChildNods(listEl);

      // 지도에 표시되고 있는 마커를 제거합니다
      removeMarker();

      for (var i = 0; i < places.length; i++) {

        // 마커를 생성하고 지도에 표시합니다
        var placePosition = new kakao.maps.LatLng(places[i].y, places[i].x),
                marker = addMarker(placePosition, i),
                itemEl = getListItem(i, places[i]); // 검색 결과 항목 Element를 생성합니다

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
        // LatLngBounds 객체에 좌표를 추가합니다
        bounds.extend(placePosition);

        // 마커와 검색결과 항목에 mouseover 했을때
        // 해당 장소에 인포윈도우에 장소명을 표시합니다
        // mouseout 했을 때는 인포윈도우를 닫습니다
        (function (marker, title) {
          kakao.maps.event.addListener(marker, 'mouseover', function () {
            displayInfowindow(marker, title);
          });

          kakao.maps.event.addListener(marker, 'mouseout', function () {
            infowindow.close();
          });

          itemEl.onmouseover = function () {
            displayInfowindow(marker, title);
          };

          itemEl.onmouseout = function () {
            infowindow.close();
          };
        })(marker, places[i].place_name);

        fragment.appendChild(itemEl);
      }

      // 검색결과 항목들을 검색결과 목록 Elemnet에 추가합니다
      listEl.appendChild(fragment);
      menuEl.scrollTop = 0;

      // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
      map.setBounds(bounds);
    }

    function displayPagination(pagination) {
      var paginationEl = document.getElementById('pagination'),
              fragment = document.createDocumentFragment(),
              i;

      // 기존에 추가된 페이지번호를 삭제합니다
      while (paginationEl.hasChildNodes()) {
        paginationEl.removeChild(paginationEl.lastChild);
      }

      for (i = 1; i <= pagination.last; i++) {
        var el = document.createElement('a');
        el.href = "#";
        el.innerHTML = i;

        if (i === pagination.current) {
          el.className = 'on';
        } else {
          el.onclick = (function (i) {
            return function () {
              pagination.gotoPage(i);
            }
          })(i);
        }

        fragment.appendChild(el);
      }
      paginationEl.appendChild(fragment);
    }

    //////////////////////////////////////////키워드 검색 끝
    // 카테고리 검색을 요청하는 함수입니다
    function searchPlaces() {
      if (!currCategory) {
        // searchAll();
      }

      // 커스텀 오버레이를 숨깁니다
      placeOverlay.setMap(null);

      // 지도에 표시되고 있는 마커를 제거합니다
      removeMarker();
      // console.log(currCategory);
      if (currCategory == 'all') {
        ps.categorySearch(['AD5', 'AT4', 'FD6'], placesSearchCB, {useMapBounds: true});
      }
      ps.categorySearch(currCategory, placesSearchCB, {useMapBounds: true});
    }


    // 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
    function placesSearchCB(data, status, pagination) {
      if (status === kakao.maps.services.Status.OK) {

        // 정상적으로 검색이 완료됐으면 지도에 마커를 표출합니다
        displayPlaces(data);
        // console.log(data);
      } else if (status === kakao.maps.services.Status.ZERO_RESULT) {
        // 검색결과가 없는경우 해야할 처리가 있다면 이곳에 작성해 주세요

      } else if (status === kakao.maps.services.Status.ERROR) {
        // 에러로 인해 검색결과가 나오지 않은 경우 해야할 처리가 있다면 이곳에 작성해 주세요

      }
    }

    // 지도에 마커를 표출하는 함수입니다
    function displayPlaces(places) {
      // console.log(currCategory);
      // 몇번째 카테고리가 선택되어 있는지 얻어옵니다
      // 이 순서는 스프라이트 이미지에서의 위치를 계산하는데 사용됩니다
      var order = document.getElementById(currCategory).getAttribute('data-order');

      var listEl = document.getElementById('placesList'),
              menuEl = document.getElementById('menu_wrap'),
              fragment = document.createDocumentFragment(),
              bounds = new kakao.maps.LatLngBounds(),
              listStr = '';

      removeAllChildNods(listEl);
      removeMarker();
      for (var i = 0; i < places.length; i++) {
        var placePosition = new kakao.maps.LatLng(places[i].y, places[i].x);
        // console.log('!' + places[i].place_url);
        itemEl = getListItem(i, places[i]);
        // console.log(itemEl);
        var url = places[i].place_url;
        // 마커를 생성하고 지도에 표시합니다
        var marker = addMarker(new kakao.maps.LatLng(places[i].y, places[i].x), order, places[i].category_group_code);


        bounds.extend(placePosition);
        (function (marker,
                   address_name,
                   category_group_code,
                   category_group_name,
                   category_name,
                   id,
                   phone,
                   title,
                   place_url,
                   road_address_name,
                   x,
                   y) {
          kakao.maps.event.addListener(marker, 'mouseover', function () {
            displayInfowindow(marker, title);
          });

          kakao.maps.event.addListener(marker, 'mouseout', function () {
            infowindow.close();
          });

          itemEl.onmouseover = function () {
            displayInfowindow(marker, title);
          };

          itemEl.onmouseout = function () {
            infowindow.close();
          };
          itemEl.onclick = function () {
            // console.log(url);
            // console.log(places[i].place_url);
            //얘가 안돼요.. Uncaught TypeError: Cannot read property 'place_url' of undefined at HTMLLIElement.itemEl.onclick

            //여기에서 바꿀까요?
            $('#address_name').val(address_name);
            console.log(address_name);
            $('#category_group_code').val(category_group_code);
            $('#category_group_name').val(category_group_name);
            $('#category_name').val(category_name);
            $('#id').val(id);
            $('#phone').val(phone);
            $('#place_name').val(title);
            $('#place_url').val(place_url);
            $('#road_address_name').val(road_address_name);
            $('#x').val(x);
            $('#y').val(y);
            // console.log('!!' + url); // <-- 얘가 undefined
            displayDetail(place_url);
          }
        })(marker,
                places[i].address_name,
                places[i].category_group_code,
                places[i].category_group_name,
                places[i].category_name,
                places[i].id,
                places[i].phone,
                places[i].place_name,
                places[i].place_url,
                places[i].road_address_name,
                places[i].x,
                places[i].y
        );

        fragment.appendChild(itemEl);

        // 마커와 검색결과 항목을 클릭 했을 때
        // 장소정보를 표출하도록 클릭 이벤트를 등록합니다
        (function (marker, place) {
          kakao.maps.event.addListener(marker, 'click', function () {
            displayPlaceInfo(place);
          });
        })(marker, places[i]);
      }
      listEl.appendChild(fragment);
      menuEl.scrollTop = 0;
    }

    //리스트를 클릭했을때 하는 행동
    function displayDetail(url) {


      $('#detail').attr('src', url); //iframe url을 넣어줌
      //iframe 내부요소를 조작해서 넣는방법 -> js로 코드를 받아와서 crawling 작업이 필요

      // <div id="addplan" class="noshow"></div>
      $('#addplan').addClass('show'); //버튼을 보여줌 위치는 우리가 css로 조작

    };


    var infowindow = new kakao.maps.InfoWindow({zIndex: 1});
    // 검색결과 목록 또는 마커를 클릭했을 때 호출되는 함수입니다
    // 인포윈도우에 장소명을 표시합니다
    function displayInfowindow(marker, title) {
      var content = '<div style="padding:5px;z-index:1;">' + title + '</div>';

      infowindow.setContent(content);
      infowindow.open(map, marker);
    }

    // 검색결과 항목을 Element로 반환하는 함수입니다
    function getListItem(index, places) {
      // console.log($("#detail").val());
      // console.log($("#mArticle > div.cont_essential > div:nth-child(1) > div.place_details > div > div > a:nth-child(3) > span.color_b").val());
      // console.log('@' + places);
      var el = document.createElement('li'),
              itemStr = '<span class="markerbg marker_' + (index + 1) + '"></span>' +
                      '<div class="info" style="font-size: 15px">' +
                      '   <h5 style="font-size: 15px; font-weight: bold;">' + places.place_name + '</h5>';

      if (places.road_address_name) {
        itemStr += '    <span style="font-size: 14px;">' + places.road_address_name + '</span>' +
                ' <span class=" gray" style="font-size: 14px;">' + places.category_group_name + '</span>';
      } else {
        itemStr += '    <span style="font-size: 14px;">' + places.category_group_name + '</span>';
      }

      itemStr += '  <span class="tel" style="color: CornflowerBlue">' + places.phone + '</span>' +
              '</div>';

      el.innerHTML = itemStr;
      el.className = 'item';

      return el;
    }

    function removeAllChildNods(el) {
      while (el.hasChildNodes()) {
        el.removeChild(el.lastChild);
      }
    }

    // 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
    function addMarker(position, order) {
      var imageSrc = '/SIST2_Travel/asset/images/places_category3.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
              imageSize = new kakao.maps.Size(27, 28),  // 마커 이미지의 크기
              imgOptions = {
                spriteSize: new kakao.maps.Size(72, 208), // 스프라이트 이미지의 크기
                spriteOrigin: new kakao.maps.Point(46, (order * 36)), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
                offset: new kakao.maps.Point(11, 28) // 마커 좌표에 일치시킬 이미지 내에서의 좌표
              },
              markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions),
              marker = new kakao.maps.Marker({
                position: position, // 마커의 위치
                image: markerImage
              });

      marker.setMap(map); // 지도 위에 마커를 표출합니다
      markers.push(marker);  // 배열에 생성된 마커를 추가합니다

      return marker;
    }

    // 지도 위에 표시되고 있는 마커를 모두 제거합니다
    function removeMarker() {
      for (var i = 0; i < markers.length; i++) {
        markers[i].setMap(null);
      }
      markers = [];
    }

    // 클릭한 마커에 대한 장소 상세정보를 커스텀 오버레이로 표시하는 함수입니다
    function displayPlaceInfo(place) {
      var content = '<div class="placeinfo">' +
              '   <a class="title" href="' + place.place_url + '" target="_blank" title="' + place.place_name + '">' + place.place_name + '</a>';

      if (place.road_address_name) {
        content += '    <span title="' + place.road_address_name + '">' + place.road_address_name + '</span>' +
                '  <span class="jibun" title="' + place.address_name + '">(지번 : ' + place.address_name + ')</span>';
      } else {
        content += '    <span title="' + place.address_name + '">' + place.address_name + '</span>';
      }

      content += '    <span class="tel">' + place.phone + '</span>' +
              '</div>' +
              '<div class="after"></div>';

      contentNode.innerHTML = content;
      placeOverlay.setPosition(new kakao.maps.LatLng(place.y, place.x));
      placeOverlay.setMap(map);
    }

    var linePath = [

      <c:forEach items="${list}" var="dto" varStatus="status">

      new kakao.maps.LatLng(${dto.y}, ${dto.x})
      <c:if test="${list.size()-1 > status.index}">
      ,
      </c:if>
      </c:forEach>

    ];


    var polyline = new kakao.maps.Polyline({
      path: linePath, // 선을 구성하는 좌표배열 입니다
      strokeWeight: 5, // 선의 두께 입니다
      strokeColor: '#FFAE00', // 선의 색깔입니다 #FFAE00
      strokeOpacity: 0.7, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
      strokeStyle: 'solid' // 선의 스타일입니다
    });

    // 지도에 선을 표시합니다
    polyline.setMap(map);

    // 각 카테고리에 클릭 이벤트를 등록합니다
    function addCategoryClickEvent() {
      var category = document.getElementById('category'),
              children = category.children;

      for (var i = 0; i < children.length; i++) {
        children[i].onclick = onClickCategory;
      }
    }

    // 카테고리를 클릭했을 때 호출되는 함수입니다
    function onClickCategory() {
      var id = this.id,
              className = this.className;

      placeOverlay.setMap(null);

      if (className === 'on') {
        currCategory = '';
        changeCategoryClass();
        removeMarker();
      } else {
        currCategory = id;
        changeCategoryClass(this);
        searchPlaces();
      }
    }

    // 클릭된 카테고리에만 클릭된 스타일을 적용하는 함수입니다
    function changeCategoryClass(el) {
      var category = document.getElementById('category'),
              children = category.children,
              i;

      for (i = 0; i < children.length; i++) {
        children[i].className = '';
      }

      if (el) {
        el.className = 'on';
      }
    }


    <%--------------------------------------------------------------------------%>

    $('.sortable').sortable({
      start: function (e, ui) {
        // creates a temporary attribute on the element with the old index
        $(this).attr('data-previndex', ui.item.index());
        console.log(ui.item.index());
      },
      update: function (e, ui) {
        // gets the new and old index then removes the temporary attribute
        /* var result = $(this).sortable('toArray');
        alert(result);
        } */
        var newIndex = ui.item.index();
        var oldIndex = $(this).attr('data-previndex');
        $(this).removeAttr('data-previndex');
        console.log(ui.item.index());
        console.log(ui.item.val());
      },
      stop: function (e, ui) {
        reorder();
      }
    });

    function reorder() {
      $(".list-group input[name='seq']").each(function (i, box) {
        $(box).val(i + 1);
      });

    }

    $('#menu_wrap').on('click', '#on_city_close_btn', function () {
      $('#menu_wrap').hide("slide", {direction: "left"}, 200);
      deleteMarkers(0);
      map_resize(1);
    });
    $('#on_city_open_btn').click(function () {
      $('#menu_wrap').show("slide", {direction: "left"}, 200);
      $('#cat_menu li.on').click();
    });

    $('.item').click(function () {
      $('#detail').show();
    })

  </script>


</body>
</html>