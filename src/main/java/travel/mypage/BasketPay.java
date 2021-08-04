package travel.mypage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import travel.community.question.CheckMember;

@WebServlet("/mypage/basketpay.do")
public class BasketPay extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CheckMember cm = new CheckMember();
		cm.check(req,resp);
		
		String basketseq = req.getParameter("basketseq");
		String tourseq = req.getParameter("tourseq");
		
		req.setAttribute("basketseq", basketseq);
		req.setAttribute("tourseq", tourseq);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/mypage/basketpay.jsp");
		dispatcher.forward(req, resp);

	}

}