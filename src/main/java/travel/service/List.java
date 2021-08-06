package travel.service;

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

/**
 * 여행 의뢰 목록 서블릿 
 * @author 이준희
 *
 */
@WebServlet("/service/list.do")
public class List extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CheckMember cm = new CheckMember();
		cm.check(req,resp);
		
		ServiceDAO dao = new ServiceDAO();
		
		HttpSession session = req.getSession();
		String id = session.getAttribute("id").toString();
		
		ArrayList<ServiceDTO> list = dao.list(id);
		
		for(ServiceDTO dto : list) {
			//날짜 > 가공 
			String startdate = dto.getDaystarttravel();
			startdate = startdate.substring(0,10); //10자까지 자르기 
			dto.setDaystarttravel(startdate); // 자른값 다시 담기 

			String enddate = dto.getDayendtravel();
			enddate = enddate.substring(0,10); //10자까지 자르기 
			dto.setDayendtravel(enddate); // 자른값 다시 담기 
		}
		
		req.setAttribute("list", list);
		
		
		
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/service/list.jsp");
		dispatcher.forward(req, resp);

	}//doGet

}//class
