package travel.community.suggest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/community/suggest/delok.do")
public class DelOk extends HttpServlet {

	@Override
	protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 데이터 가져오기
		String suggestSeq = req.getParameter("suggestSeq");
		
		//2. DB작업 > DAO위임 > delete where suggestSeq
		BoardDAO dao = new BoardDAO();
		
		HttpSession session = req.getSession();
		
		int result = dao.del(suggestSeq);
		
		//3. 결과처리
		if (result == 1 ) {
			resp.sendRedirect("/SIST2_Travel/community/suggest/list.do");
		} else {
			resp.sendRedirect("/SIST2_Travel/community/suggest/view.do?suggestSeq=" + suggestSeq);
		}
		
	}

}