package travel.tour;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
/**
 * 투어 목록 조회 서블릿
 * @author 김정은
 *
 */
@WebServlet("/tour/tour.do")
public class Tour extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		TourDAO dao = new TourDAO();
		LinkedList<TourDTO> dto = new LinkedList<TourDTO>();

		dto = dao.getList();

		req.setAttribute("dto", dto);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/tour/tour.jsp");
		dispatcher.forward(req, resp);

	}

}