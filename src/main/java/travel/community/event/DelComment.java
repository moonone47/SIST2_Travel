package travel.community.event;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 댓글 삭제 버튼을 눌렀을때 호출되는 클래스
 */
@WebServlet("/community/event/delcomment.do")
public class DelComment extends HttpServlet {
	/**
	 * 로그인 여부를 확인하고 pseq, seq를 받아와서 delComment(seq)로 댓글을 삭제하고 성공시 pseq의 글번호로 이동하고 실패시 alert창을 띄우고 뒤로 이동한다.
	 * CheckMember cm	로그인 여부를 확인하기 위한 변수
	 * String pseq	getParameter로 pseq(부모 글 번호)를 가져온다.
	 * String seq	getParameter로 seq(삭제할 댓글번호)를 가져온다.
	 * EventDAO dao	Event 테이블의 DB 작업을 위한 DAO 객체 생성
	 * int result	delete 작업 결과를 저장하는 변수
	 * PrintWriter writer	댓글 삭제 실패시 alert과 페이지 이동을 위한 변수
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
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
