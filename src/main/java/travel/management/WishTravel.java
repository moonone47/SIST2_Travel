package travel.management;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/management/wishtravel.do")
public class WishTravel extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		WishDAO dao = new WishDAO();
		


		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/management/wishtravel.jsp");
		dispatcher.forward(req, resp);

	}//doGet

}//class
