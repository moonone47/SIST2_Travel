package travel.community.suggest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/community/suggest/addcomment.do")
public class AddComment extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		
		//1. 데이터 가져오기
		String suggestSeq = req.getParameter("suggestSeq"); //보고있던 글번호(= 작성 중인 댓글의 부모 글번호)
		String content = req.getParameter("content");
		
		//2.
		BoardDAO dao = new BoardDAO();
		CommentDTO dto = new CommentDTO();
		
		HttpSession session = req.getSession();
		
		//dto.setId(session.getAttribute("id").toString()); //댓글 작성자 아이디(= 로그인한 사람 세션)
		dto.setId("2");
		dto.setSuggestSeq(suggestSeq);
		dto.setContent(content);
		
		int result = dao.addComment(dto);//1, 0		
		
		//3.
		if (result == 1) {
			resp.sendRedirect("/SIST2_Travel/community/suggest/view.do?suggestSeq=" + suggestSeq); 
			//보고 있던 글번호를 가지고 돌아가기
		} else {
			
			PrintWriter writer = resp.getWriter();		
			resp.setCharacterEncoding("UTF-8");
			
			writer.print("<html>");
			writer.print("<body>");
			writer.print("<script>");
			writer.print("alert('댓글 쓰기 실패');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body>");
			writer.print("</html>");
			
			writer.close();
		}
		
	}

}