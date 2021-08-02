package travel.community.question;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/community/question/addcomment.do")
public class AddComment extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CheckMember cm = new CheckMember();
		cm.check(req,resp);

		String questionseq = req.getParameter("questionseq"); // 보고있던 글번호 (작성중인 부모 글번호)
		String content = req.getParameter("content");

		//2.
		BoardDAO dao = new BoardDAO();

		CommentDTO dto = new CommentDTO();
		HttpSession session = req.getSession();

		dto.setId(session.getAttribute("id").toString()); // 댓글 작성자 id (로그인한 사람 세션)
		dto.setContent(content);
		dto.setQuestionseq(questionseq);

		int result = dao.addComment(dto);

		//3.
		if(result == 1) {
			resp.sendRedirect("/SIST2_Travel/community/question/view.do?questionseq=" + questionseq);
		} else {

			resp.setCharacterEncoding("UTF-8"); 

			PrintWriter writer = resp.getWriter();
			writer.print("<html>");
			writer.print("<body>");
			writer.print("<script>");
			writer.print("alert('댓글쓰기 실패');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body>");
			writer.print("</html>");

			writer.close();

		}

	}//doGet

}//class