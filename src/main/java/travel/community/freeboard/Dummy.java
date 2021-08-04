package travel.community.freeboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

import travel.DBUtil;

public class Dummy {
	
	public static void main(String[] args) {
		
		String[] id = {"1", "2", "3", "4", "5"};
		String[] subject = {"여행 너무 땡기네요",
							"다들 여름 휴가 어디로 가시나요",
							"휴가인데 일하는 거 실화?",
							"오늘 중복이래요~",
							"치킨 먹자 치킨!!",
							"여름 휴가지 추천 좀 해주세요~",
							"서울 호캉스 어디가 좋나요??",
							"춘천 닭갈비 맛집 추천드립니다",
							"부산하면 뭐가 맛있죠?",
							"다들 코로나 조심하세요~",
							"여행가고 싶다",
							"떠나요~~제주도~~~",
							"운전 연수 받아서 여행가려고 합니다",
							"여름 언제 끝나!!",
							"가을 보고 싶어~~",
							"지금 바로 떠나고 싶네요",
							"여행병 걸렸는데 어떻게 하죠..",
							"오늘 제주도 예약했네요",
							"요즘 제주도 비행기값 얼마나 하죠?",
							"제주도 렌트하려는데 렌트비 비싼가요?",
							"속초 양양 너무 좋네요"};
		
		String content = "다들 행복하세요~~";

		Random rnd = new Random();
		
		Connection conn = null;
		PreparedStatement stat = null;
		
		try {
			String sql = "insert into tblfreeboard (freeboardseq, subject, content, viewcnt, recommcnt, regdate, id) values (seqFreeBoard.nextVal,?,?,default,default,default,?)";
			conn = DBUtil.open();
			
			stat = conn.prepareStatement(sql);
			
			for(int i=0; i<50; i++) {
				
				stat.setString(1, subject[rnd.nextInt(subject.length)]);
				stat.setString(2, content);
				stat.setString(3, id[rnd.nextInt(id.length)]);
				
				stat.executeUpdate();
				
				System.out.println(i + "번째 게시물 작성 완료");
			}
			
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("Dummy.main()");
			e.printStackTrace();
		}
	}
}