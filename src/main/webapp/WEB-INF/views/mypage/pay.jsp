<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style>
</style>
</head>
<body>
	<%@ include file="/inc/asset.jsp"%>
	<form method="POST"
		action="/SIST2_Travel/mypage/payok.do?reservationseq=${reservationseq}	">

		<h1>카드정보입력</h1>
		<table class="table table-bordered">
			<tr>
				<td>카드번호('-'제외) <input type="number"></td>
			</tr>
			<tr>
				<td>유효기간(MM/YY) <input type="number"></td>
			</tr>
			<tr>

				<td>CVC번호 <input type="number"></td>
			</tr>
			<tr>
				<td>비밀번호 앞2자리 <input type="number"></td>
			</tr>
			<tr>
				<td>생년월일('-'제외) <input type="number"></td>
			</tr>
			<tr>
				<td>카드 소유자 이름 <input type="text"></td>
			</tr>

		</table>


		<fieldset>
			<input type="submit" class="btn btn-primary" id ="payment" value="결제하기">
			<button type="button" class="btn btn-default"
			onclick="history.back()">돌아가기</button>
		</fieldset>
			<input type="hidden" name="reservationseq" value="${reservationseq }" />
			
	</form>
		<script>
		$("#payment").click(function() {
			if (confirm("결제를 완료하시겠습니까?")) {
				alert('결제 완료되었습니다.');
			} 
		});
		</script>
</body>
</html>