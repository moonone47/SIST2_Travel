package travel.community.question;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 게시글 수정 확인 서블릿 
 * @author 이준희
 *
 */
@WebServlet("/community/question/editok.do")
public class EditOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		String questionseq = req.getParameter("questionseq");
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = new BoardDTO();
		HttpSession session = req.getSession();
		
		dto.setQuestionseq(questionseq);
		dto.setSubject(subject);
		dto.setContent(content);
		
		int result = dao.edit(dto);

		if(result ==1 ) {
			resp.sendRedirect("/SIST2_Travel/community/question/view.do?questionseq=" + questionseq);
		} else {
			resp.sendRedirect("/SIST2_Travel/community/question/edit.do?questionseq=" + questionseq);
		}

	

	}//doGet

}//class