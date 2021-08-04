<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns:fb="https://www.facebook.com/2008/fbml" xmlns:og="https://opengraphprotocol.org/schema/" lang="ko"><head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge;chrome=1">
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <meta name="google-site-verification" content="ipMgUnVX-SfjeuEkrb4h9kVsm7aKqjCDyEaCwb3EtlU">
    <title>여행 플래너 어스토리</title>
    <%@ include file="/inc/asset.jsp" %>
    <meta name="description" content="20만개의 여행일정, 나만의 여행일정 계획하기">
    <meta name="keywords" content="여행일정, 여행일정 만들기, 명소, 음식점, 나이트라이프 여행정보, 호텔 가격비교, 호텔 최저가, 항공권 가격비교, 아시아 여행정보, 일본 여행, 타이베이 여행, 홍콩 여행, 런던 여행, 오사카 여행, 필리핀 여행, 유럽 여행, 호주 여행, 미국 여행, 괌 여행, 제주도 여행, 부산 여행, 싱가폴 여행, 말레이시아 여행, 발리 여행">
    <meta property="fb:app_id" content="334344006612913">
    <meta property="og:title" content="여행 플래너 어스토리">
    <meta property="og:type" content="article">
    <meta property="og:url" content="https://www.earthtory.com/ko">
    <meta property="og:description" content="20만개의 여행일정, 나만의 여행일정 계획하기">
    <meta property="og:image" content="https://www.earthtory.com/res/img/earthtory_logo_to_sns.png">
    <link rel="shortcut icon" href="/res/earthtory.ico">
    <link rel="stylesheet" href="/res/css/common/web/default_ko.css?v=150805" type="text/css">
    <link rel="stylesheet" href="/res/css/component/reset.css?v=150805">
    <link rel="stylesheet" href="/res/css/component/default.css?v=150805">
    <link rel="stylesheet" href="/res/css/common/web/gnb.css?v=150805">
    <script async="" src="//www.google-analytics.com/analytics.js"></script><script>
    var et_lang = 'ko';
</script>
    <script type="text/javascript" src="/res/js/js/jquery-latest.min.js"></script>
    <script type="text/javascript" src="/res/js/common_script.js?v=151210"></script>
    <script type="text/javascript" src="/res/js/component.js?v=150805"></script>
    <script src="/res/js/js/jquery.form.js"></script>  <!-- jQuery Form -->
    <script src="/res/js/web/common_w.js?v=150805"></script>
    <script src="/res/js/web/gnb.js"></script>
    <script type="text/javascript" src="/res/js/js/jquery.xdomainrequest.min.js"></script>
    <script type="text/javascript" src="/res/js/js/placeholder.js"></script>
    <script type="text/javascript">
        lang = {};
        function lang_uri(){
            return '/ko';
        }
    </script>
    <script type="text/javascript" src="/jslang?lang=ko&amp;lang_file=commonjs"></script>
    <link rel="image_src" href="https://www.earthtory.com/res/img/earthtory_logo_to_sns.png">

    <link rel="canonical" href="https://www.earthtory.com/ko">

    <link rel="home" href="www.earthtory.com">

    <link rel="alternate" href="https://www.earthtory.com" hreflang="x-default" title="English">
    <link rel="alternate" href="https://www.earthtory.com/ja" hreflang="ja-jp" title="日本語">
    <link rel="alternate" href="https://www.earthtory.com/ko" hreflang="ko-kr" title="한국어">


    <!--[if lt IE 9]>
    <script src="https://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>

    <![endif]-->
    <!--//<style type="text/css">
      *{
        behavior: url(/pie/PIE.htc);
      }
    </style>-->
    <meta name="google-site-verification" content="MwgpAlNbsXRZEln-QQP8Jra-Aj8cTKcCtDd3L_StvTc">
    <meta name="naver-site-verification" content="48a2af847268bfd79153f73690ad01b35cb1593a">
</head>

<body style="">
<%@ include file="/inc/header.jsp" %>
<script>
    (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
        (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
        m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
    })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

    ga('create', 'UA-56285148-1', 'auto');
    ga('send', 'pageview');

    function setCookie(cName, cValue, cDay){
        var expire = new Date();
        expire.setDate(expire.getDate() + cDay);
        cookies = cName + '=' + escape(cValue) + '; path=/ '; // 한글 깨짐을 막기위해 escape(cValue)를 합니다.
        if(typeof cDay != 'undefined') cookies += ';expires=' + expire.toGMTString() + ';';
        document.cookie = cookies;
    }


    function getCookie(cName) {
        cName = cName + '=';
        var cookieData = document.cookie;
        var start = cookieData.indexOf(cName);
        var cValue = '';
        if(start != -1){
            start += cName.length;
            var end = cookieData.indexOf(';', start);
            if(end == -1)end = cookieData.length;
            cValue = cookieData.substring(start, end);
        }
        return unescape(cValue);
    }

    // var service_popup = getCookie('service_popup_160112');
    // if(service_popup == ''){
    // window.open('https://www.earthtory.com/earthtory_160112_service_check.php', 'service_check', 'toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no, resizable=no,width=536,height=491')
    // setCookie('service_popup_160112','close',7);
    // }
    //location.href="https://www.earthtory.com/earthtory_150324_service_check.php";
</script>




<div id="header">
    <div class="wrap">
        <h1 class="logo fl" alt="여행의 시작! 어스토리">
            <a href="/ko/"><img src="/res/img/common/gnb/logo.png" alt="여행의 시작! 어스토리"></a>
        </h1>
        <ul class="gnb fl">
            <a href="/ko/area" class="fl"><li>여행지</li></a>
            <a href="/ko/plan" class="fl"><li>일정만들기</li></a>
            <!--//start
