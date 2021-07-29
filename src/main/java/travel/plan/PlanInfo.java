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

		req.setCharacterEncoding("UTF-8");

		PlanInfoDAO dao = new PlanInfoDAO();
		PlanInfoDTO dto = new PlanInfoDTO();

		System.out.println("cs :" + req.getParameter("cityseq"));
		System.out.println(req.getParameter("daystarttravel"));
		System.out.println(req.getParameter("dayendtravel"));
		System.out.println(req.getParameter("name"));
		//System.out.println(req.getParameter("planseq"));
		System.out.println(req.getParameter("willshare"));



		dto.setCityseq(req.getParameter("cityseq")); //13번으로 고정정.됨
		dto.setDaystarttravel(req.getParameter("daystarttravel"));
		dto.setDayendtravel(req.getParameter("dayendtravel"));
		dto.setId("1");
		dto.setName(req.getParameter("name"));
		//dto.setPlanseq(req.getParameter("planseq"));

		System.out.println(req.getParameter("willshare"));
		
		
		if(req.getParameter("willshare") != null) {
			if (req.getParameter("willshare").equals("y") && req.getParameter("willshare") != null && req.getParameter("willshare") != "") {
				dto.setWillshare(req.getParameter("willshare"));
			} else {
				dto.setWillshare("n");
			}
			dto.setWillshare("n");
		}

	int result = dao.add(dto);



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