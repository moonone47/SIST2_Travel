package travel.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import travel.community.question.CheckMember;

/**
 * 여행 의뢰 확인 서블릿 
 * @author 이준희
 *
 */
@WebServlet("/service/applyok.do")
public class ApplyOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CheckMember cm = new CheckMember();
		cm.check(req, resp);
		
		String travelspot = req.getParameter("travelspot");
		String daystarttravel = req.getParameter("daystarttravel");
		String dayendtravel = req.getParameter("dayendtravel");
		String purpose = req.getParameter("purpose");
		String numberpeople = req.getParameter("numberpeople");
		
		
		ServiceDAO dao = new ServiceDAO();
		ServiceDTO dto = new ServiceDTO();
		HttpSession session = req.getSession();
		
		dto.setTravelspot(travelspot);
		dto.setDaystarttravel(daystarttravel);
		dto.setDayendtravel(dayendtravel);
		dto.setPurpose(purpose);
		dto.setNumberpeople(numberpeople);
		dto.setId(session.getAttribute("id").toString());
		
		int result = dao.add(dto);
		
		if (result == 1) {

			System.out.println("의뢰 신청 성공 ");
			resp.sendRedirect("/SIST2_Travel/service/list.do");
		} else {
			resp.sendRedirect("/SIST2_Travel/service/apply.do");

		}

	}

}