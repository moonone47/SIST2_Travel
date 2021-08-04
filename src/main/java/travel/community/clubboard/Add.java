package travel.community.clubboard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import travel.community.question.CheckMember;

@WebServlet("/community/clubboard/add.do")
public class Add extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		CheckMember cm = new CheckMember();
		cm.check(req,resp);
		
		String reply = req.getParameter("reply"); // 0 - 새글 , 1 - 답변 
		String thread = req.getParameter("thread");  
		String depth = req.getParameter("depth");  
		
		req.setAttribute("reply", reply);
		req.setAttribute("thread", thread);
		req.setAttribute("depth", depth);
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/clubboard/add.jsp");
		dispatcher.forward(req, resp);

	}//doGet

}//class
