package travel.login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login/signupok.do")
public class SignupOk extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");


        MemberDAO dao = new MemberDAO();
        MemberDTO dto = new MemberDTO();
//        String year = req.getParameter("yy");
//        String month = req.getParameter("mm");
//        String day = req.getParameter("dd");
//        String add1 = req.getParameter("add1");
//        String add2 = req.getParameter("add2");
//        String add3 = req.getParameter("add3");
//        String Address = add1+add2+add3;
//        System.out.println(add1);
//        System.out.println(add2);
//        System.out.println(add3);
//        System.out.println("----------");
////
//        System.out.println(req.getParameter("id"));
//        System.out.println(req.getParameter("pw"));
//        System.out.println(req.getParameter("name"));
//        System.out.println(req.getParameter("nick")); //null
//
//        System.out.println(year+month+day);
//        System.out.println(req.getParameter("email"));
//        System.out.println(req.getParameter("gender"));
//        System.out.println(req.getParameter("phone"));
//        System.out.println(req.getParameter("zip"));
//        System.out.println(req.getParameter(Address));  //null

//
//        id pwsd1 name nick yy mm dd genderemail mobile
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

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/index.jsp");
        dispatcher.forward(req, resp);

    }//doGet

}//class
