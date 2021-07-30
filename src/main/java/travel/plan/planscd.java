package travel.plan;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/plan/planscd.do")
public class planscd extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String city = req.getParameter("city");
		String cityname = req.getParameter("cityname");

		System.out.println(city);
		System.out.println(cityname);
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/plan/planscd.jsp");
		dispatcher.forward(req, resp);

	}

}