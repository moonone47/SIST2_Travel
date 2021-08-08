package travel.community.suggest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author 문지원
 * 수정하기를 눌렀을 때 실행되는 클래스

	String suggestseq	getParameter로 suggestseq를 가져온다.
	BoardDAO dao		suggest 테이블의 DB작업을 위한 DAO 객체
	BoardDTO dto		suggest 테이블의 DB작업 결과를 저장하기 위한 DTO 객체

 */
@WebServlet("/community/suggest/edit.do")
public class Edit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String suggestseq = req.getParameter("suggestseq");

		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.get(suggestseq); 

		req.setAttribute("dto", dto);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/suggest/edit.jsp");
		dispatcher.forward(req, resp);
	}

}