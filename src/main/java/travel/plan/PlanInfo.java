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




		dto.setCityseq(req.getParameter("cityseq"));
		dto.setDaystarttravel(req.getParameter("daystarttravel"));
		dto.setDayendtravel(req.getParameter("dayendtravel"));
		dto.setId("1");
		dto.setName(req.getParameter("name"));
		dto.setPlanseq(req.getParameter("planseq"));

		if(req.getParameter("willshare").equals("y")){
			dto.setWillshare(req.getParameter("willshare"));
		} else {
			dto.setWillshare("n");
		}


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