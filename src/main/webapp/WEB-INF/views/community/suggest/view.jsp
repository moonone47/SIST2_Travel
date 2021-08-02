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
<!-- view.jsp -->
<%@ include file="/inc/header.jsp" %>

<section class="main-section">
	
	<h1>건의게시판view</h1>
				
		<table class="table table-bordered">
			<tr>
				<th>번호</th>
				<td>${dto.seq}</td>
				<th>닉네임</th>
				<td>${dto.name}(${dto.id})</td>
			</tr>
			<tr>
				<th>작성일자</th>
				<td>${dto.regdate}</td>
				<th>조회수</th>
				<td>${dto.viewcnt}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="3">${dto.subject}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3">${dto.content}</td>
			</tr>
		</table>
		
		<div class="btns">
			
			<button type="button" class="btn btn-primary"
				onclick="location.href='/myapp/board/edit.do?seq=${dto.seq}';">수정하기</button>
				
			<button type="button" class="btn btn-primary"
				onclick="location.href='/myapp/board/del.do?seq=${dto.seq}';">삭제하기</button>
				
			<button type="button" class="btn btn-primary"
				onclick="location.href='/myapp/board/add.do';">답변달기</button>
				
			<button type="button" class="btn btn-default"
				onclick="location.href='/SIST2_Travel/community/suggest/list.do';">돌아가기</button>
				
		</div>
</section>


<%@ include file="/inc/init.jsp" %>
<%@ include file="/inc/footer.jsp" %>
<script>

</script>
</body>
</html>















