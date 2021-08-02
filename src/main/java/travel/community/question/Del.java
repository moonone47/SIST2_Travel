package travel.community.question;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/community/question/del.do")
public class Del extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		CheckMember cm = new CheckMember();
		cm.check(req,resp);
		
		String questioneq = req.getParameter("questionseq");
		
		req.setAttribute("questionseq", questioneq);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/question/del.jsp");
		dispatcher.forward(req, resp);

	}//doGet

}//class