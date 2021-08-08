package travel.community.suggest;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 문지원
 * 로그인 여부를 확인하기 위한 클래스

	HttpSession session	세션에 저장된 id를 불러오기 위해 세션을 생성한다.
	PrintWriter writer	id가 null이거나 빈문자열이면 alert을 띄우고 index로 보낸다

 */
public class CheckMember {

	public void check(HttpServletRequest req, HttpServletResponse resp) {
		try {
			
			HttpSession session = req.getSession();
			
			//로그인 안한사람 
			if(session.getAttribute("id") == null || session.getAttribute("id").toString().equals("")) {
				resp.setCharacterEncoding("UTF-8");
				
				PrintWriter writer;
				writer = resp.getWriter();
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
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
