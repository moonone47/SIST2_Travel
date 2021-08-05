package travel.community.suggest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/community/suggest/addok.do")
public class AddOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		  CheckMember cm = new CheckMember(); 
		  cm.check(req,resp);
	
		req.setCharacterEncoding("UTF-8");

		String subject = req.getParameter("subject");
		String content = req.getParameter("content");

		BoardDAO dao = new BoardDAO();
		BoardDTO dto = new BoardDTO();

		HttpSession session = req.getSession();

		dto.setId(session.getAttribute("id").toString());
		dto.setSubject(subject);
		dto.setContent(content);

		// 새글쓰기 vs 답변글쓰기
		String reply = req.getParameter("reply"); // 1 - 댓글 or 0 - 새글
		int thread = -1;
		int depth = -1;
		int parentThread = -1;
		int parentDepth = -1;

		if (reply.equals("0")) {
			// 새글쓰기
			// a. 현존 모든 게시물 중에서 가장 큰 thread값을 찾는다 > 0 > 그 찾은 thread값에 +1000 한 값을 현재 새글의
			// thread값으로 사용한다.
			thread = dao.getMaxThread();

			depth = 0;
		} else {
			// 답변글쓰기
			parentThread = Integer.parseInt(req.getParameter("thread"));
			parentDepth = Integer.parseInt(req.getParameter("depth"));
			// a. 현존 모든 게시물의 thread값을 대상으로 현재 작성 중인 답변글의 부모글의 thread값보다 작고, 이전 새글의 thread값보다
			// 큰 thread값을 찾아서 모두 -1한다 .

			// 이전 새글의 thread 공식
			int previousThread = (int) Math.floor((parentThread - 1) / 1000) * 1000;

			dao.updateThread(parentThread, previousThread);

			// b. 현재 작성중인 답변글의 thread값은 부모글의 thread -1을 넣는다
			thread = parentThread - 1;

			// c. 현재 작성중인 답변글의 depth값을 부모글의 depth + 1을 넣는다
			depth = parentDepth + 1;

		}

		dto.setThread(thread);
		dto.setDepth(depth);

		int result = dao.add(dto);

		if (result == 1) {

			System.out.println("게시글 작성 성공 ");
			resp.sendRedirect("/SIST2_Travel/community/suggest/list.do");
		} else {
			resp.sendRedirect("/SIST2_Travel/community/suggest/add.do");

		}
		
	}

}