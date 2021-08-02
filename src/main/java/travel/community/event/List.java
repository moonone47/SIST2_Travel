package travel.community.event;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/community/event/list.do")
public class List extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String column = req.getParameter("column");
		String search = req.getParameter("search");
		String isSearch = "n";

		if(column != null && search != null && !column.equals("") && !search.equals("")){
			isSearch = "y";
		}

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("column", column);
		map.put("search", search);
		map.put("isSearch", isSearch);

		int nowPage=0;
		int totalCount=0;
		int pageSize=10;
		int totalPage=0;
		int begin=0;
		int end=0;
		int n=0;
		int loop = 0;
		int blockSize = 10;

		String page = req.getParameter("page");

		if(page == null || page.equals("")){
			nowPage = 1;
		} else{
			nowPage = Integer.parseInt(page);
		}

		begin = ((nowPage - 1) * pageSize) +1;
		end = begin + pageSize - 1;

		map.put("begin", begin + "");
		map.put("end", end+ "");

		EventDAO dao = new EventDAO();

		totalCount = dao.getTotalCount(map);
		totalPage = (int)Math.ceil((double)totalCount / pageSize);

		String pagebar = "<nav>\r\n"
				+ "			<ul class=\"pagination\">";

		loop = 1;
		n = ((nowPage -1) / blockSize) * blockSize + 1;

		if(n==1){
			pagebar += String.format(" <li class='disabled'><a href='#!' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li> ");
		} else{
			pagebar += String.format(" <li><a href='/SIST2_Travel/community/list.do?page=%d' " +
					"aria-label='Previous'><span " +
					"aria-hidden='true'>&laquo;</span></a></li> ", n-1);
		}

		if(totalPage == 0){
			pagebar += " <li class='active'><a href='#!'>1</a></li> ";
		}

		while(!(loop > blockSize || n >  totalPage)){

			if(n == nowPage){
				pagebar += String.format(" <li calss='active'><a href='#!'>%d</a></li>", n);
			} else{
				pagebar += String.format(" <li><a href='/SIST2_Travel/community/list.do?page=%d'>%d</a></li> ", n, n);
			}

			loop++;
			n++;
		}

		if(n > totalPage){
			pagebar += String.format(" <li class='disabled'><a href='#!' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li> ");
		}else{
			pagebar += String.format(" <li><a href='/SIST2_Travel/community/list.do?page=%d' aria-label='Next'><span " +
					"aria-hidden='true'>&raquo;</span></a></li> ", n);
		}

		pagebar += "</ul>\r\n"
				+ "		</nav>";
		ArrayList<EventDTO> list = dao.list(map);

		for(EventDTO dto : list){
			String regdate = dto.getRegdate();
			regdate = regdate.substring(0, 10);
			dto.setRegdate(regdate);

			String subject = dto.getSubject();

			subject = subject.replace("<script", "&lt;script").replace("</script>", "&lt;/script&gt;");
			dto.setSubject(subject);

			if(subject.length() > 38) {
				subject = subject.substring(0, 38) + "..";
				dto.setSubject(subject);
			}

			if(isSearch.equals("y") && column.equals("subject")){
				subject = subject.replace(search, "span style='color:tomato;background-color:yellow;'>" + search +
						"</span>");
				dto.setSubject(subject);
			}
		}

		HttpSession session = req.getSession();
		session.setAttribute("read", "n");

		req.setAttribute("list", list);
		req.setAttribute("map", map);
		req.setAttribute("totalCount", totalCount);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("nowPage", nowPage);
		req.setAttribute("pagebar", pagebar);


		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/event/list.jsp");
		dispatcher.forward(req, resp);

	}

}
