package travel.community.freeboard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Editok.do

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/community/freeboard/editok.jsp");
		dispatcher.forward(req, resp);
	}

}
