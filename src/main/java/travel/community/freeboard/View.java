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
 *String freeboardseq 게시글 seq를 저장하는 변수
String column 검색 대상 저장 변수
String search 검색어 저장 변수
FreeBoardDAO dao 게시글 DB작업을 담당하는 dao 객체
FreeBoardDTO dto 게시글 데이터 전송에 쓰이는 dto 객체
HttpSession session 사용자 정보 저장 및 조회 용도의 session 객체 
String subject 제목을 저장하는 변수
String content 내용을 저장하는 변수
FreeBoardCommentDAO cdao 댓글 DB작업을 담당하는 dao 객체
FreeBoardCommentDTO cdto 댓글 데이터 전송에 쓰이는 dto 객체
ArrayList<FreeBoardCommentDTO> clist dao.getlist() 메소드의 반환값을 담을 객체.  댓글 정보를 갖고있다.
RequestDispatcher dispatcher 데이터를 forward 하기 위한 dispatcher 변수


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
