package travel.community.suggest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/community/suggest/edit.do")
public class Edit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		  CheckMember cm = new CheckMember(); 
		  cm.check(req,resp);
		
		String suggestseq = req.getParameter("suggestseq");

		//2.
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.get(suggestseq); 

		//3.
		req.setAttribute("dto", dto);


		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/suggest/edit.jsp");
		dispatcher.forward(req, resp);
	}

}