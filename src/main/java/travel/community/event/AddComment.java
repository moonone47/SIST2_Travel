package travel.community.event;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 댓글쓰기를 클릭할때 호출되는 클래스
 */
@WebServlet("/community/event/addcomment.do")
public class AddComment extends HttpServlet {
    /**
     * 로그인 여부를 확인하고 pseq, content를 받아와서 addComment를 호출하여 dto를 insert하고 성공하면 view로, 실패하면 alert과 함께 뒤로 보내진다.
     * CheckMember cm	로그인 여부를 확인하는 변수
     * String pseq	getParameter로  pseq를 가져온다.
     * String content	getParameter로 content를 가져온다.
     * EventDAO dao	이벤트 게시판 DB 작업을 위한 DAO 객체 생성
     * CommentDTO dto	댓글 정보를 저장하기 위한 DTO 객체 생성
     * HttpSession session	id를 얻기 위해 세션을 생성하는 변수
     * int result	댓글 insert 작업 결과를 저장하는 변수
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CheckMember cm = new CheckMember();
        cm.check(req, resp);

        //할일
        //1. 데이터 가져오기(content, pseq)
        //2. DB 작업 > DAO 위임 > insert
        //3. 돌아가기 > view.do?seq=10

        //1.
        String pseq = req.getParameter("pseq"); //보고있던 글번호(= 작성중인 댓글의 부모 글번호)
        String content = req.getParameter("content");

        //2.
        EventDAO dao = new EventDAO();
        CommentDTO dto = new CommentDTO();

        HttpSession session = req.getSession();

        dto.setId(session.getAttribute("id").toString()); //댓글 작성자 아이디(= 로그인한 사람 세션)
        dto.setPseq(pseq);
        dto.setContent(content);

        int result = dao.addComment(dto);//1, 0

        //3.
        if (result == 1) {
            resp.sendRedirect("/SIST2_Travel/community/event/view.do?seq=" + pseq); //보고 있던 글번호를 가지고 돌아가기
        } else {

            resp.setCharacterEncoding("UTF-8");

            PrintWriter writer = resp.getWriter();

            writer.print("<html>");
            writer.print("<body>");
            writer.print("<script>");
            writer.print("alert('댓글 쓰기 실패');");
            writer.print("history.back();");
            writer.print("</script>");
            writer.print("</body>");
            writer.print("</html>");

            writer.close();
        }

    }
}
