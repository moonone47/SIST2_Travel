package travel.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import travel.reservation.ReservationDAO;

@WebServlet("/service/servicecancel.do")
public class ServiceCancel extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String serviceseq = req.getParameter("serviceseq");
		
		ServiceDAO dao = new ServiceDAO();
		
		dao.delAllComment(serviceseq);
		
		int result = dao.cancel(serviceseq);
		
		if(result == 1) {
			resp.sendRedirect("/SIST2_Travel/service/list.do");
		} else {

			resp.setCharacterEncoding("UTF-8"); 

			PrintWriter writer = resp.getWriter();
			writer.print("<html>");
			writer.print("<body>");
			writer.print("<script>");
			writer.print("alert('의뢰 취소에 실패했습니다.');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body>");
			writer.print("</html>");

			writer.close();

		}

	}//doGet

}//class
