<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TP</title>

<%@ include file="/inc/asset.jsp"%>

<style>
.main-section {
	padding: 100px;
}

#container {
	width: 1100px;
	margin: 0px auto 50px auto;
}

.class th {
	background-color: #EEE;
}

#cover {
	width: 1100px;
	height: 350px;
	margin: 10px auto 0px auto;
	top: 0;
	left: 0;
	position: relative;
}

.cover_img {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	box-sizing: border-box;
	width: 100%;
	height: 350px;
	z-index: 1;
	background:
		url('http://img.earthtory.com/img/city_images/245/hong-kong_1425535299.jpg')
		no-repeat;
	background-size: cover;
	background-position: center center;
}

#menu {
	width: 1100px;
	height: 70px;
	font-size: 12pt;
	font-family: font-family : "Malgun Gothic", dotum, 돋움, sans-serif;
	background: white;
	padding-right: 20px;
	cursor: pointer;
	border-left: 1px solid #c8c8ca;
	border-right: 1px solid #c8c8ca;
	border-bottom: 1px solid #c8c8ca;
	position: relative;
	top: 0;
	left: 0;
}

.plan_mnu {
	display: block;
	height: 70px;
	line-height: 70px;
	padding-left: 35px;
	padding-right: 35px;
	font-size: 18px;
	color: #808080;
	float: left;
}

.plan_mnu_line {
	float: left;
	width: 1px;
	height: 24px;
	background: #b3b3b3;
	margin-top: 22px;
}

#user {
	width: 46px;
	height: 46px;
	position: absolute;
	bottom: 110px;
	left: 25px;
}

#nick {
	position: absolute;
	bottom: 112px;
	left: 82px;
	font-size: margin: 0;
	padding: 0;
	border: 0;
	color: white;
	font-size: 23px;
	font-weight: bold;
}

#planname {
	margin: 0;
	padding: 0;
	border: 0;
	color: white;
	font-weight: bold;
	font-size: 28px;
	position: absolute;
	bottom: 57px;
	left: 25px;
}

#plandate {
	position: absolute;
	bottom: 27px;
	left: 25px;
	margin: 0;
	padding: 0;
	border: 0;
	color: white;
	font-size: 16px;
	line-height: 20px;
	color: white;
}

.day_box {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	box-sizing: border-box;
	width: 100%;
	padding-bottom: 30px;
}

.day_info_box {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	box-sizing: border-box;
	width: 100%;
	height: 60px;
}

.day_txt {
	margin: 0;
	padding: 0;
	border: 0;
	font: inherit;
	box-sizing: border-box;
	float: left;
	background: #203341;
	height: 60px;
	line-height: 60px;
	color: white;
	font-weight: bold;
	font-size: 22px;
	width: 110px;
	text-align: center;
}

.day_info {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	box-sizing: border-box;
	float: left;
	width: 609px;
	background: white;
	border-top: 1px solid #e5e5e5;
	border-right: 1px solid #e5e5e5;
	height: 60px;
}

.day_info_left {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	box-sizing: border-box;
	float: left;
	width: 430px;
	padding-left: 10px;
}

.date {
	margin: 0;
	padding: 0;
	border: 0;
	font: inherit;
	box-sizing: border-box;
	font-size: 12px;
	color: #b3b3b3;
	font-weight: bold;
	padding-top: 13px;
}

.day_title {
	margin: 0;
	padding: 0;
	border: 0;
	font: inherit;
	box-sizing: border-box;
	color: #363636;
	font-weight: bold;
	font-size: 18px;
	padding-top: 0px;
}

.clear {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	box-sizing: border-box;
	clear: both;
}

.day_sch_box {
	margin: 0;
	padding: 0;
	font-size: 100%;
	font: inherit;
	box-sizing: border-box;
	width: 100%;
	border: 1px solid #e5e5e5;
	background: white;
	min-height: 100px;
}

.day_sch_num {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	box-sizing: border-box;
	height: 100%;
	text-align: center;
	float: left;
	width: 110px;
}

.sch_num {
	padding: 0;
	border: 0;
	font: inherit;
	box-sizing: border-box;
	width: 30px;
	height: 30px;
	border-radius: 50%;
	color: white;
	background: #223b68;
	margin: 0 auto;
	font-size: 18px;
	font-weight: bold;
	line-height: 32px;
	text-align: center;
	margin-top: 35px;
}

