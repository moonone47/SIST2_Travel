package travel.community.freeboard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 댓글 삭제 서블릿
 * @author 김정은
 * String freecommentseq 댓글 seq 저장하는 변수
 * String freeboardseq 게시글 seq 저장하는 변수
 * FreeBoardCommentDAO dao DB작업을 담당하는 dao 객체


 */
@WebServlet("/community/freeboard/commentdel.do")
public class CommentDel extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/freeboard/commentdel.jsp");
		dispatcher.forward(req, resp);
	}

}
