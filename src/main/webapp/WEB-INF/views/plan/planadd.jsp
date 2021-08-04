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

        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>

    <%--    <link href="//cdn.jsdelivr.net/gh/gitbrent/bootstrap4-toggle@3.4.0/css/bootstrap4-toggle.min.css" rel="stylesheet">--%>
    <%--    <script src="//cdn.jsdelivr.net/gh/gitbrent/bootstrap4-toggle@3.4.0/js/bootstrap4-toggle.min.js"></script>--%>
    <%--    <link rel="stylesheet" href="//unpkg.com/bootstrap@4/dist/css/bootstrap.min.css">--%>
    <style>
         #xdetail2{
            position: absolute;
            left: 1500px;
            top: 40px;
            z-index: 2000;
            font-size:50px;
        }
        #xdetail{
            position: absolute;
            left: 520px;
            top: 12px;
            z-index: 2000;
            font-size:12px;
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
        #button-addon1{
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
            transition: color .15s ease-in-out,background-color .15s ease-in-out,border-color .15s ease-in-out,box-shadow .15s ease-in-out;
            font-weight: 400;
            text-decoration: none;
            color: #007bff!important;
            position: relative;
            z-index: 2;
            cursor: pointer;
            border-top-left-radius: 0;
            border-bottom-left-radius: 0;
            left: 262px;
            top: -37px;
            width: 35px;
        }
        #category li{
            font-size: 16px;
            font-weight: bold;
        }
        
             
   #schedule > form > a {
    background-color:#203341;
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
    padding: 10px;
    overflow-y: auto;
    background: rgba(255, 255, 255, 0.7);
    z-index: 1;
    font-size: 12px;
    /* border: 1px solid red; */
}

