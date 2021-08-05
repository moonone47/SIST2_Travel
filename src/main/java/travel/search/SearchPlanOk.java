package travel.search;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet("/search/searchplanok.do")
public class SearchPlanOk extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String word = req.getParameter("search");

        SearchPlanDAO dao = new SearchPlanDAO();
        LinkedList<SearchPlanDTO> dto = new LinkedList<SearchPlanDTO>();

        dto = dao.getAll(word);

        req.setAttribute("dto", dto);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/search/searchplanok.jsp");
        dispatcher.forward(req, resp);
    }

}
