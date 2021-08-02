package travel.community.suggest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/community/suggest/edit.do")
public class Edit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 데이터 가져오기
		String suggestSeq = req.getParameter("suggestSeq");
		
		//2. DB작업 > DAO위임 > select where suggestSeq
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.get(suggestSeq);
		
		//3. BoardDTO 반환 > JSP호출하기 + 전달하기
		req.setAttribute("dto", dto);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/suggest/edit.jsp");
		dispatcher.forward(req, resp);
	}

}