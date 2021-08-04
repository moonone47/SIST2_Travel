package travel.mypage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import travel.community.question.CheckMember;
import travel.reservation.ReservationDAO;

@WebServlet("/mypage/payok.do")
public class PayOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		CheckMember cm = new CheckMember();
		cm.check(req,resp);
		
		String reservationseq = req.getParameter("reservationseq");
		
		ReservationDAO dao = new ReservationDAO();
		
		int result = dao.pay(reservationseq);
		
		if(result == 1) {
		

			resp.sendRedirect("/SIST2_Travel/mypage/rev.do");
		} else {

		resp.setCharacterEncoding("UTF-8"); 

			PrintWriter writer = resp.getWriter();
			writer.print("<html>");
			writer.print("<body>");
			writer.print("<script>");
			writer.print("alert('결제에 실패했습니다. 다시 시도해주세요.');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body>");
			writer.print("</html>");

			writer.close();

		}

	}

}