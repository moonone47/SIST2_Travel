package travel.reservation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mypage/revcancel.do")
public class ReservationCancel extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String reservationseq = req.getParameter("reservationseq");
		
		ReservationDAO dao = new ReservationDAO();
		
		int result = dao.cancel(reservationseq);
		
		if(result == 1) {
			resp.sendRedirect("/SIST2_Travel/mypage/rev.do");
		} else {

//			resp.setCharacterEncoding("UTF-8"); 

			PrintWriter writer = resp.getWriter();
			writer.print("<html>");
			writer.print("<body>");
			writer.print("<script>");
			writer.print("alert('이미 취소됐거거나 지난 내역입니다.');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body>");
			writer.print("</html>");

			writer.close();

		}


	}

}