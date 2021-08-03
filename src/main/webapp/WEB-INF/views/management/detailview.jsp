<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>TP</title>

   <%@ include file="/inc/asset.jsp" %>

   <style>

   </style>

</head>
<body>
<!-- template.jsp > management > detailview.jsp -->
<%@ include file="/inc/header.jsp" %>

<section class="main-section">
	<table>
		<c:forEach items="${datelist}" var="date" varStatus="status">
			<c:forEach items="${list}" var="dto"  varStatus="instatus">
				<tr>
					<th>DAY ${status.count}</th>
					<td>${date}</td>
					<td>${dto.city}</td>
				</tr>
				<c:if test="${date == dto.rdate}">
				<tr>	
					<th>{instatus.count}</th>
					<td colspan="2">
						<span>${dto.place_name}</span>
						<span>${dto.address_name}</span>
						<span>${dto.category_group_name}</span>
						<a href="${dto.place_url}">상세 페이지</a>
					<td>
				</tr>
				</c:if>
				
			</c:forEach>			
		</c:forEach>	
	</table>


</section>



<%@ include file="/inc/init.jsp" %>
<%@ include file="/inc/footer.jsp" %>
<script>

</script>
</body>
</html>















