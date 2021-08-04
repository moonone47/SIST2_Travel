package travel.mypage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mypage/basketdel.do")
public class Basketdel extends HttpServlet {

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
