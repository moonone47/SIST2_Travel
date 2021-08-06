package travel.community.event;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * 로그인 여부를 확인하기 위한 클래스
 */
public class CheckMember {
    /**
     * 세션의 id를 가져와 null 혹은 ""이면 alert 띄운 뒤 index로 보낸다.
     * HttpSession session	세션에 저장된 id를 불러오기 위해 세션을 생성한다.
     * PrintWriter writer	id가 null || “”이면 writer로 alert후 index페이지로 보낸다.
     * @param req
     * @param resp
     */
    public void check(HttpServletRequest req, HttpServletResponse resp) {
        try{
            HttpSession session = req.getSession();

            if(session.getAttribute("id") == null || session.getAttribute("id").toString().equals("")){
                resp.setCharacterEncoding("UTF-8");

                PrintWriter writer = resp.getWriter();

                writer.print("<html>");
                writer.print("<head>");
                writer.print("<meta charset='utf-8'>");
                writer.print("</head>");
                writer.print("<body>");
                writer.print("<script>");
                writer.print("alert('로그인 후 사용이 가능합니다.');");
                writer.print("location.href='/SIST2_Travel/index.do';");
                writer.print("</script>");
                writer.print("</html>");

                writer.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
