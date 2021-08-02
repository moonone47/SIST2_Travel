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
<!-- list.jsp -->
<%@ include file="/inc/header.jsp" %>

<section class="main-section">
	
	<h1>건의게시판list</h1>
	
		<table class="table table-bordered">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>닉네임</th>
				<th>작성일자</th>
				<th>조회수</th>
				<th>추천수</th>
			</tr>
			<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.suggestSeq}</td>
				<td>
					<a href="/SIST2_Travel/community/suggest/view.do?suggestSeq=${dto.suggestSeq}">${dto.subject}</a>
					
					<c:if test="${dto.isnew < (2 / 24)}">
						<span class="label label-danger">new</span>
					</c:if>
					
				</td>
				<td>${dto.name}</td>
				<td>${dto.regdate}</td>
				<td>${dto.viewcnt}</td>
				<td>${dto.recommcnt}</td>
			</tr>
			</c:forEach>
		</table>
		
		<div class="btns">	
			<button type="button" class="btn btn-primary"
				onclick="location.href='/SIST2_Travel/community/suggest/add.do';">글쓰기</button>
			<button type="button" class="btn btn-default"
				onclick="location.reload();">새로고침</button>
		</div>	
	
</section>


<%@ include file="/inc/init.jsp" %>
<%@ include file="/inc/footer.jsp" %>
<script>

</script>
</body>
</html>















