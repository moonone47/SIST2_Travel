package travel.mypage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 여행계획 삭제를 클릭하면 호출되는 클래스
 */
@WebServlet("/mypage/travelplandel.do")
public class TravelPlanDel extends HttpServlet {
	/**
	 * planseq와 category를 가져와 dao.del(planseq)로 일정을 삭제후 travelplan.do?category=catetory로 이동한다.
	 * String planseq	getParameter로 planseq를 가져온다.
	 * String category	getParameter로 category를 가져온다.
	 * TravelPlanDAO dao	DB작업을 위한 DAO 객체 생성
	 * int result	delete 작업 결과를 반환 받는 변수
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String planseq = req.getParameter("planseq");
		String category = req.getParameter("category");
		
		TravelPlanDAO dao = new TravelPlanDAO();
		
		int result = dao.del(planseq);
		
		
		resp.sendRedirect("/SIST2_Travel//mypage/travelplan.do?category=" + category);
		

	}

}
