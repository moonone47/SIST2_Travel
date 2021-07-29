package travel.plan;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/plan/planinfo.do")
public class PlanInfo extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		PlanInfoDAO dao = new PlanInfoDAO();
		PlanInfoDTO citydto = new PlanInfoDTO();

		System.out.println("cs :" + req.getParameter("cityseq"));
		System.out.println(req.getParameter("daystarttravel"));
		System.out.println(req.getParameter("dayendtravel"));
		System.out.println(req.getParameter("name"));
		//System.out.println(req.getParameter("planseq"));
		System.out.println(req.getParameter("willshare"));



		citydto.setCityseq(req.getParameter("cityseq")); //13번으로 고정정.됨
		citydto.setDaystarttravel(req.getParameter("daystarttravel"));
		citydto.setDayendtravel(req.getParameter("dayendtravel"));
		citydto.setId("1");
		citydto.setName(req.getParameter("name"));
		//dto.setPlanseq(req.getParameter("planseq"));

		System.out.println(req.getParameter("willshare"));

		System.out.println(req.getParameter("citys"));


			if(req.getParameter("willshare") != null) {
				if (req.getParameter("willshare").equals("y") && req.getParameter("willshare") != null && req.getParameter("willshare") != "") {
					citydto.setWillshare(req.getParameter("willshare"));
				} else {
					citydto.setWillshare("n");
				}
				citydto.setWillshare("n");
			}
//			[travel.plan.CityDTO@45c06dde, travel.plan.CityDTO@3415498e, travel.plan.CityDTO@38a5a859,
//			travel.plan.CityDTO@1c65f3ea, travel.plan.CityDTO@5a8dd325, travel.plan.CityDTO@44caa8c3, travel.plan.CityDTO@51383763, travel.plan.CityDTO@6271740d, travel.plan.CityDTO@56d1979d, travel.plan.CityDTO@47ccb134, travel.plan.CityDTO@575f1581, travel.plan.CityDTO@3e67d27b, travel.plan.CityDTO@6450d755, travel.plan.CityDTO@46379ffa, travel.plan.CityDTO@696b69a0, travel.plan.CityDTO@691f9afc]

		int planseq = dao.add(citydto);


		HttpSession session = req.getSession();
		
		session.setAttribute("planseq", planseq);

		//todo : daystrattravel , dayendtravel -> 날짜 계산


		//분류별로 저장

//		req.setAttribute("dto",dto);

		CityDAO cdao = new CityDAO();

		CityDTO city = cdao.getCity(citydto.getCityseq());

		req.setAttribute("city",city); //도시 좌표
		req.setAttribute("citydto",citydto); //일정에 채워 넣을 용

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