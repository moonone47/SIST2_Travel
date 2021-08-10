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
 * 회원 정보 변경 버튼을 클릭하면 호출되는 클래스
 */
@WebServlet("/mypage/editprofile.do")
public class Editprofile extends HttpServlet {
	/**
	 * 세션에서 id를 가져와 dao.get(id)를 호출하여 id의 MypageDTO의 정보를 가져와 editprofile.jsp로 넘긴다.
	 * HttpSession session	세션을 가져오기 위해 생성한다.
	 * String id	세션에서 id를 가져온다.
	 * MypageDAO dao	DB작업을 위한 DAO객체 생성
	 * MypageDTO dto	id의 select 값을 저장하기 위한 dto 객체
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		HttpSession session = req.getSession();
		String id = session.getAttribute("id").toString();

//		String id = "1";
		
		MypageDAO dao = new MypageDAO();
		MypageDTO dto = dao.get(id);
		
		req.setAttribute("dto", dto);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/mypage/editprofile.jsp");
		dispatcher.forward(req, resp);

	}

}