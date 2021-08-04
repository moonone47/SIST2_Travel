package travel.community.suggest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/community/suggest/editok.do")
public class EditOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		String suggestseq = req.getParameter("suggestseq");
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = new BoardDTO();
		HttpSession session = req.getSession();
		
		dto.setSuggestseq(suggestseq);
		dto.setSubject(subject);
		dto.setContent(content);
		
		int result = dao.edit(dto);

		if(result ==1 ) {
			resp.sendRedirect("/SIST2_Travel/community/suggest/view.do?suggestseq=" + suggestseq);
		} else {
			resp.sendRedirect("/SIST2_Travel/community/suggest/edit.do?suggestseq=" + suggestseq);
		}


	}

}