<a href="https://hotels.earthtory.com" target="_blank" class="fl"><li style="position:relative;">호텔비교<span style="font-size:10px;background:#ff0000;color:#fff;width:16px;height:16px;border-radius:8px;display:block;position:absolute;top:11px;right:6px;line-height:18px;text-align:center;">N</span></li></a>
end//-->
            <!-- 				<a href="/community/qa"" class="fl gnb_cmmt" data-on="n">
                                <li>
                                    커뮤니티					</li>
                                <div class="gnb_community_menu">
                                    <a href="/ko/community/tips" class="gnb_cmmt_mnu gtip">
                                        여행TIP						</a>
                                    <a href="/ko/community/qa" class="gnb_cmmt_mnu gqa">
                                        Q&A						</a>
                                </div>
                            </a> -->
            <!--//
<a href="/ko/hotel" class="fl"><li>호텔</li></a>
-->
            <a href="https://www.agoda.com/?cid=1607809" class="fl" target="_blank"><li>호텔</li></a>
            <!--<a href="/ko/flight" class="fl"><li>항공</li></a>-->
            <a href="/ko/intro" class="fl"><li>이용방법</li></a>
            <!--//<a href="https://bilibaba.net" target="_blank" class="fl" style="font-weight:900;"><li>고프로대여</li></a>-->

        </ul>

        <div class="fr gnb_box">

            <div class="fl gnb_search_box"><input type="text" id="gnb_search" placeholder="도시/장소를 찾아보세요."><div class="gnb_search_btn" style="display:none;"></div></div>
            <div id="gnb_search_autocomplete">

            </div>


            <div class="gnb_set_box_open_currency" style="display: none;">
                <ul class="gnb_set_box_content_currency" id="gnb_set_select_currency">


                    <li class="title bd_top">통화</li>
                    <li class="radio" data-val="USD" data-name="currency" data-on="off"><span class="et-radio">&nbsp;</span><span class="et-radio_txt">$ USD</span></li>
                    <li class="radio" data-val="JPY" data-name="currency" data-on="off"><span class="et-radio">&nbsp;</span><span class="et-radio_txt">¥ JPY</span></li>
                    <li class="radio" data-val="EUR" data-name="currency" data-on="off"><span class="et-radio">&nbsp;</span><span class="et-radio_txt">€ EUR</span></li>
                    <li class="radio" data-val="CNY" data-name="currency" data-on="off"><span class="et-radio">&nbsp;</span><span class="et-radio_txt">元 CNY</span></li>
                    <li class="radio" data-val="AUD" data-name="currency" data-on="off"><span class="et-radio">&nbsp;</span><span class="et-radio_txt">$ AUD</span></li>
                    <li class="radio" data-val="CAD" data-name="currency" data-on="off"><span class="et-radio">&nbsp;</span><span class="et-radio_txt">$ CAD</span></li>
                    <li class="radio" data-val="NZD" data-name="currency" data-on="off"><span class="et-radio">&nbsp;</span><span class="et-radio_txt">$ NZD</span></li>
                    <li class="radio" data-val="GBP" data-name="currency" data-on="off"><span class="et-radio">&nbsp;</span><span class="et-radio_txt">£ GBP</span></li>
                    <li class="radio" data-val="PHP" data-name="currency" data-on="off"><span class="et-radio">&nbsp;</span><span class="et-radio_txt">PhP PHP</span></li>
                    <li class="radio" data-val="HKD" data-name="currency" data-on="off"><span class="et-radio">&nbsp;</span><span class="et-radio_txt">HK$ HKD</span></li>
                    <li class="radio" data-val="SGD" data-name="currency" data-on="off"><span class="et-radio">&nbsp;</span><span class="et-radio_txt">$ SGD</span></li>
                    <li class="radio" data-val="INR" data-name="currency" data-on="off"><span class="et-radio">&nbsp;</span><span class="et-radio_txt">Rs INR</span></li>
                    <li class="radio on" data-val="KRW" data-name="currency" data-on="off"><span class="et-radio">&nbsp;</span><span class="et-radio_txt">\ KRW</span></li>


                </ul>
            </div>

            <div class="gnb_set_box_open_lang" style="display: none;">
                <ul class="gnb_set_box_content_lang" id="gnb_set_select_lang">

                    <li class="title">언어</li>
                    <li class="radio on" data-val="ko" data-name="lang" data-on="off"><span class="et-radio">&nbsp;</span><span class="et-radio_txt">한국어</span></li>
                    <li class="radio" data-val="en" data-name="lang" data-on="off"><span class="et-radio">&nbsp;</span><span class="et-radio_txt">ENGLISH</span></li>
                    <li class="radio" data-val="ja" data-name="lang" data-on="off"><span class="et-radio">&nbsp;</span><span class="et-radio_txt">日本語</span></li>

                    <li class="title bd_top">거리 단위</li>
                    <li class="radio on" data-val="km" data-name="units" data-on="off"><span class="et-radio">&nbsp;</span><span class="et-radio_txt">Km</span></li>
                    <li class="radio" data-val="mi" data-name="units" data-on="off"><span class="et-radio">&nbsp;</span><span class="et-radio_txt">Miles</span></li>

                </ul>
            </div>

            <div id="gnb_login_box" class="fr">
                <div class="gnb_user_img fl">
                    <img src="/res/img/common/mobile/img_profile.png" alt="김미르" onerror="this.src='/res/img/common/mobile/img_profile.png';">
                    <div class="gnb_mn_drop">
                        <a href="/ko/mypage/et_2107150609110356718001626340151?type=clipboard" class="item top">클립보드</a>
                        <a href="/ko/mypage/et_2107150609110356718001626340151?type=plan" class="item">여행일정</a>
                        <a href="/ko/mypage/et_2107150609110356718001626340151?type=review" class="item">리뷰</a>
                        <a href="/ko/mypage/et_2107150609110356718001626340151?type=my_tip" class="item">여행TIP</a>
                        <a href="/ko/mypage/et_2107150609110356718001626340151?type=my_qa" class="item">Q&amp;A</a>
                        <a href="/ko/mypage/et_2107150609110356718001626340151?type=config" class="item">설정</a>
                        <a href="/ko/member/logout" class="item">로그아웃</a>
                    </div>
                </div>
                <div class="notice fl et_slide_parent" id="gnb_notice" data-is_open="0">
                    <img id="gnb_notice_img" src="/res/img//common/gnb/gnb_notice_icon.png">
                    <div class="cnt" style="display: none;">0</div>
                </div>
                <div id="notice_content_box" class="et_slide" style="">

                </div>

                <div class="clear"></div>
            </div>



            <a href="javascript:void(0);" class="fr" style="display:none;">

                <div class="fl gnb_set_box_currency script-popup" data-scp_child="gnb_set_box_open_currency" data-scp_ani="fade" data-on="off">
                    <div style="padding-left:15px;">KRW</div>
                </div>

                <div class="fl gnb_set_box_lang script-popup" data-scp_child="gnb_set_box_open_lang" data-scp_ani="fade" data-on="off">
                    <div style="width:81px;padding-left:12px;">한국어</div>
                </div>
            </a>
            <div class="clear"></div>

        </div>
        <div class="clear"></div>
    </div>

