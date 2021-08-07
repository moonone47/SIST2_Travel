package travel.community.freeboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import travel.DBUtil;
/**
 * 댓글 DB 질의 처리 클래스
 * @author 김정은
 *
 */
public class FreeBoardCommentDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	/**
	 * FreeBoardCommentDAO 클래스 생성자 메소드
	 * 
	 */
	public FreeBoardCommentDAO() {
		try {
			conn = DBUtil.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 댓글 추가로 insert 질의를 수행하는 메소드
	 * @param dto
	 * @return int 질의가 실행된 레코드 개수를 반환

	 */
	public int add(FreeBoardCommentDTO dto) {

		try {
			String sql = "insert into tblFreeComment (freeCommentSeq, regdate, content, freeboardseq, id) values (seqFreeComment.nextVal,default,?,?,?)";		
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getContent());
			pstat.setString(2, dto.getFreeboardseq());
			//pstat.setString(3, dto.getId());
			pstat.setString(3, "3");
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}



	/**
	 * 댓글 리스트 조회로 select 질의를 수행하는 메소드
	 * @param freeboardseq
	 * @return ArrayList<FreeBoardCommentDTO> 질의 결과를 반환
	 */
	public ArrayList<FreeBoardCommentDTO> getlist(String freeboardseq) {
		try {
			
			String sql = "select * from vwFreeComment where freeboardseq = ? order by freecommentseq asc";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, freeboardseq);
			
			rs = pstat.executeQuery();
			ArrayList<FreeBoardCommentDTO> list = new ArrayList<FreeBoardCommentDTO>();
			while(rs.next()) {
				FreeBoardCommentDTO dto = new FreeBoardCommentDTO();
				dto.setFreeboardseq(rs.getString("freeboardseq"));
				dto.setFreecommentseq(rs.getString("freecommentseq"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setId(rs.getString("id"));
				dto.setNick(rs.getString("nick"));
				dto.setIsnew(rs.getString("isnew"));
				list.add(dto);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 댓글 삭제로 delete 질의를 수행하는 메소드
	 * @param freecommentseq
	 */
	public void del(String freecommentseq) {
		
		try {		
			String sql = "delete from tblFreeComment where freecommentseq = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, freecommentseq);
			
			pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
}
