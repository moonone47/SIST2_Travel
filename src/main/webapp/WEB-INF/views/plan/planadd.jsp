<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title> 플젝 </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        .map_wrap, .map_wrap * {
            margin: 0;
            padding: 0;
            font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;
            font-size: 12px;
        }

        .map_wrap {
            position: relative;
            width: 100%;
            height: 350px;
        }

        #category {
            position: absolute;
            top: 10px;
            left: 10px;
            border-radius: 5px;
            border: 1px solid #909090;
            box-shadow: 0 1px 1px rgba(0, 0, 0, 0.4);
            background: #fff;
            overflow: hidden;
            z-index: 2;
        }

        #category li {
            float: left;
            list-style: none;
            width: 50px;
            border-right: 1px solid #acacac;
            padding: 6px 0;
            text-align: center;
            cursor: pointer;
        }

        #category li.on {
            background: #eee;
        }

        #category li:hover {
            background: #ffe6e6;
            border-left: 1px solid #acacac;
            margin-left: -1px;
        }

        #category li:last-child {
            margin-right: 0;
            border-right: 0;
        }

        #category li span {
            display: block;
            margin: 0 auto 3px;
            width: 27px;
            height: 28px;
        }

        #category li .category_bg {
            background: url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_category.png) no-repeat;
        }

        #category li .bank {
            background-position: -10px 0;
        }

        #category li .mart {
            background-position: -10px -36px;
        }

        #category li .pharmacy {
            background-position: -10px -72px;
        }

        #category li .oil {
            background-position: -10px -108px;
        }

        #category li .cafe {
            background-position: -10px -144px;
        }

        #category li .store {
            background-position: -10px -180px;
        }

        #category li.on .category_bg {
            background-position-x: -46px;
        }

        .placeinfo_wrap {
            position: absolute;
            bottom: 28px;
            left: -150px;
            width: 300px;
        }

        .placeinfo {
            position: relative;
            width: 100%;
            border-radius: 6px;
            border: 1px solid #ccc;
            border-bottom: 2px solid #ddd;
            padding-bottom: 10px;
            background: #fff;
        }

        .placeinfo:nth-of-type(n) {
            border: 0;
            box-shadow: 0px 1px 2px #888;
        }

        .placeinfo_wrap .after {
            content: '';
            position: relative;
            margin-left: -12px;
            left: 50%;
            width: 22px;
            height: 12px;
            background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')
        }

        .placeinfo a, .placeinfo a:hover, .placeinfo a:active {
            color: #fff;
            text-decoration: none;
        }

        .placeinfo a, .placeinfo span {
            display: block;
            text-overflow: ellipsis;
            overflow: hidden;
            white-space: nowrap;
        }

        .placeinfo span {
            margin: 5px 5px 0 5px;
            cursor: default;
            font-size: 13px;
        }

        .placeinfo .title {
            font-weight: bold;
            font-size: 14px;
            border-radius: 6px 6px 0 0;
            margin: -1px -1px 0 -1px;
            padding: 10px;
            color: #fff;
            background: #d95050;
            background: #d95050 url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/arrow_white.png) no-repeat right 14px center;
        }

        .placeinfo .tel {
            color: #0f7833;
        }

        .placeinfo .jibun {
            color: #999;
            font-size: 11px;
            margin-top: 0;
        }


        .map_wrap, .map_wrap * {
            margin: 0;
            padding: 0;
            font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;
            font-size: 12px;
        }

        .map_wrap a, .map_wrap a:hover, .map_wrap a:active {
            color: #000;
            text-decoration: none;
        }

        .map_wrap {
            position: relative;
            width: 100%;
            height: 500px;
        }

        #menu_wrap {
            position: absolute;
            top: 0;
            left: 0;
            bottom: 0;
            width: 250px;
            margin: 10px 0 30px 10px;
            padding: 5px;
            overflow-y: auto;
            background: rgba(255, 255, 255, 0.7);
            z-index: 1;
            font-size: 12px;
            border-radius: 10px;
        }

        .bg_white {
            background: #fff;
        }

        #menu_wrap hr {
            display: block;
            height: 1px;
            border: 0;
            border-top: 2px solid #5F5F5F;
            margin: 3px 0;
        }

        #menu_wrap .option {
            text-align: center;
        }

        #menu_wrap .option p {
            margin: 10px 0;
        }

        #menu_wrap .option button {
            margin-left: 5px;
        }

        #placesList li {
            list-style: none;
        }

        #placesList .item {
            position: relative;
            border-bottom: 1px solid #888;
            overflow: hidden;
            cursor: pointer;
            min-height: 65px;
        }

        #placesList .item span {
            display: block;
            margin-top: 4px;
        }

        #placesList .item h5, #placesList .item .info {
            text-overflow: ellipsis;
            overflow: hidden;
            white-space: nowrap;
        }

        #placesList .item .info {
            padding: 10px 0 10px 55px;
        }

        #placesList .info .gray {
            color: #8a8a8a;
        }

        #placesList .info .jibun {
            padding-left: 26px;
            background: url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_jibun.png) no-repeat;
        }

        #placesList .info .tel {
            color: #009900;
        }

        #placesList .item .markerbg {
            float: left;
            position: absolute;
            width: 36px;
            height: 37px;
            margin: 10px 0 0 10px;
            background: url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png) no-repeat;
        }

        #placesList .item .marker_1 {
            background-position: 0 -10px;
        }

        #placesList .item .marker_2 {
            background-position: 0 -56px;
        }

        #placesList .item .marker_3 {
            background-position: 0 -102px
        }

        #placesList .item .marker_4 {
            background-position: 0 -148px;
        }

        #placesList .item .marker_5 {
            background-position: 0 -194px;
        }

        #placesList .item .marker_6 {
            background-position: 0 -240px;
        }

        #placesList .item .marker_7 {
            background-position: 0 -286px;
        }

        #placesList .item .marker_8 {
            background-position: 0 -332px;
        }

        #placesList .item .marker_9 {
            background-position: 0 -378px;
        }

        #placesList .item .marker_10 {
            background-position: 0 -423px;
        }

        #placesList .item .marker_11 {
            background-position: 0 -470px;
        }

        #placesList .item .marker_12 {
            background-position: 0 -516px;
        }

        #placesList .item .marker_13 {
            background-position: 0 -562px;
        }

        #placesList .item .marker_14 {
            background-position: 0 -608px;
        }

        #placesList .item .marker_15 {
            background-position: 0 -654px;
        }

        #pagination {
            margin: 10px auto;
            text-align: center;
        }

        #pagination a {
            display: inline-block;
            margin-right: 10px;
        }

        #pagination .on {
            font-weight: bold;
            cursor: default;
            color: #777;
        }

        #detail {
            position: absolute;
            top: 0px;
            left: 580px;
            bottom: 0;
            width: 500px;
            height: 900px;
            margin: 10px 0 30px 10px;
            padding: 5px;
            overflow-y: auto;
            background: rgba(255, 255, 255, 0.7);
            z-index: 1;
            font-size: 12px;
            border-radius: 10px;
        }

        #kakaoWrap {
            width: 500px;
            hieght: 500px;
        }

        #addplan {
            position: absolute;
            top: 565px;
            left: 310px;
            bottom: 0;
            width: 100px;
            height: 100px;
            margin: 10px 0 30px 10px;
            padding: 5px;
            overflow-y: auto;
            background: rgba(255, 255, 255, 0.7);
            z-index: 1;
            font-size: 12px;
            /*border: 1px solid red;*/
        }

        #addWish {
            position: absolute;
            top: 565px;
            left: 510px;
            bottom: 0;
            width: 100px;
            height: 100px;
            margin: 10px 0 30px 10px;
            padding: 5px;
            overflow-y: auto;
            background: rgba(255, 255, 255, 0.7);
            z-index: 1;
            font-size: 12px;
            /*border: 1px solid red;*/
        }

        #planlist {
            position: absolute;
            top: 26px;
            left: 253px;
            bottom: 0;
            width: 300px;
            height: 463px;
            margin: 10px 0 30px 10px;
            padding: 5px;
            overflow-y: auto;
            background: rgba(255, 255, 255, 0.7);
            z-index: 1;
            font-size: 12px;
            /* border: 1px solid red; */
        }
        #schedule {
            position: absolute;
            top: 26px;
            left: 553px;
            bottom: 0;
            width: 300px;
            height: 463px;
            margin: 10px 0 30px 10px;
            padding: 5px;
            overflow-y: auto;
            background: rgba(255, 255, 255, 0.7);
            z-index: 1;
            font-size: 12px;
            /* border: 1px solid red; */
        }

    /*도시선택*/
        /* select with custom icons */
        .ui-selectmenu-menu .ui-menu.customicons .ui-menu-item-wrapper {
            padding: 0.5em 0 0.5em 3em;
        }
        .ui-selectmenu-menu .ui-menu.customicons .ui-menu-item .ui-icon {
            height: 24px;
            width: 24px;
            top: 0.1em;
        }
        .ui-icon.video {
            background: url("https://www.washingtonpost.com/wp-apps/imrs.php?src=https://arc-anglerfish-washpost-prod-washpost.s3.amazonaws.com/public/HB4AT3D3IMI6TMPTWIZ74WAR54.jpg&w=916") 0 0 no-repeat;
        }
        .ui-icon.podcast {
            background: url("https://www.washingtonpost.com/wp-apps/imrs.php?src=https://arc-anglerfish-washpost-prod-washpost.s3.amazonaws.com/public/HB4AT3D3IMI6TMPTWIZ74WAR54.jpg&w=916") 0 0 no-repeat;
        }
        .ui-icon.rss {
            background: url("https://www.washingtonpost.com/wp-apps/imrs.php?src=https://arc-anglerfish-washpost-prod-washpost.s3.amazonaws.com/public/HB4AT3D3IMI6TMPTWIZ74WAR54.jpg&w=916") 0 0 no-repeat;
        }

        /* select with CSS avatar icons */
        option.avatar {
            background-repeat: no-repeat !important;
            padding-left: 20px;
        }
        .avatar .ui-icon {
            background-position: left top;
        }



    </style>


