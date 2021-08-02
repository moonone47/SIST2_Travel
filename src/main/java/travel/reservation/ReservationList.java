package travel.reservation;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import travel.community.question.CheckMember;

@WebServlet("/mypage/rev.do")
public class ReservationList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CheckMember cm = new CheckMember();
		cm.check(req,resp);
		HttpSession session = req.getSession();
		ReservationDAO dao = new ReservationDAO();
		ReservationDTO dto = new ReservationDTO();
		
		String id = session.getAttribute("id").toString();
		
		ArrayList<ReservationDTO> list = dao.list(id);
		req.setAttribute("list", list);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/mypage/rev.jsp");
		dispatcher.forward(req, resp);

	}

}
