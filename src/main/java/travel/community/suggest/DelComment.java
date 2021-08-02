package travel.community.suggest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/community/suggest/delcomment.do")
public class DelComment extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. 데이터 가져오기
		String suggestSeq = req.getParameter("suggestSeq"); //보고있던 부모글의 번호
		String suggestCommentSeq = req.getParameter("suggestCommentSeq"); //삭제할 댓글 번호

		//2. 
		BoardDAO dao = new BoardDAO();
		
		int result = dao.delComment(suggestCommentSeq);//1, 0		
		
		//3.
		if (result == 1) {
			resp.sendRedirect("/SIST2_Travel/community/suggest/view.do?suggestSeq" + suggestSeq); //보고 있던 글번호를 가지고 돌아가기
		} else {
			
			req.setCharacterEncoding("UTF-8");
			
			PrintWriter writer = resp.getWriter();			
			
			writer.print("<html>");
			writer.print("<body>");
			writer.print("<script>");
			writer.print("alert('delete fail');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body>");
			writer.print("</html>");
			
			writer.close();
		}

		
	}

}