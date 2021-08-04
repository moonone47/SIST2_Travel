<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>여행 병아리들을 위한 여행계획사이트 티피~~</title>

<%@ include file="/inc/asset.jsp" %>

  <style>

  </style>

</head>
<body>
<!-- template.jsp -->
<%@ include file="/inc/header.jsp" %>

<section class="main-section">


	<form  method="POST" action="editpwok.do">
	
		현재 비밀번호 입력 : <input type="password" id="old_pw" name="oldPw" ><br>
		
		변경할 비밀번호 입력 : <input type="password" maxlength="20" id="new_pw" name="newPw"><br> 
		<input type="submit" value="변경하기" id="change_pw_btn">  
	</form> 

</section>


<%@ include file="/inc/init.jsp" %>
<%-- <%@ include file="/inc/footer.jsp" %> --%>
<script>

</script>
</body>
</html>