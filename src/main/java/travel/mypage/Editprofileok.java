package travel.mypage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mypage/editprofileok.do")
public class Editprofileok extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String name = req.getParameter("name");
		String nick = req.getParameter("nick");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String zip = req.getParameter("zip");
		String address = req.getParameter("address");
		String birthday = req.getParameter("birthday");
		String gender = req.getParameter("gender");
		String id = req.getParameter("id");
		
		MypageDAO dao = new MypageDAO();
		MypageDTO dto = new MypageDTO();
		
		HttpSession session = req.getSession();
		
		dto.setId(id);
		dto.setName(name);
		dto.setNick(nick);
		dto.setEmail(email);
		dto.setPhone(phone);
		dto.setZip(zip);
		dto.setAddress(address);
		dto.setBirthday(birthday);
		dto.setGender(gender);
		
		int result = dao.edit(dto);
		
		if (result == 1) {
			resp.sendRedirect("/index.do");
		} else {
			resp.sendRedirect("/mypage/editprofile.do");
		}
		
	}
}




