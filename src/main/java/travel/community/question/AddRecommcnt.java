package travel.community.question;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/community/question/addrecommcnt.do")
public class AddRecommcnt extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String questionseq = req.getParameter("questionseq");
		
		BoardDAO dao = new BoardDAO();
		int result = dao.updateRecommcnt(questionseq);

		if(result == 1) {
			resp.sendRedirect("/SIST2_Travel/community/question/view.do?questionseq=" + questionseq);
		} else {

			resp.setCharacterEncoding("UTF-8"); 

			PrintWriter writer = resp.getWriter();
			writer.print("<html>");
			writer.print("<body>");
			writer.print("<script>");
			writer.print("alert('추천 실패');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body>");
			writer.print("</html>");

			writer.close();

		}

	}

}