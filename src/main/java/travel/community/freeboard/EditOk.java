package travel.community.freeboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 게시글 수정 데이터 처리 서블릿
 * @author 김정은
 * String freeboardseq 게시글 seq 저장하는 변수
 * String subject 제목을 저장하는 변수
 * String content 내용을 저장하는 변수
 * FreeBoardDTO dto 데이터 전송에 쓰이는 dto 객체
 * FreeBoardDAO dao DB작업을 담당하는 dao 객체
 * int result 메소드 실행 결과값을 저장하는 변수


 *
 */
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
