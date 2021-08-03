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
	height: 700px;
	margin: 0px auto 50px auto;
	border: 1px solid red;
}

#content {
	width: 900px;
	margin: 20px auto;
}

.table {
	text-align: center;
}

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
	width: 13px;
	height: 13px;
	background-color: red;
	color: white;
	border-radius: 6.5px;
	text-align: center;
}

.searchbox {
	text-align: center;
	margin-bottom: 20px;
}

.searchbox .form-control {
	display: inline-block;
	width: auto;
}

.searchbox #search {
	width: 300px;
}

.searchBar {
	margin: 10px;
	text-align: center;
}

.pagebar {

	text-align: center;	

	display: flex;
	 justify-content: center; 
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
				<c:if test="${map.isSearch == 'y'}">
					<div class="searchBar">'${map.search}'으로 검색한 결과
						${list.size()}개의 게시물이 있습니다.</div>
				</c:if>
				<table class="table">
					<tr class="active">
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
								<td><a
									href="/SIST2_Travel/community/freeboard/view.do?freeboardseq=${dto.freeboardseq}&column=${map.column}&search=${map.search}">${dto.subject}</a>
									<c:if test="${dto.ccnt > 0}">
										<span class="badge">${dto.ccnt}</span>
									</c:if> <c:if test="${dto.isnew < (2/24)}">
										<div id="isnew" style="font-size: 5px;">N</div>
									</c:if></td>
								<td>${dto.nick}</td>
								<td>${dto.regdate}</td>
								<td>${dto.viewcnt}</td>
								<td>${dto.recommcnt}</td>
							</tr>
						</c:forEach>
					</c:if>
				</table>
				<div class="pagebar">${pagebar}</div>
				<div class="searchbox">
					<div class="searchbox">
						<!-- 
						대부분(99%)의 <form>은 method="POST"를 사용한다.
						예외로.. 전송 당시의 상태를 유지하고 싶을 때 method="GET"을 사용한다.(ex.검색결과의 북마크)
						검색 결과 검색할 때 -> GET!!
						데이터 보내는 거는 POST!! 
					 -->
					 <div class="btns">
						<button type="button" class="btn btn-primary"
							onclick="location.href='/SIST2_Travel/community/freeboard/add.do';">글쓰기</button>
						<button type="button" class="btn btn-default"
							onclick="location.reload();">새로고침</button>
					</div>
						<form method="GET"
							action="/SIST2_Travel/community/freeboard/list.do">
							<select name="column" id="column" class="form-control">
								<option value="subject">제목</option>
								<option value="content">내용</option>
								<option value="name">이름</option>
								<option value="all">제목+내용</option>
							</select> <input type="text" name="search" id="search"
								class="form-control" required placeholder="검색어를 입력하세요.">
							<input type="submit" value="검색하기" class="btn btn-default">
						</form>
					</div>

					
				</div>

			</div>
	</section>



	<script>
		<c:if test="${map.isSearch == 'y'}">

		//상태 복원
		$('#column').val('${map.column}');
		$('#search').val('${map.search}');

		</c:if>
		$('#selPage').change(function() {
			location.href = '/SIST2_Travel/community/freeboard/list.do?page=' + $(this).val();
		});

		$('#selPage').val('${nowPage}');
	</script>
	<%@ include file="/inc/footer.jsp"%>
</body>
</html>


