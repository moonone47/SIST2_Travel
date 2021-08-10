<%--
  Created by IntelliJ IDEA.
  User: HR
  Date: 2021-08-02
  Time: 오후 4:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>아이디찾기</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/asset/css/bootstrap.css" />
    <link rel="stylesheet" href="<%= request.getContextPath() %>/asset/css/new_main.css" />    
</head>
<style>
    
    #content {
		margin: 100px auto;
	}
	
	#main {
		margin-top: 10px;
		margin-bottom: 10px;
		font-weight: bold;
		color: #AAA;
	}
	
	#name{
		margin-bottom: 2px;
	}
	
	#email {
		margin-bottom: 20px;
	}
	
	.btn {
		color: white;
    	border-color: #529AD9;
    	background-color: #529AD9;
	}
	
</style>
<body>
<%--<%@ include file="/inc/header.jsp" %>--%>

<form class="form-horizontal" role="form" method="POST" action="/SIST2_Travel/login/findidok.do">	
	<div id="content">
	    <h1>아이디 찾기</h1>
	    <div id="main">이름과 이메일을 입력하세요.</div>
	
	    <div class="row">
	        <div class="col-md-10 inputbb">
	            <div class="form-group">
	                <div class="input-group mb-2 mr-sm-2 mb-sm-0">
	                    <input type="text" name="name" class="form-control" id="name" placeholder="이름" required autofocus>
	                </div>
	            </div>
	        </div>
	    </div>
	
	    <div class="row">
	        <div class="col-md-10 inputbb">
	            <div class="form-group has-danger">
	                <div class="input-group mb-2 mr-sm-2 mb-sm-0">
	                    <input type="email" name="email" class="form-control" id="email" placeholder="이메일" required>
	                </div>
	            </div>
	        </div>
	    </div>
	
	    <div class="row">
	        <div class="col-md-10 inputbb">
	            <button type="submit" class="btn btn-outline-secondary findbtn">아이디 찾기</button>
	        </div>
	    </div>
	</div>
</form>

</body>
</html>
