package travel.login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login/findpw.do")
public class FindPw extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/login/findpw.jsp");
		dispatcher.forward(req, resp);

	}//doGet

}//class
