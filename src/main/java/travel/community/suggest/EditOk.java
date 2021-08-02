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
		
		//1. 데이터 가져오기
		String suggestSeq = req.getParameter("suggestSeq");
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		
		//2. DB작업 > DAO에게 위임 > update
		BoardDTO dto = new BoardDTO();
		BoardDAO dao = new BoardDAO();
		
		HttpSession session = req.getSession();
		
		dto.setSuggestSeq(suggestSeq);
		dto.setSubject(subject);
		dto.setContent(content);
		
		int result = dao.edit(dto);
		
		//3. 결과처리
		if (result == 1) {
			resp.sendRedirect("/SIST2_Travel/community/suggest/view.do?suggestSeq=" + suggestSeq);
		} else {
			resp.sendRedirect("/SIST2_Travel/community/suggest/edit.do?suggestSeq=" + suggestSeq);
		}


	}

}