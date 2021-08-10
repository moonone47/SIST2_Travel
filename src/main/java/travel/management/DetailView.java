package travel.management;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 상세 보기를 누르면 호출되는 클래스
 */
@WebServlet("/management/detailview.do")
public class DetailView extends HttpServlet {
	/**
	 * planseq와 id를 받아와 dao.getdetail(planseq, id)를 호출하여 명소, 음식점, 숙박 테이블에서 조건에 해당하는 결과를 select하여 ManagementDTO에 담고 list.add로 저장한 뒤 ArrayList<ManagementDTO>로 반환한다.
	 * String planseq	getParameter로 planseq를 가져온다.
	 * HttpSession session	id를 받기 위한 세션 변수
	 * String id	id를 저장하는 변수
	 * ManagementDAO dao	Management DB작업을 위한 DAO 객체
	 * ArrayList<ManagementDTO> list	planseq와 id를 사용하여 명소, 음식점, 숙박 테이블에서 select한 결과를 ManagementDTO에 담고, list.add로 저장한 뒤 ArrayList<ManagementDTO>형으로 반환
	 *
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String planseq = req.getParameter("planseq");
		
		//System.out.println(planseq);
		HttpSession session = req.getSession();
		
		String id = (String)session.getAttribute("id");
		
		ManagementDAO dao = new ManagementDAO();			
			
		ArrayList<ManagementDTO> list = dao.getdetail(planseq, id); // id로 나중에 바꾸기
	

		
		resp.sendRedirect("/SIST2_Travel/management/between.do?planseq="+planseq);
	}//doGet

}//class
