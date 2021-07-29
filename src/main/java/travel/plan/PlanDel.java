package travel.plan;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/plan/plandel.do")
public class PlanDel extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//PlanDel.java
		String plan2seq = req.getParameter("plan2seq");




		PlaceDAO dao = new PlaceDAO();
		PlaceDTO dto = new PlaceDTO();

		int result = dao.del(plan2seq);

		ArrayList<PlaceDTO> list = dao.getList(4);
		if(result == 0){
			System.out.println("삭제 안됨.");
		} else {
			req.setAttribute("list", list);
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/plan/planadd.jsp");
		dispatcher.forward(req, resp);
	}

}
