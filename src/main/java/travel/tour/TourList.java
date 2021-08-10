package travel.tour;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 투어 예약 리스트 조회 서블릿
 * @author 김정은
 *
 */
@WebServlet("/reservation/tourlist.do")
public class TourList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/reservation/tourlist.jsp");
		dispatcher.forward(req, resp);

	}

}