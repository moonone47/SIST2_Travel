package travel.plan;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/plan/plan.do")
public class Plan extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		CityDAO dao = new CityDAO();
		CityDTO dto = new CityDTO();

		ArrayList<CityDTO> citys = dao.list();

		req.setAttribute("citys",citys);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/plan/plan.jsp");
		dispatcher.forward(req, resp);
	}

}




//plan.java 시작 
//plan.jsp 전체 일정을 세팅 (: 일정설정 완료)  
//planinfo.java -> tblPlan에 전체 일정 생성 

//->  todo: select(citydto에 정보 where절 날리기)으로 planseq 얻어오기 -> session에 담아두기

//planinfo.java -> planadd.jsp -> 상세 일정 추가 
//planadd.jsp (일정 하나 추가) -> planadd.java (placeDAO add() -> 일정 추가 -> planadd.java -> placeDAO.getList() -> planadd.jsp에 일정 리스트 뿌려줌)
//리스트 일정 삭제 구현... x버튼 -> DB delete where 
//순서 바꾸는 것: hidden tag 이용해서 sort
 
//  -> (일정추가 버튼을 누르면) 상세 일정 하나씩 추가 완료 (: 임시테이블 tblPlan2에 담아놓음 )
//planadd.java -> plandd.jsp -> (일정 완료를 누르면) 모든 일정을 DB에 저장 -> (tblPlan2(임시) -> 음식점/숙소/명소(저장소) 옮겨주기.. planseq 얻어오기) -> 끝?
//	-> 임시 테이블에 있는 사용자의 레코드는 다 삭제 delete all where id = id;
//

















