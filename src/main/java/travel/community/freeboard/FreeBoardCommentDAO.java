package travel.community.freeboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import travel.DBUtil;

public class FreeBoardCommentDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	
	public FreeBoardCommentDAO() {
		try {
			conn = DBUtil.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


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




	public ArrayList<FreeBoardCommentDTO> getlist(String freeboardseq) {
		try {
			
			String sql = "select * from vwFreeComment where freeboardseq = ? order by freecommentseq desc";
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


	public void del(String freecommentseq) {
		
		try {		
			String sql = "delete from tblFreeComment where freecommentseq = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, freecommentseq);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
}
