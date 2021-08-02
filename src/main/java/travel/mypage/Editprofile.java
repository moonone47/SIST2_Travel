package travel.mypage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mypage/editprofile.do")
public class Editprofile extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. 데이터 가져오기
		//2. DB작업 > DAO위임 > select where seq
		//3. BoardDAO 반환 > JSP호출하기 + 전달하기
		
		String seq = req.getParameter("id");
		
		MypageDAO dao = new MypageDAO();
		MypageDTO dto = new MypageDTO();
		
		req.setAttribute("dto", dto);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/mypage/editprofile.jsp");
		dispatcher.forward(req, resp);

	}

}