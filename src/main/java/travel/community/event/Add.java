package travel.community.event;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/community/event/add.do")
public class Add extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ChceckMember cm = new Checkmember();
		cm.check(req, resp);

		String reply = req.getParameter("reply");
		String thread = req.getParameter("thread");
		String depth = req.getParameter("depth");

		req.setAttribute("reply", reply);
		req.setAttribute("thread", thread);
		req.setAttribute("depth", depth);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/event/add.jsp");
		dispatcher.forward(req, resp);

	}

}
