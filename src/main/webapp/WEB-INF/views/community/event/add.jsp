<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<%@ include file="/inc/asset.jsp" %>
<style>

</style>

</head>
<body>
<%@ include file="/inc/header.jsp"%>
	<!-- add.jsp -->
	<div class= "container">
		<h1 class="page-header"></h1>
		<form method="POST" action="/SIST2_Travel/community/event/addok.do">
			<table class="table table-bordered">
				<tr>
					<th>제목</th>
					<td>
						<label for="subject"></label><input type="text" name="subject" id="subject" class="form-control" required>
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<label for="content"></label><textarea name="content" id="content" class="form-control" required></textarea>
					</td>
				</tr>
			</table>

			<div class="btns">
				<button type="submit" class="btn btn-primary">글쓰기</button>
				<button type="button" class="btn btn-default"
						onclick="location.href='/SIST2_Travel/community/list.do';">돌아가기</button>
			</div>

			<input type="hidden" name="reply" value="${reply}">
			<input type="hidden" name="thread" value="${thread}">
			<input type="hidden" name="depth" value="${depth}">
		</form>
	</div>


<%@ include file="/inc/footer.jsp" %>
	<script>
	
	</script>
</body>
</html>