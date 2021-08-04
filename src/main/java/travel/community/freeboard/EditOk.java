package travel.community.freeboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/community/freeboard/editok.do")
public class EditOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Editok.do
		req.setCharacterEncoding("UTF-8");
		
		String freeboardseq = req.getParameter("freeboardseq");
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		
		FreeBoardDTO dto = new FreeBoardDTO();
		FreeBoardDAO dao = new FreeBoardDAO();
		
		dto.setFreeboardseq(freeboardseq);
		dto.setSubject(subject);
		dto.setContent(content);
		
		int result = dao.update(dto);
		
		if(result == 1) {
			resp.sendRedirect("/SIST2_Travel/community/freeboard/view.do?freeboardseq=" + freeboardseq);
		} else {
			resp.sendRedirect("/SIST2_Travel/community/freeboard/edit.do?freeboardseq=" + freeboardseq);
		}

	
	}

}
