package travel.community.clubboard;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import travel.community.question.CheckMember;

@WebServlet("/community/clubboard/commentdel.do")
public class CommentDel extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CheckMember cm = new CheckMember();
		cm.check(req, resp);
		// 할일
		// 1. 데이터 가져오기 (seq,pseq)
		// 2.DB작업 > DAO > delete
		// 3. 결과 처리

		String travelclubcommentseq = req.getParameter("travelclubcommentseq"); // 삭제할 댓글번호
		String travelclubseq = req.getParameter("travelclubseq");  // 보고있던 부모글 번호

		// 2.
		ClubBoardDAO dao = new ClubBoardDAO();

		int result = dao.delComment(travelclubcommentseq);

		// 3.
		if (result == 1) {
			resp.sendRedirect("/SIST2_Travel/community/clubboard/view.do?questionseq=" + travelclubseq);
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