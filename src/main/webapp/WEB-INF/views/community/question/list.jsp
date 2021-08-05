<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SIST2_Travel</title>

<%@ include file="/inc/asset.jsp"%>

<style>
.table th:nth-child(1) {
	width: 60px;
}

.table th:nth-child(2) {
	width: auto;
}

.table th:nth-child(3) {
	width: 80px;
}

.table th:nth-child(4) {
	width: 120px;
}

.table th:nth-child(5) {
	width: 70px;
}

.table th:nth-child(6) {
	width: 70px;
}

.table td:nth-child(5) {
	text-align: center;
}

.table td:nth-child(6) {
	text-align: center;
}

.table td:nth-child(2) {
	text-align: left;
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
}

.main-section {
	width: 1100px;
	margin: 35px auto;
	padding-bottom: 300px;
}
.main-section .table th {
    background-color: #EEE;
}

.pagebar {
	text-align: center;
	display: flex;
	justify-content: center;
}

.pagination>li>a, .pagination>li>span {
	position: relative;
	float: left;
	padding: 6px 12px;
	margin-left: -1px;
	line-height: 1.42857143;
	color: #337ab7;
	text-decoration: none;
	background-color: #fff;
	border: 1px solid #ddd;
}

.pagination>.active>a, .pagination>.active>span, .pagination>.active>a:hover,
	.pagination>.active>span:hover, .pagination>.active>a:focus,
	.pagination>.active>span:focus {
	z-index: 3;
	color: #fff;
	cursor: default;
	background-color: #337ab7;
	border-color: #337ab7;
}
.table-bordered {
    border: 1px solid #ddd;
}
.table {
    width: 100%;
    max-width: 100%;
    margin-bottom: 20px;
}
body, table, th, td, a, p, div, span, li, button, input, textarea, select, option, h1, h2, h3, h4, h5, h6 {
    color: #777;
    font-family: 'Jal_Onuel' !important;
}
table {
    background-color: transparent;
    border-collapse: collapse;
    border-spacing: 0;
}
#label-danger{
	background-color: tomato;
    color: white;

}
</style>

</head>
<body>
	<!-- question / list.jsp -->
	<%@ include file="/inc/header.jsp"%>

	<section class="main-section">

		<h1>
			질문게시판 <small>List</small>
		</h1>
		<c:if test="${map.isSearch == 'y' }">
			<div class="searchBar">'${map.search }'(으)로 검색한 결과가
				${list.size() }개의 결과가 있습니다.</div>
		</c:if>

		<table class="table table-bordered">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>이름</th>
				<th>날짜</th>
				<th>조회수</th>
				<th>추천수</th>
			</tr>

			<c:if test="${list.size() ==0 }">
				<tr>
					<td colspan="6">게시물이 없습니다.</td>
				</tr>
			</c:if>

			<c:forEach items="${list}" var="dto">
				<tr>
					<td><c:if test="${dto.depth ==0 }">
					${dto.questionseq}
					</c:if></td>

					<td><c:if test="${dto.depth > 0 }">
							<span
								style="color:cornflowerblue; margin-left: ${dto.depth * 20}px;">
								➥ </span>
						</c:if> <a
						href="/SIST2_Travel/community/question/view.do?questionseq=${dto.questionseq}&column=${map.column }&search=${map.search}">${dto.subject}</a>

						<c:if test="${dto.ccnt > 0}">
							<span class="badge" style="color: black"> (${dto.ccnt }) </span>

						</c:if> <c:if test="${dto.isnew < (1 / 12 ) }">
							<span class="label" id="label-danger">new </span>
						</c:if></td>
					<td>${dto.name}</td>
					<td>${dto.regdate}</td>
					<td>${dto.viewcnt}</td>
					<td>${dto.recommcnt }</td>
				</tr>
			</c:forEach>
		</table>
		<!-- 페이지바  -->
		<%-- <div>
			<form method="get" action="/SIST2_Travel/community/question/list.do">
				<input type="number" name="page" min="1" max="${totalPage }"
					value="${nowPage }" />
					 <input type="submit" value="페이지 보기" />

			</form>
		</div>

		<hr>
		<div>
			<select name="" id="selPage">
				<c:forEach var="i" begin="1" end="${totalPage }">
					<option value="${i }">${i }page</option>
				</c:forEach>
			</select>

		</div> --%>
		<hr>
		<div class='pagebar'>${pagebar }</div>



		<div class="searchbox">
			<form method="get" action="/SIST2_Travel/community/question/list.do">
				<select name="column" id="column" class="form-control">
					<option value="subject">제목</option>
					<option value="content">내용</option>
					<option value="name">이름</option>
					<option value="all">제목+내용</option>

				</select> <input type="text" name="search" id="search" class="form-control"
					required placeholder="검색어를 입력하세요." /> <input type="submit"
					value="검색하기" class="btn btn-default" style="border: 1px solid black; " />
			</form>
		</div>


		<div class="btns">
			<c:if test="${not empty id }">
				<button type="button" class="btn btn-primary"
					onclick="location.href='/SIST2_Travel/community/question/add.do?reply=0';">글쓰기</button>
			</c:if>

			<!-- <button type="button" class="btn btn-default"
				onclick="location.reload();">새로고침</button> -->
			<button type="button" class="btn btn-default" style="border: 1px solid black; "
				onclick="location.href='/SIST2_Travel/community/question/list.do';">새로고침</button>
		</div>

	</section>

	<%@ include file="/inc/init.jsp"%>
	<script>
		<c:if test="${map.isSearch == 'y'}">
		//상태 복원 
		$('#column').val('${map.column}');
		$('#search').val('${map.search}');
		</c:if>

		$('#selPage')
				.change(
						function() {

							location.href = '/SIST2_Travel/community/question/list.do?page='
									+ $(this).val();
						});

		$('#selPage').val('${nowPage}')
	</script>
</body>
</html>