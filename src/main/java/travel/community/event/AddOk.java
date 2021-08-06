package travel.community.event;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 글 작성을 완료하기 위한 메소드
 */
@WebServlet("/community/event/addok.do")
public class AddOk extends HttpServlet {
	/**
	 * subject, content를 가져온 뒤 답글의 여부에 따라 thread, depth, prarentThread, prarentDepth값을 설정하고, 답글이 있으면 updateThread를 호출하여 각 ParentThread와 previousThread 사이에 있는 Thread의 값을 -1 해준다. 답글이 없으면 maxThread로 Thread의 최대값을 가지고 온다.<br>
	 * 모든 설정이 완료되면 dao.add(dto)를 호출하여 새로운 글을 insert한다.
	 * String subject	getParameter로 subject를 가져온다.
	 * String content	getParameter로 content를 가져온다.
	 * EventDAO dao	Event 테이블의 DB 작업을 위한 DAO 객체
	 * EventDTO dto	Event 테이블의 DB 작업 결과를 저장하기 위한 DTO 객체
	 * HttpSession session	id를 가져오기 위해 세션을 생성한다.
	 * String reply	getParameter로 reply를 가져온다.
	 * int thred	답글이 없으면 dao.MaxThread로 thread의 최대값을 저장한다.
	 * 답글이 있으면 parentThread -1을 저장한다.
	 * int depth	답글이 없으면 0dmfh wlwjdgksek.
	 * 답글이 있으면 parentDepth +1을 저장한다..
	 * int parentThread	답글이 없을때 getParameter로 thread값을 가져온다.
	 * int parentDepth	답글이 없을때 getParameter로 depth를 가져온다.
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String subject = req.getParameter("subject");
		String content = req.getParameter("content");

		EventDAO dao = new EventDAO();
		EventDTO dto = new EventDTO();

		HttpSession session = req.getSession();

		dto.setId(session.getAttribute("id").toString());
		dto.setSubject(subject);
		dto.setContent(content);

		String reply = req.getParameter("reply");
		int thread = -1;
		int depth = -1;
		int parentThread = -1;
		int parentDepth = -1;

		if(reply.equals("0")){
			thread = dao.getMaxThread();
			depth = 0;
		}else{
//			if( parentThread==null)
//				parentThread=0
			parentThread = Integer.parseInt(req.getParameter("thread"));
			parentDepth = Integer.parseInt(req.getParameter("depth"));

			int previousThread = (int)Math.floor((parentThread - 1) / 1000) * 1000;

			dao.updateThread(parentThread, previousThread);

			thread = parentThread - 1;
			depth = parentDepth + 1;
		}

		dto.setThread(thread);
		dto.setDepth(depth);

		int result = dao.add(dto);

		if(result == 1){
			resp.sendRedirect("/SIST2_Travel/community/event/list.do");
		}else{
			resp.sendRedirect("/SIST2_Travel/community/event/list.do");
		}
	}
}
