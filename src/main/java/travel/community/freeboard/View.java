package travel.community.freeboard;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 게시글 조회 서블릿
 * @author 김정은
 *
 */
@WebServlet("/community/freeboard/view.do")
public class View extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//View.java
		
		String freeboardseq = req.getParameter("freeboardseq");
		

		String column = req.getParameter("column");
		String search = req.getParameter("search");
				
		FreeBoardDAO dao = new FreeBoardDAO();
		FreeBoardDTO dto = new FreeBoardDTO();
		
		HttpSession session = req.getSession();
		
		if(session.getAttribute("read") == null || session.getAttribute("read").equals("n")) {
			
			dao.updateViewcnt(freeboardseq);
			
			session.setAttribute("read", "y");
		}

				
		dto = dao.getlist(freeboardseq);
		
		String subject = dto.getSubject();
		String content = dto.getContent();
		
		subject = subject.replace("<script", "&lt;script").replace("</script>", "&lt;/script&gt;");
		dto.setSubject(subject);
		
		content = content.replace("<script", "&lt;script").replace("</script>", "&lt;/script&gt;");
		content = content.replace("\r\n", "<br>");
		content.replace("<", "&lt;").replace(">", "&gt;");
		dto.setContent(content);
		
		FreeBoardCommentDAO cdao = new FreeBoardCommentDAO();
		FreeBoardCommentDTO cdto = new FreeBoardCommentDTO();
		
		ArrayList<FreeBoardCommentDTO> clist = cdao.getlist(freeboardseq);
		

		
		req.setAttribute("dto", dto);
		req.setAttribute("clist", clist);
		req.setAttribute("column", column);
		req.setAttribute("search", search);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/freeboard/view.jsp?freeboardseq=" + freeboardseq);
		dispatcher.forward(req, resp);
	}

}
