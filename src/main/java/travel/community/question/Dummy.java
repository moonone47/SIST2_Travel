package travel.community.question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;
import travel.DBUtil;

/**
 * 게시글 더미 작성 서블릿 
 * @author 이준희
 *
 */
public class Dummy {
	public static void main(String[] args) {
		
		//글쓰기 더미 
		String[] id = {"2","3","4","5"};
		String[] subject = {"강릉까지 몇시간 걸리나요?",
							"제주도에서 가격 저렴한 숙소 어딘가요?",
							"양양에서 서핑샵 추천 !!",
							"가평 가볼만한 곳 추천드려요 ",
							"잠실 맛집 아시는분? ",
							"인천 좋은 숙소 있나요? ",
							"코로나 확진자가 줄어들지를 않네요 ㅠㅠ ",
							"비행기 싸게 구하는법 알려드림 ",
							"수산시장가서 호갱 안당하는법 ",
							"부산가서 꼭 가봐야할 맛집 베스트 5",
							"대구 숨겨진 명소 3곳 ",
							"부산에서 배타고 제주도 가는법 공유! ",
							"해외 여행은 언제쯤 갈수잇을까요 ㅠ "};
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
			
			for(int i = 0; i<30; i++) {
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