</div>
<div class="clear"></div>






<div class="recent_action ra_absolute"></div>


<script>
    //console.log('ko');
    //console.log('ko');



    $('#gnb_set_select_currency, #gnb_set_select_lang').on('click', 'li', function(){
        var select_val = $(this).attr('data-val');
        var select_name = $(this).attr('data-name');

        var data = 'member_srl=1388445&'+select_name+'='+select_val;
        $.ajax({
            type:'post',
            data:data,
            url:'/api/member/set_session',
            success: function(data){
                if(select_name == 'lang'){
                    if(select_val == 'en'){
                        location.href='';
                    }else{
                        location.href='/'+select_val+'/';
                    }
                }else{
                    location.href='';
                }
            }
        });
    });

    $.ajax({
        type:'post',
        url:'/api/alert/get_unread_alert_cnt',
        success: function(data){
            //console.log(data);
            if(data.response_result.count > 0){
                $('#gnb_login_box .cnt').text(data.response_result.count);
                $('#gnb_login_box .cnt').show();
            }else{
                $('#gnb_login_box .cnt').hide();
            }
        }
    });

    $('#gnb_notice').click(function(){
        _this_is_open = $(this).attr('data-is_open');
        if(_this_is_open == 0){
            $(this).attr('data-is_open', '1');
            $.ajax({
                type:'post',
                url:'/api/alert/get_alert_list',
                success: function(data){
                    $('#gnb_login_box .cnt').hide();
                    //console.log(data);
                    var html = '<div class="notice_box_arrow"></div>';
                    $.each(data.response_data, function(key, val) {
                        if(val.html_desc && val.img != null){
                            if(val.alert_type == '2'){
                                var al_link = '/ko/mypage/et_2107150609110356718001626340151?type=clipboard&ci_srl='+val.rel_srl;
                            }else{
                                var al_link = '';
                            }
                            html += '<div class="notice_item" data-link="'+al_link+'">'+cutStr(val.html_desc,85)+'<div class="notice_time">'+val.regdate+'</div></div>';
                        }
                        if(key == 4){
                            return false;
                        }
                    });
                    html += '<div class="notice_more_box">더보기</div>';
                    $('#notice_content_box').html(html);
                    $('#notice_content_box').slideDown();

                }
            });
        }else{
            $('#notice_content_box').slideUp(300);
            $(this).attr('data-is_open', '0');
        }
    });
    $('#notice_content_box').on('click','.notice_item, .notice_more_box',function(){
        if($(this).attr('data-link') == '' || $(this).attr('data-link') == null){
            location.href="/ko/notice";
        }else{
            location.href=$(this).attr('data-link');
        }
    });

    $(document).mouseup(function (e)
    {
        var container = $(".et_slide");

        var _parent_sel_box = $(e.target).attr('id');


        if (!container.is(e.target) // if the target of the click isn't the container...
            && container.has(e.target).length === 0 && _parent_sel_box != 'gnb_notice' && _parent_sel_box != 'gnb_notice_img' && _parent_sel_box != 'hotel_type_filter' && _parent_sel_box != 'hotel_amenity_filter' && _parent_sel_box != 'ht_filter_rank' && _parent_sel_box != 'ht_filter_type' && _parent_sel_box != 'map_tag_select_box' && _parent_sel_box != 'sky_filter_airlines' && _parent_sel_box != 'hotel_rank_filter' ) // ... nor a descendant of the container
        {
            container.slideUp(300);

            $('.et_slide_parent').removeClass('on');
            $('.et_slide_parent').attr('data-is_open','0');


        }
    });


</script><link rel="stylesheet" href="/res/css/web/date_picker.css?v=150805">
<link rel="stylesheet" href="/res/css/web/main.css?v=150924">
<script type="text/javascript" src="/jslang?lang=ja&amp;lang_file=city"></script>
<script type="text/javascript" src="/res/js/web/jui/jquery-ui.js"></script>
<script type="text/javascript" src="/res/js/web/main.js"></script>


