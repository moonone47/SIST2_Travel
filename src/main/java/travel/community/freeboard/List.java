package travel.community.freeboard;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/community/freeboard/list.do")
public class List extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//List.java

		FreeBoardDAO dao = new FreeBoardDAO();
		
		ArrayList<FreeBoardDTO> list = dao.getlist();
		
		
		for(FreeBoardDTO dto: list) {			
			if(dto.getSubject().length() >= 37) {
				String tempSub = dto.getSubject().substring(0, 37) + "...";
				dto.setSubject(tempSub);
			}
			
			dto.setRegdate(dto.getRegdate().substring(0, 11));;
		}
		
		HttpSession session = req.getSession();
		session.setAttribute("read", "n");
		
		req.setAttribute("list", list);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/freeboard/list.jsp");
		dispatcher.forward(req, resp);
	}

}
