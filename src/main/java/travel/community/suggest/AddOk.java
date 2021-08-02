package travel.community.suggest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/community/suggest/addok.do")
public class AddOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		/*
		SUBJECT	VARCHAR2(200 BYTE)
		CONTENT	VARCHAR2(4000 BYTE)
		*/
		
		//1. 데이터 가져오기
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		
		//2. DB작업 > DAO위임 > insert
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = new BoardDTO();
		
		//HttpSession session = req.getSession();

		dto.setSubject(subject);
		dto.setContent(content);
		dto.setId("1");
		
		int result = dao.add(dto);
				
		//3. 결과 > 후처리
		if (result == 1) {
			resp.sendRedirect("/SIST2_Travel/community/suggest/list.do");
		} else {
			resp.sendRedirect("/SIST2_Travel/community/suggest/add.do");
		}
		
	}

}