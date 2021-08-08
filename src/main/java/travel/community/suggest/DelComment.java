package travel.community.suggest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author 문지원
 * 댓글 삭제를 누르면 실행되는 클래스

	CheckMember cm 				로그인 여부를 확인하기 위한 변수
	String suggestcommentseq	getParameter로 suggestcommentseq를 가져온다
	String suggestseq			getParameter로 suggestseq를 가져온다
	BoardDAO dao				suggest테이블의 DB 작업을 위한 DAO 객체 생성
	int result					delete 작업 결과를 저장하는 변수
	PrintWriter writer			result가 1이 아니면 alert창을 띄우고 직전 페이지로 보낸다 

 */
@WebServlet("/community/suggest/delcomment.do")
public class DelComment extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		  CheckMember cm = new CheckMember(); 
		  cm.check(req,resp);

		String suggestcommentseq = req.getParameter("suggestcommentseq"); // 삭제할 댓글번호
		String suggestseq = req.getParameter("suggestseq");  // 보고있던 부모글 번호

		// 2.
		BoardDAO dao = new BoardDAO();

		int result = dao.delComment(suggestcommentseq);

		// 3.
		if (result == 1) {
			resp.sendRedirect("/SIST2_Travel/community/suggest/view.do?suggestseq=" + suggestseq);
		} else {
			resp.setCharacterEncoding("UTF-8");

			PrintWriter writer = resp.getWriter();
			writer.print("<html>");
			writer.print("<body>");
			writer.print("<script>");
			writer.print("alert('댓글 삭제 실패');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body>");
			writer.print("</html>");

			writer.close();
		}

		
	}

}