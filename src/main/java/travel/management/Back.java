package travel.management;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 삭제하기를 눌렀을때 호출되는 클래스
 */
@WebServlet("/management/back.do")
public class Back extends HttpServlet {
	/**
	 * 세션에서 id를 가져와, dao.del(id)를 호출하여 tblPlan2의 id로 where조건을 걸어 delete 작업을 수행한다.
	 * HttpSession session	세션에서 아이디를 호출하기 위한 변수
	 * String id	아이디를 저장하는 변수
	 * ManageMentDAO dao	삭제 작업을 위한 DAO 객체
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		String id = (String)session.getAttribute("id");
		
		ManagementDAO dao = new ManagementDAO();
		
		dao.del(id);

		resp.sendRedirect("/SIST2_Travel/management/travelplan.do");
	}

}