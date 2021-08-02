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
				<td>${dto.suggestSeq}</td>
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
		
		<!-- 각종 버튼 -->
		<div class="btns">
			<%-- <c:if test="${not empty id}"> --%>
				<c:if test="${dto.id == id}"> <!-- 해당글의 글쓴이 아이디와 로그인한 사람의 아이디가 같다면.. -->
		 			<button type="button" class="btn btn-primary"
						onclick="location.href='/SIST2_Travel/community/suggest/edit.do?suggestSeq=${dto.suggestSeq}';">수정하기</button>
						
					<button type="button" class="btn btn-primary"
						onclick="location.href='/SIST2_Travel/community/suggest/del.do?suggestSeq=${dto.suggestSeq}';">삭제하기</button>
				</c:if>
				<button type="button" class="btn btn-primary"
					onclick="location.href='/SIST2_Travel/community/suggest/add.do';">답변달기</button>
			<%-- </c:if> --%> 
				
			<button type="button" class="btn btn-default"
				onclick="location.href='/SIST2_Travel/community/suggest/list.do';">돌아가기</button>				
		</div>
		
		<hr>
		
		<!-- 댓글 -->
		<div>
			<%-- <c:if test="${not empty id}"> --%>
			<form method="POST" action="/SIST2_Travel/community/suggest/addcomment.do?suggestSeq=${dto.suggestSeq}">
				<table id="tblAddComment" class="table table-bordered">
					<tr>
						<td><input type="text" name="content" id="content" class="form-control" required placeholder="댓글을 작성하세요."></td>
						<td><input type="submit" value="댓글쓰기" class="btn btn-default"></td>
					</tr>
				</table>
			</form>
			<%-- </c:if> --%>
			
			<table id="tblListComment" class="table table-bordered">
				<c:if test="${clist.size() == 0}">
				<tr>
					<td colspan="2">댓글이 없습니다.</td>
				</tr>
				</c:if>
				
				<c:forEach items="${clist}" var="cdto">
				<tr>
					<td>
						${cdto.content}
						<span>${cdto.name}. ${cdto.regdate}</span>
					</td>
					<td>
						<%-- <c:if test="${not empty id}">
							<c:if test="${cdto.id == id}"> --%>
								<input type="button" value="삭제하기" class="btn btn-default"
									onclick="location.href='/SIST2_Travel/community/suggest/delcomment.do?suggestCommentSeq=${cdto.suggestCommentSeq}&suggestSeq${cdto.suggestSeq}';">
<%-- 							</c:if>
						</c:if> --%>
					</td>
				</tr>		
				</c:forEach>
					
			</table>
		</div>
		
</section>


<%@ include file="/inc/init.jsp" %>
<%@ include file="/inc/footer.jsp" %>
<script>

</script>
</body>
</html>















