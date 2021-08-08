package travel.community.suggest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 문지원
 * 댓글달기를 눌렀을때 호출되는 클래스
	 
	 	CheckMember cm 		로그인한 멤버인지 확인하는 변수
		String suggestseq 	getParameter로 suggestseq를 가져온다
		String content 		getParameter content를 가져온다
		BoardDAO dao 		건의 게시판 DB 작업을 위한 DAO 객체 생성
		CommentDTO dto 		댓글 정보를 저장하기 위한 DTO 객체 생성
		int result 			댓글 insert 작업 결과를 저장하는 변수
		PrintWriter writer 	result 값이 1이 아니면 alert으로 실패 창을 띄운다
 */

@WebServlet("/community/suggest/addcomment.do")
public class AddComment extends HttpServlet {

		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		  CheckMember cm = new CheckMember(); 
		  cm.check(req,resp);

		req.setCharacterEncoding("UTF-8");
		String suggestseq = req.getParameter("suggestseq"); // 보고있던 글번호 (작성중인 부모 글번호)
		String content = req.getParameter("content");

		//2.
		BoardDAO dao = new BoardDAO();

		CommentDTO dto = new CommentDTO();
		HttpSession session = req.getSession();

		dto.setId(session.getAttribute("id").toString()); // 댓글 작성자 id (로그인한 사람 세션)
		dto.setContent(content);
		dto.setSuggestSeq(suggestseq);

		int result = dao.addComment(dto);

		//3.
		if(result == 1) {
			resp.sendRedirect("/SIST2_Travel/community/suggest/view.do?suggestseq=" + suggestseq);
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