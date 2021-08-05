package travel.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mypage/travelplandel.do")
public class TravelPlanDel extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String planseq = req.getParameter("planseq");
		String category = req.getParameter("category");
		
		TravelPlanDAO dao = new TravelPlanDAO();
		
		int result = dao.del(planseq);
		
		
		resp.sendRedirect("/SIST2_Travel//mypage/travelplan.do?category=" + category);
		

	}

}
