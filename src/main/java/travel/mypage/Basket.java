package travel.mypage;

import travel.community.question.CheckMember;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 장바구니를 클릭하면 호출되는 메소드
 */
@WebServlet("/mypage/basket.do")
public class Basket extends HttpServlet {
	/**
	 * 로그인 여부를 확인하고 dao.list(id)를 호출하여 list에 DTO객체를 담아 list를  basket.jsp로 넘긴다.
	 *CheckMember cm	로그인한 멤버인지 확인하는 변수
	 * BasketDAO dao	DB작업을 위한 DAO
	 * ArrayList<BasketDTO> list	DTO객체를 담기위한 ArrayList 변수
	 * String id	아이디를 저장하기위한 변수
	 * String validate	유효기간을 확인하기 위한 변수
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CheckMember cm = new CheckMember();
		cm.check(req,resp);
		
		HttpSession session = req.getSession();
		BasketDAO dao = new BasketDAO();
		
		String id = session.getAttribute("id").toString();
		
		ArrayList<BasketDTO> list = dao.list(id);
		
		for (BasketDTO dto : list) {
			String validdate = dto.getValiddate();
			validdate = validdate.substring(0, 10);
			dto.setValiddate(validdate);
		
		}
		
		
		
		req.setAttribute("list", list);
		
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/mypage/basket.jsp");
		dispatcher.forward(req, resp);

	}

}