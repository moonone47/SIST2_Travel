package travel.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



/**
 * @author 문지원
 * 회원가입을 작업하는 클래스

	MemberDAO dao	DB작업을 위한 DAO 객체
	MemberDTO dto	DB 결과를 저장하기 위한 DTO 객체
	String year	getParameter로 yy를 가져온다 
	String month	getParameter로 mm을 가져온다
	String day	getParameter로 dd를 가져온다
	String add1	getParameter로 add1을 가져온다
	String add2	getParameter로 add2를 가져온다
	String add3	getParameter로 add3를 가져온다
	String Address	add1, add2, add3을 합쳐서 저장한다.
	int result	insert 작업결과를 저장하는 변수
	PrintWriter writer	result != null이면, alret을 띄우고 index로 보낸다. 그 외의 경우 alert을 띄우고 회원가입으로 보낸다

 */
@WebServlet("/login/signupok.do")
public class SignupOk extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");


        MemberDAO dao = new MemberDAO();
        MemberDTO dto = new MemberDTO();

        dto.setId(req.getParameter("id"));
        dto.setPw(req.getParameter("pw"));
        dto.setName(req.getParameter("name"));
        dto.setNick(req.getParameter("nick"));
        
        
        String year = req.getParameter("yy");
        String month = req.getParameter("mm");
        String day = req.getParameter("dd");
        
        dto.setBirthday(year + month + day);
        dto.setEmail(req.getParameter("email"));
        dto.setGender(req.getParameter("gender"));
        dto.setPhone(req.getParameter("phone"));
        dto.setLv("1");
        
//        String Address = req.getParameter("add1") + req.getParameter("add2") + req.getParameter("add3");
        String add1 = req.getParameter("add1");
        String add2 = req.getParameter("add2");
        String add3 = req.getParameter("add3");
        String Address = add1 + add2 + add3;
        dto.setAddress(Address);
        dto.setZip("zip");

        int result = dao.signup(dto);

        if (result != 0) {
            PrintWriter writer = resp.getWriter();
            writer.print("<html>");
            writer.print("<head>");
            writer.print("<meta charset='utf-8'>");
            writer.print("</head>");
            writer.print("<body>");
            writer.print("<script>");
            writer.print("alert('회원가입 완료.');");
            writer.print("location.href='/index.do';");
            writer.print("</script>");
            writer.print("</html>");
//            resp.sendRedirect("/WEB-INF/views/index.jsp");
        } else {
            PrintWriter writer = resp.getWriter();
            writer.print("<html>");
            writer.print("<head>");
            writer.print("<meta charset='utf-8'>");
            writer.print("</head>");
            writer.print("<body>");
            writer.print("<script>");
            writer.print("alert('회원가입 실패.');");
            writer.print("location.href='/login/signup.do';");
            writer.print("</script>");
            writer.print("</html>");
//            resp.sendRedirect("/WEB-INF/views/login/signup.jsp");
        }

//        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/index.jsp");
//        dispatcher.forward(req, resp);

    }//doGet

}//class
