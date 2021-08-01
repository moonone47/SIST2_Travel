<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/inc/asset.jsp"/>
<style>
	#bookmark-alert {
		top: 300px;
	}
	
	.modal-content {
		width: 500px;
	}
</style>
</head>
<body>
<div class="modal fade" id="loginup" tabindex="-1" role="dialog"
      aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-sm" id="bookmark-alert">
         <div class="modal-content">
            <div class="modal-header">
               로그인 실패
               <button type="button" class="close" data-dismiss="modal"
                  aria-hidden="true">x
               </button> 
            </div>
            <div class="modal-body" style="text-align: center; color: red; font-size:1.2em;">
             가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.
            </div>
            <div class="modal-footer">
               <button type="button" class="btn btn-primary" id="myButtons1" data-dismiss="modal">
                  확인
               </button>
            </div>
         </div>
      </div>
   </div>
   
   

		<script>
   		<c:if test="${!empty id}">
				location.href="/SIST2_Travel/index.do";
			<c:if test="${auto == 1}">
			setCookie("id", "${id}", 365);
			</c:if>
			
			<c:if test="${auto == 0}">
				setCookie("id", "", -1);
			</c:if>
		</c:if>
		</script>
	 
	<c:if test="${empty id}">
		<script>
		$("#loginup").modal();
		$("#loginup").on('hidden.bs.modal', function() {
			history.back();
		});
		</script>
	</c:if>
</body>
</html>