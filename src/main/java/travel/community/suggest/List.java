package travel.community.suggest;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/community/suggest/list.do")
public class List extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//1. DB작업 > DAO위임 > select
		BoardDAO dao = new BoardDAO();
		
		//2. ArrayList<BoardDTO> 반환
		ArrayList<BoardDTO> list = dao.list();
		
		for (BoardDTO dto : list) {
			
			//2.3 날짜 가공
			String regdate = dto.getRegdate();
			regdate = regdate.substring(0, 10);
			dto.setRegdate(regdate);
			
			//2.5 글제목과 내용에 들어있는 <script>태그 비활성화
			String subject = dto.getSubject();
			subject = subject.replace("<script>", "&lt;script").replace("</script>", "&lt;/script&gt;");
			dto.setSubject(subject);
			
			//2.7 제목이 너무 길면 자르기
			if (subject.length() > 35) {
				subject = subject.substring(0, 35) + "...";
				dto.setSubject(subject);
			}
		}
		
		//새로고침으로 인한 조회수 증가 방지 
		HttpSession session = req.getSession();
		session.setAttribute("read", "n");
		
		
		//3. JSP 호출하기 + ArrayList 전달
		req.setAttribute("list", list);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/suggest/list.jsp");
		dispatcher.forward(req, resp);
	}

}









