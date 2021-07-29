package travel.plan;

import travel.community.question.BoardDAO;
import travel.community.question.BoardDTO;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/plan/plan.do")
public class Plan extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		CityDAO dao = new CityDAO();
		CityDTO dto = new CityDTO();

		ArrayList<CityDTO> citys = dao.list();

		req.setAttribute("citys",citys);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/plan/planadd.jsp");
		dispatcher.forward(req, resp);
	}

}
