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

#list {
	width: 750px;
	margin: 20px auto;
}


.table th {
	width: 100px;
	text-align: center;
	vertical-align: middle;
	display: table-cell;
}

.table {text-align: center;}
.table tr:nth-child(1) th { height: 15px;}
.table tr:nth-child(2) th { height: 15px;}
.table tr:nth-child(3) th { height: 300px;}


.table td {

}

.table #contents {
	height: 300px;
}
</style>

</head>
<body>
	<!-- template.jsp views > community > freeboard > add.jsp-->
	<%@ include file="/inc/header.jsp"%>

	<section class="main-section">
	<div id="container">
		<h1>Board <small>Add</small></h1>
		
		<div id="list">
		<form method="POST" action="/SIST2_Travel/community/freeboard/editok.do?freeboardseq=${dto.freeboardseq}">
			<table class="table table-bordered">
				<tr>
					<th>글번호</th>
					<td>${dto.freeboardseq}</td>
					<th>작성자</th>
					<td>${dto.id}</td>
				</tr>
				<tr>
					<th>제목</th>
					<td colspan="3"><input type="text" name="subject" id="subject" class="form-control" value="${dto.subject}" required ></td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="3"><textarea name="content" id="contents" class="form-control" required>${dto.content}</textarea></td>
				</tr>
			</table>
			<div class="btns">
				<button type="submit" class="btn btn-primary">수정하기</button>
				<button type="button" class="btn btn-default"
					onclick="location.href='/SIST2_Travel/community/freeboard/view.do?freeboardseq=${dto.freeboardseq}';">돌아가기</button>
			</div>
		</form>
		</div>
	</div>
	</section>


	<%@ include file="/inc/footer.jsp"%>
	<script>
		
	</script>
</body>
</html>


