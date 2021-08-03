package travel.management;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/management/travelplan.do")
public class TravelPlan extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 여행관리에 여행 내역 전체 조회 
		
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id");
		
		ManagementDAO dao = new ManagementDAO();
		
		ArrayList<ManagementDTO> list = dao.getlist("3"); // 3에 id 넣자	
			
							
		for(ManagementDTO dto: list) {			
			
			dto.setDaystarttravel(dto.getDaystarttravel().substring(0, 11));
			dto.setDayendtravel(dto.getDayendtravel().substring(0, 11));
		
		}
		
		req.setAttribute("list", list);


		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/management/travelplan.jsp");
		dispatcher.forward(req, resp);

	}//doGet

}//class