<script type="text/javascript">
    $(document).ready(function(){
        $.ajax({
            type:'POST',
            url:'/api/member/get_member_info',
            data:{'lang':'ko','member_srl':'1388445','detail':'true'},
            success:function(data){
                console.log(data);
                var info = data.response_data;
                $('.logged_cnt_box.logged_plan span').text(info.plan_cnt);
                $('.logged_cnt_box.logged_review span').text(info.review_cnt);
                //$('.logged_cnt_box.logged_tip span').text(info.tip_cnt);
                $('.logged_cnt_box.logged_clip span').text(info.clip_cnt);

                $('.logged_cnt_box.logged_qa span').text(parseInt(info.q_cnt)+parseInt(info.a_cnt));
            }
        });
        $.ajax({
            type:'POST',
            url:'/api/city/get_recent_view_city',
            data:{'member_srl':'1388445'},
            success:function(data){
                console.log(data);
                var html_code = '';
                $.each(data.response_data,function(key,val){
                    if(html_code != ''){
                        html_code += ',&nbsp;';
                    }
                    html_code += '<a href="'+val.link+'" class="latest_a">'+val.ci_name+'</a>';
                });

                $('.latest_search').append(html_code);
            }
        });
        $.ajax({
            type:'POST',
            url:'/api/tips/get_main_tips',
            data:{},
            success:function(data){
                console.log(data);
                var html = '';
                $.each(data.response_data,function(key,val){
                    if(key == 0 || key == 5){
                        var big_c = ' big';
                    }else{
                        var big_c = '';
                    }
                    html += '<a href="'+val.link_url+'" class="story_box'+big_c+'">';
                    html += '<div class="story_imgbox">';
                    html += '<div class="story_cnt">';
                    html += val.cnt
                    html += '</div>';
                    html += '<img src="'+val.cover_img+'" alt="" class="story_img" onError="this.src=\''+val.page_img+'\';" />';
                    html += '</div>';
                    html += '<div class="story_title">';
                    html += val.title
                    html += '</div>';
                    html += '<div class="story_desc">';
                    if(big_c == ' big'){
                        html += val.description.cut(150,'...');
                    }else{
                        html += val.description.cut(70,'...');
                    }

                    html += '</div>';
                    html += '</a>';
                });

                html += '<div class="clear"></div>';

                $('.story_list').html(html);
                $('.more_btn.tip').text(lang_ex(lang.main_tip_more,data.response_result));
            }
        });
    });


    get_plan_main_list();
    function get_plan_main_list(){
        $.ajax({
            type:'post',
            url:'/api/plan/get_plan_main_list',
            dataType:'json',
            success: function(data){
                html = '';
                console.log('====================');
                console.log(data);
                $.each(data.response_data, function(key, val) {
                    html += '<a href="'+val.plan_url+'" target="_blank" class="box"><div class="plan_bg">';
                    html += '<div class="plan_bg_inner"><span>'+val.start_day+'</span><span class="tour_day">'+val.tour_day+'DAYS</span><br>'+cutStr(val.pn_title,38)+'</div></div>';
                    html += '<div class="plan_img_box">	<img src="'+val.cover_img_url+'" alt="" class="plan_img"></div>';
                    html += '<div class="plan_bg_inner2"><span>'+val.tour_type_nm+'</span><div class="fr pn_list_copy_icon">'+val.copy_cnt+'</div><div class="fr pn_list_view_icon">'+val.view_cnt+'</div><div class="fr pn_list_spot_icon">'+val.inspot_cnt+'</div>';
                    html += '<div class="clear"></div><div class="pn_list_city">'+cutStr(val.city_names,45)+'</div><div class="clear"></div><div class="pn_list_user">'+val.member_names+'</div></div></a>';
                });
                html += '<div class="clear"></div>';
                $('.plan_list').html(html);
            },complete: function(){

            },error:function(data){
                console.log(data);
            }
        });
    }

</script>
<div class="main_top" style="background:url('/res/img/main/key_bg_3.jpg') no-repeat;background-size:cover;">
    <div class="wrap">
        <div class="main_top_title">
            나만의 여행 플래너 어스토리!		</div>
        <div class="main_top_desc">
            쉽고 빠르게 여행을 계획하세요.		</div>
        <div class="search_area">
            <input class="search_input" id="city_search" placeholder="국가명, 도시명으로 검색">
            <div id="city_autocomplete"></div>
            <div class="latest_search">
                최근검색 :
                <a href="/ko/city/hawaii_10023" class="latest_a">하와이</a>,&nbsp;<a href="/ko/city/berlin_10016" class="latest_a">베를린</a>,&nbsp;<a href="/ko/city/jeju_312" class="latest_a">제주도</a>,&nbsp;<a href="/ko/city/osaka_58" class="latest_a">오사카</a></div>
            <a class="go_map" href="javascript:void(0)" onclick="et_full_modal('/ko/modal/world_map')">지도에서 검색 &gt;</a>
            <div class="clear"></div>
        </div>
    </div>
</div>

