package travel.community.question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;
import travel.DBUtil;

public class Dummy {
	public static void main(String[] args) {
		
		//글쓰기 더미 
		String[] id = {"1", "2","3","4","5"};
		String[] subject = {"게시판 테스트입니다.",
							"JSP/Servlet 게시판 만드는중.",
							"페이징 구현 ?",
							"오후 9시 이미 역대 최다 확진 ",
							"현대차,정년연장 떼고 3년 연속 ",
							"손흥민 이번 계약 대박 속보입수 ",
							"메디컬까지 완료했는데",
							"라멜라 영입 임박",
							"웨스트햄 재계약 2번",
							"호날두 미스터리",
							"레길론 라멜라",
							"호나우지뉴 엘클라시코 레전드 매치",
							"맨유, 토트넘제치고 코파 우승 수비수 영입 ",
							"비니시우스,맨유 안간다 ",
							"멤피스 뎀파이, 바르셀로나 훈련 합류",
							"도쿄올림픽 출전 불발된 정우영",
							"공격보강 원하는 리버풀",
							"코로나확진 대거발생 아스널",
							"황인범 다음시즌도 등번호 6번",
							"기상천외한 골 세리머니"};
		String content = "내용입니다.";
		String tag = "n";
		int thread = 0;

		
		Random rnd = new Random();
		
		Connection conn = null;
		PreparedStatement stat= null;
		
		try {
			conn = DBUtil.open();
			
			String sql = 
			"insert into tblquestion (questionseq,subject,content,viewcnt,recommcnt,thread,depth,regdate,id) "
			+ "values (seqquestion.nextval, ?,?,default,default,?,?,default,?)";
			
			stat = conn.prepareStatement(sql);
			
			for(int i = 0; i<150; i++) {
				thread += 1000;
				
				stat.setString(1, subject[rnd.nextInt(subject.length)]);
				stat.setString(2, content);
				stat.setInt(3, thread);
				stat.setInt(4, 0);
				stat.setString(5, id[rnd.nextInt(id.length)]);
				
				stat.executeUpdate();
				
				System.out.println(i+"번째 게시물 작성 완료");
				
			}
			stat.close();
			conn.close();
			
			
			
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}

