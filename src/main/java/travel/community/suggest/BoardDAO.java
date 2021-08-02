package travel.community.suggest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import travel.DBUtil;

public class BoardDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public BoardDAO() {
		
		try {
			conn = DBUtil.open();
		} catch (Exception e) {
			System.out.println("BoardDAO.BoardDAO()");
			e.printStackTrace();
		}
		
	}
	
	//AddOk에서 게시글 작성 
	public int add(BoardDTO dto) {
		
		try {
			
			String sql = "insert into tblsuggestBoard (suggestSeq, subject, content, viewcnt, recommcnt, regdate, id)"
					+ "values(seqSuggestBoard.nextVal, ?, ?, default, default, default, ?)";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getSubject());
			pstat.setString(2, dto.getContent());
			pstat.setString(3, dto.getId());
			
			return pstat.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	//List에서 글 목록을 배열에 담음
	public ArrayList<BoardDTO> list() {
		
		try {
			
			String sql = "select * from vwSuggestBoard";
			
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
			
			while (rs.next()) {
				
				//레코드 1줄이 BoardDTO 1개
				BoardDTO dto = new BoardDTO();
				
				dto.setSuggestSeq(rs.getString("suggestseq"));
				dto.setSubject(rs.getString("subject"));
				dto.setName(rs.getString("name"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setViewcnt(rs.getString("viewcnt"));
				dto.setRecommcnt(rs.getString("recommcnt"));
				dto.setIsnew(rs.getString("isnew"));
				
				list.add(dto);				
			}
			return list;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	//View에서 글번호에 맞는 레코드 내용을 담아갈 것
	public BoardDTO get(String suggestSeq) {
		
		try {
			
			String sql = "select s.* (select name from tblmember where id = s.id) as name"
					+	"from tblsuggestBoard s where suggestSeq=?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, suggestSeq);
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				BoardDTO dto = new BoardDTO();
				
				dto.setSuggestSeq(rs.getString("suggestSeq"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setViewcnt(rs.getString("viewcnt"));
				dto.setRegdate(rs.getString("regdate"));
				
				return dto;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//View가 주는 글번호에 조회수를 + 1
	public void updateReadcount(String suggestSeq) {
		
		
	}

}
















