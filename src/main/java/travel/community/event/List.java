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

/**
 * 모든 글 목록을 가져오는 클래스
 */
@WebServlet("/community/event/list.do")
public class List extends HttpServlet {
	/**
	 * column과 search, isSearch를 가져와 map에 담고 페이징에 필요한 변수를 선언후 pagebar를 생성한다. 페이징 작업 이후 dao.list(map)을 호출하여 모든 목록을 가져온 뒤
	 * <script, <를 replace하고 \r\n을 <br>로 바꾸는 작업과 search중일때 style을 추가하여 검색어를 부각시키는 작업을 진행한다.
	 * String column	getParameter로 column을 가져온다.
	 * String search	getParameter로 search를 가져온다.
	 * String isSearch	검색중인지 확인하기 위한 변수
	 * HashMap<String, String> map	column, search, isSearch를 저장하기 위한 컬렉션
	 * int nowPage	페이징 처리를 위한 현재 페이지 번호
	 * int totalCount	페이징 처리를 위한 총 게시물 수
	 * int pageSize	페이징 처리를 위한 한 페이지당 출력할 게시물 수
	 * int totalPage	페이징 처리를 위한 총 페이지 수
	 * int begin	페이징 처리를 위한 가져올 게시물 시작 위치
	 * int end	페이징 처리를 위한 가져올 게시물 끝 위치
	 * int n	페이지바 제작을 위한 변수
	 * int loop	페이지바 제작을 위한 변수
	 * int blockSize	페이지바 제작을 위한 변수
	 * String page	getParamter로 현재 page를 가져온다.
	 * EventDAO dao	Event 테이블의 DB 작업을 위한 DAO 객체
	 * String pagebar	pagebar를 만들기 위한 변수
	 * ArrayList<EventDTO> list	map의 조건에 해당하는 게시물들을 받는 변수
	 * HttpSession session	새로고침에 의한 조회수 증가를 방지하기 위해 read라는 티켓을 설정하는 변수
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
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
