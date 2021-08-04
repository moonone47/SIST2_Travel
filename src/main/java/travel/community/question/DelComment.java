package travel.community.question;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/community/question/delcomment.do")
public class DelComment extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CheckMember cm = new CheckMember();
		cm.check(req, resp);
		// 할일
		// 1. 데이터 가져오기 (seq,pseq)
		// 2.DB작업 > DAO > delete
		// 3. 결과 처리

		String questioncommentseq = req.getParameter("questioncommentseq"); // 삭제할 댓글번호
		String questionseq = req.getParameter("questionseq");  // 보고있던 부모글 번호

		// 2.
		BoardDAO dao = new BoardDAO();

		int result = dao.delComment(questioncommentseq);

		// 3.
		if (result == 1) {
			resp.sendRedirect("/SIST2_Travel/community/question/view.do?questionseq=" + questionseq);
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
	}// doGet

}// class