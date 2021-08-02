package travel.plan;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/plan/plandel.do")
public class PlanDel extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//PlanDel.java
		String plan2seq = req.getParameter("plan2seq");




		PlaceDAO dao = new PlaceDAO();
		PlaceDTO dto = new PlaceDTO();

		int result = dao.del(plan2seq);
		
		String rdate = req.getParameter("rdate");

		ArrayList<PlaceDTO> list = dao.getList(rdate, "4"); //string

		CityDTO city = new CityDTO();

		city.setName(req.getParameter("cityname"));
		city.setCityX(req.getParameter("cityX"));
		city.setCityY(req.getParameter("cityY"));
		city.setExplain(req.getParameter("explain"));
		city.setCityseq(req.getParameter("cityseq"));

		PlanInfoDTO citydto = new PlanInfoDTO();
		citydto.setName(req.getParameter("planname"));
		citydto.setDayendtravel(req.getParameter("dayendtravel"));
		citydto.setDaystarttravel(req.getParameter("daystarttravel"));
		citydto.setWillshare(req.getParameter("willshare"));

		String[] datelists = req.getParameterValues("datelist"); //날짜 배열
		ArrayList<String> datelist = new ArrayList<String>();
		for (int i = 0; i < datelists.length; i++) {
			datelist.add(datelists[i]);
		}



		req.setAttribute("list", list); //planadd.jsp에서 일정 리스트 용
		req.setAttribute("city", city); //도시 좌표
		req.setAttribute("citydto", citydto); //일정에 채워 넣을 용
		req.setAttribute("datelist", datelist); //전체 일정 날짜
		req.setAttribute("rdate", rdate);
		
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/plan/planadd.jsp?rdate="+rdate);
		dispatcher.forward(req, resp);
	}

}
