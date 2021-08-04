package travel.plan;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@WebServlet("/plan/between.do")
public class Between extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String planseq = req.getParameter("planseq");
		
		
		PlanInfoDAO dao = new PlanInfoDAO();
		PlanInfoDTO citydto = new PlanInfoDTO();
		
		citydto = dao.getlist(planseq);
		
		String isedit = req.getParameter("isedit");
		ArrayList<String> datelist = new ArrayList<String>();
		
		
		if(isedit == null || isedit.equals("")) {
			
			String startday = citydto.getDaystarttravel();
			String endday = citydto.getDayendtravel();			
			
			//daystrattravel , dayendtravel -> 날짜 계산
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			// date1, date2 두 날짜를 parse()를 통해 Date형으로 변환.
			Date FirstDate = null;
			try {
				FirstDate = format.parse(startday);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Date SecondDate = null;
			try {
				SecondDate = format.parse(endday);
			} catch (ParseException e) {
				e.printStackTrace();
			}
	
			// Date로 변환된 두 날짜를 계산한 뒤 그 리턴값으로 long type 변수를 초기화 하고 있다.
			// 연산결과 -950400000. long type 으로 return 된다.
			long calDate = FirstDate.getTime() - SecondDate.getTime();
	
			// Date.getTime() 은 해당날짜를 기준으로1970년 00:00:00 부터 몇 초가 흘렀는지를 반환해준다.
			// 이제 24*60*60*1000(각 시간값에 따른 차이점) 을 나눠주면 일수가 나온다.
			long calDateDays = calDate / ( 24*60*60*1000);
	
			calDateDays = Math.abs(calDateDays);
	
			Calendar date = Calendar.getInstance();
			Calendar sdate = Calendar.getInstance();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	
	//		startday 20210714
			int year = Integer.parseInt(startday.substring(0,4));
			int month = Integer.parseInt(startday.substring(4, 6)) ;
			int day = Integer.parseInt(startday.substring(6));
			sdate.set(year, month-1, day);
			date.set(year, month-1, day-1);
	
	//		for(int i=0; i<calDateDays; i++){
	//			date.add(Calendar.DATE, 1);
	//			String dated = df.format(date.getTime());
	//			datelist.add(dated);
	//		}
	
			String rdate = df.format(sdate.getTime());
	
			int eyear = Integer.parseInt(endday.substring(0,4));
			int emonth = Integer.parseInt(endday.substring(4, 6)) ;
			int eday = Integer.parseInt(endday.substring(6));
			Calendar endDay = Calendar.getInstance();
			endDay.set(eyear, emonth-1, eday-1);
			while(true){
				if(endDay.before(date)){
					break;
				}
	//			if(date > date.add(Calendar.DATE, calDateDays +1)
				date.add(Calendar.DATE, 1);
				String dated = df.format(date.getTime());
				datelist.add(dated);
			}
	
			
		} else {
			
			PlanInfoDTO plan = dao.getlist(planseq);
			String daystarttravel = plan.getDaystarttravel();
			String dayendtravel = plan.getDayendtravel();	
			
			//날짜 계산 -> 

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); //yyyy-MM-dd hh:mm:ss
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
			cal += 2;

			//20210803
			Calendar date = Calendar.getInstance(); //yyyy-mm-dd
			int year = Integer.parseInt(daystarttravel.substring(0,4));
			int month = Integer.parseInt(daystarttravel.substring(5, 7));
			int day = Integer.parseInt(daystarttravel.substring(8,10));
			date.set(year, month-1, day);
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			
			for(int i=0; i<cal; i++) {
				String dated = df.format(date.getTime());
				datelist.add(dated);
				date.add(Calendar.DATE, 1);			
			}	
			
		}
		
		
		//분류별로 저장
//		req.setAttribute("dto",dto);

		CityDAO cdao = new CityDAO();
		CityDTO city = cdao.getCity(citydto.getCityseq());


		req.setAttribute("city",city); //도시 좌표
		req.setAttribute("citydto",citydto); //일정에 채워 넣을 용
//		req.setAttribute("days", calDateDays); //전체 일정 날짜
		req.setAttribute("datelist", datelist);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/plan/planadd.jsp");
		dispatcher.forward(req, resp);
	}

}
