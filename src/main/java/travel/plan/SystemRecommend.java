package travel.plan;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/systemrecommend.do")
public class SystemRecommend extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//SystemRecommend.java

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/systemrecommend.jsp");
		dispatcher.forward(req, resp);
	}

}
