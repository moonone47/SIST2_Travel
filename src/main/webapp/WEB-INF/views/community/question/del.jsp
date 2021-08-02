<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myapp</title>

<%@ include file="/inc/asset.jsp"%>

<style>
.table th {
	width: 120px;
}
.main-section .table td {
	width: 680px; 
	text-align: left;
}
.table #content {
	height: 300px;
}
.main-section {
	width: 800px;
	margin: 35px auto;
}
</style>

</head>
<body>
	<!-- question/del.jsp -->
	<%@ include file="/inc/header.jsp"%>

	<section class="main-section">

		<h1>
			질문게시판 <small>Del</small>
		</h1>

		<form method="POST" action="/SIST2_Travel/community/question/delok.do">
			<table class="table table-bordered">
				<tr>
					<th>번호</th>
					<td>${questionseq } 번 게시물을 삭제합니다.</td>
				</tr>

			</table>

			<div class="btns">
				<button type="submit" class="btn btn-primary">삭제하기</button>
				<button type="button" class="btn btn-default"
					onclick="location.href='/SIST2_Travel/community/question/view.do?questionseq=${questionseq}';">돌아가기</button>
			</div>

			<input type="hidden" name="questionseq" value="${questionseq }" />
		</form>

	</section>

	<%@ include file="/inc/init.jsp" %>
   <%@ include file="/inc/footer.jsp"%> 
	<script>
		
	</script>
</body>
</html>
