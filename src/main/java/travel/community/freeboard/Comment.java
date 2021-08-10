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
 * 댓글 작성 데이터 처리 서블릿
 * @author 김정은
 * 
 * String freeboardseq 게시글 seq 저장하는 변수
 * 
 * String content 내용을 저장하는 변수
 * FreeBoardCommentDTO dto 데이터 전송에 쓰이는 dto 객체
 * FreeBoardCommentDAO dao DB작업을 담당하는 dao 객체
 * HttpSession session 사용자 정보 저장 및 조회 용도의 session 객체
 *  String id id를 저장하는 변수
 *  int result 메소드 실행 결과값을 저장하는 변수
 * 
 * 
 *
 */
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
