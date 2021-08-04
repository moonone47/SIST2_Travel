<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style>
#box {
border:1px solid black;
width: 360px !important;
 height: 443px;
}
#back{
border: 1px solid black;
right:10px
}
#title{
font-size: 30px;
font-weight: bold;
text-align: center;
}
#tourname, #tourprice {

font-size: 20px;
font-weight: bold;
text-align: center;
}
</style>
</head>
<body>
	<%@ include file="/inc/asset.jsp"%>
	<form method="POST"
		action="/SIST2_Travel/mypage/basketpayok.do?basketseq=${basketseq}">
		<div id="box">
		<table class="table table-bordered">
		<tr>
		<td id="tourname">상품명</td>
		<td >${tourname }</td>
		</tr>
		<tr>
		<td id="tourprice">가격</td>
		<td >${tourprice}</td>
		</tr>
		<tr>
		<td id="title" colspan="2">카드정보입력</td>
		</tr>
			<tr>
				<td colspan="2">• 카드번호('-'제외) <br><input type="number" style="width: 300px;"></td>
				
			</tr>
			<tr>
				<td style="width: 120px;">• 유효기간(MMYY)<br> <input type="number" style="width: 120px;"></td>
				<td>• CVC번호 <br> <input type="password" style="width: 130px;" maxlength="3"></td>
			</tr>
			<tr>
				<td>• 비밀번호 앞2자리 <input type="password" style="width: 130px;"  maxlength="2"></td>
				<td>• 생년월일('-'제외) <input type="number" style="width: 130px;"></td>
			</tr>
			<tr>
			</tr>
			<tr>
				<td colspan="2">• 카드 소유자 이름 <br><input type="text"></td>
			</tr>

		</table>


		<fieldset>
			<input type="submit" class="btn btn-primary" id ="payment" value="결제하기">
			<button type="button" class="btn btn-default" id="back" style="float: right;" 
			onclick="history.back()">돌아가기</button>
		</fieldset>
			<input type="hidden" name=basketseq value="${basketseq }" />
			<input type="hidden" name=tourseq value="${tourseq }" />
		</div>
			
	</form>
		<script>
		$("#payment").click(function() {
			if (confirm("결제를 완료하시겠습니까?")) {
				alert('결제 완료되었습니다. 결제 내역은 예약 및 결제내역 페이지에서 확인가능합니다.');
			} 
		});
		</script>
</body>
</html>