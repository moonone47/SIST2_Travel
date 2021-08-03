<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <%--    <%@ include file="/inc/asset.jsp" %>--%>
    <meta charset="utf-8">
    <title> 플젝 </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">


    <link href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/asset/css/plan.css" type="text/css"/>
    <%-- <link rel="stylesheet" href="/SIST2_Travel/asset/css/plan.css" type="text/css"/>--%>

    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

    <%--    <link href="//cdn.jsdelivr.net/gh/gitbrent/bootstrap4-toggle@3.4.0/css/bootstrap4-toggle.min.css" rel="stylesheet">--%>
    <%--    <script src="//cdn.jsdelivr.net/gh/gitbrent/bootstrap4-toggle@3.4.0/js/bootstrap4-toggle.min.js"></script>--%>
    <%--    <link rel="stylesheet" href="//unpkg.com/bootstrap@4/dist/css/bootstrap.min.css">--%>
    <style>
        .map_wrap{
            margin-top:100px;
        }
        #menu_wrap > div:nth-child(3) > div > form {
            position: fixed;
            left: 311px;
            right: 900px;
            top: 17px;
        }
        #category{
            position: absolute;
            top: -80px;
            left: 10px;
        }

        body > div.container > h1{
            margin-bottom:250px;
        }

        #menu_wrap > div.option > div > form{
            position: fixed;
            left: 300px;
            top: 0px;
            z-index: 1000;
            font-size: 30px;
            width:200px;
            display: inline;
        }
        #keyword{
            width: 350px;
            height: 50px;
            font-size: 20px;
            display: inline;
        }
        #menu_wrap > div.option > div > form > button{
            width: 122px;
            height: 50px;
            font-size: 20px;
            display: inline;
        }
        body > div.container > div{
            margin-bottom: 200px;
        }


    </style>
</head>

<%-------------------------------- 카테고리 -----------------------------------%>
<%--<body onload="script();">--%>
<body>
<div class="map_wrap">
    <div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div>
    <ul id="category">
        <li id="all" data-order="1">
            <span class="category_bg store"></span>
            전체
        </li>
        <li id="AD5" data-order="2">
            <span class="category_bg store"></span>
            숙박시설
        </li>
        <li id="AT4" data-order="3">
            <span class="category_bg store"></span>
            관광명소
        </li>
        <li id="FD6" data-order="4">
            <span class="category_bg store"></span>
            음식점
        </li>
    </ul>
    <div id="menu_wrap" class="bg_white">
        <div class="option"></div>
        <hr>
            <div class="option">
                <div>
                    <form onsubmit="searchPlaces(); return false;">
                        키워드 : <input type="text" value="서울 여행" id="keyword" size="15" class="form-control">
                        <button type="submit" class="btn btn-info">검색하기</button>
                    </form>
                </div>
            </div>
            <hr>
            <ul id="placesList"></ul>
            <div id="pagination"></div>
        </div>
    </div>

<iframe id='detail'
        class="embed-responsive embed-responsive-16by9 "
        src=''
        frameborder='0'
        scrolling='yes'
        style='width: 800px;'>
    <!--  onload="this.style.height=(this.contentWindow.document.body.scrollHeight+20)+'px';">-->
