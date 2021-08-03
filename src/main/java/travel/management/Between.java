package travel.management;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/management/between.do")
public class Between extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ArrayList<ManagementDTO> list = (ArrayList<ManagementDTO>)req.getAttribute("list");
		
		ArrayList<String> datelist = (ArrayList<String>)req.getAttribute("datelist");
		
		req.setAttribute("list", list);
		req.setAttribute("datelist", datelist);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/management/detailview.jsp");
		dispatcher.forward(req, resp);
	}

}
