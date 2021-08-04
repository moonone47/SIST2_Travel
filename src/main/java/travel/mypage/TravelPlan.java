package travel.mypage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mypage/travelplan.do")
public class TravelPlan extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		//http://localhost:8090/SIST2_Travel/mypage/travelplan.do
		
		String category = req.getParameter("category");
		
		if(category == null) {
			category = "";
		}
		
		HttpSession session = req.getSession();
		
		String id = (String)session.getAttribute("id");
		
		TravelPlanDAO dao = new TravelPlanDAO();
		
		ArrayList<TravelPlanDTO> list = dao.getlist("3" , category); // 3에 id 넣자
		
		
		for(TravelPlanDTO dto: list) {			
			
			dto.setDaystarttravel(dto.getDaystarttravel().substring(0, 11));
			dto.setDayendtravel(dto.getDayendtravel().substring(0, 11));
		
		}
		
		
		
		req.setAttribute("list", list);
		req.setAttribute("category", category);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/mypage/travelplan.jsp?category=" + category);
		dispatcher.forward(req, resp);

	}

}