<div class="page silver logged_box">
    <div class="wrap logged">
        <img class="logged_user_img" src="/res/img/common/mobile/img_profile.png" onerror="this.src='/res/img/common/mobile/img_profile.png';">
        <div class="logged_left">
            <div class="logged_name">
                김미르			</div>
            <div class="clear"></div>
            <a href="/ko/mypage/et_2107150609110356718001626340151?type=clipboard" class="logged_cnt_box logged_clip">
                <b>클립보드</b>
                <span>0</span>
            </a>
            <div class="logged_line">&nbsp;</div>
            <a href="/ko/mypage/et_2107150609110356718001626340151?type=plan" class="logged_cnt_box logged_plan">
                <b>여행일정</b>
                <span>3</span>
            </a>
            <div class="logged_line">&nbsp;</div>
            <a href="/ko/mypage/et_2107150609110356718001626340151?type=review" class="logged_cnt_box logged_review">
                <b>리뷰</b>
                <span>0</span>
            </a>
            <div class="logged_line">&nbsp;</div>
            <a href="/ko/mypage/et_2107150609110356718001626340151?type=my_qa" class="logged_cnt_box logged_qa">
                <b>Q&amp;A</b>
                <span>0</span>
            </a>
            <div class="clear"></div>
        </div>
        <a href="javascript:et_modal('550px','500px','1','0','/ko/modal/inquiry','2','1');" class="logged_btn_box">
            <div class="logged_btn">
                <div class="logged_btn_ico">
                    <img src="/res/img/main/ico_qa.png" alt="">
                </div>
                질문하기			</div>
        </a>
        <a href="javascript:et_full_modal('/ko/modal/write_ci_review');" class="logged_btn_box">
            <div class="logged_btn">
                <div class="logged_btn_ico">
                    <img src="/res/img/main/ico_review.png" alt="">
                </div>
                리뷰쓰기			</div>
        </a>
        <a href="/ko/plan" class="logged_btn_box">
            <div class="logged_btn">
                <div class="logged_btn_ico">
                    <img src="/res/img/main/ico_plan.png" alt="">
                </div>
                일정만들기			</div>
        </a>
        <div class="clear"></div>
    </div>
</div>


<div class="page white" style="padding-top:30px;">

    <center style="padding-bottom:50px;"><a href="https://www.agoda.com?cid=1740480" target="_blank"><img src="/res/1600_210_1.png" style="width:1000px;height:auto;"></a></center>

    <!--//<center style="padding-bottom:50px;"><a href="/earthtory_agoda" target="_blank"><img src="/res/et_x_agoda/1000X131.jpg" style="width:1000px;height:auto;"></a></center>-->
    <div class="wrap">
        <div class="page_title">
            인기 여행일정
        </div>
        <div class="page_desc">
            다른 여행자들의 일정을 참고해 나만의 여행을 계획해보세요!
        </div>
        <div class="plan_list"><a href="/mypage/et_1504280847030207932001430221623?type=plan_sub&amp;gdb_srl=41958" target="_blank" class="box"><div class="plan_bg"><div class="plan_bg_inner"><span>2015-06-25</span><span class="tour_day">6DAYS</span><br>싱가폴</div></div><div class="plan_img_box">	<img src="http://img.earthtory.com/img/city_images/243/singapore_1429501207.jpg" alt="" class="plan_img"></div><div class="plan_bg_inner2"><span>커플 여행</span><div class="fr pn_list_copy_icon">1</div><div class="fr pn_list_view_icon">116</div><div class="fr pn_list_spot_icon">34</div><div class="clear"></div><div class="pn_list_city">싱가포르</div><div class="clear"></div><div class="pn_list_user">sea93617</div></div></a><a href="/mypage/et_1506030943040386960001433292184?type=plan_sub&amp;gdb_srl=49434" target="_blank" class="box"><div class="plan_bg"><div class="plan_bg_inner"><span>2015-06-09</span><span class="tour_day">5DAYS</span><br>홍콩 첫 자유여행</div></div><div class="plan_img_box">	<img src="http://img.earthtory.com/img/city_images/245/hong-kong_1426839831.jpg" alt="" class="plan_img"></div><div class="plan_bg_inner2"><span>커플 여행</span><div class="fr pn_list_copy_icon">1</div><div class="fr pn_list_view_icon">120</div><div class="fr pn_list_spot_icon">45</div><div class="clear"></div><div class="pn_list_city">홍콩,마카오</div><div class="clear"></div><div class="pn_list_user">김광준</div></div></a><a href="/mypage/et_1504300711290222928001430388689?type=plan_sub&amp;gdb_srl=42373" target="_blank" class="box"><div class="plan_bg"><div class="plan_bg_inner"><span>2015-05-22</span><span class="tour_day">5DAYS</span><br>홍콩&amp;마카오</div></div><div class="plan_img_box">	<img src="http://img.earthtory.com/img/city_images/245/hong-kong_1429504157.jpg" alt="" class="plan_img"></div><div class="plan_bg_inner2"><span>커플 여행</span><div class="fr pn_list_copy_icon">4</div><div class="fr pn_list_view_icon">113</div><div class="fr pn_list_spot_icon">38</div><div class="clear"></div><div class="pn_list_city">홍콩,마카오</div><div class="clear"></div><div class="pn_list_user">최현경</div></div></a><a href="/mypage/editor2?type=plan_sub&amp;gdb_srl=38940" target="_blank" class="box"><div class="plan_bg"><div class="plan_bg_inner"><span>2015-04-24</span><span class="tour_day">5DAYS</span><br>타이페이 4박5일 추천일정!</div></div><div class="plan_img_box">	<img src="http://img.earthtory.com/img/city_default/26/92.jpg" alt="" class="plan_img"></div><div class="plan_bg_inner2"><span>친구와 함께</span><div class="fr pn_list_copy_icon">27</div><div class="fr pn_list_view_icon">543</div><div class="fr pn_list_spot_icon">55</div><div class="clear"></div><div class="pn_list_city">타이베이</div><div class="clear"></div><div class="pn_list_user">Pro-traveler</div></div></a><a href="/mypage/et_1506221053480700409001434981228?type=plan_sub&amp;gdb_srl=53201" target="_blank" class="box"><div class="plan_bg"><div class="plan_bg_inner"><span>2015-07-11</span><span class="tour_day">8DAYS</span><br>고고고</div></div><div class="plan_img_box">	<img src="http://img.earthtory.com/img/city_images/196/praha_1429514804.jpg" alt="" class="plan_img"></div><div class="plan_bg_inner2"><span>친구와 함께</span><div class="fr pn_list_copy_icon">0</div><div class="fr pn_list_view_icon">128</div><div class="fr pn_list_spot_icon">78</div><div class="clear"></div><div class="pn_list_city">프라하,부다페스트,빈</div><div class="clear"></div><div class="pn_list_user">심현정</div></div></a><a href="/mypage/et_1506290907170863695001435579637?type=plan_sub&amp;gdb_srl=56378" target="_blank" class="box"><div class="plan_bg"><div class="plan_bg_inner"><span>2015-07-28</span><span class="tour_day">5DAYS</span><br>대만여행</div></div><div class="plan_img_box">	<img src="http://img.earthtory.com/img/city_images/92/taipei_1425530234.jpg" alt="" class="plan_img"></div><div class="plan_bg_inner2"><span>친구와 함께</span><div class="fr pn_list_copy_icon">9</div><div class="fr pn_list_view_icon">58</div><div class="fr pn_list_spot_icon">41</div><div class="clear"></div><div class="pn_list_city">타이베이</div><div class="clear"></div><div class="pn_list_user">정지나</div></div></a><div class="clear"></div></div>
        <div class="more_btn" onclick="location.href='/ko/plan';">
            56,065개의 추천일정 모두보기
        </div>
    </div>
