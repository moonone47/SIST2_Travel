package travel.mypage;

import travel.community.question.CheckMember;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 결제 완료를 처리하기 위한 메소드
 */
@WebServlet("/mypage/basketpayok.do")
public class BasketPayOk extends HttpServlet {

	/**
	 * 사용자 로그인 여부를 확인한 뒤 basketseq, tourseq를 가져오고 세션에서 id를 가져와 dao.insertrev(tourseq, id)로 결제상태를 y로 바꾸고 dao.del(basketseq)로 장바구니에 있는 품목을 삭제한다.
	 * CheckMember cm	사용자의 로그인 여부를 확인한다.
	 * String basketseq	getParameter로 basketseq를 저장한다.
	 * String tourseq	getParameter로 tourseq를 저장한다.
	 * Httpsession session	세션을 가져오기위해 생성한다.
	 * String id	세션에서 id를 가져온다.
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
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