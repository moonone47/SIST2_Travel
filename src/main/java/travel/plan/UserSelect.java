package travel.plan;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/userselect.do")
public class UserSelect extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//UserSelect

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/userselect.jsp");
		dispatcher.forward(req, resp);
	}

}