</div>

<div class="page silver">
    <div class="wrap">
        <div class="page_title">
            어디로 갈까?			</div>
        <div class="page_desc">
            팁에서 아이디어를 얻어보세요.			</div>
        <div class="story_list"><a href="/ko/tip/view?srl=633" class="story_box big"><div class="story_imgbox"><div class="story_cnt">5</div><img src="http://img.earthtory.com/img/nt_img/cover/73/73_1403078509.jpg" alt="" class="story_img" onerror="this.src='http://img.earthtory.com/img/mb_img/73/73_1409209705.JPG';"></div><div class="story_title">멜번의 또다른 모습, 가까운 주변 여행지</div><div class="story_desc">멜버른 시티에서 약 한 시간여 거리에 있는 모닝턴 반도와 소버린힐. 모닝턴반도에서의 느긋한 하루 또는 골드러쉬로의 시간 여행.</div></a><a href="/ko/tip/view?srl=393" class="story_box"><div class="story_imgbox"><div class="story_cnt">6</div><img src="http://img.earthtory.com/img/nt_img/cover/74/74_1400818442.jpg" alt="" class="story_img" onerror="this.src='http://img.earthtory.com/img/mb_img/74/74_1429243176.jpg';"></div><div class="story_title">가족단위의 여행객이 좋아하는 제주도의 테마파크</div><div class="story_desc">어린아이들이 있는 가족이라면 그냥 지나칠 수 없는 제주도의 다양한 테마...</div></a><a href="/ko/tip/view?srl=543" class="story_box"><div class="story_imgbox"><div class="story_cnt">5</div><img src="http://img.earthtory.com/img/place_img_user/74/common/test_1437361189.jpg" alt="" class="story_img" onerror="this.src='http://img.earthtory.com/img/mb_img/74/74_1429243176.jpg';"></div><div class="story_title">뮌헨, 옥토버페스트의 도시</div><div class="story_desc">뮌헨, 옥토버페스트의 도시</div></a><a href="/ko/tip/view?srl=397" class="story_box"><div class="story_imgbox"><div class="story_cnt">5</div><img src="http://img.earthtory.com/img/nt_img/cover/74/74_1400827936.jpg" alt="" class="story_img" onerror="this.src='http://img.earthtory.com/img/mb_img/74/74_1429243176.jpg';"></div><div class="story_title">방콕의 필수 여행지</div><div class="story_desc">어디를 가서 무엇을 봐야할지 도저히 감이 잡히지 않는다면, 필수 스팟을 ...</div></a><a href="/ko/tip/view?srl=448" class="story_box"><div class="story_imgbox"><div class="story_cnt">11</div><img src="http://img.earthtory.com/img/nt_img/cover/74/74_1401269875.jpg" alt="" class="story_img" onerror="this.src='http://img.earthtory.com/img/mb_img/74/74_1429243176.jpg';"></div><div class="story_title">부산, 최상의 관광지 </div><div class="story_desc">부산에 와서 꼭 둘러봐야하는 최상의 관광지만 엄선! 이 스팟들만 둘러봐도...</div></a><a href="/ko/tip/view?srl=373" class="story_box big"><div class="story_imgbox"><div class="story_cnt">12</div><img src="http://img.earthtory.com/img/nt_img/cover/73/73_1400665387.jpg" alt="" class="story_img" onerror="this.src='http://img.earthtory.com/img/mb_img/73/73_1409209705.JPG';"></div><div class="story_title">아직도 제주도가 처음?!</div><div class="story_desc">첫 번째 제주도 방문이라면, 제주도 여행으로 시작하기 좋은 곳</div></a><div class="clear"></div></div>

        <div class="more_btn tip" onclick="location.href='/ko/community/tips';">481개의 여행TIP 모두보기</div>
    </div>
