# SIST2_Travel
여행 커뮤니티 사이트

## SIST Travel planner-based community site TP!
- 코로나로 인해 해외 여행자가 감소하고, 현저하게 늘어난 국내 여행 수요에 맞춰, 국내 여행 계획을 도와주는 여행 플래너를 JSP + Servlet을 활용한 MVC Model2로 제작했다

- 여행을 위한 장소는 검색하면 얼마든지 나온다. 그렇기에 사용자의 편의성을 높인 사이트를 만들고자 하였다. 검색된 장소를 일정으로 담아 제공하는 서비스를 만들어 여행을 계획하는 사람들에게 더욱 편리한 이용이 가능하도록 하는 것이 이번 프로젝트의 주된 목표이다. 크게 음식점, 숙박업소, 명소등 세 가지의 카테고리로 나누어 카테고리별로 지도좌표에 따라 리스트를 구성하여 확인 후 일정을 계획 할 수 있다. 각 날짜 별로 일정을 계획 한 후 만들어진 일정을 공유 할 수 있고, 공유된 일정은 다른 사람이 그대로 복사 후 수정이 가능하도록 구현하였다. 자세한 일정 보기를 통해 일정 리스트를 사용자에게 제공하고 지도에 마커와 선으로 연결하여 시각적인 효과를 높여 일정에 대한 정보를 얻을 수 있다. 또한 여행이라는 특성상 여행지에 대한 경험을 나누는 것이 중요하기에 커뮤니티 게시판을 통해 사용자들이 자유롭게 의견을 나눌 수 있도록 하였다.

- 5명 구성원

- 2021.07.14 ~ 2021.08.06 까지 작업

## Features
1. 메인화면 회원가입, 로그인, 로그아웃, 일정계획, 일정관리, 커뮤니티, 검색
2. 일정계획 일정 입력, 일정 조회, 각 일정마다 여행지 추가 및 삭제, 여행지 정보 상세보기, 여행지로 추가한 장소 지도 상 연결 및 마커 표시
3. 일정관리 일정 계획을 통해 작성된 일정 조회/삭제/수정, 일정 상세보기
4. 커뮤니티 여행소모임 게시판, 질문 게시판, 건의 게시판, 이벤트 게시판, 자유 게시판 게시판 CRUD + 댓글 및 답글 작성/삭제 , 게시글 추천 기능
5. 검색 장소 키워드 검색. 도시별 실시간 날씨 검색
6. 서비스 여행 일정 의뢰 신청, 조회, 취소
7. 예약 투어 상품 조회, 예약 신청
8. 마이페이지 개인 정보 조회, 수정, 탈퇴
9. 장바구니 장바구니에 담긴 상품 목록 조회, 상품 내역 상세보기 , 결제 진행
10. 결제 및 예약 내역 결제 및 예약한 상품 조회, 관련 내역 상세보기, 예약취소 , 결제진행

## Tech
- Java
  - 컬렉션 ArrayList, LinkedList, HashMap, Comparator 등 오버로딩, 오버라이딩

- DBMS
  - Oracle Procedure, View 등 SQL DML, DDL
  - JDBC
  - Connection, PreparedStatement, ResultSet

- HTML5, CSS, JavaScript
  - HTML, CSS, JavaScript 응용

- JSP
  - JSTL 문법, EL문법

- Servlet
  - 가상주소, Dispatcher, request, response 등

- Bootstrap5
  - layout, content, forms, icon 등

- Jquery
  - Ajax 기능 구현에 필요한 메소드 등
  - Jquery-UI
  - Calander, Draggable, Sorttable

- JSTL
  - 서블릿에서 받은 정보를 jsp에서 출력하기 위함.

- Kakao API
  - 지도API

- Javascript
  - 카카오 API 호출 후 JavaSciprt로 재가공, 데이터 정제, 데이터 계산, 데이터 출력

