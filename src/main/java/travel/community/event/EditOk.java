package travel.community.event;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 글 수정 완료 처리를 위한 메소드
 */
@WebServlet("/community/event/editok.do")
public class EditOk extends HttpServlet {
    /**
     * 로그인 여부를 확인하고 seq, subject, content 정보를 받아 dto를 생성하고 dao.edit(dto)를 호출하여 글을 update한다. 성공하면 view.do로 이동하고 실패시 edit으로 이동한다.
     * CheckMember cm	로그인 여부를 확인하기 위한 변수
     * String seq	getParamter로 seq를 가져온다.
     * String subject	getParamter로 subject를 가져온다.
     * String content	getParamter로 content를 가져온다.
     * EventDAO dao	Event 테이블의 DB 작업을 위한 DAO 객체
     * EventDTO dto	Event 테이블의 DB 작업 결과를 저장하기 위한 DTO 객체
     * int result	update 작업 결과를 저장하는 변수
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CheckMember cm = new CheckMember();
        cm.check(req, resp);


        String seq = req.getParameter("seq");
        String subject = req.getParameter("subject");
        String content = req.getParameter("content");
        String tag = req.getParameter("tag");

        //2.
        EventDAO dao = new EventDAO();
        EventDTO dto = new EventDTO();

        HttpSession session = req.getSession();

        dto.setSeq(seq);
        dto.setSubject(subject);
        dto.setContent(content);

        int result = dao.edit(dto);

        //3.
        if (result == 1) {
            resp.sendRedirect("/community/event/view.do?seq=" + seq);
        } else {
            resp.sendRedirect("/community/event/edit.do?seq=" + seq);
        }

    }

}

