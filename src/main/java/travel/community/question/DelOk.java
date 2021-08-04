package travel.community.question;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/community/question/delok.do")
public class DelOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String questionseq = req.getParameter("questionseq");

		BoardDAO dao = new BoardDAO();

		HttpSession session = req.getSession();

		// 2.1 현재 글에 달린 댓글부터 삭제하기 ***
		dao.delAllComment(questionseq); // 부모 글번호 - 이 글을 부모라고 생각하는 모든 댓글 지우기

		int result = dao.del(questionseq);

		if (result == 1) {
			resp.sendRedirect("/SIST2_Travel/community/question/list.do");
		} else {
			resp.sendRedirect("/SIST2_Travel/community/question/del.do?questionseq=" + questionseq);
		}

	}// doGet

}// class