package travel.community.suggest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 문지원
 글쓰기 완료 처리를 위한 클래스

	CheckMember cm 		로그인한 멤버인지 확인하는 변수
	String subject 		getParameter로 subject를 가져온다.
	String content 		getParameter로 content를 가져온다.
	BoardDAO dao 		Suggest 테이블의 DB 작업을 위한 DAO 객체
	BoardDTO dto 		Suggest 테이블의 DB 작업 결과를 저장하기 위한 DTO 객체
	String reply 		getParameter로 reply를 가져온다
	int thread `		답글이 없으면  dao.getMaxThread로 thread의 최대값을 저장한다. 답글이 있으면 parentThread -1을 저장한다.
	int depth 			답글이 없으면 0으로 지정한다 답글이 있으면 parentDepth +1을 저장한다.
	int parentThread 	답글이 없을때 getParameter로 thread를 가져온다
	int parentDepth  	답글이 없을때 getParameter로 depth를 가져온다
	int previousThread 	이전 새 글의 thread 공식
	int result 			게시글 insert 작업 결과를 저장하는 변수

 */
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