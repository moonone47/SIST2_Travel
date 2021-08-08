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
/**
 * 게시판 리스트 조회 서블릿
 * @author 김정은
 *
 */
@WebServlet("/community/freeboard/list.do")
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
		//   /SIST2_Travel/community/freeboard/list.do

	

		//페이징 처리 
		// -> 보고 싶은 페이지를 정하기 위한 처리
		int nowPage = 0;		//현재 페이지 번호
		int totalCount = 0;		//총 게시물 수
		int pageSize = 10;		//한 페이지당 출력할 게시물 수
		int totalPage = 0;		//총 페이지 수
		int begin = 0;			//가져올 게시물 시작 위치
		int end = 0;			//가져올 게시물 끝 위치
		int n = 0;				//페이지바 제작
		int loop = 0;			//페이지바 제작
		int blockSize = 10;		//페이지바 제작
		
		
		//list.do > list.do?page=1
		//list.do?page=3
		
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
		
		map.put("begin", begin + "");
		map.put("end", end + "");

		
		
		
		//총 게시물 수 알아내기
		totalCount = dao.getTotalCount(map);
		//System.out.println(totalCount);
		
		//총 페이지 수 알아내기
		//393 / 10 = 39.3 > 40
		totalPage = (int)Math.ceil((double)totalCount / pageSize);
		//System.out.println(totalPage);
		
		
		
		
		String pagebar = "<nav>\r\n"
				+ "			<ul class=\"pagination\">";
		
//		for (int i=1; i<=totalPage; i++) {
//			if (i == nowPage) {
//				pagebar += String.format(" <a href='#!' style='color:tomato;'>%d</a> ", i, i);				
//			} else {
//				pagebar += String.format(" <a href='/SIST2_Travel/community/freeboard/list.do?page=%d'>%d</a> ", i, i);
//			}
//		}
		
		
		//list.do?page=1
		//1 2 3 4 5 6 7 8 9 10
		
		//list.do?page=5
		//1 2 3 4 5 6 7 8 9 10
		
		//list.do?page=10
		//1 2 3 4 5 6 7 8 9 10
		
		//list.do?page=11
		//11 12 13 14 15 16 17 18 19 20
		
		//list.do?page=15
		//11 12 13 14 15 16 17 18 19 20
		
		
		
		loop = 1; //while 루프 변수
		n = ((nowPage - 1) / blockSize) * blockSize + 1; //출력되는 페이지 번호
		
		
		//이전 10페이지
//		if (n == 1) {
//			pagebar += String.format(" <a href='#!'>[이전 %d페이지]</a> ", blockSize);			
//		} else {
//			pagebar += String.format(" <a href='/myapp/board/list.do?page=%d'>[이전 %d페이지]</a> ", n-1, blockSize);			
//		}
		
		if (n == 1) {
			pagebar += String.format(" <li class='disabled'><a href='#!' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li> ");			
		} else {
			pagebar += String.format(" <li><a href='/SIST2_Travel/community/freeboard/list.do?page=%d' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li> ", n-1);			
		}
		
		
		
		
		//페이지 링크		
//		while (!(loop > blockSize || n > totalPage)) {
//			
//			if (n == nowPage) {
//				pagebar += String.format(" <a href='#!' style='color:tomato;'>%d</a> ", n, n);				
//			} else {
//				pagebar += String.format(" <a href='/myapp/board/list.do?page=%d'>%d</a> ", n, n);
//			}
//			
//			loop++;
//			n++;
//		}
		
		
		if (totalPage == 0) {
			pagebar += " <li class='active'><a href='#!'>1</a></li> ";
		}
		
		while (!(loop > blockSize || n > totalPage)) {
			
			if (n == nowPage) {
				pagebar += String.format(" <li class='active'><a href='#!'>%d</a></li> ", n);				
			} else {
				pagebar += String.format(" <li><a href='/SIST2_Travel/community/freeboard/list.do?page=%d'>%d</a></li> ", n, n);
			}
			
			loop++;
			n++;
		}
		
		
		
		//다음 10페이지
//		if (n > totalPage) {
//			pagebar += String.format(" <a href='#!'>[다음 %d페이지]</a> ", blockSize);			
//		} else {
//			pagebar += String.format(" <a href='/myapp/board/list.do?page=%d'>[다음 %d페이지]</a> ", n, blockSize);
//		}
		
		if (n > totalPage) {
			pagebar += String.format(" <li class='disabled'><a href='#!' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li> ");			
		} else {
			pagebar += String.format(" <li><a href='/SIST2_Travel/community/freeboard/list.do?page=%d' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li> ", n);
		}
		
		
		
		pagebar += "</ul>\r\n"
				+ "		</nav>";
		
	
		
	
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
		
		req.setAttribute("totalCount", totalCount);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("nowPage", nowPage);
		req.setAttribute("pagebar", pagebar);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/freeboard/list.jsp");
		dispatcher.forward(req, resp);
	}

}
