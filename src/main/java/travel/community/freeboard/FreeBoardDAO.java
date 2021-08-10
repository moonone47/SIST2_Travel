package travel.community.freeboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import travel.DBUtil;
/**
 * 게시글 DB 질의 처리 클래스
 * @author 김정은
 *private Connection conn
statement 객체 생성을 위한 Connection 객체
Statement stat sql 질의 실행을 위한 객체
PreparedStatement pstat sql 질의 실행을 위한 객체
ResultSet rs sql 질의 실행 후 반환되는 객체
String sql sql문 저장 변수
String where 조건에 따라 다른 where절을 저장하기 위한 변수
{@code ArrayList<FreeBoardDTO> list  while문을 돌며 생성되는 dto객체를 담는 ArrayList 객체}
FreeBoardDTO dto select문의 반환값인 ResultSet객체의 인자값을 옮겨담기 위한 dto 객체


 */
public class FreeBoardDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	/**
	 * FreeBoardDAO 클래스 생성자 메소드
	 */
	public FreeBoardDAO() {
		try {
			conn = DBUtil.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 게시물 추가로  insert 질의를 수행하는 메소드
	 * @param dto
	 * @return int 질의가 실행된 레코드 개수를 반환
	 */
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

	/**
	 * 게시글 조회로 select 질의를 수행하는 메소드
	 * @param map {@code HashMap<String,String>map 검색대상,검색어를 담은 Hashmap}
	 * @return getlist 질의 결과를 반환
	 */
	public ArrayList<FreeBoardDTO> getlist(HashMap<String, String> map) {
		
		try {
			
			String where = "";
			if (map.get("isSearch").equals("y")) {
				//검색
				//where name like '%홍길동%'
				//where subject like '%날씨%'
				//where all like 
				if(map.get("column").equals("all")) {
					where = String.format("and subject like '%%%s%%' or  content like '%%%s%%' ", map.get("search"), map.get("search"));										
				} else {
					where = String.format("and %s like '%%%s%%' ", map.get("column"), map.get("search"));					
				}
			}
			//String sql = "select * from vwFreeBoard order by FREEBOARDSEQ desc";
			
			String sql = String.format("select * from vwFreeBoard where rnum between %s and %s %s order by freeboardseq desc", map.get("begin"), map.get("end"), where);
			
			pstat = conn.prepareStatement(sql);
			
			rs = pstat.executeQuery();
			
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
				
				dto.setCcnt(rs.getString("ccnt"));
				list.add(dto);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * view 및 update에서 게시글 정보 조회를 위해 select 질의를 수행하는 메소드
	 * @param freeboardseq
	 * @return FreeBoardDTO 질의 결과를 반환
	 */
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

	/**
	 * 게시글 수정으로 update 질의를 수행하는 메소드
	 * @param dto
	 * @return int 질의가 실행된 레코드 개수를 반환
	 */
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

	/**
	 * 게시글 삭제로 delete 질의를 수행하는 메소드
	 * @param freeboardseq
	 * @return int 질의가 실행된 레코드 개수를 반환
	 */
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

	/**
	 * 조회수 증가로 update질의를 수행하는 메소드
	 * @param freeboardseq
	 */
	public void updateViewcnt(String freeboardseq) {

		try {
			String sql = "update tblfreeboard set viewcnt= viewcnt+1 where freeboardseq =" + freeboardseq;
			
			stat = conn.createStatement();
			stat.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 총 게시글 개수 구하는 메소드
	 * @param map 검색대상,검색어를 담은 Hashmapp
	 * @return int 질의 결과인 count(*)를 반환 
	 */
	public int getTotalCount(HashMap<String, String> map) {
		
		try {
			
			String where = "";
			
			if (map.get("isSearch").equals("y")) {

				if(map.get("column").equals("all")) {
					where = String.format(" where subject like '%%%s%%' or  content like '%%%s%%' ", map.get("search"), map.get("search"));										
				} else {
					where = String.format(" where %s like '%%%s%%' ", map.get("column"), map.get("search"));					
				}
			}
			
			String sql = String.format("select count(*) as cnt from tblFreeBoard %s" , where);

			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			if(rs.next()) {
				return rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
	
}
