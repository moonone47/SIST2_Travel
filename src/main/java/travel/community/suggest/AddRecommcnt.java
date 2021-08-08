package travel.community.suggest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 문지원
 * 추천을 눌렀을때 호출되는 클래스
 * 
	String suggestseq 	getParameter로 suggestseq를 가져온다
	BoardDAO dao 		Suggest 테이블의 DB작업을 위한 DAO 객체
	int result 			추천 insert 작업 결과를 저장하는 변수
	PrintWriter writer 	result가 1이 아니면 alert이 뜨고 직전 페이지로 보낸다.
 */
@WebServlet("/community/suggest/addrecommcnt.do")
public class AddRecommcnt extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String suggestseq = req.getParameter("suggestseq");
		
		BoardDAO dao = new BoardDAO();
		int result = dao.updateRecommcnt(suggestseq);

		if(result == 1) {
			resp.sendRedirect("/SIST2_Travel/community/suggest/view.do?suggestseq=" + suggestseq);
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
