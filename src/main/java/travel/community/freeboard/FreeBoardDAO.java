package travel.community.freeboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import travel.DBUtil;

public class FreeBoardDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	
	public FreeBoardDAO() {
		try {
			conn = DBUtil.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public int add(FreeBoardDTO dto) {

		try {
			String sql = "insert into tblFreeBoard (freeBoardSeq, subject, content, viewcnt, recommcnt, regdate, id) values (seqFreeBoard.nextVal,?,?,default,default,default,?)";		
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getSubject());
			pstat.setString(2, dto.getContent());
			//pstat.setString(3, dto.getId());
			pstat.setString(3, "3");
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}


	public ArrayList<FreeBoardDTO> getlist() {
		
		try {
			
			String sql = "select * from vwFreeBoard order by FREEBOARDSEQ desc";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			ArrayList<FreeBoardDTO> list = new ArrayList<FreeBoardDTO>();
			while(rs.next()) {
				FreeBoardDTO dto = new FreeBoardDTO();
				dto.setFreeboardseq(rs.getString("freeboardseq"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setViewcnt(rs.getString("viewcnt"));
				dto.setRecommcnt(rs.getString("recommcnt"));
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


	public FreeBoardDTO getlist(String freeboardseq) {

		try {
			
			String sql = "select * from vwFreeBoard where freeboardseq = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, freeboardseq);
			
			rs = pstat.executeQuery();
			FreeBoardDTO dto = new FreeBoardDTO();
			
			while(rs.next()) {
				dto.setFreeboardseq(rs.getString("freeboardseq"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setViewcnt(rs.getString("viewcnt"));
				dto.setRecommcnt(rs.getString("recommcnt"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setId(rs.getString("id"));
				dto.setNick(rs.getString("nick"));
				dto.setIsnew(rs.getString("isnew"));
			}
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}


	public int update(FreeBoardDTO dto) {
		try {
			String sql = "update tblFreeBoard set subject = ?, content = ? where freeboardseq=?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getSubject());
			pstat.setString(2, dto.getContent());
			pstat.setString(3, dto.getFreeboardseq());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}


	public int delete(String freeboardseq) {
		try {		
			String sql = "delete from tblFreeBoard where freeboardseq = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, freeboardseq);
			
			return pstat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}


			
		return 0;
	}


	public void updateViewcnt(String freeboardseq) {

		try {
			String sql = "update tblfreeboard set viewcnt= viewcnt+1 where freeboardseq =" + freeboardseq;
			
			stat = conn.createStatement();
			stat.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