.sch_content {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	box-sizing: border-box;
	width: 604px;
	float: left;
	padding-top: 15px;
}

.spot_content_box {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	box-sizing: border-box;
	width: 425px;
	float: left;
	padding-left: 10px;
}

.spot_name {
	margin: 0;
	padding: 0;
	border: 0;
	font: inherit;
	box-sizing: border-box;
	font-size: 17px;
	color: #555555;
	font-weight: bold;
}

.day_sch_distance {
	margin: 0;
	padding: 0;
	border: 0;
	font: inherit;
	box-sizing: border-box;
	width: 719px;
	border-left: 1px solid #e5e5e5;
	border-right: 1px solid #e5e5e5;
	height: 28px;
	line-height: 30px;
	background: url('/res/img/mypage/plan/sub/distance_line.gif') no-repeat;
	background-position: 57px center;
	padding-left: 117px;
	color: #555555;
	font-size: 12px;
}

.spot_btn_box {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	box-sizing: border-box;
	width: 109px;
	float: left;
	height: 100%;
	padding-right: 15px;
	margin-top: 20px;
}

.page_left {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	float: left;
	width: 744px;
	min-height: 500px;
	padding-right: 25px;
}

.spot_detail {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	float: right;
	margin-left: 15px;
	cursor: pointer;
	width: 35px;
	height: 35px;
}

.page_right {
	margin: 0;
	padding: 0;
	border: 1px solid blue;

	/* float: left; */
	width: 348px;
	position: absoulte;
	height: 100vh;
/* 	top: -3057px;
	left: 547px; */
}

.right_scroll_box {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	box-sizing: border-box;
	
	width: 348px;
	
	margin-left: 198px;
	height: 500px;
}

.map_box {
	margin: 0;
	padding: 0;
	font-size: 100%;
	font: inherit;
	box-sizing: border-box;
	width: 100%;
	height: 500px;
	border-bottom: 1px solid #e5e5e5;
	border-top: 1px solid #e5e5e5;
	border-right: 1px solid #e5e5e5;
	border-left: 1px solid #e5e5e5;
	background: white;
/* 	overflow: hidden; */
	position: sticky;
	top: 100px;
}

.wrap_page_show{
    padding: 0;
    border: 0;
    font-size: 100%;
    font: inherit;
    box-sizing: border-box;
    width: 1092px;
    margin: 0 auto;
    position: relative;
    margin-top: 30px;
    padding-bottom: 60px;
    display: block;
}

</style>

