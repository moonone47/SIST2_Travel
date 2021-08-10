package travel.community.freeboard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 게시글 작성 jsp 호출하는 서블릿
 * @author 김정은
 *RequestDispatcher dispatcher  데이터를 forward 하기 위한 dispatcher 변수


 */
@WebServlet("/community/freeboard/add.do")
public class Add extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Add.java

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/freeboard/add.jsp");
		dispatcher.forward(req, resp);
	}

}