</div>

<div class="page white">
    <div class="wrap">
        <div class="page_title">
            인기도시 TOP10		</div>
        <div class="top_city_list">
            <a href="/ko/city/london_309" class="top_city w2">
                <div class="top_city_title">
                    런던				</div>
                <img src="/res/img/main/po_city/po_city_01.jpg" alt="">
            </a>
            <a href="/ko/city/paris_307" class="top_city">
                <div class="top_city_title">
                    파리				</div>
                <img src="/res/img/main/po_city/po_city_02.jpg" alt="">
            </a>
            <a href="/ko/city/singapore_243" class="top_city">
                <div class="top_city_title">
                    싱가포르				</div>
                <img src="/res/img/main/po_city/po_city_03.jpg" alt="">
            </a>

            <a href="/ko/city/istanbul_202" class="top_city">
                <div class="top_city_title">
                    이스탄불				</div>
                <img src="/res/img/main/po_city/po_city_04.jpg" alt="">
            </a>
            <a href="/ko/city/venice_187" class="top_city">
                <div class="top_city_title">
                    베네치아				</div>
                <img src="/res/img/main/po_city/po_city_05.jpg" alt="">
            </a>
            <a href="/ko/city/barcelona_10005" class="top_city">
                <div class="top_city_title">
                    바르셀로나				</div>
                <img src="/res/img/main/po_city/po_city_06.jpg" alt="">
            </a>
            <a href="/ko/city/taipei_92" class="top_city h2">
                <div class="top_city_title">
                    타이베이				</div>
                <img src="/res/img/main/po_city/po_city_07.jpg" alt="">
            </a>

            <a href="/ko/city/hong-kong_245" class="top_city">
                <div class="top_city_title">
                    홍콩				</div>
                <img src="/res/img/main/po_city/po_city_08.jpg" alt="">
            </a>
            <a href="/ko/city/bangkok_86" class="top_city">
                <div class="top_city_title">
                    방콕				</div>
                <img src="/res/img/main/po_city/po_city_09.jpg" alt="">
            </a>
            <a href="/ko/city/jeju_312" class="top_city">
                <div class="top_city_title">
                    제주도				</div>
                <img src="/res/img/main/po_city/po_city_10.jpg" alt="">
            </a>
            <div class="clear"></div>
        </div>
    </div>
</div>

<div class="page silver">
    <div class="wrap">
        <div class="page_title">
            어스토리에서 여행을 시작하세요!		</div>
        <div class="clear"></div>
        <div class="intro_list">
            <div class="intro_box" onclick="location.href='/ko/area';">
                <img src="/res/img/main/intro_img/intro_1.jpg" alt="">
                <div class="intro_title">
                    여행정보				</div>
                <div class="intro_desc">
                    전 세계 800개 도시, 30만개의 관광명소, 음식점, 쇼핑 정보를 확인하세요.				</div>
            </div>
            <div class="intro_box" onclick="location.href='/ko/plan';">
                <img src="/res/img/main/intro_img/intro_2.jpg" alt="">
                <div class="intro_title">
                    여행일정				</div>
                <div class="intro_desc">
                    전 세계 100,000개 이상의 여행일정을 확인하고 나만의 일정을 계획해 보세요.				</div>
            </div>
            <div class="intro_box" onclick="location.href='/ko/community/qa';">
                <img src="/res/img/main/intro_img/intro_3.jpg" alt="">
                <div class="intro_title">
                    커뮤니티				</div>
                <div class="intro_desc">
                    여행자들과 정보를 공유하고, 궁금한 것은 언제든 물어보세요.				</div>
            </div>
            <div class="clear"></div>
        </div>
        <a href="/ko/intro" class="intro_link">
            사용방법이 궁금하신가요?		</a>
    </div>
</div>

<div class="et_mobile_full_box">
    <div class="wrap" style="height:382px;">
        <div class="et_mobile_demo"><img src="/res/img/main/et_mobile_demo_ko.png" alt="모바일에서도 어스토리를 만나보세요."></div>
        <div class="et_mobile_title">
            <!--모바일에서도 어스토리를 만나보세요-->모바일에서도 어스토리를 만나보세요.		</div>
        <div class="et_mobile_sub_title" style="font-size:14px;">
            <!--내가 계획한 일정과 전세계 주요 관광지 정보를 빠르고 쉽게 찾을 수 있습니다.<br>어스토리의 모든 서비스는 무료 입니다.-->내가 계획한 일정과 전세계 주요 관광지 정보를 빠르고 쉽게 찾을 수 있습니다.<br>어스토리의 모든 서비스는 무료 입니다.		</div>
        <div class="et_mobile_google"><a href="https://play.google.com/store/apps/details?id=com.earthtory" target="_blank"><img src="/res/img/main/et_mobile_google.png"></a></div>
        <div class="et_mobile_apple">
            <a href="https://itunes.apple.com/kr/app/eoseutoli-earthtory-juyo-gwangwangji/id919377935?mt=8" target="_blank">
                <img src="/res/img/main/et_mobile_apple.png">
            </a>
        </div>
        <div class="et_mobile_sns_fb">
            <a href="https://facebook.com/Earthtory" target="_blank">
                <div class="et_mobile_sns_icon fl">
                    <img src="/res/img/main/sns_fb_icon.png" alt="어스토리 페이스북"><!--어스토리 페이스북-->
                </div>
                <div class="et_mobile_sns_txt fl">www.facebook.com/Earthtory</div></a>
            <div class="clear"></div>
        </div>
        <div class="et_mobile_sns_nv">
            <a href="https://blog.earthtory.com" target="_blank">
                <div class="et_mobile_sns_icon fl">
                    <img src="/res/img/main/sns_nv_icon.png" alt="어스토리 블로그"><!--어스토리 블로그-->
                </div>
                <div class="et_mobile_sns_txt fl">blog.earthtory.com</div></a>
            <div class="clear"></div>
        </div>
    </div>
