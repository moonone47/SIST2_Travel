package travel.management;

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
 * 여행 계획을 클릭했을 때 호출되는 클래스
 */
@WebServlet("/management/travelplan.do")
public class TravelPlan extends HttpServlet {

	/**
	 * 세션에서 id를 받아와 중복 방지를 위해 tblPlan2에서 id에 해당하는컬럼을 삭제 후 dao.getlist(id)로 명소, 식당, 숙박 테이블에서 데이터를 list로 받아 온 뒤 dto 정보를 후처리 한 뒤  travlplan.jsp로 전달한다.
	 * HttpSession session	id를 받아오기 위 한 세션 변수
	 * String id	id를 저장하는 변수
	 * ManagementDAO dao	DB작업을 위한 DAO 객체 생성
	 * ArrayList<ManagementDTO> list	DB의 select 결과를 담아 DTO 에 저장하는 컬렉션
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 여행관리에 여행 내역 전체 조회 
		//http://localhost:8090/SIST2_Travel/management/travelplan.do 
		
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id"); 
		

		
		ManagementDAO dao = new ManagementDAO();
		dao.del(id);// 중복 방지
		ArrayList<ManagementDTO> list = dao.getlist(id); // 3에 id 넣자	
			
		for(ManagementDTO dto : list) {
			dto.setDayendtravel(dto.getDayendtravel().substring(0,10));
			dto.setDaystarttravel(dto.getDaystarttravel().substring(0,10));
		}
		
		
		
		
		req.setAttribute("list", list);

		
		//travelplan.jsp - SIST2_Travel/src/main/webapp/WEB-INF/views/management
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/management/travelplan.jsp");
		dispatcher.forward(req, resp);

	}//doGet

}//class









