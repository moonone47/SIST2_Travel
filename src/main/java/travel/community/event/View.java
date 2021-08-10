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

/**
 * 글을 선택하면 상세 글 보기를 위해 호출되는 클래스다.
 */
@WebServlet("/community/event/view.do")
public class View extends HttpServlet {
	/**
	 * seq, column, search를 가져와 dao.get(dto)를 호출하여 dto에 해당하는 정보를 가져온다. read 티켓을 확인후 조회수를 1 증가시키고, 가져온 dto의 contenet와 subject의 후처리를 진행한다.
	 * XSS공격을 방지하기위해 <script와 <를 replace하고 가독성을위해 \r\n을 <br>로, search중일때는 style을 추가하여 검색어를 부각시킨다.
	 * HttpSession session	read 티켓을 가져오기 위한 session 변수
	 * String seq	getParameter로 seq를 가져온다.
	 * String column	getParameter로 column을 가져온다.
	 * String search	getParameter로 search를 가져온다.
	 * EventDAO dao	Event 테이블의 DB 작업을 위한 DAO 객체
	 * EventDTO dto	Event 테이블의 DB 작업 결과 저장을 위한 DTO 개ㅑㄱ체
	 * String subject	dto에 저장된 subject를 가져와 XSS공격을 방지하기 위해 <script 와 <를 replace하고 \r\n을 <br>로 replace하고 search중일때 style을 추가하여 부각시킨다.
	 * String content	dto에 저장된 content를 가져와 XSS공격을 방지하기 위해 <script 와 <를 replace하고 \r\n을 <br>로 replace하고 search중일때 style을 추가하여 부각시킨다.
	 * ArrayList<CommentDTO> clist	seq(현재 글번호)에 해당하는 모든 댓글을 저장하기 위한 변수
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//할일
		//1. 데이터 가져오기(seq)
		//2. DB 작업 > DAO 위임 > select where seq
		//3. EventDTO 반환 > JSP 호출하기 + 전달하기

		HttpSession session = req.getSession();

		//1.
		String seq = req.getParameter("seq");
		String column = req.getParameter("column");
		String search = req.getParameter("search");

		//2.
		EventDAO dao = new EventDAO();


		if (session.getAttribute("read") != null && session.getAttribute("read").toString().equals("n")) {
			//2.3 조회수 증가하기
			dao.updateReadcount(seq);

			session.setAttribute("read", "y");
		}


		EventDTO dto = dao.get(seq);

		//2.5
		String subject = dto.getSubject();
		String content = dto.getContent();

		//무조건 글 제목과 내용에 들어있는 <script>태그는 비활성화!!!
		subject = subject.replace("<script", "&lt;script").replace("</script>", "&lt;/script&gt;");
		dto.setSubject(subject);

		content = content.replace("<script", "&lt;script").replace("</script>", "&lt;/script&gt;");
		dto.setContent(content);


		//글 내용에 태그 적용 안되게 하기
		if (true) {
			//<b> -> &lt;b&gt;
			content = content.replace("<", "&lt;").replace(">", "&gt;");
			dto.setContent(content);
		}

		//글 내용에 개행 문자 처리하기
		content = content.replace("\r\n", "<br>");
		dto.setContent(content);


		//내용으로 검색 중일 때 검색어 부각 시키기
		if (column != null && search != null && column.equals("content")) {
			content = content.replace(search, "<span style='color:tomato;background-color:yellow;'>" + search + "</span>");
			dto.setContent(content);
		}



		//2.7
		// - 현재 보고 있는 글에 달린 댓글 목록 가져오기
		ArrayList<CommentDTO> clist = dao.listComment(seq); //현재 글번호(= 댓글의 부모글번호)



		//3.
		req.setAttribute("dto", dto);
		req.setAttribute("column", column);
		req.setAttribute("search", search);
		req.setAttribute("clist", clist);


		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/event/view.jsp");
		dispatcher.forward(req, resp);
	}

}













