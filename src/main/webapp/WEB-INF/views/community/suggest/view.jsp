<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TP</title>

<%-- <%@ include file="/inc/asset.jsp"%> --%>
<link rel="stylesheet" href="<%= request.getContextPath() %>/asset/css/myapp.css" />

<style>

.main-section {
	width: 800px;
	margin: 35px auto;
	padding-bottom: 300px;
}

}
</style>

</head>
<body>
	<!-- board/view.jsp -->
	<%@ include file="/inc/header.jsp"%>

	<section class="main-section">

		<h1>
			건의게시판 <small>View</small>
		</h1>


		<table class="table table-bordered">
			<tr>
				<th>번호</th>
				<td>${dto.suggestseq }</td>
				<th>이름</th>
				<td colspan="3">${dto.name }(${dto.id })</td>
			</tr>
			<tr>
				<th>날짜</th>
				<td>${dto.regdate }</td>
				<th>조회수</th>
				<td>${dto.viewcnt }</td>
				<th>추천수</th>
				<td>${dto.recommcnt }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="5">${dto.subject }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="5">${dto.content }</td>
			</tr>

		</table>

		<
		<div class="btns">

			<c:if test="${not empty id }">

				<c:if test="${dto.id == id }">
					<button type="button" class="btn btn-primary"
						onclick="location.href='/SIST2_Travel/community/suggest/edit.do?suggestseq=${dto.suggestseq}';">수정하기</button>
					<button type="button" class="btn btn-primary"
						onclick="location.href='/SIST2_Travel/community/suggest/del.do?suggestseq=${dto.suggestseq}';">삭제하기</button>

				</c:if>
				
				<button type="button" class="btn btn-primary"
					onclick="location.href='/SIST2_Travel/community/suggest/add.do?reply=1&thread=${dto.thread}&depth=${dto.depth }';">답변달기</button>
				
				<form method="get" action="/SIST2_Travel/community/suggest/addrecommcnt.do">
				<button type = "submit" id = "btnRecommend">추천하기</button>
				<input type="hidden" name="suggestseq" value="${dto.suggestseq }" />
				</form>
				
				
			</c:if>
			
			<button type="button" class="btn btn-default"
				onclick="location.href='/SIST2_Travel/community/suggest/list.do?column=${column}&search=${search }';">돌아가기</button>
		</div>
		
		
		<div >
			<c:if test="${not empty id }">
				<form method="POST"
					action="/SIST2_Travel/community/suggest/addcomment.do">
					<table id="tblAddComment" class="table table-bordered" style="width: 800px;">
						<tr>
							<td><input type="text" name="content" id="content"
								class="form-control" required placeholder="댓글을 입력하세요." /></td>
							<td><input type="submit" value="댓글쓰기"
								class="btn btn-default" /></td>
						</tr>
					</table>
					<input type="hidden" name="suggestseq" value="${dto.suggestseq }" />
				</form>
			</c:if>
			<table id="tblListComment" class="table table-bordered">

				<c:if test="${clist.size() ==0 }">
					<tr >
						<td colspan="2" >댓글이 없습니다.</td>
					</tr>
				</c:if>
				<c:forEach items="${clist }" var="cdto">
					<tr>
						<td>${cdto.content }<span>${cdto.name }
								${cdto.regdate }</span>
						</td>
						<c:if test="${not empty id }">
							<c:if test="${cdto.id == id }">
								<td><input type="button" value="삭제하기"
									class="btn btn-default"
									onclick="location.href='/SIST2_Travel/community/suggest/delcomment.do?suggestcommentseq=${cdto.suggestcommentseq}&suggestseq=${dto.suggestseq }';" />
								</td>
							</c:if>
						</c:if>
					</tr>
				</c:forEach>

			</table>

		</div>
	</section>

	<%@ include file="/inc/init.jsp"%>
	<script>
	$("#btnRecommend").click(function(){
	    if(confirm("해당 글을 추천하시겠습니까?")){
	        
	        
	       
	        
	        }
	    });
	</script>
</body>
</html>