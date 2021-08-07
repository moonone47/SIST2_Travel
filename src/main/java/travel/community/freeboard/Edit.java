package travel.community.freeboard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 게시글 수정 jsp 호출 서블릿
 * @author 김정은
 *
 */
@WebServlet("/community/freeboard/edit.do")
public class Edit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Edit.java
		
		String freeboardseq = req.getParameter("freeboardseq");
		
		FreeBoardDAO dao = new FreeBoardDAO();
		FreeBoardDTO dto = new FreeBoardDTO();
		
		dto = dao.getlist(freeboardseq);
		
		req.setAttribute("dto", dto);

		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/freeboard/edit.jsp");
		dispatcher.forward(req, resp);
	}

}
