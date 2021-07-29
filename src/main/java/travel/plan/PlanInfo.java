package travel.plan;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/plan/planinfo.do")
public class PlanInfo extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		    <form method="POST" action="/SIST2_Travel/plan/planinfo.do">
//    <a href="#" class="list-group-item list-group-item-action active py-3 lh-tight" aria-current="true">
//        <div class="w-100 align-items-center justify-content-between">
//            <strong class="mb-1">전체 일정</strong>
//<%--            <div>시작날짜 <span>Date: <input type="text" class="datepicker" id="datepicker_start" name="datepicker_start"></span> </div><br>--%>
//<%--            <div>종료날짜:<span>Date: <input type="text" class="datepicker" id="datepicker_end" name="datepicker_end"></span> </div>
//				--%>
//            <label for="from">From</label>
//            <input type="text" id="from" name="from">
//            <label for="to">to</label>
//            <input type="text" id="to" name="to">
//
//        </div>
//        <div class="w-100 align-items-center justify-content-between">
//            <h2>제목</h2>
//            <fieldset>
//                <select style="width:200px;" name="city">
//                    <c:forEach items='${citys}' var="citys">
//                    <option value="${citys.cityseq}">${citys.name}</option>
//                    </c:forEach>
//                </select>
//            </fieldset>
//<%--
//				plan.java -> planadd.jsp 에서 DB에있는 City정보를 planadd.jsp에게 전달
//		여기와서 일정 정보를 planinfo.java에게 전달 planinfo.java에서 도시 좌표, 일 수 계산값을 planadd.jsp에게 전달
//		--%>
//        </div>
//
//        <div class="col-10 mb-1 small">공유여부:
//            <input type="checkbox" checked data-toggle="toggle" data-size="xs">
//        </div>
//        <input type="submit" value="일정 설정 완료">
//    </a>
//    </form>

//		create table TBLPLAN
//				(
//						PLANSEQ        NUMBER           not null
//		primary key,
//		STATUS         VARCHAR2(50)     not null
//		check (status in ('0', '1')),
//				NAME           VARCHAR2(200)    not null,
//				DAYSTARTTRAVEL DATE             not null,
//				DAYENDTRAVEL   DATE             not null,
//				WILLSHARE      VARCHAR2(20)     not null
//		check (willShare in ('y', 'n')),
//				WISH           NUMBER default 0 not null,
//				THEME          VARCHAR2(200),
//				ID             VARCHAR2(50)     not null
//		references TBLMEMBER,
//		CITYSEQ        NUMBER
//		references TBLCITY
//)
		PlanInfoDAO dao = new PlanInfoDAO();
		PlanInfoDTO dto = new PlanInfoDTO();

//		java.sql.SQLDataException: ORA-01830: date format picture ends before converting entire input string
//
//		at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:440)
//		at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:396)
//		at oracle.jdbc.driver.T4C8Oall.processError(T4C8Oall.java:837)
//		at oracle.jdbc.driver.T4CTTIfun.receive(T4CTTIfun.java:445)
//		at oracle.jdbc.driver.T4CTTIfun.doRPC(T4CTTIfun.java:191)
//		at oracle.jdbc.driver.T4C8Oall.doOALL(T4C8Oall.java:523)
//		at oracle.jdbc.driver.T4CPreparedStatement.doOall8(T4CPreparedStatement.java:207)
//		at oracle.jdbc.driver.T4CPreparedStatement.executeForRows(T4CPreparedStatement.java:1010)
//		at oracle.jdbc.driver.OracleStatement.doExecuteWithTimeout(OracleStatement.java:1315)
//		at oracle.jdbc.driver.OraclePreparedStatement.executeInternal(OraclePreparedStatement.java:3576)
//		at oracle.jdbc.driver.OraclePreparedStatement.executeUpdate(OraclePreparedStatement.java:3657)
//		at oracle.jdbc.driver.OraclePreparedStatementWrapper.executeUpdate(OraclePreparedStatementWrapper.java:1350)
//		at travel.plan.PlanInfoDAO.add(PlanInfoDAO.java:65)
//		at travel.plan.PlanInfo.doPost(PlanInfo.java:95)


		System.out.println(req.getParameter("cityseq"));
		System.out.println(req.getParameter("daystarttravel"));
		System.out.println(req.getParameter("dayendtravel"));
		System.out.println(req.getParameter("name"));
		//System.out.println(req.getParameter("planseq"));
		System.out.println(req.getParameter("willshare"));

		1
		2021-08-18
		2021-08-26
		title
		y
		y
		PlanInfoDTO.add
		java.sql.SQLSyntaxErrorException: ORA-01722: invalid number

		dto.setCityseq(req.getParameter("cityseq"));
		dto.setDaystarttravel(req.getParameter("daystarttravel"));
		dto.setDayendtravel(req.getParameter("dayendtravel"));
		dto.setId("1");
		dto.setName(req.getParameter("name"));
		//dto.setPlanseq(req.getParameter("planseq"));

		System.out.println(req.getParameter("willshare"));
		if(req.getParameter("willshare").equals("y") && req.getParameter("willshare") !=null){
			dto.setWillshare(req.getParameter("willshare"));
		} else {
			dto.setWillshare("n");
		}

		int result = dao.add(dto);

//		java.lang.NullPointerException: Cannot invoke "String.equals(Object)" because the return value of "javax.servlet.http.HttpServletRequest.getParameter(String)" is null
//		travel.plan.PlanInfo.doPost(PlanInfo.java:84)
//		javax.servlet.http.HttpServlet.service(HttpServlet.java:652)
//		javax.servlet.http.HttpServlet.service(HttpServlet.java:733)
//		org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
//		비고 근본 원인(root cause)의 풀 스택 트레이스를, 서버 로그들에서 확인할 수 있습니다.


		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/plan/planadd.jsp");
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);


		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/plan/planadd.jsp");
		dispatcher.forward(req, resp);
	}

}