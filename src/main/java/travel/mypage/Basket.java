package travel.mypage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import travel.community.clubboard.ClubBoardDAO;
import travel.community.clubboard.ClubBoardDTO;
import travel.community.question.CheckMember;
import travel.reservation.ReservationDAO;
import travel.reservation.ReservationDTO;

@WebServlet("/mypage/basket.do")
public class Basket extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CheckMember cm = new CheckMember();
		cm.check(req,resp);
		
		HttpSession session = req.getSession();
		BasketDAO dao = new BasketDAO();
		
		String id = session.getAttribute("id").toString();
		
		ArrayList<BasketDTO> list = dao.list(id);
		
		for (BasketDTO dto : list) {
			String validdate = dto.getValiddate();
			validdate = validdate.substring(0, 10);
			dto.setValiddate(validdate);
		
		}
		
		
		
		req.setAttribute("list", list);
		
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/mypage/basket.jsp");
		dispatcher.forward(req, resp);

	}

}