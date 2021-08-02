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
			
			String sql = "select s.*, (select name from tblMember where id = s.id) as name"
					+ " from tblsuggestBoard s where suggestSeq=?";
			
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
		
		try {
			
			String sql = "update tblsuggestBoard set viewcnt = viewcnt + 1 where suggestSeq=?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, suggestSeq);
			
			pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

	//DelOk에서 글번호에 맞는 글을 삭제
	public int del(String suggestSeq) {
		
		try {
			
			String sql = "delete from tblsuggestBoard where suggestSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, suggestSeq);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	
	//EditOk에서 수정할 DTO를 받아서 UPDATE
	public int edit(BoardDTO dto) {
		
		try {
			
			String sql = "update tblsuggestBoard set subject = ?, content = ? where suggestSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getSubject());
			pstat.setString(2, dto.getContent());
			pstat.setString(3, dto.getSuggestSeq());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	//AddComment 댓글을 insert
	public int addComment(CommentDTO dto) {
		
		try {
			
			String sql = "insert into tblsuggestComment (suggestCommentSeq, content, regdate, suggestSeq, id)"
					+	"values(seqSuggestComment.nextVal, ?, default, ?, ?)";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getContent());
			pstat.setString(2, dto.getSuggestSeq());
			pstat.setString(3, dto.getId());
			
			return pstat.executeUpdate();
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	//View 댓글 목록 select
	public ArrayList<CommentDTO> listComment(String suggestSeq) {
		
		try {

			String sql = "select sc.*, (select name from tblmember where id = sc.id) as name "
					+ "from tblsuggestComment sc where suggestSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, suggestSeq);
			
			rs = pstat.executeQuery();
			
			ArrayList<CommentDTO> clist = new ArrayList<CommentDTO>();
			
			while (rs.next()) {
				//레코드 1줄 -> DTO 1개
				CommentDTO dto = new CommentDTO();
				
				dto.setSuggestCommentSeq(rs.getString("suggestCommentSeq"));
				dto.setContent(rs.getString("content"));
				dto.setId(rs.getString("id"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setSuggestSeq(rs.getString("suggestSeq"));
				dto.setName(rs.getString("name"));
				
				clist.add(dto);
			}
			return clist;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		}

	
	//DelOk 글번호를 줄테니 댓글을 delete
	public int delComment(String suggestCommentSeq) {
		
		try {

			String sql = "delete from tblsuggestComment where suggestCommentSeq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, suggestCommentSeq);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
}














