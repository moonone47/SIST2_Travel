package travel.mypage;

import travel.community.question.CheckMember;
import travel.reservation.ReservationDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 결제 완료를 처리하기 위한 클래스
 */
@WebServlet("/mypage/payok.do")
public class PayOk extends HttpServlet {

	/**
	 * 로그인 여부를 확인 한 뒤 dao.pay(reservationseq)를 호출하여 결제를 n 에서 y로 바꾼다. 성공하면 rev.do로, 실패하면 뒤로 이동한다.
	 * CheckMember cm	로그인 여부를 확인하기 위한 변수
	 * String reservationseq	getParameter로 reservationseq를 가져온다.
	 * ReservationDAO dao	DB 작업을 위한  DAO 객체 생성
	 * int result	결재상태를 y로 변경하고 작업 결과를 확인하는 변수
	 * PrintWriter writer	alert과 페이지 이동을 위한 변수
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
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