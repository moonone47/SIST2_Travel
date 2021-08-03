package travel.management;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/management/travelplan.do")
public class TravelPlan extends HttpServlet {

	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 여행관리에 여행 내역 전체 조회 
		//http://localhost:8090/SIST2_Travel/management/travelplan.do 
		
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id"); 
		
		String name = req.getParameter("name");
		String daystarttravel = req.getParameter("daystarttravel");
		String dayendtravel = req.getParameter("dayendtravel");
		String cityname = req.getParameter("cityname");		
		
		ManagementDAO dao = new ManagementDAO();
		
		ArrayList<ManagementDTO> list = dao.getlist("3"); // 3에 id 넣자	
			
		//날짜 계산 -> 
		ArrayList<String> datelist = new ArrayList<String>();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd hh:mi:ss");
		// date1, date2 두 날짜를 parse()를 통해 Date형으로 변환.
		Date FirstDate = null;
		try {
			FirstDate = format.parse(daystarttravel);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date SecondDate = null;
		try {
			SecondDate = format.parse(dayendtravel);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// Date로 변환된 두 날짜를 계산한 뒤 그 리턴값으로 long type 변수를 초기화 하고 있다.
		// 연산결과 -950400000. long type 으로 return 된다.
		long calDate = FirstDate.getTime() - SecondDate.getTime();

		// Date.getTime() 은 해당날짜를 기준으로1970년 00:00:00 부터 몇 초가 흘렀는지를 반환해준다.
		// 이제 24*60*60*1000(각 시간값에 따른 차이점) 을 나눠주면 일수가 나온다.
		long calDateDays = (calDate + (24*60*60*1000)) / (24*60*60*1000);

		calDateDays = Math.abs(calDateDays);

		int cal = (int)calDateDays;
		
		Calendar date = Calendar.getInstance();
		int year = Integer.parseInt(daystarttravel.substring(0,4));
		int month = Integer.parseInt(daystarttravel.substring(4, 6)) ;
		int day = Integer.parseInt(daystarttravel.substring(6));
		date.set(year, month-1, day);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		for(int i=0; i<cal; i++) {
			
			String dated = df.format(date.getTime());
			datelist.add(dated);
			date.add(Calendar.DATE, 1);			
		}
		
		
		req.setAttribute("list", list);
		req.setAttribute("datelist", datelist);
		
		
		//travelplan.jsp - SIST2_Travel/src/main/webapp/WEB-INF/views/management
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/management/detailview.jsp");
		dispatcher.forward(req, resp);

	}//doGet

}//class









