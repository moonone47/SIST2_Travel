<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="travel.mypage.MypageDAO"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>회원 탈퇴</title>

<%@ include file="/inc/asset.jsp" %>

  <style>

  </style>

</head>
<body>
<!-- template.jsp -->
<%@ include file="/inc/header.jsp" %>

<section class="main-section">

<%
	
	String pw = request.getParameter("pw");
	String id = (String)session.getAttribute("id");
	
	
		MypageDAO dao = new MypageDAO();
	
		boolean flag = dao.deleteMember(id);
		if(flag) {
%>

<script>
			alert("회원 탈퇴가 정상적으로 처리되었습니다.");
			document.location.href="/SIST2_Travel/index.do";
</script>
<%
		}else {
%>
		<script>
			alert("회원 탈퇴에 실패했습니다.");
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