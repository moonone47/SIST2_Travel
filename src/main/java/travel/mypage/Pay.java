package travel.mypage;

import travel.community.question.CheckMember;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 결제 버튼을 클릭했을 때 호출되는 메소드이다.
 */
@WebServlet("/mypage/pay.do")
public class Pay extends HttpServlet {
	/**
	 * 로그인 여부를 확인 한 뒤 reservationseq, tourname, tourprice를 받아 pay.jsp에 넘긴다.
	 * CheckMember cm	로그인 여부를 확인하기 위한 변수
	 * String reservationseq	getParameter로 reservationseq를 가져온다.
	 * String tourname	getParameter로 tournaem을 가져온다.
	 * String tourprice	getParameter로 tourpirce를 가져온다.
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
		String tourname = req.getParameter("tourname");
		String tourprice = req.getParameter("tourprice");
		
		req.setAttribute("reservationseq", reservationseq);
		req.setAttribute("tourname", tourname);
		req.setAttribute("tourprice", tourprice);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/mypage/pay.jsp");
		dispatcher.forward(req, resp);


	}

}