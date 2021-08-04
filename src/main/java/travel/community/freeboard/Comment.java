package travel.community.freeboard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/community/freeboard/comment.do")
public class Comment extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Comment.java
		
		req.setCharacterEncoding("UTF-8");
		
		String freeboardseq = req.getParameter("freeboardseq");
		String content = req.getParameter("content");
		
		FreeBoardCommentDTO dto = new FreeBoardCommentDTO();
		FreeBoardCommentDAO dao = new FreeBoardCommentDAO();
		
		HttpSession session = req.getSession();
		
		String id = (String)session.getAttribute("id");
		
		dto.setFreeboardseq(freeboardseq);
		dto.setContent(content);
		dto.setId(id);
		
		int result = dao.add(dto);
		
		resp.sendRedirect("/SIST2_Travel/community/freeboard/view.do?freeboardseq=" + freeboardseq);

	}

}
