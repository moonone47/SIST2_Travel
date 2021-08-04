package travel.plan;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/plan/plandone.do")
public class PlanDone extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
//        req.setAttribute("?", )
		/*
		일정 계획 완료
		1) 순서 넣어주기 tblPlan2에 seq 컬럼에 추가해준다.
		        <input type="hidden" name="planseq" value="${dto.planseq}"> -> tblPlan2 planseq
                <input type="hidden" name="seq" value="">                  -> 히든 태그로 seq

		2) tblPlan2에 있는 걸 조건문 걸어서 음식점/명소/숙소로 쪼개서 넣는다.
		이때  : hidden태그에 숨어있는 순서와, 일정seq를 서블릿으로 보낸 후 session에 있는 planseq(tblPlan)-> 전체 일정 seq를 다 넣어준다.
		
		3) tblPlan2에 있는 id, rdate의 레코드들을 삭제한다.

		*/
//		1) 순서 넣어주기 tblPlan2에 seq 컬럼에 추가해준다.
        //planseq	[i]	1 2 3 4 5 6 789
        //seq			1 2 6 7 3 4 589
        //              0 1 2 3 4 5 6 7 8
        String[] planseq = req.getParameterValues("planseq");
        String[] seq = req.getParameterValues("seq");
        PlaceDAO dao = new PlaceDAO();

        PlaceDTO dto = new PlaceDTO();


        //tblPlan2 -> seq -> 1로 통일 -> seq[i]로 바꿔주기
        for (int i = 0; i < planseq.length; i++) {
            dao.update(planseq[i], seq[i]);
            //planseq[i] -> where절걸고
            //seq[i] ->
        }


        //AT4 관광명소
        //AD5 숙박
        //FD6 음식점

        HttpSession session = req.getSession();
        String tblplanseq= session.getAttribute("planseq") + "";
        String memberid = session.getAttribute("id") + "";
        for (int i = 0; i < planseq.length; i++) {
            dto = dao.split(planseq[i]);

            if (dto.getCategory_group_code().equals("AT4")) { 
                dao.addAT4(dto,tblplanseq,memberid);
            } else if (dto.getCategory_group_code().equals("AD5")) {
                dao.addAD5(dto,tblplanseq,memberid);
            } else if (dto.getCategory_group_code().equals("FD6")) {
                dao.addFD6(dto,tblplanseq, memberid);
            }else{
                System.err.println("잘못됨..");
            }
            
            dao.removeAll(planseq[i]);
        }
        
        
/*
 for(day){
	for(){
	 day1
	}
}

//todo: 전체 일정 추가로 변경
1 2 3
1 -> 순서 다 바꿔 놓음,() -> palndone을 들리게끔 -> 2일차 일정 짜고 순서바꾸고 -> ///
//일정등록 -> 하루치 day1 , day2 -> for하나더해서 전체 일정을 등록하도록...
//for문 -> 1day 클릭하는 함수를 불러오고 리스트 받고
// -> day1 날짜 버튼(plandone.update())-> day2
 */


        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/plan/plandone.jsp");
        dispatcher.forward(req, resp);
    }

}
