</head>
<link href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
<body>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<link rel="stylesheet" href="//unpkg.com/bootstrap@4/dist/css/bootstrap.min.css">


<link href="//cdn.jsdelivr.net/gh/gitbrent/bootstrap4-toggle@3.4.0/css/bootstrap4-toggle.min.css" rel="stylesheet">
<script src="//cdn.jsdelivr.net/gh/gitbrent/bootstrap4-toggle@3.4.0/js/bootstrap4-toggle.min.js"></script>

<p style="margin-top:-12px">
    <em class="link">
        <a href="/web/documentation/#CategoryCode" target="_blank">카테고리 코드목록을 보시려면 여기를 클릭하세요!</a>
    </em>
</p>
<div class="map_wrap">
    <div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div>
    <ul id="category">
        <li id="all" data-order="1">
            <span class="category_bg store"></span>
            전체
        </li>
        <li id="AD5" data-order="2">
            <span class="category_bg store"></span>
            숙박시설
        </li>
        <li id="AT4" data-order="3">
            <span class="category_bg store"></span>
            관광명소
        </li>
        <li id="FD6" data-order="4">
            <span class="category_bg store"></span>
            음식점
        </li>
    </ul>
    <div id="menu_wrap" class="bg_white">
        <div class="option"></div>
        <hr>
        <ul id="placesList"></ul>
        <div id="pagination"></div>
    </div>
    <iframe id='detail'
            class="embed-responsive embed-responsive-16by9"
            src=''
            frameborder='0'
            scrolling='yes'
            style='width: 800px;'>
        <!--  onload="this.style.height=(this.contentWindow.document.body.scrollHeight+20)+'px';">-->

    </iframe>


    <div id="addplan" class="noshow">
        <form method="POST" action="/SIST2_Travel/plan/planadd.do">
            <span><img src=""></span>
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                 class="bi bi-check-lg" viewBox="0 0 16 16">
                <path d="M13.485 1.431a1.473 1.473 0 0 1 2.104 2.062l-7.84 9.801a1.473 1.473 0 0 1-2.12.04L.431 8.138a1.473 1.473 0 0 1 2.084-2.083l4.111 4.112 6.82-8.69a.486.486 0 0 1 .04-.045z"/>
            </svg>
            <input type="hidden" id="address_name"name="address_name" value="">
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
            <input type="submit" value="일정추가">
        </form>
    </div>
    <div id="addWish" class="noshow">
        <a href="!#">
            <span><img src=""></span>
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-lg"
                 viewBox="0 0 16 16">
                <path d="M13.485 1.431a1.473 1.473 0 0 1 2.104 2.062l-7.84 9.801a1.473 1.473 0 0 1-2.12.04L.431 8.138a1.473 1.473 0 0 1 2.084-2.083l4.111 4.112 6.82-8.69a.486.486 0 0 1 .04-.045z"/>
            </svg>
            <div>찜 추가</div>
        </a>
    </div>
