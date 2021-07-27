package travel.community.clubboard;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/community/clubboard/del.do")
public class Del extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Delete.java

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/clubboard/del.jsp");
		dispatcher.forward(req, resp);
	}

}
