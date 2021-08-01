package travel.plan;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/plan/planscd.do")
public class planscd extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		/*
             <input type="hidden"  name="city" value="${city}">

            <input type="hidden" name="cityname" value="${city.name}">
            <input type="hidden" name="cityX" value="${city.cityX}">
            <input type="hidden" name="cityY" value="${city.cityY}">
            <input type="hidden" name="Explain" value="${city.explain}">
            <input type="hidden" name="Cityseq" value="${city.cityseq}">



            <input type="hidden" name="planname" value="${citydto.name}">
            <input type="hidden" name="dayendtravel" value="${citydto.dayendtravel}">
            <input type="hidden" name="daystarttravel" value="${citydto.daystarttravel}">
            <input type="hidden" name="willshare" value="${citydto.willshare}">

			<input type="hidden" name="rdate" value="${list}">

            <c:forEach items="${datelist}" var="list">
            <input type="hidden" name="datelist" value="${list}">
            </c:forEach>
        */

		//1. 데이터 받아오기
		CityDTO city = new CityDTO();

		city.setName(req.getParameter("cityname"));
		city.setCityX(req.getParameter("cityX"));
		city.setCityY(req.getParameter("cityY"));
		city.setExplain(req.getParameter("Explain"));
		city.setCityseq(req.getParameter("Cityseq"));

		PlanInfoDTO citydto = new PlanInfoDTO();
		citydto.setName(req.getParameter("planname"));
		citydto.setDayendtravel(req.getParameter("dayendtravel"));
		citydto.setDaystarttravel(req.getParameter("daystarttravel"));
		citydto.setWillshare(req.getParameter("willshare"));

		String[] datelists = req.getParameterValues("datelist"); //날짜 배열
		ArrayList<String> datelist = new ArrayList<String>();
		for (int i = 0; i < datelists.length; i++) {
			datelist.add(datelists[i]);
			//System.out.println(datelists[i]);
		}


		String rdate = req.getParameter("rdate");
//		System.out.println("-----------");
//		System.out.println(rdate);
//		System.out.println("-----------");
		//2.tblPlan2 -> rdate select해오기
		//
		PlaceDAO dao = new PlaceDAO();

		//todo: 로그인 구현 되면 id ->session에서 가져오기

		ArrayList<PlaceDTO> list = dao.getList(rdate, "4"); //string

		req.setAttribute("list", list); //planadd.jsp에서 일정 리스트 용
		req.setAttribute("city", city); //도시 좌표
		req.setAttribute("citydto", citydto); //일정에 채워 넣을 용
		req.setAttribute("datelist", datelist); //전체 일정 날짜
		req.setAttribute("rdate", rdate); // 선택한 날짜

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/plan/planadd.jsp?rdate="+rdate);
		dispatcher.forward(req, resp);

	}

}






