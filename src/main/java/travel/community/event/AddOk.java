package travel.community.event;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/community/event/addok.do")
public class AddOk extends HttpServlet {

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
			resp.sendRedirect("/SIST2_Travel/community/event/add.do");
		}
	}
}
