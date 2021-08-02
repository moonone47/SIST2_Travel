package travel.community.event;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/community/event/delcomment.do")
public class DelComment extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		CheckMember cm = new CheckMember();
		cm.check(req, resp);

		//할일
		//1. 데이터 가져오기(seq, pseq)
		//2. DB 작업 > DAO 위임 > delete
		//3. 결과 처리

		//1.
		String pseq = req.getParameter("pseq"); //보고있던 부모글번호
		String seq = req.getParameter("seq"); //삭제할 댓글번호

		//2.
		EventDAO dao = new EventDAO();

		int result = dao.delComment(seq);//1, 0

		//3.
		if (result == 1) {
			resp.sendRedirect("/SIST2_Travel/community/event/view.do?seq=" + pseq); //보고 있던 글번호를 가지고 돌아가기
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