#schedule {
    position: absolute;
    top: 0px;
    left: 0px;
    bottom: 0;
    width: 300px;
    height: 463px;
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
   	width: 150px;
   	background-color: #203341;
   	border-color: #203341;
   	margin-left: 50px;
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
            <div class="city_name">${city.name} <div id="on_city_close_btn"></div></div>
            <div class="search">
                <form onsubmit="searchPlaces2(); return false;">
                    <input type="text" class="textbox form-control" placeholder="키워드를 입력하세요." id="keyword"
                           value="서울 여행">
                    <button id="button-addon1" type="submit" class="btn btn-link text-primary"><i class="fa fa-search"></i></button>
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
    <div id="detail-box">
    
   <!-- -->
	    <iframe id='detail' 
			    name=naver onload="naver.scrollTo(40,100);"
			    class="embed-responsive embed-responsive-16by9 invisible"
			    style="-webkit-transform:scale(0.7);"
	            src=''
	            frameborder='0'
	            scrolling='yes'>
	        <!--  onload="this.style.height=(this.contentWindow.document.body.scrollHeight+20)+'px';">-->
	        <%--        <button id="xdetail2" type="button" class="btn-close" aria-label="Close">X</button>--%>
	    </iframe>
	    
	    <div id="detailbtns" class="invisible">
	    <button id="xdetail" type="button" class="invisible" >
	   	<img id="xdetailimg" src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pg0KPCEtLSBHZW5lcmF0b3I6IEFkb2JlIElsbHVzdHJhdG9yIDE5LjAuMCwgU1ZHIEV4cG9ydCBQbHVnLUluIC4gU1ZHIFZlcnNpb246IDYuMDAgQnVpbGQgMCkgIC0tPg0KPHN2ZyB2ZXJzaW9uPSIxLjEiIGlkPSJMYXllcl8xIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHhtbG5zOnhsaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rIiB4PSIwcHgiIHk9IjBweCINCgkgdmlld0JveD0iMCAwIDM3OC4zMDIgMzc4LjMwMiIgc3R5bGU9ImVuYWJsZS1iYWNrZ3JvdW5kOm5ldyAwIDAgMzc4LjMwMiAzNzguMzAyOyIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+DQo8cG9seWdvbiBzdHlsZT0iZmlsbDojMjQ4OEZGOyIgcG9pbnRzPSIzNzguMzAyLDI4LjI4NCAzNTAuMDE3LDAgMTg5LjE1MSwxNjAuODY3IDI4LjI4NCwwIDAsMjguMjg0IDE2MC44NjYsMTg5LjE1MSAwLDM1MC4wMTggDQoJMjguMjg0LDM3OC4zMDIgMTg5LjE1MSwyMTcuNDM2IDM1MC4wMTcsMzc4LjMwMiAzNzguMzAyLDM1MC4wMTggMjE3LjQzNSwxODkuMTUxICIvPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPC9zdmc+DQo=" />
	    창 닫기</button>
		        <%---------------------- 일정추가  rdate + 전체 일정 dto 추가----------------------------%>
	    <div id="addplan" class="noshow" >
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
	
	            <button id="addplanbtn" class ="invisible" type="submit" >
	            <img id="addplanimg" src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pg0KPCEtLSBHZW5lcmF0b3I6IEFkb2JlIElsbHVzdHJhdG9yIDE5LjAuMCwgU1ZHIEV4cG9ydCBQbHVnLUluIC4gU1ZHIFZlcnNpb246IDYuMDAgQnVpbGQgMCkgIC0tPg0KPHN2ZyB2ZXJzaW9uPSIxLjEiIGlkPSJMYXllcl8xIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHhtbG5zOnhsaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rIiB4PSIwcHgiIHk9IjBweCINCgkgdmlld0JveD0iMCAwIDQ5NSA0OTUiIHN0eWxlPSJlbmFibGUtYmFja2dyb3VuZDpuZXcgMCAwIDQ5NSA0OTU7IiB4bWw6c3BhY2U9InByZXNlcnZlIj4NCjxnPg0KCTxwb2x5Z29uIHN0eWxlPSJmaWxsOiNCRERCRkY7IiBwb2ludHM9IjIyNy41LDM3OS4xMzMgMjI3LjUsMjY3LjUgMTE1Ljg2NSwyNjcuNSAxMTUuODY1LDIyNy41IDIyNy41LDIyNy41IDIyNy41LDExNS44NjcgDQoJCTI0Ny41LDExNS44NjcgMjQ3LjUsMCAwLDAgMCw0OTUgMjQ3LjUsNDk1IDI0Ny41LDM3OS4xMzMgCSIvPg0KCTxwb2x5Z29uIHN0eWxlPSJmaWxsOiM5QkM5RkY7IiBwb2ludHM9IjI0Ny41LDAgMjQ3LjUsMTE1Ljg2NyAyNjcuNSwxMTUuODY3IDI2Ny41LDIyNy41IDM3OS4xMzUsMjI3LjUgMzc5LjEzNSwyNjcuNSAyNjcuNSwyNjcuNSANCgkJMjY3LjUsMzc5LjEzMyAyNDcuNSwzNzkuMTMzIDI0Ny41LDQ5NSA0OTUsNDk1IDQ5NSwwIAkiLz4NCgk8cG9seWdvbiBzdHlsZT0iZmlsbDojMjQ4OEZGOyIgcG9pbnRzPSIyMjcuNSwyMjcuNSAxMTUuODY1LDIyNy41IDExNS44NjUsMjY3LjUgMjI3LjUsMjY3LjUgMjI3LjUsMzc5LjEzMyAyNjcuNSwzNzkuMTMzIA0KCQkyNjcuNSwyNjcuNSAzNzkuMTM1LDI2Ny41IDM3OS4xMzUsMjI3LjUgMjY3LjUsMjI3LjUgMjY3LjUsMTE1Ljg2NyAyMjcuNSwxMTUuODY3IAkiLz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjwvc3ZnPg0K" />
	            일정 추가</button>
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
	            <button type="button" id="addWishbtn" class="invisible">
	            <img id="addwishimg" src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pg0KPCEtLSBHZW5lcmF0b3I6IEFkb2JlIElsbHVzdHJhdG9yIDE5LjAuMCwgU1ZHIEV4cG9ydCBQbHVnLUluIC4gU1ZHIFZlcnNpb246IDYuMDAgQnVpbGQgMCkgIC0tPg0KPHN2ZyB2ZXJzaW9uPSIxLjEiIGlkPSJMYXllcl8xIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHhtbG5zOnhsaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rIiB4PSIwcHgiIHk9IjBweCINCgkgdmlld0JveD0iMCAwIDUwMS4yOCA1MDEuMjgiIHN0eWxlPSJlbmFibGUtYmFja2dyb3VuZDpuZXcgMCAwIDUwMS4yOCA1MDEuMjg7IiB4bWw6c3BhY2U9InByZXNlcnZlIj4NCjxnPg0KCTxwb2x5Z29uIHN0eWxlPSJmaWxsOiNGRkNEMDA7IiBwb2ludHM9IjUwMS4yOCwxOTQuMzcgMzM1LjI2LDE1OS4zMyAyNTAuNjQsMTIuMjcgMjUwLjY0LDQxOS43NyA0MDUuNTQsNDg5LjAxIDM4Ny41NiwzMjAuMjkgCSIvPg0KCTxwb2x5Z29uIHN0eWxlPSJmaWxsOiNGRkRBNDQ7IiBwb2ludHM9IjE2Ni4wMiwxNTkuMzMgMCwxOTQuMzcgMTEzLjcyLDMyMC4yOSA5NS43NCw0ODkuMDEgMjUwLjY0LDQxOS43NyAyNTAuNjQsMTIuMjcgCSIvPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPC9zdmc+DQo=" />
	            찜 추가</button>
	    </div>
	</div>
	</div>
	
