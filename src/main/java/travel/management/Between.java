package travel.management;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * 여행 일정을 클릭했을때 detailview.jsp로 가기 전 중간 페이지를 넣어 새로고침과 뒤로가기에 대응하는 클래스
 */
@WebServlet("/management/between.do")
public class Between extends HttpServlet {

	/**
	 * dao.list(planseq)를 호출하여 ManagementDTO를 저장하고 날짜 계산을 위한 변수를 생성한 뒤 처음 날짜와 끝 날짜의 날짜를 datelist에 저장하고 저장된 모든 정모를 detailview.jsp에 전달한다.
	 * String planseq	getPrameter로 planseq를 받아온다.
	 * ManagementDAO dao	Management DB작업을 위한 DAO 객체
	 * HttpSession session	세션에서 id를 받아오기 위한 변수
	 * String id	id를 저장하는 변수
	 * Arraylist<ManagementDTO> list	ManagementDTO 정보들을 가지고 있는 컬렉션
	 * ManagementDTO plan	planseq에 해당하는 정보를 담은 DTO 객체
	 * String daystarttravel	여행 시작 날짜를 저장하는 변수
	 * String dayendtravl	여행 종료 날짜를 저장하는 변수
	 * Date FirstDate	날짜 계산을 위한 임시변수
	 * Date SecondDate	날짜 계산을 위한 임시 변수
	 * long calDate	두 날짜 사이의 차이를 long으로 저장
	 * long calDateDays	두 날짜 사이의 차이를 일로 변환하여 저장
	 * int cal	calDateDays를 (int)형으로 바꾸고 Math.abs를 적용
	 * Calendar date	Calendar 객체로 날짜를 저장하기 위한 변수
	 * ArrayList<String> datelist	시작날짜와 끝 날짜 사이의 리스트를 문자열로 저장.
	 * String nick	글 쓴 사람의 닉네임을 받아오는 변수
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
		String planseq = req.getParameter("planseq");
		
		ManagementDAO dao = new ManagementDAO();
		
		HttpSession session = req.getSession();
		
		String id = (String)session.getAttribute("id");
		
		
		ArrayList<ManagementDTO> list = dao.getDetailList(id);
		
		ManagementDTO plan = dao.list(planseq);
		
		//System.out.println(plan.getDaystarttravel());
		
		//System.out.println(list.get(1).getPlace_name());
		// 끝 - 시작 = ( 날짜 + 1 )  -> 날짜 ArrayList 만들기
		
		String daystarttravel = plan.getDaystarttravel();
		String dayendtravel = plan.getDayendtravel();	
		
		//System.out.println(daystarttravel);
		//System.out.println(dayendtravel);
		
		//날짜 계산 -> 
		ArrayList<String> datelist = new ArrayList<String>();
		
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
		long calDate = SecondDate.getTime() -FirstDate.getTime(); 
		
		//System.out.println(calDate);
		// Date.getTime() 은 해당날짜를 기준으로1970년 00:00:00 부터 몇 초가 흘렀는지를 반환해준다.
		// 이제 24*60*60*1000(각 시간값에 따른 차이점) 을 나눠주면 일수가 나온다.
		long calDateDays = (calDate  + (24*60*60*1000) ) / (24*60*60*1000);

		calDateDays = Math.abs(calDateDays);

		int cal = (int)calDateDays;
		
		
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
		
		plan.setDayendtravel(plan.getDayendtravel().substring(0,10));
		plan.setDaystarttravel(plan.getDaystarttravel().substring(0,10));
		
		for(ManagementDTO dto : list) {
			dto.setRdate(dto.getRdate().substring(0,10));
		}
		
		//System.out.println(list.get(0).getRdate());
		//System.out.println(datelist.get(0));
		
		String nick = plan.getWriternick();
		
		req.setAttribute("nick", nick);
		req.setAttribute("plan", plan);
		req.setAttribute("list", list);
		req.setAttribute("datelist", datelist);
		req.setAttribute("cal", cal);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/management/detailview.jsp");
		dispatcher.forward(req, resp);
	}

}
