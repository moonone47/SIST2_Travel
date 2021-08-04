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
.table th {
	width: 120px;
}
.table td {
	width: 680px;
}
.table #content {
	height: 400px;
}
.table {
	width: 1000px;
}
.main-section {
	width: 800px;
	margin: 35px auto;
	padding-bottom: 300px;
}

</style>

</head>
<body>
	<!-- service/apply.jsp -->
	<%@ include file="/inc/header.jsp"%>

	<section class="main-section">

		<h1>
			여행 의뢰 신청 <small>Add</small>
		</h1>

		<form method="POST" action="/SIST2_Travel/service/applyok.do">
			<table class="table table-bordered">
				<tr>
					<th>여행지</th>
					<td>
					<input type="text" name="travelspot" id=""travelspot""
						class="form-control" required />
						</td>
				</tr>
				<tr >
					<th>여행시작날짜</th>
					<td >
					<input type="regdate" name="daystarttravel" id="daystarttravel"
						class="form-control" required />
							</td>
				</tr>
				<tr >
					<th>여행종료날짜</th>
					<td >
					<input type="regdate" name="dayendtravel" id="dayendtravel"
						class="form-control" required />
							</td>
				</tr>
				<tr >
					<th>여행목적</th>
					<td >
					<input type="text" name="purpose" id="purpose"
						class="form-control" required />
							</td>
				</tr>
				<tr >
					<th>인원</th>
					<td >
					<input type="number" name="numberpeople" id="numberpeople"
						class="form-control" required />
							</td>
				</tr>
				

			</table>

			<div class="btns">
				<button type="submit" id="apply" class="btn btn-primary">의뢰 신청하기</button>
				<button type="button" class="btn btn-default"
					onclick="location.href='/SIST2_Travel/service/list.do';">돌아가기</button>
			</div>
		
		</form>

	</section>

	<%@ include file="/inc/init.jsp"%>
   <%@ include file="/inc/footer.jsp"%> 
	<script>
	$("#apply").click(function() {
		if (confirm("여행 의뢰를 신청하시겠습니까?")) {
			
		}
	});
	</script>
</body>
</html>