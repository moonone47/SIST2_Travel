package travel.plan;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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

		String startday = req.getParameter("daystarttravel");
		String endday = req.getParameter("dayendtravel");

		citydto.setCityseq(req.getParameter("cityseq")); //13번으로 고정됨.
		citydto.setDaystarttravel(req.getParameter("daystarttravel"));
		citydto.setDayendtravel(req.getParameter("dayendtravel"));
		citydto.setName(req.getParameter("name"));
		//dto.setPlanseq(req.getParameter("planseq"));


		if(req.getParameter("willshare") != null) {
			if (req.getParameter("willshare").equals("y") && req.getParameter("willshare") != null && req.getParameter("willshare") != "") {
				citydto.setWillshare(req.getParameter("willshare"));
			} else {
				citydto.setWillshare("n");
			}
		}

		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("id");
		int planseq = dao.add(citydto, userId);



		
		session.setAttribute("planseq", planseq);

		
		resp.sendRedirect("/SIST2_Travel/plan/between.do?planseq=" + planseq+"&isedit=n");

	}



	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.sendRedirect("/SIST2_Travel/plan/plan.do");
	}

}