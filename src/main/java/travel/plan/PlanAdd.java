package travel.plan;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/plan/planadd.do")
public class PlanAdd extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");


		
		String address_name = req.getParameter("address_name");
		String category_group_code = req.getParameter("category_group_code");
		String category_group_name = req.getParameter("category_group_name");
		String category_name = req.getParameter("category_name");
		String id = req.getParameter("id");
		String phone = req.getParameter("phone");
		String place_name = req.getParameter("place_name");
		String place_url = req.getParameter("place_url");
		String road_address_name = req.getParameter("road_address_name");
		String x = req.getParameter("x");
		String y = req.getParameter("y");
		
		String rdate = req.getParameter("rdate");
//		System.out.println("@@@@@@@@@@@@@@");
//		System.out.println(rdate);
//		System.out.println("@@@@@@@@@@@@@@");


		//2.tblPlan2 -> rdate select해오기
		//

		//todo: 로그인 구현 되면 id ->session에서 가져오기


		HttpSession session = req.getSession();
//		todo: 구현
//		String userId = (String) session.getAttribute("id");
//		String userId = req.getParameter("userid");
//		String planNum = req.getParameter("planNum");
//		String isDone = req.getParameter("isDone");
		PlaceDAO dao = new PlaceDAO();
		PlaceDTO dto = new PlaceDTO();
		ArrayList<PlaceDTO> list = dao.getList(rdate, "4"); //string
		int plan2seq = 0;
		//
		// 맵에서 들어오는 req들을 PlanDTO > list 에 일정들을 임시 저장
		// 일정번호
		// 아이디

		int result = -1;
		
//		ArrayList의 PlanDTO를
		if(address_name !=null && place_name !=null && !x.equals("[object HTMLInputElement]") && !y.equals("[object HTMLInputElement]")) {
			
		dto.setAddress_name(address_name);
		dto.setCategory_group_code(category_group_code);
		dto.setCategory_group_name(category_group_name);
		dto.setCategory_name(category_name);
		dto.setId(id);
		dto.setPhone(phone);
		dto.setPlace_name(place_name);
		dto.setPlace_url(place_url);
		dto.setRoad_address_name(road_address_name);
		dto.setX(x);
		dto.setY(y);
		dto.setRdate(rdate);

		result = dao.add(dto);

		}
		

		//todo: 일정 삭제시 할 기능 구현 
		

		//todo: id별로 dto를 묶어서 사용자에게 모든 일정을 전달해야한다. dto가 아닌 list를 던져줘야함..
		// db 들어가서 where 일정번호로 select해서 나온 값을 return해줘야함...
//		ArrayList<PlanDTO> list = new ArrayList<PlanDTO>();
		//ArrayList<PlaceDTO> list = dao.getList(4); //where memberid == 4


		CityDTO city = new CityDTO();

		city.setName(req.getParameter("cityname"));
		city.setCityX(req.getParameter("cityX"));
		city.setCityY(req.getParameter("cityY"));
		city.setExplain(req.getParameter("Explain"));
		city.setCityseq(req.getParameter("Cityseq"));

		PlanInfoDTO citydto = new PlanInfoDTO();
		citydto.setName(req.getParameter("planname"));
		citydto.setDayendtravel(req.getParameter("dayendtravel"));
		citydto.setDaystarttravel(req.getParameter("daystarttravel"));
		citydto.setWillshare(req.getParameter("willshare"));

		String[] datelists = req.getParameterValues("datelist"); //날짜 배열
		ArrayList<String> datelist = new ArrayList<String>();
		for (int i = 0; i < datelists.length; i++) {
			datelist.add(datelists[i]);
			//System.out.println(datelists[i]);
		}



		req.setAttribute("list", list); //planadd.jsp에서 일정 리스트 용
		req.setAttribute("city", city); //도시 좌표
		req.setAttribute("citydto", citydto); //일정에 채워 넣을 용
		req.setAttribute("datelist", datelist); //전체 일정 날짜
		req.setAttribute("rdate", rdate);

		//RequestDispatcher dispatcher = req.getRequestDispatcher("/map.jsp");
//		todo: 기능 구현 후 아래 planadd.jsp
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/plan/planadd.jsp?rdate="+rdate);
		dispatcher.forward(req, resp);
		
	}











	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	//RequestDispatcher dispatcher = req.getRequestDispatcher("/map.jsp");
		// todo: 기능 구현후 planadd.jsp로 이동
				RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/plan/planadd.jsp");
//		dispatcher.forward(req, resp);
	}
}