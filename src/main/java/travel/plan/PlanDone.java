package travel.plan;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/plan/plandone.do")
public class PlanDone extends HttpServlet {

	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

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
		for(int i=0; i<planseq.length; i++){
			System.out.println(planseq[i]);	//161 191 192 193
			System.out.println(seq[i]);	// 1 2 3 4
			dao.update(planseq[i],seq[i]);
			//planseq[i] -> where절걸고
			//seq[i] -> 
		}





		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/plan/plandone.jsp");
		dispatcher.forward(req, resp);
	}

}
















