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

		// PlanAdd.java
//		address_name: "서울 중구 을지로5가 275-3"
//		category_group_code: "AD5"
//		category_group_name: "숙박"
//		category_name: "여행 > 숙박 > 호텔 > 특급호텔 > 라마다호텔"
//		id: "13111137"
//		phone: "02-2276-3500"
//		place_name: "라마다 서울동대문"
//		place_url: "http://place.map.kakao.com/13111137"
//		road_address_name: "서울 중구 동호로 354"
//		x: "127.002698429626"
//		y: "37.5658944720562"
		
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
		String date = req.getParameter("date");
		HttpSession session = req.getSession();
//		todo: 구현
//		String userId = (String) session.getAttribute("id");
//		String userId = req.getParameter("userid");
//		String planNum = req.getParameter("planNum");
//		String isDone = req.getParameter("isDone");
		PlaceDAO dao = new PlaceDAO();
		PlaceDTO dto = new PlaceDTO();
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

		result = dao.add(dto);

		}
		
		if(result == 0){
			System.out.println(result);
		}
		//todo: 일정 삭제시 할 기능 구현


		//todo: id별로 dto를 묶어서 사용자에게 모든 일정을 전달해야한다. dto가 아닌 list를 던져줘야함..
		// db 들어가서 where 일정번호로 select해서 나온 값을 return해줘야함...
//		ArrayList<PlanDTO> list = new ArrayList<PlanDTO>();
		ArrayList<PlaceDTO> list = dao.getList(4); //where memberid == 4


//		req.setAttribute("list", list);
//		if (list.size() != 0) {
//			resp.sendRedirect("/SIST2_Travel/map.jsp");
//		} else {
//			System.out.println("list에 값이 들어있지 않습니다.");
//		}

//		list.add(dto); // DB에 넣지 않고 list에 add 가능한가요..?
		//
		/*
		 * if(isDone != null && isDone.equals("y")){ dao.add(list); }
		 */
//		req.setAttribute("list", list);
//		req.setAttribute("dto", dto); // dto로 전달

		
		/*
		 * String[] planseq = req.getParameterValues("planseq"); String[] seq =
		 * req.getParameterValues("seq");
		 * 
		 * ArrayList<HashMap<String,String>> seqlist = new
		 * ArrayList<HashMap<String,String>>();
		 * 
		 * 
		 * for(int i=0; i<planseq.length; i++) {
		 * 
		 * HashMap<String,String> temp = new HashMap<String,String>();
		 * 
		 * temp.put(planseq[i], seq[i]); seqlist.add(temp); }
		 * 
		 * int r = dao.addseq(seqlist);
		 * 
		 * if(r == planseq.length) { // 완료 페이지로 이동
		 * 
		 * } else { // 실패 -> 페이지 유지 }
		 */
		
		if(list.size() == 0){
			System.out.println("list가 null입니다.");
		}
		req.setAttribute("list", list);
		//RequestDispatcher dispatcher = req.getRequestDispatcher("/map.jsp");
//		todo: 기능 구현 후 아래 planadd.jsp
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/plan/planadd.jsp");
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