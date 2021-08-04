<%--
  Created by IntelliJ IDEA.
  User: HR
  Date: 2021-08-03
  Time: 오후 8:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach items="${dto}" var="dto">
<%--        ${dto.planseq}--%>
<%--        ${dto.status}--%>
<%--        ${dto.name}--%>
<%--        ${dto.daystarttravel}--%>
<%--        ${dto.dayendtravel}--%>
<%--        ${dto.willshare}--%>
<%--        ${dto.wish}--%>
<%--        ${dto.theme}--%>
<%--        ${dto.id}--%>
<%--        ${dto.cityseq}--%>
<%--        ${dto.cityname}--%>
<%--        ${dto.cityx}--%>
<%--        ${dto.cityy}--%>
        ${dto}
    </c:forEach>
</body>
</html>
