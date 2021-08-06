<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>여행 병아리들을 위한 여행계획사이트 티피~~</title>

    <%@ include file="/inc/asset.jsp" %>

    <link rel="stylesheet"
          href="<%=request.getContextPath()%>/asset/css/index.css">

</head>
<body>
<!-- template.jsp -->
<%@ include file="/inc/header.jsp" %>

<section class="main-section">
    <div class="con1">
        <div class="con1-title">나만의 여행 플래너 TP!</div>
        <div class="cont1-desc">쉽고 빠르게 여행을 계획하세요.</div>
        <div class="search_area">
            <input class="search_input" id="city_search" placeholder="국가명, 도시명으로 검색">
            <div id="city_autocomplete"></div>
            <div class="latest_search">
                최근검색 :
            </div>
            <a class="go_map">지도에서 검색 &gt;</a>
            <div class="clear"></div>
        </div>
    </div>
    <div class="page silver logged_box">
        <div class="wrap logged">
            <img class="logged_user_img" src="https://image.flaticon.com/icons/png/128/1946/1946429.png">
            <div class="logged_left">
                <div class="logged_name">
                    김미르
                </div>
                <div class="clear"></div>
                <a href="#"
                   class="logged_cnt_box logged_clip">
                    <b>클립보드</b>
                    <span>0</span>
                </a>
                <div class="logged_line">&nbsp;</div>
                <a href="#" class="logged_cnt_box logged_plan">
                    <b>여행일정</b>
                    <span>0</span>
                </a>
                <div class="logged_line">&nbsp;</div>
                <a href="#"
                   class="logged_cnt_box logged_review">
                    <b>리뷰</b>
                    <span>0</span>
                </a>
                <div class="logged_line">&nbsp;</div>
                <a href="#" class="logged_cnt_box logged_qa">
                    <b>Q&amp;A</b>
                    <span>0</span>
                </a>
                <div class="clear"></div>
            </div>
            <a class="logged_btn_box">
                <div class="logged_btn">
                    <div class="logged_btn_ico">
                        <img src="https://image.flaticon.com/icons/png/128/1545/1545615.png" width="45px" alt="">
                    </div>
                    질문하기
                </div>
            </a>
            <a class="logged_btn_box">
                <div class="logged_btn">
                    <div class="logged_btn_ico">
                        <img src="https://image.flaticon.com/icons/png/128/1159/1159633.png" width="45px" alt="">
                    </div>
                    리뷰쓰기
                </div>
            </a>
            <a class="logged_btn_box">
                <div class="logged_btn">
                    <div class="logged_btn_ico">
                        <img src="https://image.flaticon.com/icons/png/128/747/747310.png" width="45px" alt="">
                    </div>
                    일정만들기
                </div>
            </a>
            <div class="clear"></div>
        </div>
    </div>
    <div class="recruiting_advertisers">
        <img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbFm8C6%2FbtqvJTJ494C%2F1kCwf2kwJeHAhRpZlWXibK%2Fimg.png"
             width="400px" alt="광고주모집중">
    </div>
    <div class="page white" style="padding-top:30px;">

        <%--        <center style="padding-bottom:50px;"><img--%>
        <%--                src="/res/1600_210_1.png" style="width:1000px;height:auto;"></center>--%>

        <!--//<center style="padding-bottom:50px;"><a href="/earthtory_agoda" target="_blank"><img src="/res/et_x_agoda/1000X131.jpg" style="width:1000px;height:auto;"></a></center>-->
        <div class="wrap">
            <div class="page_title">
                인기 여행일정
            </div>
            <div class="page_desc">
                다른 여행자들의 일정을 참고해 나만의 여행을 계획해보세요!
            </div>
            <div class="plan_list"><a href="/mypage/et_1507160505510903439001437033951?type=plan_sub&amp;gdb_srl=59770"
                                      target="_blank" class="box">
                <div class="plan_bg">
                    <div class="plan_bg_inner"><span>2015-08-17</span><span class="tour_day">8DAYS</span><br>20살 첫 여행
                    </div>
                </div>
                <div class="plan_img_box"><img
                        src="http://img.earthtory.com/img/city_images/243/singapore_1425521362.jpg" alt=""
                        class="plan_img"></div>
                <div class="plan_bg_inner2"><span>친구와 함께</span>
                    <div class="fr pn_list_copy_icon">0</div>
                    <div class="fr pn_list_view_icon">144</div>
                    <div class="fr pn_list_spot_icon">66</div>
                    <div class="clear"></div>
                    <div class="pn_list_city">싱가포르</div>
                    <div class="clear"></div>
                    <div class="pn_list_user">Park Sunyeon</div>
                </div>
            </a><a href="/mypage/et_0143164001425947988?type=plan_sub&amp;gdb_srl=35258" target="_blank" class="box">
                <div class="plan_bg">
                    <div class="plan_bg_inner"><span>2015-04-24</span><span class="tour_day">4DAYS</span><br>친구와 함께 싱가포르
                    </div>
                </div>
                <div class="plan_img_box"><img src="http://img.earthtory.com/img/city_default/19/243.jpg" alt=""
                                               class="plan_img"></div>
                <div class="plan_bg_inner2"><span>친구와 함께</span>
                    <div class="fr pn_list_copy_icon">8</div>
                    <div class="fr pn_list_view_icon">97</div>
                    <div class="fr pn_list_spot_icon">59</div>
                    <div class="clear"></div>
                    <div class="pn_list_city">싱가포르</div>
                    <div class="clear"></div>
                    <div class="pn_list_user">손명준</div>
                </div>
            </a><a href="/mypage/et_1505250552050514630001432543925?type=plan_sub&amp;gdb_srl=47576" target="_blank"
                   class="box">
                <div class="plan_bg">
                    <div class="plan_bg_inner"><span>2015-07-05</span><span class="tour_day">5DAYS</span><br>여름휴가</div>
                </div>
                <div class="plan_img_box"><img src="http://img.earthtory.com/img/city_images/312/jeju_1425527554.jpg"
                                               alt="" class="plan_img"></div>
                <div class="plan_bg_inner2"><span>친구와 함께</span>
                    <div class="fr pn_list_copy_icon">0</div>
                    <div class="fr pn_list_view_icon">220</div>
                    <div class="fr pn_list_spot_icon">42</div>
                    <div class="clear"></div>
                    <div class="pn_list_city">제주도</div>
                    <div class="clear"></div>
                    <div class="pn_list_user">Wonki Kim</div>
                </div>
            </a><a href="/mypage/et_0318356001415714282?type=plan_sub&amp;gdb_srl=49357" target="_blank" class="box">
                <div class="plan_bg">
                    <div class="plan_bg_inner"><span>2015-10-26</span><span class="tour_day">5DAYS</span><br>기대되는 태국
                    </div>
                </div>
                <div class="plan_img_box"><img src="http://img.earthtory.com/img/city_images/86/bangkok_1429502798.jpg"
                                               alt="" class="plan_img"></div>
                <div class="plan_bg_inner2"><span>커플 여행</span>
                    <div class="fr pn_list_copy_icon">0</div>
                    <div class="fr pn_list_view_icon">134</div>
                    <div class="fr pn_list_spot_icon">34</div>
                    <div class="clear"></div>
                    <div class="pn_list_city">방콕,파타야</div>
                    <div class="clear"></div>
                    <div class="pn_list_user">이소연</div>
                </div>
            </a><a href="/mypage/et_1507050701470788956001436090507?type=plan_sub&amp;gdb_srl=57096" target="_blank"
                   class="box">
                <div class="plan_bg">
                    <div class="plan_bg_inner"><span>2015-07-13</span><span class="tour_day">23DAYS</span><br>유럽여행</div>
                </div>
                <div class="plan_img_box"><img
                        src="http://img.earthtory.com/img/city_images/207/warszawa_1426830331.jpg" alt=""
                        class="plan_img"></div>
                <div class="plan_bg_inner2"><span>가족 여행</span>
                    <div class="fr pn_list_copy_icon">0</div>
                    <div class="fr pn_list_view_icon">352</div>
                    <div class="fr pn_list_spot_icon">221</div>
                    <div class="clear"></div>
                    <div class="pn_list_city">서울,바르샤바,크라쿠프,부다페스트,프라하,잘츠...</div>
                    <div class="clear"></div>
                    <div class="pn_list_user">Pip</div>
                </div>
            </a><a href="/mypage/et_1507071158530846875001436281133?type=plan_sub&amp;gdb_srl=57594" target="_blank"
                   class="box">
                <div class="plan_bg">
                    <div class="plan_bg_inner"><span>2015-07-19</span><span class="tour_day">5DAYS</span><br>2015 여름휴가 -
                        대만
                    </div>
                </div>
                <div class="plan_img_box"><img src="http://img.earthtory.com/img/city_images/92/taipei_1429503854.jpg"
                                               alt="" class="plan_img"></div>
                <div class="plan_bg_inner2"><span>친구와 함께</span>
                    <div class="fr pn_list_copy_icon">0</div>
                    <div class="fr pn_list_view_icon">126</div>
                    <div class="fr pn_list_spot_icon">40</div>
                    <div class="clear"></div>
                    <div class="pn_list_city">타이베이</div>
                    <div class="clear"></div>
                    <div class="pn_list_user">Jisu Park</div>
                </div>
            </a>
                <div class="clear"></div>
            </div>
            <div class="more_btn" onclick="location.href='/ko/plan';">
                56,065개의 추천일정 모두보기
            </div>
        </div>
    </div>

    <div class="page silver">
        <div class="wrap">
            <div class="page_title">
                어디로 갈까?
            </div>
            <div class="page_desc">
                팁에서 아이디어를 얻어보세요.
            </div>
            <div class="story_list"><a href="/ko/tip/view?srl=524" class="story_box big">
                <div class="story_imgbox">
                    <div class="story_cnt"></div>
                    <img src="http://img.earthtory.com/img/nt_img/cover/73/73_1401758930.jpg" alt="" class="story_img"
                         onerror="this.src='http://img.earthtory.com/img/mb_img/73/73_1409209705.JPG';"></div>
                <div class="story_title">방콕에서의 달달한 하루</div>
                <div class="story_desc">방콕에서 단 하루만 머문다면, 어디부터 가야 할까? 방콕 하루 꼬박 여행.</div>
            </a><a href="/ko/tip/view?srl=1201" class="story_box">
                <div class="story_imgbox">
                    <div class="story_cnt"></div>
                    <img src="http://img.earthtory.com/img/nt_img/cover/74/74_1409026663.jpg" alt="" class="story_img"
                         onerror="this.src='http://img.earthtory.com/img/mb_img/74/74_1429243176.jpg';"></div>
                <div class="story_title">체코, 프라하의 베스트 명소</div>
                <div class="story_desc">프라하에서 빼놓을 수 없는 명소들을 미리 둘러보기!</div>
            </a><a href="/ko/tip/view?srl=336" class="story_box">
                <div class="story_imgbox">
                    <div class="story_cnt"></div>
                    <img src="http://img.earthtory.com/img/nt_img/cover/73/73_1400492225.jpg" alt="" class="story_img"
                         onerror="this.src='http://img.earthtory.com/img/mb_img/73/73_1409209705.JPG';"></div>
                <div class="story_title">축제의 도시 멜버른</div>
                <div class="story_desc">축제가 끊이지 않은 도시, 멜버른의 시기별 다양한 축제와 이벤트 속으로 ...</div>
            </a><a href="/ko/tip/view?srl=453" class="story_box">
                <div class="story_imgbox">
                    <div class="story_cnt">12</div>
                    <img src="http://img.earthtory.com/img/nt_img/cover/73/73_1401265474.jpg" alt="" class="story_img"
                         onerror="this.src='http://img.earthtory.com/img/mb_img/73/73_1409209705.JPG';"></div>
                <div class="story_title">낮보다 화려한 홍콩의 밤</div>
                <div class="story_desc">야행성 여행자들을 위한 도시 홍콩. 밤에만 볼 수 있는 아주 특별한 풍경! ...</div>
            </a><a href="/ko/tip/view?srl=378" class="story_box">
                <div class="story_imgbox">
                    <div class="story_cnt"></div>
                    <img src="http://img.earthtory.com/img/nt_img/cover/73/73_1403172007.jpg" alt="" class="story_img"
                         onerror="this.src='http://img.earthtory.com/img/mb_img/73/73_1409209705.JPG';"></div>
                <div class="story_title">스페인 타블라오 탐방기</div>
                <div class="story_desc">카르멘의 나라, 플라멩코 만끽하기!</div>
            </a><a href="/ko/tip/view?srl=528" class="story_box big">
                <div class="story_imgbox">
                    <div class="story_cnt"></div>
                    <img src="http://img.earthtory.com/img/place_img_user/74/common/test_1437361860.jpg" alt=""
                         class="story_img"
                         onerror="this.src='http://img.earthtory.com/img/mb_img/74/74_1429243176.jpg';"></div>
                <div class="story_title">홍콩에서 디저트 먹방!!</div>
                <div class="story_desc">홍콩의 디저트 맛집 체크리스트! 빼먹지말자! 홍콩의 디저트!!</div>
            </a>
                <div class="clear"></div>
            </div>

            <div class="more_btn tip" onclick="location.href='/ko/community/tips';">481개의 여행TIP 모두보기</div>
        </div>
    </div>
    <div class="page white">
        <div class="wrap">
            <div class="page_title">
                인기도시 TOP10		</div>
            <div class="top_city_list">
                <a href="/ko/city/london_309" class="top_city w2">
                    <div class="top_city_title">
                        런던				</div>
                    <img src="http://img.earthtory.com/img/nt_img/cover/74/74_1409026663.jpg" alt="">
                </a>
                <a href="/ko/city/paris_307" class="top_city">
                    <div class="top_city_title">
                        파리				</div>
                    <img src="http://img.earthtory.com/img/nt_img/cover/74/74_1409026663.jpg" alt="">
                </a>
                <a href="/ko/city/singapore_243" class="top_city">
                    <div class="top_city_title">
                        싱가포르				</div>
                    <img src="http://img.earthtory.com/img/nt_img/cover/74/74_1409026663.jpg" alt="">
                </a>

                <a href="/ko/city/istanbul_202" class="top_city">
                    <div class="top_city_title">
                        이스탄불				</div>
                    <img src="http://img.earthtory.com/img/nt_img/cover/74/74_1409026663.jpg" alt="">
                </a>
                <a href="/ko/city/venice_187" class="top_city">
                    <div class="top_city_title">
                        베네치아				</div>
                    <img src="http://img.earthtory.com/img/nt_img/cover/74/74_1409026663.jpg" alt="">
                </a>
                <a href="/ko/city/barcelona_10005" class="top_city">
                    <div class="top_city_title">
                        바르셀로나				</div>
                    <img src="http://img.earthtory.com/img/nt_img/cover/74/74_1409026663.jpg" alt="">
                </a>
                <a href="/ko/city/taipei_92" class="top_city h2">
                    <div class="top_city_title">
                        타이베이				</div>
                    <img src="http://img.earthtory.com/img/nt_img/cover/74/74_1409026663.jpg" alt="">
                </a>

                <a href="/ko/city/hong-kong_245" class="top_city">
                    <div class="top_city_title">
                        홍콩				</div>
                    <img src="http://img.earthtory.com/img/nt_img/cover/74/74_1409026663.jpg" alt="">
                </a>
                <a href="/ko/city/bangkok_86" class="top_city">
                    <div class="top_city_title">
                        방콕				</div>
                    <img src="http://img.earthtory.com/img/nt_img/cover/74/74_1409026663.jpg" alt="">
                </a>
                <a href="/ko/city/jeju_312" class="top_city">
                    <div class="top_city_title">
                        제주도				</div>
                    <img src="http://img.earthtory.com/img/nt_img/cover/74/74_1409026663.jpg" alt="">
                </a>
                <div class="clear"></div>
            </div>
        </div>
    </div>
    <div class="page silver">
        <div class="wrap">
            <div class="page_title">
                TP에서 여행을 시작하세요!		</div>
            <div class="clear"></div>
            <div class="intro_list">
                <div class="intro_box" onclick="location.href='/ko/area';">
                    <img src="	https://www.earthtory.com/res/img/main/intro_img/intro_1.jpg" alt="">
                    <div class="intro_title">
                        여행정보				</div>
                    <div class="intro_desc">
                        전 세계 800개 도시, 30만개의 관광명소, 음식점, 쇼핑 정보를 확인하세요.				</div>
                </div>
                <div class="intro_box" onclick="location.href='/ko/plan';">
                    <img src="	https://www.earthtory.com/res/img/main/intro_img/intro_1.jpg" alt="">
                    <div class="intro_title">
                        여행일정				</div>
                    <div class="intro_desc">
                        전 세계 100,000개 이상의 여행일정을 확인하고 나만의 일정을 계획해 보세요.				</div>
                </div>
                <div class="intro_box" onclick="location.href='/ko/community/qa';">
                    <img src="	https://www.earthtory.com/res/img/main/intro_img/intro_1.jpg" alt="">
                    <div class="intro_title">
                        커뮤니티				</div>
                    <div class="intro_desc">
                        여행자들과 정보를 공유하고, 궁금한 것은 언제든 물어보세요.				</div>
                </div>
                <div class="clear"></div>
            </div>
            <a href="/ko/intro" class="intro_link">
                사용방법이 궁금하신가요?		</a>
        </div>
    </div>
    <%--  <c:if test="${not empty id}">--%>
    <%--    <div>--%>
    <%--      <span><img src="https://www.earthtory.com/res/img/common/mobile/img_profile.png" alt="회원사진"></span>--%>
    <%--      <div class="member_name">회원이름</div>--%>
    <%--      <table class="table table-bordered">--%>
    <%--        <tr>--%>
    <%--          <td>클립보드</td>--%>
    <%--          <td>여행일정</td>--%>
    <%--          <td>리뷰</td>--%>
    <%--          <td>Q&A</td>--%>
    <%--        </tr>--%>
    <%--        <tr>--%>
    <%--          <td>0</td>--%>
    <%--          <td>3</td>--%>
    <%--          <td>1</td>--%>
    <%--          <td>2</td>--%>
    <%--        </tr>--%>
    <%--      </table>--%>
    <%--      <div class="make-schedule"><img src="https://www.earthtory.com/res/img/main/ico_plan.png">일정 만들기</div>--%>
    <%--    </div>--%>
    <%--  </c:if>--%>
    <%--이름정하기........................................--%>
    <%--zzz--%>
    <%--어스토리 마이리얼트립 스투비플래너 클룩 트리플 프립--%>
    <%--어스 리얼 플래너--%>
    <%--마이트래블플래너--%>
    <%--유어리얼트립--%>
    <%--  travel plan--%>
    <%--  tp--%>
    <%--  sist--%>
    <%--  SisTravel--%>
    <%--  Schedule--%>

    <%--트래블러--%>
    <%--티피(아귀엽다) > Travel Plan * 여행 병아리들을 위한 여행계획사이트 티피~~--%>
    <%--TCP--%>
</section>


<%@ include file="/inc/init.jsp" %>
<%@ include file="/inc/footer.jsp" %>
<script>

</script>
</body>
</html>















