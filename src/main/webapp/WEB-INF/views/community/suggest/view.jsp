<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>여행 병아리들을 위한 여행계획사이트 티피~~</title>

<%@ include file="/inc/asset.jsp" %>

  <style>

  </style>

</head>
<body>
<!-- template.jsp -->
<%@ include file="/inc/header.jsp" %>

<section class="main-section">

	<h1>문의게시판view</h1>
	
	<table class="table table-bordered">
		<tr>
			<th>번호</th>
			<td></td>
			<th>이름</th>
			<td></td>
		</tr>
		<tr>
			<th>날짜</th>
			<td></td>
			<th>읽음</th>
			<td></td>
		</tr>
		<tr>
			<th>제목</th>
			<td></td>
			<th>내용</th>
			<td></td>
		</tr>
	</table>
	
	<div class="btns">
		<button type="button" class="btn btn-primary"
			onclick="location.href=''">수정하기</button>
		<button type="button" class="btn btn-primary"
			onclick="location.href=''">삭제하기</button>
		<button type="button" class="btn btn-primary"
			onclick="location.href=''">돌아가기</button>
	</div>

</section>


<%@ include file="/inc/init.jsp" %>
<%@ include file="/inc/footer.jsp" %>
<script>

</script>
</body>
</html>
