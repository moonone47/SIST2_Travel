package travel.management;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/management/detailview.do")
public class DetailView extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String planseq = req.getParameter("planseq");
		
		ManagementDAO dao = new ManagementDAO();
		
		ArrayList<ManagementDTO> dto = dao.getlist(planseq);
		
		// planseq를 보내서 tblPlan이랑 음식점, tblPlan + 명소, tblPlan + 숙소 -> 이너조인한 vw에 where로 planseq를 넣고 DTO에 담아서 리스트로 만들어서 와 -> 날짜별로 asc
		
		req.setAttribute("dto", dto);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/management/detailview.jsp");
		dispatcher.forward(req, resp);

	}//doGet

}//class
