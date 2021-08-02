<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<%@ include file="/inc/asset.jsp"%>
<style>
</style>

</head>
<body>
	<%@ include file="/inc/header.jsp"%>
	<!--  -->
	<h1>
		내 예약내역 <small>List</small>
	</h1>
	<!-- 
	dto.setReservationseq(rs.getString("reservationseq"));
	dto.setIscancel(rs.getString("iscancel"));
	dto.setTourseq(rs.getString("tourseq"));
	dto.setTourname(rs.getString("tourname"));
	dto.setMembername(rs.getString("membername"));
	dto.setUse(rs.getString("use"));
	dto.setValiddate(rs.getString("validdate"));
	dto.setTourname(rs.getString("tourprice")); -->
	<table class="table table-bordered">
		<tr>
			<th>예약 번호</th>
			<th>투어 이름</th>
			<th>사용처</th>
			<th>사용기간</th>
			<th>투어 가격</th>
			<th>취소여부</th>
			<th>예약자 이름</th>
		</tr>

		<c:if test="${list.size() ==0 }">
			<tr>
				<td colspan="7">게시물이 없습니다.</td>
			</tr>
		</c:if>
		<c:if test="${not empty id }">
		<%-- 	<c:if test="${dto.id == id }"> --%>
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.reservationseq}</td>
						<td><a href="/SIST2_Travel/mypage/revview.do?tourseq=${dto.tourseq }">${dto.tourname}</a></td>
						<td>${dto.use}</td>
						<td>${dto.validdate}</td>
						<td>${dto.tourprice}</td>
						<td>${dto.iscancel }</td>
						<td>${dto.membername }</td>
					</tr>
				</c:forEach>
			<%-- </c:if> --%>
		</c:if>
	</table>





	<%-- <%@ include file="/inc/init.jsp" %>
   <%@ include file="/inc/footer.jsp"%> --%>
	<script>
		
	</script>
</body>
</html>