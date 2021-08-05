<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행 병아리들을 위한 여행계획사이트 티피~~</title>

<%@ include file="/inc/asset.jsp"%>

<style>
.main-section {
	padding: 100px;
}
</style>

</head>
<body>
	<!-- editprofileok.jsp -->
	<%@ include file="/inc/header.jsp"%>

	<section class="main-section">

		<h1 class="page-header">프로필수정</h1>
		
		<form method="POST" action="/SIST2_Travel/mypage/editprofileok.do">
			<table class="table table-bordered">
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" id="name"
						class="form-control" value="${dto.name}"></td>
				</tr>
				<tr>
					<th>닉네임</th>
					<td><input type="text" name="nick" id="nick"
						class="form-control" value="${dto.nick}"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="email" id="email"
						class="form-control" value="${dto.email}"></td>
				</tr>
				<tr>
					<th>연락처</th>
					<td><input type="text" name="phone" id="phone"
						class="form-control" value="${dto.phone}"></td>
				</tr>
				<tr>
					<th>우편번호</th>
					<td><input type="number" name="zip" id="zip"
						class="form-control" value="${dto.zip}"></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" name="address" id="address"
						class="form-control" value="${dto.address}"></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td><input type="regdate" name="birthday" id="birthday"
						class="form-control" value="${dto.birthday}"></td>
				</tr>
				<tr>
					<th>성별</th>
					<td><label><input type="radio" name="gender" value="m">남자</label>
						<label><input type="radio" name="gender" value="f">여자</label>
					</td>
				</tr>
			</table>

			<div class="btns">
				<button type="submit" class="btn btn-primary" >수정하기</button>
				<button type="button" class="btn btn-default"	
					onclick="location.href='/SIST2_Travel/mypage/profile.do">돌아가기</button>
			</div>
		</form>

	</section>


	<%@ include file="/inc/init.jsp"%>
	<%@ include file="/inc/footer.jsp"%>
	<script>
		
	</script>
</body>
</html>

