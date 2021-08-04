<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="travel.mypage.MypageDAO"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>비밀번호 변경</title>

<%@ include file="/inc/asset.jsp" %>

  <style>

  </style>

</head>
<body>
<!-- template.jsp -->
<%@ include file="/inc/header.jsp" %>

<section class="main-section">

<%
	
	String oldPw = request.getParameter("oldPw");
	String newPw = request.getParameter("newPw");
	String id = (String)session.getAttribute("id");
	
	
		MypageDAO dao = new MypageDAO();
	
		boolean flag = dao.changePassword(id, newPw);
		if(flag) {
%>

<script>
			alert("비밀번호가 정상적으로 변경되었습니다.");
			document.location.href="/SIST2_Travel/index.do";
</script>
<%
		}else {
%>
		<script>
			alert("비밀번호 변경에 실패했습니다.");
			history.back();
		</script>
<%		
		}
%>
	

</section>


<%@ include file="/inc/init.jsp" %>
<%-- <%@ include file="/inc/footer.jsp" %> --%>

</body>
</html>