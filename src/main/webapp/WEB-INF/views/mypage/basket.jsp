<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>여행 병아리들을 위한 여행계획사이트 티피~~</title>

<%@ include file="/inc/asset.jsp" %>

  <style>
	
	.table th:nth-child(1) {
	width: 60px;
}

.table th:nth-child(2) {
	width: auto;
}

.table th:nth-child(3) {
	width: 80px;
}

.table th:nth-child(4) {
	width: 120px;
}

.table th:nth-child(5) {
	width: 60px;
}

.table td:nth-child(2) {
	text-align: left;
}

.searchbox {
	text-align: center;
	margin-bottom: 20px;
}

.searchbox .form-control {
	display: inline-block;
	width: auto;
}

.searchbox #search {
	width: 300px;
}

.searchBar {
	margin: 10px;
	text-align: center;
}

.pagebar { text-align: center;}

  </style>

</head>
<body>
<!-- template.jsp -->
<%@ include file="/inc/header.jsp" %>

<section class="main-section">

	<h1>
			MyPage <small>Basket</small>
		</h1>
		
		<%-- <c:if test="${map.isSearch == 'y'}">
			<div class="searchBar">'${map.search}'으로 검색한 결과
				${list.size()}개의 게시물이 있습니다.</div>
		</c:if>

		<c:if test="${map.isSearch == 'y'}">
			<div class="searchBar">'${map.search}'으로 검색한 결과
				${list.size()}개의 게시물이 있습니다.</div>
		</c:if> --%>


		<table class="table table-bordered">
			<tr>
				<th>번호</th>
				<th>상품 이름</th>
				<th>아이디</th>
				<th>상품 번호</th>
				<th>상품 유효기간</th>
				<th></th>
				
			</tr>
			
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.basketseq}</td>
					<td>${tblTour.name}</td>
					<td>${dto.id}</td>
					<td>${dto.tourseq}</td>
					<td>${tblTour.validDate}</td>
				</tr>
			</c:forEach>
		</table>



</section>


<%@ include file="/inc/init.jsp" %>
<%-- <%@ include file="/inc/footer.jsp" %> --%>
<script>

</script>
</body>
</html>