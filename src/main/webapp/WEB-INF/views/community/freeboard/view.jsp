<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여행 병아리들을 위한 여행계획사이트 티피~~</title>

<%@ include file="/inc/asset.jsp"%>

<style>
#container {
	width: 1100px;
	margin: 0px auto 50px auto;

}

.list {
	width: 900px;

	margin: 20px auto;
}

.table {
	text-align: center;
}

.table tr:nth-child(1) th {
	width: 120px;
}

.table tr:nth-child(4) td {
	height: 300px;
	text-align: left;
}

.table #subject td:nth-child(2) {
	text-align: left;
}

.table #content th {
	width: 120px;
}


#comment {
	width: 750px;
	display: flex;
	margin-top: 10px;
}

#comment input[type="text"] {
	width: 720px;
	margin-right: 5px;
	padding-left: 5px;
}

#reply-container {
	margin-top: 10px;

}

#reply-container .reply {
	width: 100%;
	border-bottom: 1px solid #DDD;
	padding-bottom: 3px;
}

#nick {
	font-weight: bold;
}

#regdate {
	margin-top: 4px;
	color: #AAA;
	display: flex;
	justify-content: space-between;
}
</style>

</head>
<body>
	<!-- template.jsp views > community > freeboard > view.jsp -->
	<%@ include file="/inc/header.jsp"%>

	<section class="main-section">
		<div id="container">
			<h1>
				자유게시판 <small>글 보기</small>
			</h1>

			<div class="list">
				<table class="table table-bordered">
					<tr>
						<th>글번호</th>
						<td>${dto.freeboardseq}</td>
						<th>작성자</th>
						<td>${dto.nick}</td>
					</tr>
					<tr>
						<th>작성일</th>
						<td>${dto.regdate}</td>
						<th>조회수</th>
						<td>${dto.viewcnt}</td>
					</tr>
					<tr id="subject">
						<th>제목</th>
						<td>${dto.subject}</td>
						<th>추천수</th>
						<td>${dto.recommcnt}</td>
					</tr>
					<tr id="content">
						<th>내용</th>
						<td colspan="3">${dto.content}</td>
					</tr>
				</table>
				
				
			</div>
			<div class="list">
				<div class="btns">
					<button type="button" class="btn btn-primary"
						onclick="location.href='/SIST2_Travel/community/freeboard/edit.do?freeboardseq=${dto.freeboardseq}';">수정하기</button>
					<button type="button" class="btn btn-primary" id="del">삭제하기</button>
					<button type="button" class="btn btn-primary" onclick="">답변달기</button>
					<button type="button" class="btn btn-default"
						onclick="location.href='/SIST2_Travel/community/freeboard/list.do?column=${column}&search=${search}';">돌아가기</button>
				</div>
				<div>
					<div id="reply-container">
						<c:forEach items="${clist}" var="cdto">
							<div class="reply">
								<div id="nick">${cdto.nick}</div>
								<div id="comcontent">${cdto.content}</div>
								<div id="regdate">
									${cdto.regdate} 
									<span>
										<form method="GET" action="/SIST2_Travel/community/freeboard/commentdel.do">
											<input type="hidden" name="freecommentseq" value="${cdto.freecommentseq}">
											<input type="hidden" name="freeboardseq" value="${cdto.freeboardseq}">
											<input type="submit" value="삭제">
										</form>
									</span>
								</div>
							</div>
						</c:forEach>
					</div>
					<form method="POST"
						action="/SIST2_Travel/community/freeboard/comment.do">
						<div id="comment">
							<input type="text" name="content" class="form-control"
								autocomplete="off" required placeholder="댓글을 남겨보세요"> <input
								type="hidden" name="freeboardseq" value="${dto.freeboardseq}">
							<input type="submit" class="pull-right" value="등록"
								class="btn btn-default">
						</div>
					</form>
				</div>
			</div>

		</div>

	</section>


	<%@ include file="/inc/init.jsp"%>
	<%@ include file="/inc/footer.jsp"%>
	<script>
		$('#del')
				.click(
						function() {
							var result = confirm('${dto.freeboardseq}번 글을 삭제하시겠습니까?');

							if (result) {
								location
										.replace('/SIST2_Travel/community/freeboard/delete.do?freeboardseq=${dto.freeboardseq}');
							} else {

							}
						});
		$('#delcom').click(function() {
			var result = confirm('댓글을 삭제하시겠습니까?');

		});
	</script>
</body>
</html>


