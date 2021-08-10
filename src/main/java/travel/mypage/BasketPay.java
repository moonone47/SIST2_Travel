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
 * 장바구니에서 결제하기 버튼을 클릭하면 호출되는 클래스
 */
@WebServlet("/mypage/basketpay.do")
public class BasketPay extends HttpServlet {
	/**
	 * 사용자 로그인 여부를 확인 한 후, basketseq, tourseq, tourname, tourprice를 basketpay.jsp로 넘긴다.
	 * CheckMember cm	사용자의 로그인 여부를 확인한다.
	 * String basketseq	getParameter로 basketseq를 저장한다.
	 * String tourseq	getParameter로 tourseq를 저장한다.
	 * String tourname	getParameter로 tourname을 저장한다.
	 * String tourprice	getParameter로 tourprice를 저장한다.
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CheckMember cm = new CheckMember();
		cm.check(req,resp);
		
		String basketseq = req.getParameter("basketseq");
		String tourseq = req.getParameter("tourseq");
		String tourname = req.getParameter("tourname");
		String tourprice = req.getParameter("tourprice");
		
		req.setAttribute("basketseq", basketseq);
		req.setAttribute("tourseq", tourseq);
		req.setAttribute("tourprice", tourprice);
		req.setAttribute("tourname", tourname);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/mypage/basketpay.jsp");
		dispatcher.forward(req, resp);

	}

}