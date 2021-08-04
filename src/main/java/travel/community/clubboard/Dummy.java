package travel.community.clubboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

import travel.DBUtil;

public class Dummy {
	
	public static void main(String[] args) {
		
		//글쓰기(게시물) 더미 만들기
		String[] id = {"1", "2", "3", "4", "5"};
		String[] subject = {"양양으로 떠나는 여행", 
							"제주도 여행 가실분~~", 
							"여행 친구 구해요", 
							"여행 메이트 찾아요!!", 
							"속초 여행 메이트 찾아요 ", 
							"강릉 같이 가실분",
							"보성 메이트 구함.",
							"여행 같이 가요",
							"전주 여행 갈 사람~!", 
							"친구 구해여", 
							"경주 맛집 뿌시러 가실 분!",
							"강화도나 김포 사시는 분?", 
							"충주 여름 여행 같이 떠나요", 
							"여수 갈 사람", 
							"경주 갈 사람", 
							"시골 여행 갈 사람",
							"여행 친구 구합니다~~~~",
							"친구 만들고 싶어요"};
		
		String content = "내용입니다.";
//		String tag = "n";
		
		Random rnd = new Random();
		
		Connection conn = null;
		PreparedStatement stat = null;
		
		try {
			
			String sql = "insert into tbltravelclubboard (travelclubseq, subject, content, viewcnt, recommcnt, regdate, id, thread, depth)"
					+ "values (seqtravelclubboard.nextVal, ?, ?, default, default, default, ?, ?, ?)";
			
			conn = DBUtil.open();
			stat = conn.prepareStatement(sql);
			
			int thread = 3000;
			
			for(int i=0; i<100; i++) {
				
				thread += 1000;
				
				stat.setString(1, subject[rnd.nextInt(subject.length)]);
				stat.setString(2, content);
				stat.setString(3, id[rnd.nextInt(id.length)]);
				stat.setInt(4, thread);
				stat.setInt(5, 0);
				
				stat.executeUpdate();
				
				System.out.println(i + "번째 게시물 작성 완료");
			}
			
			
		} catch (Exception e) {
			System.out.println("Dummy.main()");
			e.printStackTrace();
		}
		
		
		
	}

}