</div>

<%----------------------------- 추가된 일정 리스트 ----------------------------%>
<form id="getlist" method="POST" action="/SIST2_Travel/plan/plandel.do">
    
    <div class="plan sortable" id="planlist">
		<div>여기에 버튼 넣기</div>
        <c:forEach items="${list}" var="dto" varStatus="status">

            <div class="list-group">
                <div class="list-group-item list-group-item-action">
                    <div id="seqname"></div>
                    <div class="d-flex w-100 justify-content-between" data-seq="${status.index}">
                        <h5 class="mb-1">${dto.place_name} ${status.index}</h5>
                        <small class="text-muted">${dto.category_group_name}</small>
                    </div>
                    <p class="mb-1">${dto.address_name}</p>
                    <button type="submit" class="close" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>


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


                        <%--                    <input type="hidden" name="datelist" value="${datelist}">--%>
                </div>
                <input type="hidden" name="planseq" value="${dto.plan2seq}">
                <input type="hidden" name="seq" value="${status.count}">
            </div>
        </c:forEach>
    </div>
    <c:forEach items="${datelist}" var="list">
        <input type="hidden" name="datelist" value="${list}">
    </c:forEach>

</form>


<%-------------------------------일정 등록 완료------------------------%>
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


<%---------------------------------일정---------------------------------%>
<div id="schedule" class="list-group list-group-flush border-bottom scrollarea">
    <form method="POST" action="/SIST2_Travel/plan/planinfo.do">
        <a href="#" class="list-group-item list-group-item-action active py-3 lh-tight" aria-current="true">
            <div class="w-100 align-items-center justify-content-between">
                <strong class="mb-1">전체 일정</strong>
                <div>일정 이름: <input type="text" id="name" name="name" autocomplete="off" value="${citydto.name}"></div>

                <label for="from">From</label>
                <input type="text" id="from" name="daystarttravel" value="${citydto.daystarttravel}">
                <br>
                <label for="to">to</label>
                <input type="text" id="to" name="dayendtravel" value="${citydto.dayendtravel}">

            </div>
            <div class="w-100 align-items-center justify-content-between">
                <fieldset>
                    <select style="width:200px;" name="cityseq">
                        <c:forEach items='${citys}' var="citys">
                            <option value="${city.name}">${citys.name}</option>
                        </c:forEach>
                    </select>
                </fieldset>

            </div>
            <div class="col-10 mb-1 small">공유여부:

                <div class="form-check">
                    <input class="form-check-input" type="radio" name="willshare" id="flexRadioDefault1" value="y"
                           checked>
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
        </a>
    </form>
    <%--    ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ전체일정ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ--%>
    <c:forEach items="${datelist}" var="list" varStatus="status">
    <div id="schedulelist" class="list-group">
        <form id="my_form" method="POST" action="/SIST2_Travel/plan/planscd.do">
            <input type="submit" value="${'Day'} ${status.count} ${list}" class="btn btn-primary">

            <div class="d-flex w-100 align-items-center justify-content-between">
                <strong class="mb-1">${"Day"} ${status.count}</strong>
                <small>${list}</small>
            </div>
            <div class="col-10 mb-1 small">${city.name}</div>
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
        $("#detail").removeClass("invisible");
        $("#xdetail").removeClass("invisible");
        $("#addplanbtn").removeClass("invisible");
        $("#addWishbtn").removeClass("invisible");
        $("#detailbtns").removeClass("invisible");
    });
    $("#xdetail").click(function () {
        $("#detail").addClass("invisible");
        $("#xdetail").addClass("invisible");
        $("#addplanbtn").addClass("invisible");
        $("#addWishbtn").addClass("invisible");
        $("#detailbtns").addClass("invisible");
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
        $('#menu_wrap').on('click','#on_city_close_btn',function(){
            $('#menu_wrap').hide("slide", { direction: "left" }, 200);
            deleteMarkers(0);
        	map_resize(1);
        });
        $('#on_city_open_btn').click(function(){
            $('#menu_wrap').show("slide", { direction: "left" }, 200);
        	$('#cat_menu li.on').click();
        });


    </script>


</body>
</html>