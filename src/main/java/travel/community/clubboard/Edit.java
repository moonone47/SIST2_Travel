package travel.community.clubboard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import travel.community.question.CheckMember;

@WebServlet("/community/clubboard/edit.do")
public class Edit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CheckMember cm = new CheckMember();
		cm.check(req,resp);
		
		String travelclubseq = req.getParameter("travelclubseq");

		//2.
		ClubBoardDAO dao = new ClubBoardDAO();
		ClubBoardDTO dto = dao.get(travelclubseq); // 이미 view 때문에 만들었엇음 - 재사용가능 

		//3.
		req.setAttribute("dto", dto);


		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/clubboard/edit.jsp");
		dispatcher.forward(req, resp);

	}//doGet

}//class