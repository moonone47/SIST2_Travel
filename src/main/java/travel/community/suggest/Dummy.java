package travel.community.suggest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;
import travel.DBUtil;

/**
 * @author 문지원
 * 게시글 데이터를 만들기 위한 데이터

	String[] id				id를 담은 배열
	String[] subject		제목을 담은 배열
	String content			게시글 내용을 담은 배열
	int thread				thread값을 저장 
	Random rnd				랜덤으로 배열에 값을 생성한다.
	Connection conn			DB접속을 돕는 conn 객체 생성
	PreparedStatement stat	sql 구문을 실행한다.
	String sql				tblsuggestBoard에 값을 insert하는 sql 구문

 */
public class Dummy {
	public static void main(String[] args) {
		
		//글쓰기 더미 
		String[] id = {"1", "2","3","4","5"};
		String[] subject = {"게시판 테스트입니다.",
							"게시판 만드는중.",
							"구현 진짜 어렵네요",
							"건의합니다",
							"이런 기능이 있으면 좋을 것 같아요",
							"자유게시판 불편해요",
							"계획 기능 추가해주세요",
							"이 기능 없는 것 같아요",
							"기능 추가 부탁드립니다.",
							"이거 있으면 좋을 것 같습니다",
							"건의",
							"이런 기능은 어떨까요",
							"페이지 디자인도 신경쓰셨으면...",
							"수정 요청",
							"예약 관련 건의드립니다.",
							"마이페이지에 기능 추가해주세요",
							"지도에 사람모양 찍혔으면 좋겠어요",
							"지도 추가해주세요",
							"색상 변경은 안되는 건가요?",
							"이 점은 바뀌었으면 합니다."};
		String content = "내용입니다.";
		int thread = 0;

		
		Random rnd = new Random();
		
		Connection conn = null;
		PreparedStatement stat= null;
		
		try {
			conn = DBUtil.open();
			
			String sql = 
			"insert into tblsuggestBoard (suggestseq,subject,content,viewcnt,recommcnt,thread,depth,regdate,id) "
			+ "values (seqsuggestBoard.nextval, ?,?,default,default,?,?,default,?)";
			
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