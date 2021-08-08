package travel.login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

/**
 * @author 문지원
 * 회원가입을 눌렀을때 실행되는 클래스

	MemberDAO dao 	DB작업을 위한 DAO 객체
	LinkedList<String> dto	모든 id정보를 가져오기 위한 변수
 */
@WebServlet("/login/signup.do")
public class SignUp extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        MemberDAO dao = new MemberDAO();
        LinkedList<String> dto = new LinkedList<String>();

        dto = dao.getAllId();

        req.setAttribute("dto", dto);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/login/signup.jsp");
        dispatcher.forward(req, resp);

    }//doGet

}//class
