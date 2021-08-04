package travel.login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login/findidok.do")
public class FindIdOk extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        MemberDAO dao = new MemberDAO();
        MemberDTO dto = new MemberDTO();

        dto.setName(req.getParameter("name"));
        dto.setEmail(req.getParameter("email"));

        String result = dao.findId(dto);

        if (result != null) {
            req.setAttribute("id", result);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/login/findidok.jsp");
            dispatcher.forward(req, resp);
//            resp.sendRedirect("/SIST2_Travel/WEB-INF/views/login/findidok.jsp");
        } else {
//            resp.sendRedirect("/SIST2_Travel/WEB-INF/views/login/findid.jsp");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/login/findid.jsp");
            dispatcher.forward(req, resp);
        }
//
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/login/findidok.jsp");
//        dispatcher.forward(req, resp);
    }

}
