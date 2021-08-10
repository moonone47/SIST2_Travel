package travel.community.event;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 글 삭제 완료 처리를 위한 클래스
 */
@WebServlet("/community/event/delok.do")
public class DelOk extends HttpServlet {
    /**
     * seq를 받아와 dao.delAllComment로 모든 댓글을 삭제하고, dao.del(sq)로 글을 삭제한 뒤 list로 이동한다. 실패하면 del.do로 seq를 가지고 이동한다.
     * String seq	getParameter로 seq를 가져온다.
     * EventDAO dao	Event테이블의 DB작업을 위한 DAO객체 생성
     * HttpSession session	세션생성을 위한 변수
     * int result	delete 작업 결과를 저장하는 변수
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String seq = req.getParameter("seq");

        //2.
        EventDAO dao = new EventDAO();

        HttpSession session = req.getSession();

        //2.5 현재 글에 달린 댓글부터 삭제하기(***)
        dao.delAllComment(seq); //부모글번호

        int result = dao.del(seq);

        //3.
        if (result == 1) {
            resp.sendRedirect("/community/event/list.do");
        } else {
            resp.sendRedirect("/community/event/del.do?seq=" + seq);
        }

    }


}