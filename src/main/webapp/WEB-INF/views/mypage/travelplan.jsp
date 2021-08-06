<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행 병아리들을 위한 여행계획사이트 티피~~</title>

<%@ include file="/inc/asset.jsp"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


<style>
#container {
	width: 1100px;
	height: 700px;
	margin: 0px auto 50px auto;
	/* border: 1px solid red; */
}

#category {
	width: 120px;
	text-align: center;
}

.list {
	width: 900px;
	margin: 20px auto;
	position: relative;
	top: 0;
	left: 0;
}

#search {
	margin-left: 340px;
}

#search input[type="text"] {
	height:
}

#thumbBox {
	width: 900px;
	display: flex;
	flex-wrap: wrap;
}
</style>

</head>
<%@ include file="/inc/header.jsp"%>
<body>
	<!-- template.jsp > mypage > travelplan.jsp-->

	<section class="main-section">

		<div id="container">
			<h1>여행 일정 내역</h1>
			<div class="list">


				<nav class="navbar navbar-expand-sm bg-dark navbar-default">
					<!-- 리스트 : 부트스트랩은 모바일 우선이라 화면이 작으면 아래로 쌓아서 내려온다 -->
					<ul id="categorylist"class="navbar-nav navbar-default">
						<li id ="ing" class="nav-item"><a class="nav-link" href="/SIST2_Travel/mypage/travelplan.do?category=ing">계획중인 일정 </a></li>
						<li id="end" class="nav-item"><a class="nav-link" href="/SIST2_Travel/mypage/travelplan.do?category=end"> 완료된 일정</a></li>
						<li id="wish" class="nav-item"><a class="nav-link" href="/SIST2_Travel/mypage/travelplan.do?category=wish"> 찜한 일정</a></li>
					</ul>
					<!-- Search -->
					<form id="search" method="GET" class="form-inline" action="">
						<!-- inline여야 간격이 없이 메뉴처럼 나온다-->
						<input class="form-control mr-sm-2" type="text"
							placeholder="Search">
						<!-- form-control 입력창 꾸며주는 클래스 -->
						<button class="btn btn-success btn-lg" type="submit">Search</button>
					</form>
				</nav>
				<div id="thumbBox">
				<c:if test="${empty list}">
							<div>게시물이 없습니다.</div>
				</c:if>
				<c:if test="${not empty list}">
				<div id=""class="row">
				<c:forEach items="${list}" var="dto">
					<div class="col-sm-6 col-md-3">
						<div class="thumbnail">
							<img src="https://cdn.pixabay.com/photo/2016/11/21/17/44/arches-national-park-1846759_960_720.jpg" alt="...">
							<div class="caption">
								<h3>${dto.name}</h3>
								<p>
									도시 : ${dto.cityname}<br>
									여행기간 : ${dto.daystarttravel} ~ ${dto.dayendtravel} <br>
									찜 횟수 : ${dto.wish}
									<c:if test="${category eq 'wish'}">
									<br>작성자 : ${dto.writernick}
									</c:if>
								</p>
								<p>
									<a href="/SIST2_Travel/management/detailview.do?planseq=${dto.planseq}" class="btn btn-primary" role="button">자세히</a>
									<span>
									<a id="del" href="/SIST2_Travel/mypage/travelplandel.do?planseq=${dto.planseq}&category=${category}" class="btn btn-danger" role="button">삭제하기</a>
								</span>
								</p>
								
							</div>
						</div>
					</div>

				</c:forEach>
				</div>
				
				
			</c:if>
			</div>

			</div>
		</div>

	</section>



	<script>

	 $(function(){
	  var sBtn = $("#categorylist li");    //  ul > li 이를 sBtn으로 칭한다. (클릭이벤트는 li에 적용 된다.)
	  sBtn.find("a").click(function(){   // sBtn에 속해 있는  a 찾아 클릭 하면.
	   sBtn.removeClass("active");     // sBtn 속에 (active) 클래스를 삭제 한다.
	   $(this).parent().addClass("active"); // 클릭한 a에 (active)클래스를 넣는다.
	  })
	 })
	
	 $(function(){
		
		 if(${category == 'wish'}){
			 $('#wish').addClass('active');
		 } else if (${category == 'end'}){
			 $('#end').addClass('active');
		 } else if (${category == 'ing'}){
			 $('#ing').addClass('active');
		 }
	 })

	 $('#del').click(function() {
			var result = confirm('일정을 삭제하시겠습니까?');

		});

	</script>
</body>
<%-- <%@ include file="/inc/footer.jsp"%> --%>
</html>