</div>

<%--
todo:
리스트 출력
순서 드래그앤 드랍
날짜 정하기

마커끼리 선으로 연결

 --%>
<%----------------------------- 추가된 일정 리스트 ----------------------------%>
<form method="POST" action="/SIST2_Travel/plan/planadd.do">
<div class="plan sortable" id="planlist"  >
	
    <c:forEach items="${list}" var="dto" varStatus="status">

        <div class="list-group" >
            <div   class="list-group-item list-group-item-action">
            	<div id="seqname"></div>
                <div class="d-flex w-100 justify-content-between" data-seq="${status.index}">
                    <h5 class="mb-1">${dto.place_name}  ${status.index}</h5>
                    <small class="text-muted">${dto.category_group_name}</small>
                </div>
                <p class="mb-1">${dto.address_name}</p>
                <button type="button" class="close" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>

                    <%-- <small class="text-muted">And some muted small print.</small>--%>
            </div>
            <input type="hidden" name="planseq[]" value="${dto.planseq}">
            <input type="hidden" name="seq[]" value="">
        </div>
    </c:forEach>
	<input type="submit" value="일정 등록 완료">
</div>
</form>
<%-----------------------------------------달력---------------------------------%>
<%--<script>--%>
<%--    $( function() {--%>
<%--        $( "#datepicker" ).datepicker({--%>
<%--            showOn: "button",--%>
<%--            buttonImage: "https://d29fhpw069ctt2.cloudfront.net/icon/image/38308/preview.svg",--%>
<%--            buttonImageOnly: true,--%>
<%--            buttonText: "Select date"--%>
<%--        });--%>
<%--        $('.ui-datepicker-trigger').width('100px');--%>
<%--    } );--%>
<%--</script>--%>


