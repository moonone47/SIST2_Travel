package travel.community.suggest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/community/suggest/view.do")
public class View extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		//1. 데이터 가져오기
		String suggestSeq = req.getParameter("suggestSeq");
		
		//2. DB작업 > DAO위임 > select where suggestSeq
		BoardDAO dao = new BoardDAO();
		
		if(session.getAttribute("read") != null && session.getAttribute("read").toString().equals("n")) {
			//2.3 조회수 증가하기
			dao.updateReadcount(suggestSeq);
			
			session.setAttribute("read", "y");
		}
		
		BoardDTO dto = dao.get(suggestSeq);
		
			

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/suggest/view.jsp");
		dispatcher.forward(req, resp);
	}

}
