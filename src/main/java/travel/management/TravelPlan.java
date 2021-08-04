package travel.management;

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

@WebServlet("/management/travelplan.do")
public class TravelPlan extends HttpServlet {

	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 여행관리에 여행 내역 전체 조회 
		//http://localhost:8090/SIST2_Travel/management/travelplan.do 
		
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id"); 
		
		String name = req.getParameter("name");
		String daystarttravel = req.getParameter("daystarttravel");
		String dayendtravel = req.getParameter("dayendtravel");
		String cityname = req.getParameter("cityname");		
		
		ManagementDAO dao = new ManagementDAO();
		dao.del(id);// 중복 방지
		ArrayList<ManagementDTO> list = dao.getlist("3"); // 3에 id 넣자	
			
		req.setAttribute("list", list);

		
		//travelplan.jsp - SIST2_Travel/src/main/webapp/WEB-INF/views/management
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/management/travelplan.jsp");
		dispatcher.forward(req, resp);

	}//doGet

}//class