<script>
    $( function() {
        var dateFormat = "yy-mm-dd",
            from = $( "#from" )
                .datepicker({
                    defaultDate: "+1w",
                    changeMonth: true,
                    numberOfMonths: 1,
                    dateFormat: 'yy-mm-dd'
                })
                .on( "change", function() {
                    to.datepicker( "option", "minDate", getDate( this ) );
                }),
            to = $( "#to" ).datepicker({
                defaultDate: "+1w",
                changeMonth: true,
                numberOfMonths: 1,
                dateFormat: 'yy-mm-dd'
            })
                .on( "change", function() {
                    from.datepicker( "option", "maxDate", getDate( this ) );
                });

        function getDate( element ) {
            var date;
            try {
                date = $.datepicker.parseDate( dateFormat, element.value );
            } catch( error ) {
                date = null;
            }

            return date;
        }
    } );
</script>
<%------------------------도시선택----------------------------%>
<%--<script>--%>
<%--    $( function() {--%>
<%--        $.widget( "custom.iconselectmenu", $.ui.selectmenu, {--%>
<%--            _renderItem: function( ul, item ) {--%>
<%--                var li = $( "<li>" ),--%>
<%--                    wrapper = $( "<div>", { text: item.label } );--%>

<%--                if ( item.disabled ) {--%>
<%--                    li.addClass( "ui-state-disabled" );--%>
<%--                }--%>

<%--                $( "<span>", {--%>
<%--                    style: item.element.attr( "data-style" ),--%>
<%--                    "class": "ui-icon " + item.element.attr( "data-class" )--%>
<%--                })--%>
<%--                    .appendTo( wrapper );--%>

<%--                return li.append( wrapper ).appendTo( ul );--%>
<%--            }--%>
<%--        });--%>


<%--        $( "#city" )--%>
<%--            .iconselectmenu()--%>
<%--            .iconselectmenu( "menuWidget")--%>
<%--            .addClass( "ui-menu-icons avatar" );--%>
<%--    } );--%>
<%--</script>--%>
<%--<p>Date: <input type="text" class="datepicker"></p>--%>


