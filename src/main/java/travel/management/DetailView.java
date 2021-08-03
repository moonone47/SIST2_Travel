package travel.management;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/management/detailview.do")
public class DetailView extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String planseq = req.getParameter("planseq");
		
		HttpSession session = req.getSession();
		
		String id = (String)session.getAttribute("id");
		
		ManagementDAO dao = new ManagementDAO();
			
		ArrayList<ManagementDTO> list = dao.getdetail(planseq, "3"); // id로 나중에 바꾸기
	
		// 끝 - 시작 = ( 날짜 + 1 )  -> 날짜 ArrayList 만들기


		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/management/detailview.jsp");
		dispatcher.forward(req, resp);

	}//doGet

}//class
