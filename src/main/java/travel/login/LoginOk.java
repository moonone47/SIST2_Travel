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
 * @author 문지원
 * 로그인 실행을 처리하는 클래스

	String id	getParameter로 id를 가져온다
	String pw	getParameter로 pw를 가져온다
	String auto	getParameter로 autoId를 가져온다
	MemberDAO dao	DB작업을 위한 DAO 객체
	MemberDTO dto	DB 결과를 저장하기 위한 DTO 객체
	MemberDTO result	DB에서 회원정보를 받아온다.

 */

@WebServlet("/login/loginok.do")
public class LoginOk extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 로그인 확인 창
		String id = req.getParameter("id");
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
