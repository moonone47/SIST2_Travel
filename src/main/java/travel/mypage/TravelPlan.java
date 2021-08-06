package travel.mypage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 여행일정을 클릭했을때 호출되는 클래스
 */
@WebServlet("/mypage/travelplan.do")
public class TravelPlan extends HttpServlet {
	/**
	 * category와 id를 가져온 후 dao.getlist(id, category)로 여행 일정을 모두 가져와 ArrayList<TravelPlanDTO>에 저장하여  list와 category를 travelplan.jsp에 넘긴다.
	 * String category	getParameter로 category를 가져온다.
	 * HttpSession session	세션정보를 얻기 위한 변수
	 * String id	세션에 저장된 id를 저장하는 변수
	 * TravelPlanDAO dao	DB작업을 위한 DAO 객체 생성
	 * ArrayList<TravelPlanDTO> list	id에 해당하는 category를 전부 받아 저장하는 변수
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String category = req.getParameter("category");
		
		if(category == null) {
			category = "";
		}
		
		HttpSession session = req.getSession();
		
		String id = (String)session.getAttribute("id");
		
		TravelPlanDAO dao = new TravelPlanDAO();
		
		ArrayList<TravelPlanDTO> list = dao.getlist(id , category); // 3에 id 넣자
		
		
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