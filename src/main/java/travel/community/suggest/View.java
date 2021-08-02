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

		HttpSession session = req.getSession();

		//1. 데이터 가져오기
		String suggestSeq = req.getParameter("suggestSeq");
		String column = req.getParameter("column");
		String search = req.getParameter("search");
		
		//2. DB작업 > DAO위임 > select where suggestSeq
		BoardDAO dao = new BoardDAO();
		
		if(session.getAttribute("read") != null && session.getAttribute("read").toString().equals("n")) {
			
			//2.3 조회수 증가하기
			dao.updateReadcount(suggestSeq);
			session.setAttribute("read", "y");
		}
		
		BoardDTO dto = dao.get(suggestSeq);
		
		String subject = dto.getSubject();
		String content = dto.getContent();
		
		//2.5 글 제목과 내용에 들어있는 <script> 태그는 비활성화
		subject = subject.replace("<script", "&lt;script").replace("</script>", "&lt;/script&gt;");
		dto.setSubject(subject);
		
		content = content.replace("<script", "&lt;script").replace("</script>", "&lt;/script&gt;");
		dto.setContent(content);
	
		//2.7 글 내용에 개행 문자 처리하기
		content = content.replace("\r\n", "<br>");
		dto.setContent(content);
		
		//2.8 내용으로 검색 중일 때 검색어 부각 시키기
		if (column != null && search != null && column.equals("content")) {
			content = content.replace(search, "<span style='color:tomato;background-color:yellow;'>" + search + "</span>");
			dto.setContent(content);
		}
		
		//2.9 현재 보고 있는 글에 달린 댓글 목록 가져오기
		ArrayList<CommentDTO> clist = dao.listComment(suggestSeq); //현재 글번호(= 댓글의 부모글번호)
		
		//3. BoardDTO 반환 > JSP 호출하기 + 전달하기
		req.setAttribute("dto", dto);
		req.setAttribute("column", column);
		req.setAttribute("search", search);
		req.setAttribute("clist", clist);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/suggest/view.jsp");
		dispatcher.forward(req, resp);
	}

}