</head>
<body onload="noBack();" onpageshow="if(event.persisted) noBack();"
	onunload="">
	<!-- template.jsp > management > detailview.jsp -->
	<%@ include file="/inc/header.jsp"%>

	<section class="main-section" style="padding: 0px;">
		<div id="container">

			<div id="cover">
			<div class="cover_img" style="background:url('http://img.earthtory.com/img/city_default/205/310.jpg') no-repeat;background-size:cover;background-position:center center;"></div>
				
				<img id="user"
					src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pg0KPCEtLSBHZW5lcmF0b3I6IEFkb2JlIElsbHVzdHJhdG9yIDE5LjAuMCwgU1ZHIEV4cG9ydCBQbHVnLUluIC4gU1ZHIFZlcnNpb246IDYuMDAgQnVpbGQgMCkgIC0tPg0KPHN2ZyB2ZXJzaW9uPSIxLjEiIGlkPSJDYXBhXzEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHg9IjBweCIgeT0iMHB4Ig0KCSB2aWV3Qm94PSIwIDAgNTMgNTMiIHN0eWxlPSJlbmFibGUtYmFja2dyb3VuZDpuZXcgMCAwIDUzIDUzOyIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+DQo8cGF0aCBzdHlsZT0iZmlsbDojRTdFQ0VEOyIgZD0iTTE4LjYxMyw0MS41NTJsLTcuOTA3LDQuMzEzYy0wLjQ2NCwwLjI1My0wLjg4MSwwLjU2NC0xLjI2OSwwLjkwM0MxNC4wNDcsNTAuNjU1LDE5Ljk5OCw1MywyNi41LDUzDQoJYzYuNDU0LDAsMTIuMzY3LTIuMzEsMTYuOTY0LTYuMTQ0Yy0wLjQyNC0wLjM1OC0wLjg4NC0wLjY4LTEuMzk0LTAuOTM0bC04LjQ2Ny00LjIzM2MtMS4wOTQtMC41NDctMS43ODUtMS42NjUtMS43ODUtMi44ODh2LTMuMzIyDQoJYzAuMjM4LTAuMjcxLDAuNTEtMC42MTksMC44MDEtMS4wM2MxLjE1NC0xLjYzLDIuMDI3LTMuNDIzLDIuNjMyLTUuMzA0YzEuMDg2LTAuMzM1LDEuODg2LTEuMzM4LDEuODg2LTIuNTN2LTMuNTQ2DQoJYzAtMC43OC0wLjM0Ny0xLjQ3Ny0wLjg4Ni0xLjk2NXYtNS4xMjZjMCwwLDEuMDUzLTcuOTc3LTkuNzUtNy45NzdzLTkuNzUsNy45NzctOS43NSw3Ljk3N3Y1LjEyNg0KCWMtMC41NCwwLjQ4OC0wLjg4NiwxLjE4NS0wLjg4NiwxLjk2NXYzLjU0NmMwLDAuOTM0LDAuNDkxLDEuNzU2LDEuMjI2LDIuMjMxYzAuODg2LDMuODU3LDMuMjA2LDYuNjMzLDMuMjA2LDYuNjMzdjMuMjQNCglDMjAuMjk2LDM5Ljg5OSwxOS42NSw0MC45ODYsMTguNjEzLDQxLjU1MnoiLz4NCjxnPg0KCTxwYXRoIHN0eWxlPSJmaWxsOiM1NTYwODA7IiBkPSJNMjYuOTUzLDAuMDA0QzEyLjMyLTAuMjQ2LDAuMjU0LDExLjQxNCwwLjAwNCwyNi4wNDdDLTAuMTM4LDM0LjM0NCwzLjU2LDQxLjgwMSw5LjQ0OCw0Ni43Ng0KCQljMC4zODUtMC4zMzYsMC43OTgtMC42NDQsMS4yNTctMC44OTRsNy45MDctNC4zMTNjMS4wMzctMC41NjYsMS42ODMtMS42NTMsMS42ODMtMi44MzV2LTMuMjRjMCwwLTIuMzIxLTIuNzc2LTMuMjA2LTYuNjMzDQoJCWMtMC43MzQtMC40NzUtMS4yMjYtMS4yOTYtMS4yMjYtMi4yMzF2LTMuNTQ2YzAtMC43OCwwLjM0Ny0xLjQ3NywwLjg4Ni0xLjk2NXYtNS4xMjZjMCwwLTEuMDUzLTcuOTc3LDkuNzUtNy45NzcNCgkJczkuNzUsNy45NzcsOS43NSw3Ljk3N3Y1LjEyNmMwLjU0LDAuNDg4LDAuODg2LDEuMTg1LDAuODg2LDEuOTY1djMuNTQ2YzAsMS4xOTItMC44LDIuMTk1LTEuODg2LDIuNTMNCgkJYy0wLjYwNSwxLjg4MS0xLjQ3OCwzLjY3NC0yLjYzMiw1LjMwNGMtMC4yOTEsMC40MTEtMC41NjMsMC43NTktMC44MDEsMS4wM1YzOC44YzAsMS4yMjMsMC42OTEsMi4zNDIsMS43ODUsMi44ODhsOC40NjcsNC4yMzMNCgkJYzAuNTA4LDAuMjU0LDAuOTY3LDAuNTc1LDEuMzksMC45MzJjNS43MS00Ljc2Miw5LjM5OS0xMS44ODIsOS41MzYtMTkuOUM1My4yNDYsMTIuMzIsNDEuNTg3LDAuMjU0LDI2Ljk1MywwLjAwNHoiLz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjwvc3ZnPg0K" />
				<div id="nick">${nick}</div>
				<div id="planname">${plan.name}</div>
				<div id="plandate">${plan.daystarttravel}~
					${plan.dayendtravel} (${fn:length(datelist)}일)</div>

			</div>

			<div id="menu">
				<div class="plan_mnu on">개요</div>
				<div class="plan_mnu_line"></div>
				<div class="plan_mnu">일정표</div>
				<div class="plan_mnu_line"></div>
				<div class="plan_mnu">지도</div>
				<div class="plan_mnu_line"></div>
				<div class="plan_mnu" data-id="3">댓글</div>
			</div>

			<br> <br> <br>

			<div class="wrap_page_show">
			<div class="page_left">

				<div class="day_box" data-id="1">
					<c:forEach items="${datelist}" var="date" varStatus="status">
						<div class="day_info_box">
							<div class="day_txt">DAY ${status.count}</div>
							<div class="day_info">
								<div class="day_info_left">
									<div class="date">${date}</div>
									<div class="day_title">${plan.cityname}</div>
								</div>
								<div class="day_info_right" style="display: none;"></div>
								<div class="clear"></div>
							</div>
							<div class="clear"></div>
						</div>
						<c:forEach items="${list}" var="dto" varStatus="instatus">
							<c:if test="${date eq dto.rdate}">
								<div class="day_sch_box" data-id="1-1">
									<div class="day_sch_num">
										<div class="sch_num">${instatus.count}</div>
									</div>
									<div class="sch_content">
										<div class="spot_content_box">
											<div class="spot_name">${dto.place_name}</div>
											<div class="spot_info">
												<div class="my_cate ht">${dto.category_group_name}</div>
												<div class="sinfo_line"></div>
												<div class="sinfo_txt">${dto.address_name}</div>
												<div class="clear"></div>
											</div>
										</div>
										<div class="spot_btn_box">
											<img class="spot_detail"
												onclick="window.open=('${dto.place_url}')"
												src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pg0KPCEtLSBHZW5lcmF0b3I6IEFkb2JlIElsbHVzdHJhdG9yIDE5LjAuMCwgU1ZHIEV4cG9ydCBQbHVnLUluIC4gU1ZHIFZlcnNpb246IDYuMDAgQnVpbGQgMCkgIC0tPg0KPHN2ZyB2ZXJzaW9uPSIxLjEiIGlkPSJDYXBhXzEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHg9IjBweCIgeT0iMHB4Ig0KCSB2aWV3Qm94PSIwIDAgNTEyIDUxMiIgc3R5bGU9ImVuYWJsZS1iYWNrZ3JvdW5kOm5ldyAwIDAgNTEyIDUxMjsiIHhtbDpzcGFjZT0icHJlc2VydmUiPg0KPHBhdGggc3R5bGU9ImZpbGw6IzBBNEVBRjsiIGQ9Ik0yNTYsNTEyYy02OC4zOCwwLTEzMi42NjctMjYuNjI5LTE4MS4wMi03NC45OEMyNi42MjksMzg4LjY2NywwLDMyNC4zOCwwLDI1Ng0KCVMyNi42MjksMTIzLjMzMyw3NC45OCw3NC45OEMxMjMuMzMzLDI2LjYyOSwxODcuNjIsMCwyNTYsMHMxMzIuNjY3LDI2LjYyOSwxODEuMDIsNzQuOThDNDg1LjM3MSwxMjMuMzMzLDUxMiwxODcuNjIsNTEyLDI1Ng0KCXMtMjYuNjI5LDEzMi42NjctNzQuOTgsMTgxLjAyQzM4OC42NjcsNDg1LjM3MSwzMjQuMzgsNTEyLDI1Niw1MTJ6Ii8+DQo8cGF0aCBzdHlsZT0iZmlsbDojMDYzRThCOyIgZD0iTTQzNy4wMiw3NC45OEMzODguNjY3LDI2LjYyOSwzMjQuMzgsMCwyNTYsMHY1MTJjNjguMzgsMCwxMzIuNjY3LTI2LjYyOSwxODEuMDItNzQuOTgNCglDNDg1LjM3MSwzODguNjY3LDUxMiwzMjQuMzgsNTEyLDI1NlM0ODUuMzcxLDEyMy4zMzMsNDM3LjAyLDc0Ljk4eiIvPg0KPHBhdGggc3R5bGU9ImZpbGw6I0ZGRkZGRjsiIGQ9Ik0yNTYsMTg1Yy0zMC4zMjcsMC01NS0yNC42NzMtNTUtNTVzMjQuNjczLTU1LDU1LTU1czU1LDI0LjY3Myw1NSw1NVMyODYuMzI3LDE4NSwyNTYsMTg1eiBNMzAxLDM5NQ0KCVYyMTVIMTkxdjMwaDMwdjE1MGgtMzB2MzBoMTQwdi0zMEgzMDF6Ii8+DQo8Zz4NCgk8cGF0aCBzdHlsZT0iZmlsbDojQ0NFRkZGOyIgZD0iTTI1NiwxODVjMzAuMzI3LDAsNTUtMjQuNjczLDU1LTU1cy0yNC42NzMtNTUtNTUtNTVWMTg1eiIvPg0KCTxwb2x5Z29uIHN0eWxlPSJmaWxsOiNDQ0VGRkY7IiBwb2ludHM9IjMwMSwzOTUgMzAxLDIxNSAyNTYsMjE1IDI1Niw0MjUgMzMxLDQyNSAzMzEsMzk1IAkiLz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjwvc3ZnPg0K" />
											<div class="clear"></div>
										</div>
										<div class="clear"></div>
									</div>
									<div class="clear"></div>
								</div>
								<div class="day_sch_distance"></div>
							</c:if>

						</c:forEach>
					</c:forEach>
				</div>
				<button class="btn btn-primary"
					onclick="location.href='/SIST2_Travel/plan/between.do?planseq=${plan.planseq}&isedit=y';">수정하기
				</button>
				<button class="btn btn-default"
					onclick="location.href='/SIST2_Travel/management/back.do';">돌아가기
				</button>
			</div>
		<div style="clear: both;"></div>
		<div class="page_right">
			<div class="right_scroll_box"
				style="position: sticky; width: 348px; top: 100px; ">
				<div class="map_box" id="map"
					style="position: relative; overflow: hidden;">
	
					
				</div>
			</div>
		</div>
		</div>
		
	</div>


	</section>

	<%@ include file="/inc/init.jsp"%>
	<%@ include file="/inc/footer.jsp"%>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=a59ab72fe6eb98f4d9b891ada5aaa375"></script>
	<script>
		function noEvent() { // 새로 고침 방지
			if (event.keyCode == 116) {
				alert("새로고침을 할 수 없습니다.");
				event.keyCode = 2;
				return false;
			} else if (event.ctrlKey
					&& (event.keyCode == 78 || event.keyCode == 82)) {
				return false;
			}
		}

		document.onkeydown = noEvent;

		window.history.forward();

		function noBack() {
			window.history.forward();
		}
		
		var container = document.getElementById('map'); // 지도 태그 선택
		
		var options = {
			center: new daum.maps.LatLng(${plan.cityY}, ${plan.cityX}), // 지도의 중앙 좌표
			level: 10 // 지도의 레벨(확대,축소)
		};
		
		var map = new daum.maps.Map(container, options); //지도 생성
		
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
            strokeColor: '#4384D9', // 선의 색깔입니다 #FFAE00
            strokeOpacity: 0.7, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
            strokeStyle: 'solid' // 선의 스타일입니다
        });

        // 지도에 선을 표시합니다
        polyline.setMap(map);
		
		
        var positions = [
        	<c:forEach items="${list}" var="dto" varStatus="status">
            {
                title: '${dto.place_name}', 
                content: '<div>${dto.place_name}</div>', 
                latlng: new kakao.maps.LatLng(${dto.y}, ${dto.x})
            }
            
            <c:if test="${list.size()-1 > status.index}">
            ,
            </c:if>
            </c:forEach>
        ];
        
        var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
        
        for (var i = 0; i < positions.length; i ++) {
            
            // 마커 이미지의 이미지 크기 입니다
            var imageSize = new kakao.maps.Size(24, 35); 
            
            // 마커 이미지를 생성합니다    
            var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
            
            // 마커를 생성합니다
            var marker = new kakao.maps.Marker({
                map: map, // 마커를 표시할 지도
                position: positions[i].latlng, // 마커를 표시할 위치
                title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
                image : markerImage // 마커 이미지 
            });
            
            // 마커에 표시할 인포윈도우를 생성합니다 
            var infowindow = new kakao.maps.InfoWindow({
                content: positions[i].content // 인포윈도우에 표시할 내용
            });

            // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
            // 이벤트 리스너로는 클로저를 만들어 등록합니다 
            // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
            kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
            kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
        }
        
     // 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
        function makeOverListener(map, marker, infowindow) {
            return function() {
                infowindow.open(map, marker);
            };
        }

        // 인포윈도우를 닫는 클로저를 만드는 함수입니다 
        function makeOutListener(infowindow) {
            return function() {
                infowindow.close();
            };
        }
	</script>
</body>
</html>















