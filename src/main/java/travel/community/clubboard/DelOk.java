package travel.community.clubboard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/community/clubboard/delok.do")
public class DelOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String travelclubseq = req.getParameter("travelclubseq");

		ClubBoardDAO dao = new ClubBoardDAO();

		HttpSession session = req.getSession();

		// 2.1 현재 글에 달린 댓글부터 삭제하기 ***
		dao.delAllComment(travelclubseq); // 부모 글번호 - 이 글을 부모라고 생각하는 모든 댓글 지우기

		int result = dao.del(travelclubseq);

		if (result == 1) {
			resp.sendRedirect("/SIST2_Travel/community/clubboard/list.do");
		} else {
			resp.sendRedirect("/SIST2_Travel/community/clubboard/del.do?travelclubseq=" + travelclubseq);
		}

	}// doGet

}// class