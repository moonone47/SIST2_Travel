<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<%@ include file="/inc/asset.jsp"%>

<style>
</style>
</head>
<body>
   <!--  -->
   <div class="container">
      
      <h1 class="page-header"></h1>
      <c:forEach items="${list}" var="dto">
     	${dto.address_name}
	    ${dto.category_group_code}
	    ${dto.category_group_name}
	    ${dto.category_name}
	    ${dto.id}
	    ${dto.phone}
	    ${dto.place_name}
	    ${dto.place_url}
	    ${dto.road_address_name}
	    ${dto.x}
	    ${dto.y}
    </c:forEach>
   </div>

   <script>
      
   </script>
</body>
</html>

