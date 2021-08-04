package travel.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 회원 로그아웃 클래스
 * @author 이준희
 *
 */

@WebServlet("/login/logout.do")
public class Logout extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		HttpSession session = req.getSession();
		
		session.removeAttribute("id");
		session.removeAttribute("name");
		session.removeAttribute("lv");
		
		resp.sendRedirect("/SIST2_Travel/index.do");
	}//doGet

}//class
