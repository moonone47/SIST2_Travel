package travel.community.clubboard;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import travel.community.question.CheckMember;

@WebServlet("/community/clubboard/view.do")
public class View extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		CheckMember cm = new CheckMember();
		cm.check(req,resp);
		
		String travelclubseq = req.getParameter("travelclubseq");
		
		ClubBoardDAO dao = new ClubBoardDAO();
		
		HttpSession session = req.getSession(); 
		
		if(session.getAttribute("read") != null && session.getAttribute("read").toString().equals("n")){

			// 조회수 증가하기 (내가 읽은것도 포함 )
			dao.updateReadCount(travelclubseq);

			session.setAttribute("read", "y");
		}		
		
		ClubBoardDTO dto = dao.get(travelclubseq);
		
		String subject = dto.getSubject();
		String content = dto.getContent();

		subject = subject.replace("<script>", "&lt;script").replace("</script>", "%lt;/script&gt;");
		dto.setSubject(subject);

		content = content.replace("<script>", "&lt;script").replace("</script>", "%lt;/script&gt;");
		dto.setContent(content);
		
		ArrayList<ClubBoardCommentDTO> clist = dao.listcomment(travelclubseq);

		
		content = content.replace("\r", "<br>");
		dto.setContent(content);		
		
		req.setAttribute("dto", dto);
		req.setAttribute("clist", clist);
		
		
				

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/clubboard/view.jsp");
		dispatcher.forward(req, resp);

	}//doGet

}//class