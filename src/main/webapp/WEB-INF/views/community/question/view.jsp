<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myapp</title>

<%-- <%@ include file="/inc/asset.jsp"%> --%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/asset/css/myapp.css" />

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
	width: 1100px;
	margin: 35px auto;
	padding-bottom: 300px;
}

#tblAddComment, #tblListComment {
	width: 1100px;
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

#btnRecommend {
	float: right;
	position: relative;
	top: -40px;
	width: 98px;
	right: 21px;
}
</style>

</head>
<body>
	<!-- board/view.jsp -->
	<%@ include file="/inc/header.jsp"%>

	<section class="main-section">

		<h1>
			자유게시판 <small>View</small>
		</h1>


		<table class="table table-bordered">
			<tr>
				<th>번호</th>
				<td>${dto.questionseq }</td>
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

		
		<div class="btns" style="position: static;">

			<c:if test="${not empty id }">

				<c:if test="${dto.id == id || id == 1 }">
					<button type="button" class="btn btn-primary"
						onclick="location.href='/SIST2_Travel/community/question/edit.do?questionseq=${dto.questionseq}';">수정하기</button>

				</c:if>

				<button type="button" class="btn btn-primary"
					onclick="location.href='/SIST2_Travel/community/question/add.do?reply=1&thread=${dto.thread}&depth=${dto.depth }';">답변달기</button>

				<button type="button" class="btn btn-primary"
					style="background-color: #d5371b; border-color: #d5371b; color: white;"
					onclick="location.href='/SIST2_Travel/community/question/del.do?questionseq=${dto.questionseq}';">삭제하기</button>
				<button type="button" class="btn btn-default"
					style="float: left; border: 1px solid black; margin-right: 6px"
					onclick="location.href='/SIST2_Travel/community/question/list.do?column=${column}&search=${search }';">돌아가기</button>

				<form method="get"
					action="/SIST2_Travel/community/question/addrecommcnt.do">
					<button type="submit" id="btnRecommend">추천하기</button>
					<input type="hidden" name="questionseq" value="${dto.questionseq }" />
				</form>


			</c:if>

		</div>


		<div>
			<c:if test="${not empty id }">
				<form method="POST"
					action="/SIST2_Travel/community/question/addcomment.do">
					<table id="tblAddComment" class="table table-bordered"
						style="width: 1100px;">
						<tr>
							<td><input type="text" name="content" id="content"
								class="form-control" required placeholder="댓글을 입력하세요." /></td>
							<td><input type="submit" value="댓글쓰기"
								style="border: 1px solid black" class="btn btn-default" /></td>
						</tr>
					</table>
					<input type="hidden" name="questionseq" value="${dto.questionseq }" />
				</form>
			</c:if>
			<table id="tblListComment" class="table table-bordered">

				<c:if test="${clist.size() ==0 }">
					<tr>
						<td colspan="2">댓글이 없습니다.</td>
					</tr>
				</c:if>
				<c:forEach items="${clist }" var="cdto">
					<tr>
						<td>${cdto.content }<span>${cdto.name } ${cdto.regdate }</span>
						</td>
						<c:if test="${not empty id }">
							<c:if test="${cdto.id == id }">
								<td><input type="button" value="삭제하기"
									class="btn btn-default"
									style="border: 1px solid black; background-color: #d5371b; border-color: #d5371b; color: white;"
									onclick="location.href='/SIST2_Travel/community/question/delcomment.do?questioncommentseq=${cdto.questioncommentseq}&questionseq=${dto.questionseq }';" />
								</td>
							</c:if>
						</c:if>
					</tr>
				</c:forEach>

			</table>

		</div>
	</section>

	<script>
		$("#btnRecommend").click(function() {
			if (confirm("해당 글을 추천하시겠습니까?")) {

			}
		});
	</script>
</body>
</html>