package travel.community.event;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 글 삭제 버튼을 눌렀을때 호출되는 클래스
 */
@WebServlet("/community/event/del.do")
public class Del extends HttpServlet {
	/**
	 * 로그인 여부를 확인하고 seq를 받아와서 del.jsp에게 전달한다.
	 * CheckMember cm	로그인 여부를 확인하기 위한 변수
	 * String seq	getParameter로 seq를 가져온다.
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		CheckMember cm = new CheckMember();
		cm.check(req, resp);

		//할일
		//1. 데이터 가져오기(seq)
		//2. JSP 호출하기 + 글번호 전달하기

		//1.
		String seq = req.getParameter("seq");

		//2.
		req.setAttribute("seq", seq);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/event/del.jsp");
		dispatcher.forward(req, resp);
	}

}
