package travel.community.freeboard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/community/freeboard/delete.do")
public class Del extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Delete.java
		
		String freeboardseq = req.getParameter("freeboardseq");
		
		FreeBoardDAO dao = new FreeBoardDAO();
		
		int result = dao.delete(freeboardseq);
		
		if(result == 1) {
			resp.sendRedirect("/SIST2_Travel/community/freeboard/list.do");
		} else {
			resp.sendRedirect("/SIST2_Travel/community/freeboard/view.do?freeboardseq=" + freeboardseq);
		}
		

	}

}
