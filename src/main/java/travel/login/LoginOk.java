package travel.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 회원 로그인 성공여부 확인 클래스
 * @author 이준희
 *
 */

@WebServlet("/login/loginok.do")
public class LoginOk extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 로그인 확인 창
		String id = req.getParameter("ide");
		String pw = req.getParameter("pw");
		String auto = req.getParameter("autoId");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO();
		
		dto.setId(id);
		dto.setPw(pw);
		
		MemberDTO result = dao.login(dto);
		
		if(result != null) {
			HttpSession session = req.getSession();
			
			session.setAttribute("id", result.getId());
			session.setAttribute("name", result.getName());
			session.setAttribute("lv", result.getLv());
		} else {
			
		}
		
		req.setAttribute("result", result);
		req.setAttribute("auto", auto);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/login/loginok.jsp");
		dispatcher.forward(req, resp);
	}
}
