package travel.community.event;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/community/event/delok.do")
public class DelOk extends HttpServlet {

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