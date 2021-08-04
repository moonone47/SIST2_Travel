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
.main-section {
	width: 800px;
	margin: 35px auto;
	padding-bottom: 300px;
}
h1{
text-align: center;
font-size: 2em;
}
.btn {
position:relative;
}
#tbl {
width: 1000px;
}
</style>

</head>
<body>
	<%@ include file="/inc/header.jsp"%>
	
	<!--  -->
	<h1>여행 의뢰 서비스 </h1>
	<section class="main-section">
		<button type="button" class="btn btn-primary"
				onclick="location.href='/SIST2_Travel/service/apply.do';">새 의뢰 신청</button>
		<br><br><br><br>
		<h2>
			내 여행 의뢰 내역 <small>List</small>
		</h2>

		<table class="table table-bordered" id="tbl">
			<tr>
				<th>의뢰 번호</th>
				<th>여행지</th>
				<th>여행 시작날짜</th>
				<th>여행 종료날짜</th>
				<th>여행 목적</th>
				<th>여행 인원</th>
				<th>의뢰자 이름</th>
				<th>의뢰 취소</th>
			</tr>

			<c:if test="${list.size() ==0 }">
				<tr>
					<td style="text-align: center; font-weight: bold;" colspan="8">신청한 의뢰 내역이 없습니다.</td>
				</tr>
			</c:if>
			<c:if test="${not empty id }">
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.serviceseq}</td>
						<td>${dto.travelspot}</a></td>
						<td>${dto.daystarttravel}</td>
						<td>${dto.dayendtravel}</td>
						<td>${dto.purpose}</td>
						<td>${dto.numberpeople}</td>
						<td>${dto.name}</td>
						<td>
						
								<form method="get" action="/SIST2_Travel/service/servicecancel.do">
				<button type = "submit" id = "btnCancel">의뢰 취소하기</button>
				<input type="hidden" name="serviceseq" value="${dto.serviceseq }" />
				</form>

						</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		

	</section>



	<%@ include file="/inc/init.jsp"%>
	<%@ include file="/inc/footer.jsp"%>
	<script>
		 $("#btnCancel").click(function() {
			if (confirm("정말 의뢰를 취소하시겠습니까?")) {
				alert('취소되었습니다.');
			}
		});
		 
		 
		 
		 
	</script>
	<script type="text/javascript" src="script.js" charset="utf-8"></script>

</body>
</html>