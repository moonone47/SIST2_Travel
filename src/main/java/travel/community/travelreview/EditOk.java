package travel.community.travelreview;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/community/travelreview/editok.do")
public class EditOk extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//EditOk

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/travelreview/editok.jsp");
		dispatcher.forward(req, resp);
	}

}
