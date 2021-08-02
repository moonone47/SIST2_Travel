package travel.reservation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mypage/revview.do")
public class ReservationView extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String tourseq = req.getParameter("tourseq");
		
		ReservationDAO dao = new ReservationDAO();
		
		ReservationDTO dto = dao.get(tourseq);
		
		req.setAttribute("dto", dto);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/mypage/revview.jsp");
		dispatcher.forward(req, resp);

	}

}