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
    	req.setAttribute("Resdto", Restaurantdto);
		req.setAttribute("Roomdto", Roomdto);
		req.setAttribute("Sdto", Sightdto);
		    restaurantSeq number           NOT NULL primary key,
    name          varchar2(100)    NOT NULL,
    address       varchar2(1000)   NOT NULL,
    image         varchar2(1000)   NULL,
    wish          number default 0 NOT NULL,
    theme         varchar2(100)    NULL,
    restaurantX   number           NULL,
    restaurantY   number           NULL

        roomsSeq number         NOT NULL PRIMARY KEY,
    name     varchar2(50)   NOT NULL,
    explain  varchar2(2000) NOT NULL,
    address  varchar2(200)  NOT NULL,
    type     varchar2(50)   NOT NULL,
    rank     number         NOT NULL,
    price    number         NOT NULL,
    grade    number         NOT NULL,
    roomsX   number         NOT NULL,
    roomsY   number         NOT NULL,
    wish     number  default 0  NOT NULL,
    siteSeq  number         NOT NULL references tblRoomsSite (siteSeq)
    -->
   <div class="container">
      
      <h1 class="page-header">찜 목록</h1>
      <c:forEach items="${Resdto}" var="resdto">
         ${resdto.restaurantSeq}
         ${resdto.name}
         ${resdto.address}
         ${resdto.image}
         ${resdto.wish}
         ${resdto.theme}
         ${resdto.restaurantX}
         ${resdto.restaurantY}
         ${resdto}
      </c:forEach>
      <hr>
      <c:forEach items="${Roomdto}" var="roomdto">
         ${roomdto.name}
         ${roomdto.explain}
         ${roomdto.address}
         ${roomdto.type}
         ${roomdto.rank}
         ${roomdto.price}
         ${roomdto.grade}
         ${roomdto.roomsX}
         ${roomdto.roomsY}
         ${roomdto.wish}
         ${roomdto.siteSeq}
      </c:forEach>
      <hr>
      <c:forEach items="${Sdto}" var="sdto">
         ${sdto.restaurantSeq}
         ${sdto.name}
         ${sdto.address}
         ${sdto.image}
         ${sdto.wish}
         ${sdto.theme}
         ${sdto.restaurantX}
         ${sdto.restaurantY}
         ${sdto}
      </c:forEach>
      <hr>
      
   </div>

   <script>
      
   </script>
</body>
</html>

