<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
   <style>

   </style>
   <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b98db171cb4bc02433f272306db4edb2"></script>
   <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<title></title>



<style>
</style>
</head>
<body>
   <!-- test.jsp -->
   <div class="container">

	<%--
	어느 한 지역을 선택한 뒤에 > 선택된 지역을 기반으로 명소, 음식점, 숙소 리스트를 출력
	API를 이용.
	--%>

      <h1 class="page-header">test2</h1>
<%--      <div id="map" style="width:100%;height:1000px;"></div>--%>
	  <p id="me">

      </p>
   </div>
   <script>
   /* GET /v2/local/search/category.{format} HTTP/1.1
   Host: dapi.kakao.com
   Authorization: KakaoAK {REST_API_KEY} 
   
    AT4	관광명소
	AD5	숙박
	FD6	음식점
   */

   // https://developers.kakao.com/docs/latest/ko/local/dev-guide#search-by-category
   let url2 = 'https://dapi.kakao.com/v2/local/search/category.json?' +
           'category_group_code='+encodeURIComponent('AT4') //AT4 카테고리 코드 관광명소
           +'&x='+encodeURIComponent('37.47150565190942') // &x= 위도
           +'&y='+encodeURIComponent('126.59619949317715');
   $.ajax({ //37.47150565190942, 126.59619949317715
       url:'https://dapi.kakao.com/v2/local/search/category.json?' +
               'category_group_code='+encodeURIComponent('AT4') //AT4 카테고리 코드 관광명소
    		   +'&x='+encodeURIComponent('37.47150565190942') // &x= 위도
               +'&y='+encodeURIComponent('126.59619949317715'), // &y = 경도
		       type:'GET',
		       headers: {'Authorization' : 'KakaoAK b7007a415d33c970f8d73abba2ce576c'},
		success:function(data){
		   console.log(data);
           $("p").append(data.documents[2].id); //여기 문제 있나요?
           $("#me").append(data); //여기 문제 있나요?

		},
		error : function(e){
		   console.log(e);
		}
});
   // .done(function (msg) {
   //    $("p").append(msg.documents[2].title);
   //    $(".thumbnail").append('<img src="' + msg.documents[2].thumbnail + '"/>');
   // });
   
   /* GET /v2/local/search/address.{format} HTTP/1.1
   Host: dapi.kakao.com
   Authorization: KakaoAK {REST_API_KEY} */
   $.ajax({
       url:'https://dapi.kakao.com/v2/local/search/address.json?query='+encodeURIComponent('숭의동'),
		       type:'GET',
		       headers: {'Authorization' : 'KakaoAK b7007a415d33c970f8d73abba2ce576c'},
		success:function(data){
		   console.log(data);
		},
		error : function(e){
		   console.log(e);
		}
});
   $("p").append(url2);
   </script>
</body>
</html>

