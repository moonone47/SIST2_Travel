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
   <!--

    -->
   <div class="container">
      
      <h1 class="page-header">찜 목록</h1>
      <c:forEach items="${Resdto}" var="resdto">
         ${resdto.restaurantSeq}
         ${resdto.name}
         ${resdto.explain}
         ${resdto.address}
         ${resdto.image}
         ${resdto.grade}
         ${resdto.wish}
         ${resdto.theme}
         ${resdto.restaurantX}
         ${resdto.restaurantY}
         ${resdto.plandate}
         ${resdto.budget}
         ${resdto.seq}
         ${resdto.url}
         ${resdto.planseq}
         ${resdto.id}
         <hr>
      </c:forEach>

      <c:forEach items="${Roomdto}" var="roomdto">
         ${roomdto.roomsSeq}
         ${roomdto.name}
         ${roomdto.explain}
         ${roomdto.address}
         ${roomdto.image}
         ${roomdto.grade}
         ${roomdto.wish}
         ${roomdto.theme}
         ${roomdto.roomsX}
         ${roomdto.roomsY}
         ${roomdto.plandate}
         ${roomdto.budget}
         ${roomdto.seq}
         ${roomdto.url}
         ${roomdto.planseq}
         ${roomdto.id}
         <hr>
      </c:forEach>
      <c:forEach items="${Sdto}" var="sdto">

         ${sdto.sightsSeq}
         ${sdto.name}
         ${sdto.explain}
         ${sdto.address}
         ${sdto.image}
         ${sdto.grade}
         ${sdto.wish}
         ${sdto.theme}
         ${sdto.sightsX}
         ${sdto.sightsY}
         ${sdto.plandate}
         ${sdto.budget}
         ${sdto.seq}
         ${sdto.url}
         ${sdto.planseq}
         ${sdto.id}
         <hr>
      </c:forEach>
      <hr>
      
   </div>

   <script>
      
   </script>
</body>
</html>

