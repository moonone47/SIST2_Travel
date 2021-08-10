package travel.plan;

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

@WebServlet("/plan/planinfo.do")
public class PlanInfo extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		PlanInfoDAO dao = new PlanInfoDAO();
		PlanInfoDTO citydto = new PlanInfoDTO();

//		System.out.println("cs :" + req.getParameter("cityseq"));
//		System.out.println(req.getParameter("daystarttravel"));
//		System.out.println(req.getParameter("dayendtravel"));
//		System.out.println(req.getParameter("name"));
		//System.out.println(req.getParameter("planseq"));
//		System.out.println(req.getParameter("willshare"));
		String startday = req.getParameter("daystarttravel");
		String endday = req.getParameter("dayendtravel");

		citydto.setCityseq(req.getParameter("cityseq")); //13번으로 고정정.됨
		citydto.setDaystarttravel(req.getParameter("daystarttravel"));
		citydto.setDayendtravel(req.getParameter("dayendtravel"));
		citydto.setName(req.getParameter("name"));
		//dto.setPlanseq(req.getParameter("planseq"));
		
//		System.out.println(req.getParameter("willshare"));

//		System.out.println(req.getParameter("citys"));

		
			if(req.getParameter("willshare") != null) {
				if (req.getParameter("willshare").equals("y") && req.getParameter("willshare") != null && req.getParameter("willshare") != "") {
					citydto.setWillshare(req.getParameter("willshare"));
				} else {
					citydto.setWillshare("n");
				}
				citydto.setWillshare("n");
			}
//			[travel.plan.CityDTO@45c06dde, travel.plan.CityDTO@3415498e, travel.plan.CityDTO@38a5a859,
//			travel.plan.CityDTO@1c65f3ea, travel.plan.CityDTO@5a8dd325, travel.plan.CityDTO@44caa8c3, travel.plan.CityDTO@51383763, travel.plan.CityDTO@6271740d, travel.plan.CityDTO@56d1979d, travel.plan.CityDTO@47ccb134, travel.plan.CityDTO@575f1581, travel.plan.CityDTO@3e67d27b, travel.plan.CityDTO@6450d755, travel.plan.CityDTO@46379ffa, travel.plan.CityDTO@696b69a0, travel.plan.CityDTO@691f9afc]

		int planseq = dao.add(citydto);


		
		HttpSession session = req.getSession();
		
		session.setAttribute("planseq", planseq);

		//todo : daystrattravel , dayendtravel -> 날짜 계산
//		System.out.println(startday);
//		System.out.println(endday);
//		20210714
//20210722



		 SimpleDateFormat format = new SimpleDateFormat("yyyymmdd");
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
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		startday 20210714
		int year = Integer.parseInt(startday.substring(0,4));
		int month = Integer.parseInt(startday.substring(4, 6));
		int day = Integer.parseInt(startday.substring(6));
		date.set(year, month, day);
		ArrayList<String> datelist = new ArrayList<String>();

		for(int i=0; i<calDateDays; i++){
			date.add(Calendar.DATE, 1);
			String dated = df.format(date.getTime());
			datelist.add(dated);
		}

//		System.out.println(date);
		//분류별로 저장

//		req.setAttribute("dto",dto);

		CityDAO cdao = new CityDAO();

		CityDTO city = cdao.getCity(citydto.getCityseq());



		req.setAttribute("city",city); //도시 좌표
		req.setAttribute("citydto",citydto); //일정에 채워 넣을 용
		req.setAttribute("datelist", datelist);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/plan/planadd.jsp");
		dispatcher.forward(req, resp);
	}



	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = req.getRequestDispatcher("/plan/plan.do");
		dispatcher.forward(req, resp);
	}

}