package travel.community.suggest;

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

/**
 * @author 문지원
 * 게시글 목록을 보여주는 클래스

	String column	getParameter로 column을 가져온다
	String search	getParameter로 search를 가져온다
	String isSearch	검색중인지 확인하기 위한 변수
	HashMap<String, String> map	column, search, isSearch를 저장하기 위한 컬렉션
	int nowPage	페이징 처리를 위한 현재 페이지 번호
	int totalCount	페이징 처리를 위한 총 게시물 수
	int pageSize	페이징 처리를 위한 한 페이지당 출력할 게시물 수
	int begin	페이징 처리를 위한 가져올 게시물 시작 위치
	int end	페이징 처리를 위한 가져올 게시물 끝 위치
	int n	페이지바 제작을 위한 변수
	int loop	페이지바 제작을 위한 변수
	int blockSize	페이지바 제작을 위한 변수
	String page	getParameter로 현재 페이지를 가져온다
	BoardDAO dao	suggest 테이블의 DB작업을 위한 DAO 객체
	String pagebar	pagebar를 만들기 위한 변수
	ArrayList<BoardDTO> list	map의 조건에 해당하는 게시물들을 받는 변수
	HttpSession session	새로고침에 의한 조회수 증가를 방지하기 위해 read라는 티켓을 설정하는 변수

 */
@WebServlet("/community/suggest/list.do")
public class List extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPostGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPostGet(req, resp);

	}

	private void doPostGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
	
		String column = req.getParameter("column");
		String search = req.getParameter("search");
	
		
		String isSearch = "n";

		if(column != null && search != null && !column.equals("") && !search.equals("")) {
			isSearch = "y";
		}

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("column", column);
		map.put("search", search);
		map.put("isSearch", isSearch);

		// 페이징 처리
		// -> 보고 싶은 페이지를 정하기 위한 처리
		int nowPage = 0; // 현재 페이지 번호
		int totalCount = 0; // 총 게시물
		int pageSize = 10; // 한 페이지당 출력할 게시물수
		int totalPage = 0; // 총 페이지수
		int begin = 0; // 가져올 게시물 시작 위치
		int end = 0; // 가져올 게시물 끝 위치
		int n = 0; // 페이지바 제작
		int loop = 0; // 페이지바 제작
		int blockSize = 10; // 페이지바 제작

		String page = req.getParameter("page");

		if (page == null || page.equals("")) {
			nowPage = 1;
		} else {
			nowPage = Integer.parseInt(page);
		}
		
		//nowPage > 지금 보게될 페이지 번호
		//1page -> where rnum between 1 and 10
		//2page -> where rnum between 11 and 20
		//3page -> where rnum between 21 and 30

		begin = ((nowPage - 1) * pageSize) + 1;
		end = begin + pageSize - 1;

		BoardDAO dao = new BoardDAO();

		map.put("begin", begin + "");
		map.put("end", end + "");
		
		//총 게시물 수 알아내기
		totalCount = dao.getTotalCount(map);
		// System.out.println(totalCount);
		
		//총 게시물 수 알아내기 
		totalPage = (int) Math.ceil((double) totalCount / pageSize);
		

		
		
		String pagebar = " <nav>\n" + "<ul class=\"pagination\">";

		loop = 1; // while문 루프 변수
		n = ((nowPage - 1) / blockSize) * blockSize + 1; // 출력되는 페이지 번호

		if (n == 1) {
			pagebar += String.format(
					" <li class='disabled'><a href='#!' aria-label='Previous'> <span aria-hidden='true'>&laquo;</span></a></li> ");
		} else {
			pagebar += String.format(
					" <li><a href='/SIST2_Travel/community/suggest/list.do?page=%d' aria-label='Previous'> "
					+ "<span aria-hidden='true'>&laquo;</span></a></li>", n - 1);
		}
		

			if (totalPage == 0) {
				pagebar += " <li class='active'><a href='#!'>1</a></li> ";
			}
			while (!(loop > blockSize || n > totalPage)) {
				if (n == nowPage) {
					pagebar += String.format(" <li class='active'><a href='#!'>%d</a></li> ", n);
				} else {
					pagebar += String.format(" <li><a href='/SIST2_Travel/community/suggest/list.do?page=%d'>%d</a></li> ", n, n);
				}
				loop++;
				n++;
			}

			if (n > totalPage) {
				pagebar += String.format(
						" <li class='disabled'><a href='#!' aria-label='Next'> <span aria-hidden='true'>&raquo;</span></a></li> ");
			} else {
				pagebar += String.format(
						" <li><a href='/SIST2_Travel/community/suggest/list.do?page=%d' aria-label='Next'> <span aria-hidden='true'>&raquo;</span></a></li> ",
						n);
			}
			pagebar += "</ul>\n" + "		</nav> ";

			
			
			ArrayList<BoardDTO> list = dao.list(map);

			for (BoardDTO dto : list) {
				String regdate = dto.getRegdate();
				regdate = regdate.substring(0, 10);
				dto.setRegdate(regdate);

				String subject = dto.getSubject();
				subject = subject.replace("<script>", "&lt;script").replace("</script>", "%lt;/script&gt;");
				dto.setSubject(subject);

				if (subject.length() > 30) {
					subject = subject.substring(0, 30) + "...";
					dto.setSubject(subject);
				}

				
			}

			// 새로고침에 의한 조회수 증가 방지 티켓
			HttpSession session = req.getSession();

			session.setAttribute("read", "n");

			// 3.
			req.setAttribute("list", list);
			req.setAttribute("map", map);
			req.setAttribute("totalCount", totalCount);
			req.setAttribute("totalPage", totalPage);
			req.setAttribute("nowPage", nowPage);

			req.setAttribute("pagebar", pagebar);

			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/suggest/list.jsp");
			dispatcher.forward(req, resp);
	}

}









