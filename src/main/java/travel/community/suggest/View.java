package travel.community.suggest;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/community/suggest/view.do")
public class View extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/*
		 * CheckMember cm = new CheckMember(); cm.check(req,resp);
		 */
		
		String suggestseq = req.getParameter("suggestseq");
		
		BoardDAO dao = new BoardDAO();
		
		HttpSession session = req.getSession(); 
		
		if(session.getAttribute("read") != null && session.getAttribute("read").toString().equals("n")){

			// 조회수 증가하기 (내가 읽은것도 포함 )
			dao.updateReadCount(suggestseq);

			session.setAttribute("read", "y");
		}		
		
		BoardDTO dto = dao.get(suggestseq);
		
		String subject = dto.getSubject();
		String content = dto.getContent();

		subject = subject.replace("<script>", "&lt;script").replace("</script>", "%lt;/script&gt;");
		dto.setSubject(subject);

		content = content.replace("<script>", "&lt;script").replace("</script>", "%lt;/script&gt;");
		dto.setContent(content);
		
		ArrayList<CommentDTO> clist = dao.listcomment(suggestseq);

		
		content = content.replace("\r", "<br>");
		dto.setContent(content);		
		
		req.setAttribute("dto", dto);
		req.setAttribute("clist", clist);
		
		
				

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/suggest/view.jsp");
		dispatcher.forward(req, resp);

	}

}