<%-----------------------------------------달력---------------------------------%>
<p>Date: <input type="text" id="datepicker"></p>
<div id="schedule" class="list-group list-group-flush border-bottom scrollarea">
    <form method="POST" action="/SIST2_Travel/plan/planinfo.do">
    <a href="#" class="list-group-item list-group-item-action active py-3 lh-tight" aria-current="true">
        <div class="w-100 align-items-center justify-content-between">
            <strong class="mb-1">전체 일정</strong>
            <div>일정 이름: <input type="text" id="name" name="name" autocomplete="off"></div>
<%--            <div>시작날짜 <span>Date: <input type="text" class="datepicker" id="datepicker_start" name="datepicker_start"></span> </div><br>--%>
<%--            <div>종료날짜:<span>Date: <input type="text" class="datepicker" id="datepicker_end" name="datepicker_end"></span> </div>
--%>
            <label for="from">From</label>
            <input type="text" id="from" name="daystarttravel">
            <label for="to">to</label>
            <input type="text" id="to" name="dayendtravel">

        </div>
        <div class="w-100 align-items-center justify-content-between">
            <h2>제목</h2>
            <fieldset>
                <select style="width:200px;" name="cityseq">
                    <c:forEach items='${citys}' var="citys">
                    <option value="${citys.cityseq}">${citys.name}</option>
                    </c:forEach>
                </select>
            </fieldset>
<%--
plan.java -> plan.jsp 에서 DB에있는 City정보를 plan.jsp에게 전달
plan.jsp에서 일정 정보를 planinfo.java에게 전달 planinfo.java에서 도시 좌표, 일 수 계산값을 planadd.jsp에게 전달
--%>
        </div>

        <div class="col-10 mb-1 small">공유여부:
<%--            <input type="checkbox" checked data-toggle="toggle" data-size="xs" name="willshare" id="willshare"--%>
<%--            class="willshare" value="y">--%>
<%--            <input type="ra"--%>

            <div class="form-check">
                <input class="form-check-input" type="radio" name="willshare" id="flexRadioDefault1" value="y" checked>
                <label class="form-check-label" for="flexRadioDefault1">
                    공유함
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="willshare" id="flexRadioDefault2" value="n">
                <label class="form-check-label" for="flexRadioDefault2">
                    공유안함
                </label>
            </div>
        </div>
        <input type="submit" value="일정 설정 완료">
<%--        <input type="hidden" value="${citys}" name="citys">--%>
    </a>
    </form>

citydto.setDaystarttravel(req.getParameter("daystarttravel"));
		citydto.setDayendtravel(req.getParameter("dayendtravel"));
<%--값 전달해서 보내주기--%>
<%--<c:set var="num" value="1" />--%>
<%--<c:set var="Day" value="Day"/>--%>
<%--<c:forEach var="test" begin="1" end= "${citydto.dayendtravel - citydto.daystarttravel}" step="1">   ---  반복할 횟수를 직접 지정하여 반복. step 생략 시 기본값으로 1--%>
<%--<c:out value="${test}" /> --%>
<%--</c:forEach>--%>


