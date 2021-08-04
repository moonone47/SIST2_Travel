<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SIST2_travel</title>

<%-- <%@ include file="/inc/asset.jsp"%> --%>
<link rel="stylesheet" href="<%= request.getContextPath() %>/asset/css/myapp.css" />

<style>
.main-section .table th {
	width: 120px;
}

.main-section .table td {
	width: 280px;
	text-align: left;
}

.main-section .table tr:nth-child(4) {
	height: 300px;
}

.main-section {
	width: 800px;
	margin: 35px auto;
	padding-bottom: 300px;
}
#tblAddComment, #tblListComment {
	width: 800px;
	margin: 15px auto;
}

#tblAddComment {
	margin-top: 30px;
}

#tblAddComment td:nth-child(1) {
	width: 600px;
}

#tblAddComment td:nth-child(2) {
	width: 100px;
}

#tblListComment td:nth-child(1) {
	width: 600px;
}

#tblListComment td:nth-child(2) {
	width: 100px;
}

#tblListComment td {
	position: relative;
	left: 0;
	top: 0;
}

#tblListComment td span {
	position: absolute;
	right: 10px;
	bottom: 5px;
	color: #AAA;
	font-size: 11px;
}
</style>

</head>
<body>
	<!-- board/view.jsp -->
	<%@ include file="/inc/header.jsp"%>

	<section class="main-section">

		<h1>
			여행 소모임 게시판 <small>View</small>
		</h1>


		<table class="table table-bordered">
			<tr>
				<th>번호</th>
				<td>${dto.seq }</td>
				<th>이름</th>
				<td colspan="3">${dto.name }(${dto.id })</td>
			</tr>
			<tr>
				<th>날짜</th>
				<td>${dto.regdate }</td>
				<th>조회수</th>
				<td>${dto.viewCnt }</td>
				<th>추천수</th>
				<td>${dto.recommCnt }</td>
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
						onclick="location.href='/SIST2_Travel/community/clubboard/edit.do?travelclubseq=${dto.seq}';">수정하기</button>
					<button type="button" class="btn btn-primary"
						onclick="location.href='/SIST2_Travel/community/clubboard/del.do?travelclubseq=${dto.seq}';">삭제하기</button>

				</c:if>
				
				<button type="button" class="btn btn-primary"
					onclick="location.href='/SIST2_Travel/community/clubboard/add.do?reply=1&thread=${dto.thread}&depth=${dto.depth }';">답변달기</button>
				
				<%-- <form method="get" action="/SIST2_Travel/community/clubboard/addrecommcnt.do">
				<button type = "submit" id = "btnRecommend">추천하기</button>
				<input type="hidden" name="travelclubseq" value="${dto.seq }" />
				</form> --%>
				
				
			</c:if>
			
			<button type="button" class="btn btn-default"
				onclick="location.href='/SIST2_Travel/community/clubboard/list.do?column=${column}&search=${search }';">돌아가기</button>
		</div>
		
		
		<div >
			<c:if test="${not empty id }">
				<form method="POST"
					action="/SIST2_Travel/community/clubboard/comment.do">
					<table id="tblAddComment" class="table table-bordered" style="width: 800px;">
						<tr>
							<td><input type="text" name="content" id="content"
								class="form-control" required placeholder="댓글을 입력하세요." /></td>
							<td><input type="submit" value="댓글쓰기"
								class="btn btn-default" /></td>
						</tr>
					</table>
					<input type="hidden" name="travelclubseq" value="${dto.seq }" />
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
									onclick="location.href='/SIST2_Travel/community/clubboard/commentdel.do?travelclubcommentseq=${cdto.travelclubcommentseq}&travelclubseq=${dto.seq }';" />
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