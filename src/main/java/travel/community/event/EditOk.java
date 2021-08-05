package travel.community.event;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/community/event/editok.do")
public class EditOk extends HttpServlet {

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

