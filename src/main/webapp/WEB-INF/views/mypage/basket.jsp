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
table,
thead,
tr,
tbody,
th,
td {
	text-align: center;
}

.table td {
	text-align: center;
}
</style>

</head>
<body>

	<%@ include file="/inc/header.jsp"%>
	<!--  -->
	<section class="main-section">
		<h1>
			장바구니 내역 <small>List</small>
		</h1>

		<table class="table table-bordered align-middle">
			<tr>
				<th>장바구니 번호</th>
				<th>투어/티켓 이름</th>
				<th>사용처</th>
				<th>사용기간</th>
				<th>예약자 이름</th>
				<th>투어 가격</th>
				<th>결제 여부</th>
				<th>장바구니 제거</th>
			</tr>

			<c:if test="${list.size() ==0 }">
				<tr>
					<td colspan="8" style="text-align: center; font-weight: bold;">게시물이 없습니다.</td>
				</tr>
			</c:if>
			<c:if test="${not empty id }">
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.basketseq}</td>
						<td id="tourname"><a
							href="/SIST2_Travel/mypage/revview.do?tourseq=${dto.tourseq }">${dto.tourname}</a></td>
						<td>${dto.use}</td>
						<td>${dto.validdate}</td>
						<td><div id="membername">${dto.membername }</div></td>
						<td>${dto.tourprice}</td>
					 	<td>${dto.ispay }
						<c:if test="${dto.ispay eq '미결제' }">
								<form method="POST"
									action="/SIST2_Travel/mypage/basketpay.do?basketseq=${dto.basketseq}	">
									<button id="payment" type="submit"  class="btn btn-primary form-control">결제하기</button>
									<input type="hidden" name="reservationseq"	value="${dto.basketseq }" />
									<input type="hidden" name="tourseq"	value="${dto.tourseq }" />
									<input type="hidden" name="tourname"	value="${dto.tourname }" />
									<input type="hidden" name="membername"	value="${dto.membername }" />
									<input type="hidden" name="tourprice"	value="${dto.tourprice }" />
								</form>
							</c:if>
						</td> 
						

						<td>
								<form method="get"
									action="/SIST2_Travel/mypage/basketdel.do?basketseq=${dto.basketseq}">
									<button type="submit" id="btnDel" class="btn btn-warning form-control" onclick="del()" >장바구니 삭제</button>
									<input type="hidden" name="basketseq"
										value="${dto.basketseq }" />
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
	
		
	    function del() {
	        if (!confirm("목록에거 삭제하시겠습니까?")) {
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