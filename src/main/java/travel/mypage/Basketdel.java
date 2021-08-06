package travel.mypage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 장바구니 품목 삭제버튼을 클릭하면 호출되는 클래스
 */
@WebServlet("/mypage/basketdel.do")
public class Basketdel extends HttpServlet {
	/**
	 * basketseq를 받아 dao.del(basketseq)를 호출하여 해당 품목을 삭제한다. 성공시 장바구니 페이지로, 실패시 뒤로 간다.
	 * String basketseq	getParameter로 basketseq를 가져온다.
	 * BasketDAO dao	DB작업을 위한 DAO 객체 생성
	 * int result	DAO에서 삭제 작업의 결과값을 저장
	 * PrintWriter writer	사용자에게 alert을 출력하고, 페이지를 이동하기 위한 변수
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String basketseq = req.getParameter("basketseq");

		BasketDAO dao = new BasketDAO();

		int result = dao.del(basketseq);

		if (result == 1) {
			resp.sendRedirect("/SIST2_Travel/mypage/basket.do");
		} else {

			resp.setCharacterEncoding("UTF-8");

			PrintWriter writer = resp.getWriter();
			writer.print("<html>");
			writer.print("<body>");
			writer.print("<script>");
			writer.print("alert('삭제에 실패했습니다. 다시 시도해주세요.');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body>");
			writer.print("</html>");

			writer.close();

		}
	}
}
