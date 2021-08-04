<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>TP</title>

   <%@ include file="/inc/asset.jsp" %>

   <style>
	   .main-section {padding: 100px;}
   </style>

</head>
<body onload="noBack();" onpageshow="if(event.persisted) noBack();" onunload="">
<!-- template.jsp > management > detailview.jsp -->
<%@ include file="/inc/header.jsp" %>

<section class="main-section">
	<h1>상세 일정 보기</h1>
	<table class="table">
		<c:forEach items="${datelist}" var="date" varStatus="status">
				<tr>
					<th>DAY ${status.count}</th>
					<td>${date} ${plan.cityname}</td>
				</tr>
			<c:forEach items="${list}" var="dto"  varStatus="instatus">
					<tr>	
						<th>${instatus.count}</th>
						<td>
							<span>${dto.place_name}</span>
							<span>${dto.address_name}</span>
							<span>${dto.category_group_name}</span>
							<a href="${dto.place_url}">상세 페이지</a>
						<td>
					</tr>
			</c:forEach>		
		</c:forEach>	
	</table>
	<button class="btn btn-primary" 
		onclick="location.href='/SIST2_Travel/plan/between.do?planseq=${plan.planseq}&isedit=y';">수정하기</button>
	<button class="btn btn-default"
		onclick="location.href='/SIST2_Travel/management/back.do';">돌아가기</button>
</section>



<%@ include file="/inc/init.jsp" %>
<%@ include file="/inc/footer.jsp" %>
<script>

	function noEvent() { // 새로 고침 방지
	    if (event.keyCode == 116) {
	        alert("새로고침을 할 수 없습니다.");
	        event.keyCode = 2;
	        return false;
	    } else if (event.ctrlKey
	            && (event.keyCode == 78 || event.keyCode == 82)) {
	        return false;
	    }
	}
	document.onkeydown = noEvent;
	
	window.history.forward();
	function noBack(){window.history.forward();}
	
	

</script>
</body>
</html>















