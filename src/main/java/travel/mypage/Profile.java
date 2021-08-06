package travel.mypage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 프로필을 클릭했을때 호출되는 클래스이다.
 */
@WebServlet("/mypage/profile.do")
public class Profile extends HttpServlet {
	/**
	 * id를 받아와 dao.get(id)로 회원 정보를 받아와 profile.jsp에 넘긴다.
	 * HttpSession session	세션 정보를 얻기위한 변수
	 * String id	세션에 저장된 id를 저장하기 위한 변수
	 * MyPageDAO dao	DB 작업을 위한 DAO 객체
	 * MyPageDTO dto	DB결과를 저장하기 위한 DTO 객체
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		
//		String id = "1";
		String id = session.getAttribute("id").toString();
		MypageDAO dao = new MypageDAO();
		MypageDTO dto = dao.get(id);
		
		req.setAttribute("dto", dto);		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/mypage/profile.jsp");
		dispatcher.forward(req, resp);

	}

}
