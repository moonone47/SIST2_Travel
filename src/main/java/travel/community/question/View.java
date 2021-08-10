package travel.community.question;

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
 * 게시글 상세보기 서블릿 
 * @author 이준희
 *
 */
@WebServlet("/community/question/view.do")
public class View extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		CheckMember cm = new CheckMember();
		cm.check(req,resp);
		
		String questionseq = req.getParameter("questionseq");
		
		BoardDAO dao = new BoardDAO();
		
		HttpSession session = req.getSession(); 
		
		if(session.getAttribute("read") != null && session.getAttribute("read").toString().equals("n")){

			// 조회수 증가하기 (내가 읽은것도 포함 )
			dao.updateReadCount(questionseq);

			session.setAttribute("read", "y");
		}		
		
		BoardDTO dto = dao.get(questionseq);
		
		String subject = dto.getSubject();
		String content = dto.getContent();

		subject = subject.replace("<script>", "&lt;script").replace("</script>", "%lt;/script&gt;");
		dto.setSubject(subject);

		content = content.replace("<script>", "&lt;script").replace("</script>", "%lt;/script&gt;");
		dto.setContent(content);
		
		ArrayList<CommentDTO> clist = dao.listcomment(questionseq);

		
		content = content.replace("\r", "<br>");
		dto.setContent(content);		
		
		req.setAttribute("dto", dto);
		req.setAttribute("clist", clist);
		
		
				

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/question/view.jsp");
		dispatcher.forward(req, resp);

	}//doGet

}//class