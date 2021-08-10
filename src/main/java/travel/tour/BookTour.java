package travel.tour;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * 투어 예약 서블릿
 * @author 김정은
 *String id 사용자 id 
BookTourDAO dao BookTourDAO 클래스 객체로 만드는 변수 
BookTourDTO dto BookTourDTO 클래스 객체로 만드는 변수 


 */
@WebServlet("/tour/booktour.do")
public class BookTour extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        BookTourDAO dao = new BookTourDAO();
        BookTourDTO dto = new BookTourDTO();
//        private String name;
//        private String regdate;
//        private String personnel;
//        private String contact;
//        private String email;
//        private String moredetail;
//        private String tourseq;
        HttpSession session = req.getSession();
        String id = session.getAttribute("id").toString();
        if(id == null || id.equals("")){

            PrintWriter writer = resp.getWriter();
            writer.print("<html>");
            writer.print("<head>");
            writer.print("<meta charset='utf-8'>");
            writer.print("</head>");
            writer.print("<body>");
            writer.print("<script>");
            writer.print("alert('로그인 후 사용이 가능합니다.');");
            writer.print("location.href='/SIST2_Travel/tour/tour.do';");
            writer.print("</script>");
            writer.print("</html>");
        }

        dto.setId(id);
        dto.setName(req.getParameter("name"));
        dto.setRegdate(req.getParameter("regdate"));
        dto.setPersonnel(req.getParameter("personnel"));
        dto.setContact(req.getParameter("contact"));
        dto.setEmail(req.getParameter("email"));
        dto.setMoredetail(req.getParameter("moredetail"));
        dto.setTourseq(req.getParameter("tourseq"));

        int result = dao.insertTour(dto);

        if (result > 0){
            PrintWriter writer = resp.getWriter();
            writer.print("<html>");
            writer.print("<head>");
            writer.print("<meta charset='utf-8'>");
            writer.print("</head>");
            writer.print("<body>");
            writer.print("<script>");
            writer.print("alert('예약을 완료했습니다..');");
            writer.print("location.href='/SIST2_Travel/tour/tour.do';");
            writer.print("</script>");
            writer.print("</html>");

        }else{
            PrintWriter writer = resp.getWriter();
            writer.print("<html>");
            writer.print("<head>");
            writer.print("<meta charset='utf-8'>");
            writer.print("</head>");
            writer.print("<body>");
            writer.print("<script>");
            writer.print("alert('예약을 실패했습니다. 다시 시도해주세요.');");
            writer.print("location.href='/SIST2_Travel/tour/tour.do';");
            writer.print("</script>");
            writer.print("</html>");
        }
    }
}
