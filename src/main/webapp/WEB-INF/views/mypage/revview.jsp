<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myapp</title>

<%@ include file="/inc/asset.jsp"%>
<%-- <link rel="stylesheet" href="<%= request.getContextPath() %>/asset/css/myapp.css" /> --%>

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
#table1{
width:82%;
}
</style>

</head>
<body>
	<!-- board/view.jsp -->
	<%@ include file="/inc/header.jsp"%>

	<section class="main-section">

		<h1>
			예약 내역 상세 정보 <small>View</small>
		</h1>


		<table class="table table-bordered" id="table1">
			<tr>
				<th>투어 번호</th>
				<td>${dto.tourseq }</td>
				<th>투어 이름</th>
				<td colspan="3">${dto.tourname }</td>
			</tr>
			<tr>
				<th>사용처</th>
				<td>${dto.use }</td>
				<th>유효 날짜</th>
				<td>${dto.validdate }</td>
				<th>투어 가격</th>
				<td>${dto.tourprice }</td>
			</tr>
			<tr>
				<th>상세정보</th>
				<td colspan="5">${dto.detail }</td>
			</tr>
			<tr>
				
				<td colspan ="6"><img src="${dto.img }" > </td>
			</tr>
			<%-- <tr>
				<th>내용</th>
				<td colspan="5">${dto.content }</td>
			</tr>  --%>

		</table>
			
		<button type="button" class="btn btn-primary"
			onclick="history.back()">돌아가기</button>



	</section>

	<%@ include file="/inc/init.jsp"%>
<%@ include file="/inc/footer.jsp" %>
	<script>
		
	</script>
</body>
</html>