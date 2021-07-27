package travel.community.freeboard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/community/freeboard/deleteok.do")
public class DelOk extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Deleteok.java

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/freeboard/deleteok.jsp");
		dispatcher.forward(req, resp);
	}

}
