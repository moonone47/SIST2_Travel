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
