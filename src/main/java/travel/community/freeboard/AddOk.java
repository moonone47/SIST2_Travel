package travel.community.freeboard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 게시글 작성 데이터 처리 서블릿
 * @author 김정은
 * String subject 제목을 저장하는 변수
 * String content 내용을 저장하는 변수
 * FreeBoardDTO dto 데이터 전송에 쓰이는 dto 객체
 * FreeBoardDAO dao DB작업을 담당하는 dao 객체
 * HttpSession session 사용자 정보 저장 및 조회 용도의 session 객체
 * String id id를 저장하는 변수
 * int result 메소드 실행 결과값을 저장하는 변수


 *
 */
@WebServlet("/community/freeboard/addok.do")
public class AddOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Addok.java

		req.setCharacterEncoding("UTF-8");
		
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		String tag = req.getParameter("tag");
		
		
		FreeBoardDTO dto = new FreeBoardDTO();
		FreeBoardDAO dao = new FreeBoardDAO();
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id");
		
		dto.setSubject(subject);
		dto.setContent(content);
		dto.setId(id);

		
		int result = dao.add(dto);
		
		if(result == 1) {
			resp.sendRedirect("/SIST2_Travel/community/freeboard/list.do");
		} else {
			resp.sendRedirect("/SIST2_Travel/community/freeboard/add.do");
		}
		
	}

}