</div>
<div id="footer">
    <div class="wrap">
        <div class="footer_col fl">
            <div class="footer_title">어스토리</div>
            <a href="/ko/area">여행지</a>
            <a href="/ko/plan">일정만들기</a>
            <!--//<a href="/ko/hotel">호텔</a>-->
            <a href="https://www.agoda.com/?cid=1607809" target="_blank">호텔</a>
            <a href="/ko/community/qa">Q&amp;A</a>
            <a href="/ko/community/tips">여행TIP</a>
            <a href="/ko/mobile">모바일</a><!--모바일-->
        </div>

        <div class="footer_col fl">
            <div class="footer_title">회사이야기</div>
            <a href="/ko/helpdesk/about">회사소개</a>
            <a href="/ko/helpdesk/intro">이용방법</a>
            <a href="/ko/helpdesk/contact">광고 및 제휴</a>
        </div>

        <div class="footer_col fl">
            <div class="footer_title">고객센터</div>
            <a href="/ko/helpdesk/faq">FAQ</a>
            <a href="/ko/helpdesk">문의하기</a>
            <a href="/ko/helpdesk/policy">이용약관</a>
            <a href="/ko/helpdesk/personal_info">개인정보 처리방침</a>
        </div>


        <div class="footer_col fl" style="margin-right:0px;">
            <div class="footer_title" style="border-bottom:0px;margin-bottom:0px;">&nbsp;</div>
            <script type="text/javascript">
                $(document).ready(function(){
                    $('#lang_chage_item_box .lang_change_item').click(function(){
                        var lang_n = $(this).attr('data');
                        console.log(lang_n);
                        $.ajax({
                            type:'post',
                            url:'/api/member/set_session',
                            data:{'lang':lang_n},
                            success:function(){
                                if(lang_n == 'ko'){
                                    location.href = '';
                                }else if(lang_n == 'ja'){
                                    location.href = '';
                                }else{
                                    location.href = '';
                                }
                            }
                        });
                    });

                    $('#currency_change_item_box .currency_change_item').click(function(){
                        var currency = $(this).attr('data');
                        console.log(currency);
                        $.ajax({
                            type:'post',
                            url:'/api/member/set_session',
                            data:{'currency':currency},
                            success:function(data){
                                location.href = '/ko';
                            }
                        });
                    });
                });

                $('#footer').on('click','#footer_lang_sel_box',function(){
                    is_open = $(this).attr('data-is_open');
                    //console.log(is_open);
                    if(is_open == '1'){
                        $('#lang_chage_item_box').slideUp(300);
                        $(this).attr('data-is_open','0');
                    }else{
                        $('#lang_chage_item_box').slideDown(200);
                        $(this).attr('data-is_open','1');
                    }
                });

                $('#footer').on('click','#footer_currency_sel_box',function(){
                    is_open = $(this).attr('data-is_open');
                    //console.log(is_open);
                    if(is_open == '1'){
                        $('#currency_change_item_box').slideUp(300);
                        $(this).attr('data-is_open','0');
                    }else{
                        $('#currency_change_item_box').slideDown(200);
                        $(this).attr('data-is_open','1');
                    }
                });

            </script>


            <div class="fl footer_lang_box" id="footer_lang_sel_box" data-is_open="0" data-h="ko/ko">
                한국어
            </div>
            <div id="lang_chage_item_box">
                <a href="/ko/" class="prevent_href lang_change_item" data="ko">한국어</a>
                <a href="/ja/" class="prevent_href lang_change_item" data="ja">日本語</a>
                <a href="/" class="prevent_href lang_change_item" data="en">English</a>
            </div>
            <div class="fl footer_currency_box" id="footer_currency_sel_box" data-is_open="0">
                KRW			</div>
            <div id="currency_change_item_box">
                <a class="currency_change_item" data="KRW">KRW</a>
                <a class="currency_change_item" data="JPY">JPY</a>
                <a class="currency_change_item" data="USD">USD</a>
            </div>
            <div class="clear" style="padding-bottom:20px"></div>

            <div class="fl footer_sns_icon"><a href="https://www.facebook.com/Earthtory" target="_blank"><img src="/res/img/common/footer/ft_fb_icon.png" alt="어스토리 페이스북"></a></div>
            <div class="fl footer_sns_icon"><a href="http://blog.earthtory.com/" target="_blank"><img src="/res/img/common/footer/ft_blog_icon.png" alt="어스토리 트위터"></a></div>
            <!-- <div class="fl footer_sns_icon"><img src="/res/img/common/footer/ft_pr_icon.png" alt="어스토리 핀터레스트"></div>
            <div class="fl footer_sns_icon"><img src="/res/img/common/footer/ft_gp_icon.png" alt="어스토리 구글플러스"></div> -->
            <div class="clear"></div>
        </div>

        <div class="clear"></div>
    </div>

    <div class="footer_bottom">
        <div class="wrap">
            Copyright ⓒ 2015 Earthtory.com, All Rights Reserved.
            <div style="float:right;">제휴문의: wonwoo@earthtory.com | 02-6441-4100</div><div class="clear"></div>
        </div>
    </div>
</div>
<%@ include file="/inc/init.jsp" %>
<%@ include file="/inc/footer.jsp" %>
</body></html>