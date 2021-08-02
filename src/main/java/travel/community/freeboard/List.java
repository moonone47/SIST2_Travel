package travel.community.freeboard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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

		String column = req.getParameter("column");
		String search = req.getParameter("search");
		
		// 이 변수에 아무것도 없음 -> 목록보기, 있으면 검색 결과 
		
		String isSearch = "n";
		
		//System.out.println("column: " + column);
		//System.out.println("search: " + search);
		
		if (column != null && search != null && !column.equals("") && !search.equals("")) {
			isSearch = "y";
		}
		
		HashMap<String, String> map = new HashMap<String,String>();
		map.put("column", column);
		map.put("search", search);
		map.put("isSearch", isSearch);
		
		
		
		
		
		FreeBoardDAO dao = new FreeBoardDAO();
	
		ArrayList<FreeBoardDTO> list = dao.getlist(map);
		
		
		for(FreeBoardDTO dto: list) {			
			if(dto.getSubject().length() >= 37) {
				String tempSub = dto.getSubject().substring(0, 37) + "...";
				dto.setSubject(tempSub);
			}
			String subject = dto.getSubject();
			dto.setRegdate(dto.getRegdate().substring(0, 11));
			
			if(isSearch.equals("y") && column.equals("subject")) {
				subject = subject.replace(search, "<span style='color:tomato; background-color:yellow;'>"+search+"</span>");
				dto.setSubject(subject);
			}
		}
		
		HttpSession session = req.getSession();
		session.setAttribute("read", "n");
		req.setAttribute("list", list);
		req.setAttribute("map", map);
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/freeboard/list.jsp");
		dispatcher.forward(req, resp);
	}

}
