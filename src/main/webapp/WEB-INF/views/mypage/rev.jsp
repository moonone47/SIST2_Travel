<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<%@ include file="/inc/asset.jsp"%>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>

<style>
.main-section {
	width: 1100px;
	margin: 35px auto;
	padding-bottom: 300px;
}
</style>

</head>
<body>

	<%@ include file="/inc/header.jsp"%>
	<!--  -->
	<section class="main-section">
		<h1>
			결제 및 예약 내역 <small>List</small>
		</h1>

		<table class="table table-bordered">
			<tr>
				<th>예약 번호</th>
				<th>투어/티켓 이름</th>
				<th>사용처</th>
				<th>사용기간</th>
				<th>예약자 이름</th>
				<th>투어 가격</th>
				<th>결제 여부</th>
				<th>취소여부</th>
				<th>예약 취소</th>
			</tr>

			<c:if test="${list.size() ==0 }">
				<tr>
					<td colspan="9">게시물이 없습니다.</td>
				</tr>
			</c:if>
			<c:if test="${not empty id }">
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.reservationseq}</td>
						<td id="tourname"><a
							href="/SIST2_Travel/mypage/revview.do?tourseq=${dto.tourseq }">${dto.tourname}</a></td>
						<td>${dto.use}</td>
						<td>${dto.validdate}</td>
						<td><div id="membername">${dto.membername }</div></td>
						<td>${dto.tourprice}</td>
						<td>${dto.ispay }<c:if test="${dto.ispay eq '미결제' }">
								<form method="POST"
									action="/SIST2_Travel/mypage/pay.do?reservationseq=${dto.reservationseq}	">
									<button id="payment" type="submit" class="btn btn-primary" style="font-size: 15px">결제하기</button>
									<input type="hidden" name="reservationseq"
										value="${dto.reservationseq }" />
								</form>
							</c:if>
						</td>
						<td>${dto.iscancel }</td>

						<td><c:if test="${dto.iscancel eq 'n' }">
								<form method="get"
									action="/SIST2_Travel/mypage/revcancel.do?reservationseq=${dto.reservationseq}">
									<button type="submit" id="btnCancel" class="btn btn-primary" onclick="cancel()">예약 취소하기</button>
									<input type="hidden" name="reservationseq"
										value="${dto.reservationseq }" />
								</form>
							</c:if> <c:if test="${dto.iscancel eq 'y' }">
							취소 완료 
						</c:if></td>
					</tr>
				</c:forEach>
			</c:if>
		</table>





	</section>

	<%@ include file="/inc/init.jsp"%>
	<%@ include file="/inc/footer.jsp"%>
	<script>
	
		
	    function cancel() {
	        if (!confirm("정말 예약을 취소하시겠습니까?")) {
	            alert("취소(아니오)를 누르셨습니다.");
	        } else {
	            alert("확인(예)을 누르셨습니다.");
	        }
	    }

		/* function showPopup() {
			window.open("/SIST2_Travel/mypage/pay.do", "결제창",
					"width=400, height=600, left=100, top=50");
		} */
	</script>

</body>
</html>