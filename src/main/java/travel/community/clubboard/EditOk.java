package travel.community.clubboard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/community/clubboard/editok.do")
public class EditOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		String travelclubseq = req.getParameter("travelclubseq");
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		
		ClubBoardDAO dao = new ClubBoardDAO();
		ClubBoardDTO dto = new ClubBoardDTO();
		HttpSession session = req.getSession();
		
		dto.setSeq(travelclubseq);
		dto.setSubject(subject);
		dto.setContent(content);
		
		int result = dao.edit(dto);

		if(result ==1 ) {
			resp.sendRedirect("/SIST2_Travel/community/clubboard/view.do?travelclubseq=" + travelclubseq);
		} else {
			resp.sendRedirect("/SIST2_Travel/community/clubboard/edit.do?travelclubseq=" + travelclubseq);
		}

	

	}//doGet

}//class