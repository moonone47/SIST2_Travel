package travel.mypage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import travel.community.question.CheckMember;

@WebServlet("/mypage/basketpayok.do")
public class BasketPayOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		CheckMember cm = new CheckMember();
		cm.check(req,resp);
		
		String basketseq = req.getParameter("basketseq");
		String tourseq = req.getParameter("tourseq");
		
		HttpSession session = req.getSession();
		
		String id = session.getAttribute("id").toString();
		
		BasketDAO dao = new BasketDAO();
		
		int result1 = dao.insertrev(tourseq,id);
		
		int result2 = dao.del(basketseq);
		
		if(result1 == 1 && result2 == 1) {
		

			resp.sendRedirect("/SIST2_Travel/mypage/basket.do");
		} else {

		resp.setCharacterEncoding("UTF-8"); 

			PrintWriter writer = resp.getWriter();
			writer.print("<html>");
			writer.print("<body>");
			writer.print("<script>");
			writer.print("alert('결제에 실패했습니다. 다시 시도해주세요.');");
			writer.print("history.back();");
			writer.print("</script>");
			writer.print("</body>");
			writer.print("</html>");

			writer.close();

		}

	}

}