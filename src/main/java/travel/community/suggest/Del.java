package travel.community.suggest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author 문지원
 * 삭제하기 버튼을 누르면 실행되는 클래스

	CheckMember cm		로그인 여부를 확인하기 위한 변수
	String suggestseq	getParameter로 suggestseq를 가져온다
 */
@WebServlet("/community/suggest/del.do")
public class Del extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		  CheckMember cm = new CheckMember(); 
		  cm.check(req,resp);
		
		String suggestseq = req.getParameter("suggestseq");
		
		req.setAttribute("suggestseq", suggestseq);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/suggest/del.jsp");
		dispatcher.forward(req, resp);
	}

}