## Review
처음 사용해보는 JSP Servlet 기반의 Model2 웹 프로젝트 였다. 여행 일정을 만드는 웹 서비스를 진행 하였는데, 사용자의 행동에 따라 여러 서블릿과 하나의 map.jsp 페이지로 데이터를 주고 받는 방식으로 구현하였다. 사용자의 행동에 반응하기 위하여 자바스크립트를 많이 활용했다. 특히, 다음 카카오 API를 사용하여 API의 호출 결과 값을 Javascript로 재가공하고 데이터를 정제, 계산하여 사용자에게 출력하는 과정까지 디버깅을 통해서 완료할 수 있었다. 다음에서 제공하는 API가 그렇게 친절하지가 않아 손 봐야 할 곳이 많았고, 조원들이 원하는 기능을 구현하기 위해 시간을 많이 소요하였다. DAO와 DTO를 사용하여 데이터를 관리하였으며 필요한 정보는 DB에 담아 저장하였다. 기능에는 전체 일정을 선택할 수 있고 지도를 움직이면 자동으로 해당 거리에서 정확도순으로 음식점, 명소, 숙박업소등으로 분류하여 리스트에 출력하고, 출력된 리스트중 사용자가 원하는 일정을 추가 할 수 있다. 일정을 모두 추가한 후 완료 버튼을 누르면 여행관리 게시판에서 내역을 확인할 수 있고 수정하기를 통해 일정을 수정도 가능하다. 또한 커뮤니티 게시판도 만들어 사용자들이 의견을 교류할 수 있도록 하였고 게시판의 기능은 CRUD, 검색, 답글, 댓글, 추천, 검색등의 기능이 가능하다. 투어 상품을 따로 만들어 투어의 상품을 예약할 수 있고 결제와 예약이 가능하다. 또한 회원들 마이페이지를 통해 결제와 예약 목록을 조회할 수 있다. 일정 플랜을 메인으로 하고 만들어진 일정을 게시판으로 서브 업무를 구성하였다. 실제로 이러한 서비스를 구현해보니 하나의 페이지를 만드는데도 소요되는 시간과 작업량이 많다는 것을 몸소 체험 할 수 있었다. 문법이나 기술등은 크게 어렵진 않았는데 똑같지는 않지만 비슷한 코드의 반복이 계속되는 점이 아쉬웠다. 예를 들어 하나의 작업이 필요할 때 서블릿에서 req.getParameter로 값을 받아오고 처리하는 일련의 과정들이 여러 작업이 존재하였고 이를 메소드로 빼지도 못하고 수작업으로 작성해야 한다는 점이 아쉬웠다. 비효율적인 코딩을 한다는 느낌이 들었지만 현재로서는 최선의 방법이였고 값을 전달하고 전달 받는 과정이 꼭 필요했기 때문에 이 작업을 안할 수 는 없었다. 이와 같은 코드를 좀더 clean한 코드로 작성 할 수 있었으면 좋겠다는 생각이 들었다. 또한 각자 사용하는 환경이 달라서 통합을 하는데 어려움을 겪었다. 필요한 library 파일을 관리하는데도 어려움이 있었다. 일정한 환경을 구성할 수 있는 툴을 마련했으면 좋겠다는 생각도 들었다.

## implementation screen
![impl1](https://user-images.githubusercontent.com/81938175/145777073-da3bdfaa-e2c5-49a1-89dd-ca2ac35e2b2f.png)
![impl2](https://user-images.githubusercontent.com/81938175/145777085-74afbdd1-4c8a-4a19-a4ac-f0b8cba23779.png)
![impl3](https://user-images.githubusercontent.com/81938175/145777092-16c30f9f-eca1-4b87-a9bd-b303758c4dde.png)
![impl4](https://user-images.githubusercontent.com/81938175/145777095-fb2e3f99-c382-4be1-a065-587ac954d83e.png)
<img width="1169" alt="impl5" src="https://user-images.githubusercontent.com/81938175/145777102-2467b79d-15eb-4fbe-a7fa-6db173b9fd7f.png">

## Develope Enviroment
- platform
  - Windows, Mac, Chrome
- JAVA version(Language)
  - JDK 1.8
- Eclipse version(Development tool)
  - Version: 2021-06 (4.20.0) Build id: 20210612-2011
- Tool
  - Eclipse, SQL Developer, IntelliJ, SourceTree, Slack
- Language
  - JAVA, JSP, Servlet, HTML, CSS, JavaScript, PL/SQL,Oracle
