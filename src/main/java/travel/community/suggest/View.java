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

/**
 * @author 문지원
 * 게시글 내용을 보여주는 클래스

	String suggestseq	getParameter로 suggestseq를 가져온다
	HttpSession session	티켓을 가져오기 위한 session 변수
	BoardDTO dto	suggest 테이블의 DB 작업을 위한 DAO 객체
	String subject	제목에 태그 사용을 replace 하여 XXS 공격을 방지한다. 
	String content	내용에 태그 사용을 replace 하여 XXS 공격을 방지한다. 
	ArrayList<CommentDTO> clist	현재 글 번호에 해당하는 모든 댓글을 저장하기 위한 변수

 */

@WebServlet("/community/suggest/view.do")
public class View extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
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
