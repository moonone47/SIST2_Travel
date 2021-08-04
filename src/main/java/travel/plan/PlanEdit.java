package travel.plan;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/planedit.do")
public class PlanEdit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//PlanEdit.java

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/planedit.jsp");
		dispatcher.forward(req, resp);
	}

}
