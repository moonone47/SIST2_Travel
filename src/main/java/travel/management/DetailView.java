package travel.management;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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
		
		System.out.println(planseq);
		HttpSession session = req.getSession();
		
		String id = (String)session.getAttribute("id");
		
		ManagementDAO dao = new ManagementDAO();			
			
		ArrayList<ManagementDTO> list = dao.getdetail(planseq, "3"); // id로 나중에 바꾸기
	

		
		resp.sendRedirect("/SIST2_Travel/management/between.do?planseq="+planseq);
	}//doGet

}//class
