<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날씨 정보 검색</title>

<%@ include file="/inc/asset.jsp"%>

<style>
   #frame{
      margin-bottom: 200px;
   }
</style>
</head>
<body>
   <!--  -->
   <%@ include file="/inc/header.jsp"%>
   <div class="container">
      
      <h1 class="page-header">날씨 정보 검색</h1>
      <iframe id="frame"
              src="https://make-weather.web.app/html/index.html"
              frameborder='0'
              scrolling='no'
              style='width: 100%; height: 1000px;'
              onload="this.style.height=(this.contentWindow.document.body.scrollHeight+20)+'px';">

      </iframe>
   </div>
   <%@ include file="/inc/footer.jsp"%>
   <script>
      
   </script>
</body>
</html>

