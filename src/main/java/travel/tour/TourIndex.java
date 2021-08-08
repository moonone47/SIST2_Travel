package travel.tour;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 투어 예약 페이지 호출 서블릿
 * @author 김정은
 *
 */
@WebServlet("/reservation/tourindex.do")
public class TourIndex extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/reservation/tourindex.jsp");
		dispatcher.forward(req, resp);

	}

}