package travel.community.event;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 글 쓰기 버튼을 클릭했을때 호출되는 클래스
 */
@WebServlet("/community/event/add.do")
public class Add extends HttpServlet {

	/**
	 * 로그인한 사람인지 확인을 한 뒤에 getParameter로 reply, thread, depth를 받아와서 add.jsp에게 넘긴다.
	 * CheckMember cm	로그인 여부를 확인하는 변수
	 * String reply	답글을 달기 위한 정보 변수
	 * String thread	답글을 달기 위한 정보 변수
	 * String depth	답글을 달기 위한 정보 변수
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		todo: 로그인 구현 이후
		CheckMember cm = new CheckMember();
		cm.check(req, resp);

		String reply = req.getParameter("reply");
		String thread = req.getParameter("thread");
		String depth = req.getParameter("depth");

		req.setAttribute("reply", reply);
		req.setAttribute("thread", thread);
		req.setAttribute("depth", depth);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/event/add.jsp");
		dispatcher.forward(req, resp);

	}

}
