package travel.mypage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 정보 변경 완료를 처리하기 위한 클래스
 */
@WebServlet("/mypage/editprofileok.do")
public class Editprofileok extends HttpServlet {

	/**
	 * getParameter로 바뀐 정보를 모두 가져온 뒤 dto를 설정한 뒤 dao.edit(dto)를 호출하여 정보를 변경한다. 성공시 profile.jsp로, 실패시 뒤로 이동한다.
	 * String name	getPrameter로 name을 저장한다.
	 * String nick	getPrameter로 nick을 저장한다.
	 * String email	getPrameter로 email을 저장한다.
	 * String phone	getPrameter로 phone을 저장한다.
	 * String zip	getPrameter로 zip을 저장한다.
	 * String address	getPrameter로 address을 저장한다.
	 * String birthday	getPrameter로 birthday을 저장한다.
	 * String gender	getPrameter로 gender을 저장한다.
	 * String id	getPrameter로 id을 저장한다.
	 * MypageDAO dao	DB작업을 위한 DAO객체 생성
	 * MypageDTO dto	update 결과값을 저장하기 위한 DTO 객체 생성
	 * int result	update 작업이 정상적으로 완료됐는지 확인하기 위한 변수
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String nick = req.getParameter("nick");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String zip = req.getParameter("zip");
		String address = req.getParameter("address");
		String birthday = req.getParameter("birthday");
		String gender = req.getParameter("gender");
		String id = "1";
		
		MypageDAO dao = new MypageDAO();
		MypageDTO dto = new MypageDTO();

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
			resp.sendRedirect("/SIST2_Travel/mypage/profile.do?id=" + id);
		} else {
			resp.sendRedirect("/SIST2_Travel/mypage/editprofile.do?id=" + id);
		}
		
	}
}




