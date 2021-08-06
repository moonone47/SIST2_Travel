package travel.community.event;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 글 수정 버튼을 눌렀을때 호출되는 메소드
 */
@WebServlet("/community/event/edit.do")
public class Edit extends HttpServlet {
	/**
	 * seq를 받아 dao.get(seq)를 호출하여 받은 dto를 edit.jsp에 전달한다.
	 * String seq	getParameter로 seq를 가져온다.
	 * EventDAO dao	Event 테이블의 DB 작업을 위한 DAO 객체
	 * EventDTO dto	Event 테이블의 DB 작업 결과를 저장하기 위한 DTO 객체
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String seq = req.getParameter("seq");

		//2.
		EventDAO dao = new EventDAO();

		EventDTO dto = dao.get(seq);


		//3.
		req.setAttribute("dto", dto);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/event/edit.jsp");
		dispatcher.forward(req, resp);


	}

}