<%--<c:set var="num" value="1" />--%>
<%--<c:set var="Day" value="Day"/>--%>
<%--<c:forEach var="test" begin="1" end= "${citydto.days}" step="1">   ---  반복할 횟수를 직접 지정하여 반복. step 생략 시 기본값으로 1--%>
<%--<c:out value="${test}" /> --%>
<%--</c:forEach>--%>


    <a href="#" class="list-group-item list-group-item-action active py-3 lh-tight" aria-current="true">
        <div class="d-flex w-100 align-items-center justify-content-between">
            <strong class="mb-1">${"Day"}${num}</strong>
            <small>08.01</small>
        </div>
        <div class="col-10 mb-1 small">부산</div>
    </a>
    <a href="#" class="list-group-item list-group-item-action active py-3 lh-tight" aria-current="true">
        <div class="d-flex w-100 align-items-center justify-content-between">
            <strong class="mb-1">Day2</strong>
            <small>08.02</small>
        </div>
        <div class="col-10 mb-1 small">부산</div>
    </a>
    <a href="#" class="list-group-item list-group-item-action active py-3 lh-tight" aria-current="true">
        <div class="d-flex w-100 align-items-center justify-content-between">
            <strong class="mb-1">Day3</strong>
            <small>08.03</small>
        </div>
        <div class="col-10 mb-1 small">부산</div>
    </a>
</div>


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
            center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
            level: 5 // 지도의 확대 레벨
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

    // 카테고리 검색을 요청하는 함수입니다
    function searchPlaces() {
        if (!currCategory) {
            searchAll();
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
            var marker = addMarker(new kakao.maps.LatLng(places[i].y, places[i].x), order);


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
        // console.log('@' + places);
        var el = document.createElement('li'),
            itemStr = '<span class="markerbg marker_' + (index + 1) + '"></span>' +
                '<div class="info">' +
                '   <h5>' + places.place_name + '</h5>';

        if (places.road_address_name) {
            itemStr += '    <span>' + places.road_address_name + '</span>' +
                '   <span class="jibun gray">' + places.address_name + '</span>';
        } else {
            itemStr += '    <span>' + places.address_name + '</span>';
        }

        itemStr += '  <span class="tel">' + places.phone + '</span>' +
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
        var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_category.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
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


    // $( function() {
    //     $( '.sortable' ).sortable();
    //     $( '.sortable' ).disableSelection();
    // } );

     $('.sortable').sortable({
        start: function(e, ui) {
            // creates a temporary attribute on the element with the old index
            $(this).attr('data-previndex', ui.item.index());
            console.log(ui.item.index());
        },
        update: function(e, ui) {
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
     	stop: function(e,ui){
     		reorder();
     	}
    });
 
     function reorder() {
    	  $(".list-group input[name='seq']").each(function(i, box) {
    	 	 $(box).val(i + 1);
    	  });
    	  
    	}
    

     
     

   <%--  $('.sortable').sortable({
        start: function(e, ui) {
            // creates a temporary attribute on the element with the old index
            $(this).attr('data-previndex', ui.item.index());
            console.log(ui.item.index());
        },
        update: function(e, ui) {
            // gets the new and old index then removes the temporary attribute
            var newIndex = ui.item.index();
            var oldIndex = $(this).attr('data-previndex');
            $(this).removeAttr('data-previndex');
            // console.log(ui.item.index());
            // console.log($(this));
            // $('#seq').html=ui.item.index();
            // newIndex < -> oldIndex의 seq  SWAP?
            // 3번 -> 0번 3번 seq 데이터 0번 : 0번 ~n번 +1

			// 일정추가 -> 무조건 순서대로 넣는다.(마지막 seq) -> DB 데이터에 이 아이디 + 전체 일정 번호 중에 seq가 max...? max + 1
            // 일정받아오면 -> seq 줘야하는데..${status.index}이거로 초기화
            // 여기서 순서대로 정렬시킨 -> DB size(); order by

            //1. n번 -> m번으로 이동하면
            // ------------------ 이함수실행시 1번 시작

            //2. seq가 m번과 같거나 큰 애들은 각 seq를 +1
            // seq 기준???
            //3. n번의 seq는 m이 된다.

            // $('[data-input-type="test"')
           // <div class="d-flex w-100 justify-content-between" data-seq="${status.index}">
            // $('.seq').data('seq', newIndex);
		document.getElementById("seq").innerHTML=ui.item.index();

        }
    }); --%>
</script>


</body>
</html>