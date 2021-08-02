<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행 병아리들을 위한 여행계획사이트 티피~~</title>

<%@ include file="/inc/asset.jsp"%>

<style>
#container {
	width: 1100px;
	margin: 0px auto 50px auto;
	border: 1px solid red;
}

#content {
	width: 900px;
	margin: 20px auto;
}
.table {text-align: center;}
.table tr:first-child th:nth-child(1) {
	width: 60px;
}

.table tr:first-child th:nth-child(2) {
	width: auto;
}

.table tr:first-child th:nth-child(3) {
	width: 100px;
}

.table tr:first-child th:nth-child(4) {
	width: 120px;
}

.table tr:first-child th:nth-child(5) {
	width: 60px;
}
.table tr:first-child th:nth-child(6) {
	width: 60px;
}
.table tr td:nth-child(2) {
	text-align: left;
}

#isnew {
	display: inline-block;
	width:13px;
	height: 13px;
	background-color: red;
	color: white;
	border-radius: 6.5px;
	text-align:center;
}
</style>

</head>
<body>
	<!--views > community > freeboard > list.jsp -->
	<%@ include file="/inc/header.jsp"%>

	<section class="main-section">
		<div id="container">
			<h1>
				Board <small>List</small>
			</h1>
			<div id="content">
				<table class="table table-bordered">
					<tr>
						<th>글번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
						<th>추천수</th>
					</tr>
					<c:if test="${empty list}">
						<tr>
							<td colspan="5">게시물이 없습니다.</td>
						</tr>
					</c:if>
					<c:if test="${not empty list}">
						<c:forEach items="${list}" var="dto">
							<tr>
								<td>${dto.freeboardseq}</td>
								<td>
									<a href="/SIST2_Travel/community/freeboard/view.do?freeboardseq=${dto.freeboardseq}">${dto.subject}</a>
									<c:if test="${dto.isnew < (2/24)}">
										<div id="isnew" style="font-size:5px;"> N </div>
									</c:if>
								</td>
								<td>${dto.nick}</td>
								<td>${dto.regdate}</td>
								<td>${dto.viewcnt}</td>
								<td>${dto.recommcnt}</td>
							</tr>
						</c:forEach>
					</c:if>
				</table>


				<div class="btns">
					<button type="button" class="btn btn-primary"
						onclick="location.href='/SIST2_Travel/community/freeboard/add.do';">글쓰기</button>
					<button type="button" class="btn btn-default"
						onclick="location.reload();">새로고침</button>
				</div>
			</div>

		</div>
	</section>


	<%@ include file="/inc/init.jsp"%>
	<%@ include file="/inc/footer.jsp"%>
	<script>
		
	</script>
</body>
</html>


