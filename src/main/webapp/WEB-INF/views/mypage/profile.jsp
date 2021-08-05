<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>TP</title>

   <%@ include file="/inc/asset.jsp" %>

   <style>
		.main-section { padding: 100px; }
   </style>

</head>
<body>
<!-- profile.jsp -->
<%@ include file="/inc/header.jsp" %>

<section class="main-section">
	
	<h1>프로필</h1>
		
		<table class="table table-bordered">
			
			<tr>
				<th>아이디</th>
				<th>${dto.id}</th>
			</tr>
			<tr>
				<th>이름</th>
				<th>${dto.name}</th>
			</tr>			
			<tr>
				<th>닉네임</th>
				<th>${dto.nick}</th>
			</tr>
			<tr>
				<th>이메일</th>
				<th>${dto.email}</th>
			</tr>
			<tr>
				<th>연락처</th>
				<th>${dto.phone}</th>
			</tr>
			<tr>
				<th>우편번호</th>
				<th>${dto.zip}</th>
			</tr>
			<tr>
				<th>주소</th>
				<th>${dto.address}</th>
			</tr>
			<tr>
				<th>등급</th>
				<th>${dto.lv}</th>
			</tr>
			<tr>
				<th>생년월일</th>
				<th>${dto.birthday}</th>
			</tr>
			<tr>
				<th>성별</th>
				<th>${dto.gender}</th>
			</tr>
			
		</table>
		
		<div class="btn">
			<button type="button" class="btn btn-primary"
				onclick="location.href='/SIST2_Travel/mypage/editprofile.do?id=${dto.id}';">수정하기</button>
			<button type="button" class="btn btn-primary"
				onclick="location.href='/SIST2_Travel/mypage/memberdelete.do?id=${dto.id}';">탈퇴하기</button>
		</div>
</section>


<%@ include file="/inc/init.jsp" %>
<%@ include file="/inc/footer.jsp" %>
<script>

</script>
</body>
</html>















