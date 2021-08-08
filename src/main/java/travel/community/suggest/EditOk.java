package travel.community.suggest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * @author 문지원
 * 글 수정을 작업하는 클래스

	String suggestseq	getParameter로 suggestseq를 가져온다
	String subject		getParameter로 subject를 가져온다
	String content		getParameter로 content를 가져온다
	BoardDAO dao		suggest 게시판의 DB 작업을 위한 DAO 객체
	BoardDTO dto		suggest 게시판의 DB 작업 결과를 저장하기 위한 DTO 객체
	int result			update 작업 결과를 저장하는 변수
 */

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