</iframe>

    <script>
        $("#placesList").click(function () {
            $("detail").removeAttr("invisible");
        });
    </script>
    <script>
        $(function () {
            var dateFormat = "yy-mm-dd",
                from = $("#from")
                    .datepicker({
                        defaultDate: "+1w",
                        changeMonth: true,
                        numberOfMonths: 1,
                        dateFormat: 'yy-mm-dd'
                    })
                    .on("change", function () {
                        to.datepicker("option", "minDate", getDate(this));
                    }),
                to = $("#to").datepicker({
                    defaultDate: "+1w",
                    changeMonth: true,
                    numberOfMonths: 1,
                    dateFormat: 'yy-mm-dd'
                })
                    .on("change", function () {
                        from.datepicker("option", "maxDate", getDate(this));
                    });

            function getDate(element) {
                var date;
                try {
                    date = $.datepicker.parseDate(dateFormat, element.value);
                } catch (error) {
                    date = null;
                }

                return date;
            }
        });
    </script>
    <%--    <script language='javascript'>--%>

    <%--        function noEvent() {--%>
    <%--            if (event.keyCode == 116) {--%>
    <%--                event.keyCode = 2;--%>
    <%--                return false;--%>
    <%--            } else if (event.ctrlKey && (event.keyCode == 78 || event.keyCode == 82)) {--%>
    <%--                return false;--%>
    <%--            }--%>
    <%--        }--%>

    <%--        document.onkeydown = noEvent;--%>
    <%--    </script>--%>
    <%---------------------------------지도---------------------------------%>

    <script type="text/javascript"
            src="//dapi.kakao.com/v2/maps/sdk.js?appkey=146e5efa152999d1970430f4e8202734&libraries=services"></script>
    <script>
        window.onload = function () {
            $('#all').trigger("click");
        }
        // 마커를 클릭했을 때 해당 장소의 상세정보를 보여줄 커스텀오버레이입니다
        var placeOverlay = new kakao.maps.CustomOverlay({zIndex: 1}),
            contentNode = document.createElement('div'), // 커스텀 오버레이의 컨텐츠 엘리먼트 입니다
            markers = [], // 마커를 담을 배열입니다
            currCategory = ''; // 현재 선택된 카테고리를 가지고 있을 변수입니다

        var mapContainer = document.getElementById('map'), // 지도를 표시할 div
            mapOption = {
                center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
                <%--center: new kakao.maps.LatLng(${city.cityY}, ${city.cityX}), // 지도의 중심좌표   ${city.cityX}--%>
                level: 7 // 지도의 확대 레벨

            };

        // 지도를 생성합니다
        var map = new kakao.maps.Map(mapContainer, mapOption);

        // 장소 검색 객체를 생성합니다
        var ps = new kakao.maps.services.Places(map);

        // 지도에 idle 이벤트를 등록합니다
        kakao.maps.event.addListener(map, 'idle', searchPlaces);

        // 커스텀 오버레이의 컨텐츠 노드에 css class를 추가합니다
        contentNode.className = 'placeinfo_wrap';

        // 커스텀 오버레이의 컨텐츠 노드에 mousedown, touchstart 이벤트가 발생했을때
        // 지도 객체에 이벤트가 전달되지 않도록 이벤트 핸들러로 kakao.maps.event.preventMap 메소드를 등록합니다
        addEventHandle(contentNode, 'mousedown', kakao.maps.event.preventMap);
        addEventHandle(contentNode, 'touchstart', kakao.maps.event.preventMap);

        // 커스텀 오버레이 컨텐츠를 설정합니다
        placeOverlay.setContent(contentNode);

        // 각 카테고리에 클릭 이벤트를 등록합니다
        addCategoryClickEvent();

        // 엘리먼트에 이벤트 핸들러를 등록하는 함수입니다
        function addEventHandle(target, type, callback) {
            if (target.addEventListener) {
                target.addEventListener(type, callback);
            } else {
                target.attachEvent('on' + type, callback);
            }
        }
        searchPlaces();
        // 키워드 검색을 요청하는 함수입니다
        function searchPlaces() {

            var keyword = document.getElementById('keyword').value;

            if (!keyword.replace(/^\s+|\s+$/g, '')) {
                alert('키워드를 입력해주세요!');
                return false;
            }

            // 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
            ps.keywordSearch( keyword, placesSearchCB);
        }

        // 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
        function placesSearchCB(data, status, pagination) {
            if (status === kakao.maps.services.Status.OK) {

                // 정상적으로 검색이 완료됐으면
                // 검색 목록과 마커를 표출합니다
                displayPlaces(data);

                // 페이지 번호를 표출합니다
                displayPagination(pagination);

            } else if (status === kakao.maps.services.Status.ZERO_RESULT) {

                alert('검색 결과가 존재하지 않습니다.');
                return;

            } else if (status === kakao.maps.services.Status.ERROR) {

                alert('검색 결과 중 오류가 발생했습니다.');
                return;

            }
        }

        // // 카테고리 검색을 요청하는 함수입니다
        // function searchPlaces() {
        //     if (!currCategory) {
        //         searchAll();
        //     }
        //
        //     // 커스텀 오버레이를 숨깁니다
        //     placeOverlay.setMap(null);
        //
        //     // 지도에 표시되고 있는 마커를 제거합니다
        //     removeMarker();
        //     // console.log(currCategory);
        //     if (currCategory == 'all') {
        //         ps.categorySearch(['AD5', 'AT4', 'FD6'], placesSearchCB, {useMapBounds: true});
        //     }
        //     ps.categorySearch(currCategory, placesSearchCB, {useMapBounds: true});
        // }
        //
        //
        // // 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
        // function placesSearchCB(data, status, pagination) {
        //     if (status === kakao.maps.services.Status.OK) {
        //
        //         // 정상적으로 검색이 완료됐으면 지도에 마커를 표출합니다
        //         displayPlaces(data);
        //         // console.log(data);
        //     } else if (status === kakao.maps.services.Status.ZERO_RESULT) {
        //         // 검색결과가 없는경우 해야할 처리가 있다면 이곳에 작성해 주세요
        //
        //     } else if (status === kakao.maps.services.Status.ERROR) {
        //         // 에러로 인해 검색결과가 나오지 않은 경우 해야할 처리가 있다면 이곳에 작성해 주세요
        //
        //     }
        // }

        // 지도에 마커를 표출하는 함수입니다
        function displayPlaces(places) {
            // console.log(currCategory);
            // 몇번째 카테고리가 선택되어 있는지 얻어옵니다
            // 이 순서는 스프라이트 이미지에서의 위치를 계산하는데 사용됩니다
            var order = document.getElementById(currCategory).getAttribute('data-order');

            var listEl = document.getElementById('placesList'),
                menuEl = document.getElementById('menu_wrap'),
                fragment = document.createDocumentFragment(),
                bounds = new kakao.maps.LatLngBounds(),
                listStr = '';

            removeAllChildNods(listEl);
            removeMarker();
            for (var i = 0; i < places.length; i++) {
                var placePosition = new kakao.maps.LatLng(places[i].y, places[i].x);
                // console.log('!' + places[i].place_url);
                itemEl = getListItem(i, places[i]);
                // console.log(itemEl);
                var url = places[i].place_url;
                // 마커를 생성하고 지도에 표시합니다
                var marker = addMarker(new kakao.maps.LatLng(places[i].y, places[i].x), order);


                bounds.extend(placePosition);
                (function (marker,
                           address_name,
                           category_group_code,
                           category_group_name,
                           category_name,
                           id,
                           phone,
                           title,
                           place_url,
                           road_address_name,
                           x,
                           y) {
                    kakao.maps.event.addListener(marker, 'mouseover', function () {
                        displayInfowindow(marker, title);
                    });

                    kakao.maps.event.addListener(marker, 'mouseout', function () {
                        infowindow.close();
                    });

                    itemEl.onmouseover = function () {
                        displayInfowindow(marker, title);
                    };

                    itemEl.onmouseout = function () {
                        infowindow.close();
                    };
                    itemEl.onclick = function () {
                        // console.log(url);
                        // console.log(places[i].place_url);
                        //얘가 안돼요.. Uncaught TypeError: Cannot read property 'place_url' of undefined at HTMLLIElement.itemEl.onclick

                        //여기에서 바꿀까요?
                        $('#address_name').val(address_name);
                        console.log(address_name);
                        $('#category_group_code').val(category_group_code);
                        $('#category_group_name').val(category_group_name);
                        $('#category_name').val(category_name);
                        $('#id').val(id);
                        $('#phone').val(phone);
                        $('#place_name').val(title);
                        $('#place_url').val(place_url);
                        $('#road_address_name').val(road_address_name);
                        $('#x').val(x);
                        $('#y').val(y);
                        // console.log('!!' + url); // <-- 얘가 undefined
                        displayDetail(place_url);
                    }
                })(marker,
                    places[i].address_name,
                    places[i].category_group_code,
                    places[i].category_group_name,
                    places[i].category_name,
                    places[i].id,
                    places[i].phone,
                    places[i].place_name,
                    places[i].place_url,
                    places[i].road_address_name,
                    places[i].x,
                    places[i].y
                );

                fragment.appendChild(itemEl);

                // 마커와 검색결과 항목을 클릭 했을 때
                // 장소정보를 표출하도록 클릭 이벤트를 등록합니다
                (function (marker, place) {
                    kakao.maps.event.addListener(marker, 'click', function () {
                        displayPlaceInfo(place);
                    });
                })(marker, places[i]);
            }
            listEl.appendChild(fragment);
            menuEl.scrollTop = 0;
        }

        //리스트를 클릭했을때 하는 행동
        function displayDetail(url) {


            $('#detail').attr('src', url); //iframe url을 넣어줌
            //iframe 내부요소를 조작해서 넣는방법 -> js로 코드를 받아와서 crawling 작업이 필요

            // <div id="addplan" class="noshow"></div>
            $('#addplan').addClass('show'); //버튼을 보여줌 위치는 우리가 css로 조작

        };


        var infowindow = new kakao.maps.InfoWindow({zIndex: 1});
        // 검색결과 목록 또는 마커를 클릭했을 때 호출되는 함수입니다
        // 인포윈도우에 장소명을 표시합니다
        function displayInfowindow(marker, title) {
            var content = '<div style="padding:5px;z-index:1;">' + title + '</div>';

            infowindow.setContent(content);
            infowindow.open(map, marker);
        }

        // 검색결과 항목을 Element로 반환하는 함수입니다
        function getListItem(index, places) {
            // console.log('@' + places);
            var el = document.createElement('li'),
                itemStr = '<span class="markerbg marker_' + (index + 1) + '"></span>' +
                    '<div class="info">' +
                    '   <h5>' + places.place_name + '</h5>';

            if (places.road_address_name) {
                itemStr += '    <span>' + places.road_address_name + '</span>' +
                    '   <span class="jibun gray">' + places.address_name + '</span>';
            } else {
                itemStr += '    <span>' + places.address_name + '</span>';
            }

            itemStr += '  <span class="tel">' + places.phone + '</span>' +
                '</div>';

            el.innerHTML = itemStr;
            el.className = 'item';

            return el;
        }

        function removeAllChildNods(el) {
            while (el.hasChildNodes()) {
                el.removeChild(el.lastChild);
            }
        }

        // 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
        function addMarker(position, order) {
            var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_category.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
                imageSize = new kakao.maps.Size(27, 28),  // 마커 이미지의 크기
                imgOptions = {
                    spriteSize: new kakao.maps.Size(72, 208), // 스프라이트 이미지의 크기
                    spriteOrigin: new kakao.maps.Point(46, (order * 36)), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
                    offset: new kakao.maps.Point(11, 28) // 마커 좌표에 일치시킬 이미지 내에서의 좌표
                },
                markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions),
                marker = new kakao.maps.Marker({
                    position: position, // 마커의 위치
                    image: markerImage
                });

            marker.setMap(map); // 지도 위에 마커를 표출합니다
            markers.push(marker);  // 배열에 생성된 마커를 추가합니다

            return marker;
        }

        // 지도 위에 표시되고 있는 마커를 모두 제거합니다
        function removeMarker() {
            for (var i = 0; i < markers.length; i++) {
                markers[i].setMap(null);
            }
            markers = [];
        }

        // 클릭한 마커에 대한 장소 상세정보를 커스텀 오버레이로 표시하는 함수입니다
        function displayPlaceInfo(place) {
            var content = '<div class="placeinfo">' +
                '   <a class="title" href="' + place.place_url + '" target="_blank" title="' + place.place_name + '">' + place.place_name + '</a>';

            if (place.road_address_name) {
                content += '    <span title="' + place.road_address_name + '">' + place.road_address_name + '</span>' +
                    '  <span class="jibun" title="' + place.address_name + '">(지번 : ' + place.address_name + ')</span>';
            } else {
                content += '    <span title="' + place.address_name + '">' + place.address_name + '</span>';
            }

            content += '    <span class="tel">' + place.phone + '</span>' +
                '</div>' +
                '<div class="after"></div>';

            contentNode.innerHTML = content;
            placeOverlay.setPosition(new kakao.maps.LatLng(place.y, place.x));
            placeOverlay.setMap(map);
        }

        var linePath = [

            <c:forEach items="${list}" var="dto" varStatus="status">

            new kakao.maps.LatLng(${dto.y}, ${dto.x})
            <c:if test="${list.size()-1 > status.index}">
            ,
            </c:if>
            </c:forEach>

        ];


        var polyline = new kakao.maps.Polyline({
            path: linePath, // 선을 구성하는 좌표배열 입니다
            strokeWeight: 5, // 선의 두께 입니다
            strokeColor: '#FFAE00', // 선의 색깔입니다 #FFAE00
            strokeOpacity: 0.7, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
            strokeStyle: 'solid' // 선의 스타일입니다
        });

        // 지도에 선을 표시합니다
        polyline.setMap(map);

        // 각 카테고리에 클릭 이벤트를 등록합니다
        function addCategoryClickEvent() {
            var category = document.getElementById('category'),
                children = category.children;

            for (var i = 0; i < children.length; i++) {
                children[i].onclick = onClickCategory;
            }
        }

        // 카테고리를 클릭했을 때 호출되는 함수입니다
        function onClickCategory() {
            var id = this.id,
                className = this.className;

            placeOverlay.setMap(null);

            if (className === 'on') {
                currCategory = '';
                changeCategoryClass();
                removeMarker();
            } else {
                currCategory = id;
                changeCategoryClass(this);
                searchPlaces();
            }
        }

        // 클릭된 카테고리에만 클릭된 스타일을 적용하는 함수입니다
        function changeCategoryClass(el) {
            var category = document.getElementById('category'),
                children = category.children,
                i;

            for (i = 0; i < children.length; i++) {
                children[i].className = '';
            }

            if (el) {
                el.className = 'on';
            }
        }


        <%--------------------------------------------------------------------------%>

        $('.sortable').sortable({
            start: function (e, ui) {
                // creates a temporary attribute on the element with the old index
                $(this).attr('data-previndex', ui.item.index());
                console.log(ui.item.index());
            },
            update: function (e, ui) {
                // gets the new and old index then removes the temporary attribute
                /* var result = $(this).sortable('toArray');
                alert(result);
                } */
                var newIndex = ui.item.index();
                var oldIndex = $(this).attr('data-previndex');
                $(this).removeAttr('data-previndex');
                console.log(ui.item.index());
                console.log(ui.item.val());
            },
            stop: function (e, ui) {
                reorder();
            }
        });

        function reorder() {
            $(".list-group input[name='seq']").each(function (i, box) {
                $(box).val(i + 1);
            });

        }


    </script>


</body>
</html>