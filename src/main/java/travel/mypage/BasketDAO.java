package travel.mypage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import travel.DBUtil;


public class BasketDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	
	public BasketDAO() {
		try {
			conn = DBUtil.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<BasketDTO> list(HashMap<String, String> map) {

		try {

			// 이 메소드 입장
			// 1. 목록보기
			// 2. 검색하기

			String where = "";

			if (map.get("isSearch").equals("y")) {
				// 검색
				// where name like '%홍길동%'
				// where subject like '%날씨%'
				// where all like '%날씨%'

				if (map.get("column").equals("all")) {
					where = String.format(" and subject like '%%%s%%' or content like '%%%s%%' ", map.get("subject"),
							map.get("search"));
				} else {
					where = String.format(" and %s like '%%%s%%' ", map.get("column"), map.get("search"));
				}

			}

			//페이징 조건 <-> (분리) <-> 검색 조건
			String sql = "select * from tblbasket";
			pstat = conn.prepareStatement(sql);

			rs = pstat.executeQuery();

			ArrayList<BasketDTO> list = new ArrayList<BasketDTO>(); // 옮겨 담을 큰상자

			while (rs.next()) {

				// 레코드 1줄 -> BoardDTO 1개
				BasketDTO dto = new BasketDTO();

				dto.setBasketseq(rs.getString("basketseq"));
				// dto.setId(rs.getString("id"));
				dto.setId(rs.getString("id"));
//				dto.setSubject(rs.getString("subject"));
				dto.setTourseq(rs.getString("tourseq"));
				
				
				list.add(dto);

			}

			return list;

		} catch (Exception e) {
			System.out.println("BoardDAO.list()");
			e.printStackTrace();
		}

		return null;
	}
	
	public int getTotalCount(HashMap<String, String> map) {

		try {
			
			String where = "";

			if (map.get("isSearch").equals("y")) {
				// 검색
				// where name like '%홍길동%'
				// where subject like '%날씨%'
				// where all like '%날씨%'

				if (map.get("column").equals("all")) {
					where = String.format(" where subject like '%%%s%%' or content like '%%%s%%' ", map.get("subject"),
							map.get("search"));
				} else {
					where = String.format(" where %s like '%%%s%%' ", map.get("column"), map.get("search"));
				}

			}
			
			String sql = String.format("select count(*) as cnt from tbltravelclubboard %s", where); //게시물 수
			
			pstat = conn.prepareStatement(sql);
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				return rs.getInt("cnt");
			}
			
			
			
		} catch (Exception e) {
			System.out.println("BoardDAO.getTotalCount()");
			e.printStackTrace();
		}
		
		
		
		return 0;
	}
	
	
	/*
	 * public String getName() { String sql =
	 * "select name from tblTour where tourseq = ?";
	 * 
	 * pstat = conn.prepareStatement(sql);
	 * 
	 * try { pstat = conn.prepareStatement(sql); pstat.setString(1,
	 * dto.getTourseq());
	 * 
	 * 
	 * 
	 * 
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * return flag; } }
	 */
	
	/*
	 * public BasketDTO get(String tourseq) { try {
	 * 
	 * String sql = "select * from tblTour where tourseq=?";
	 * 
	 * pstat = conn.prepareStatement(sql); pstat.setString(1, tourseq);
	 * 
	 * rs = pstat.executeQuery();
	 * 
	 * if (rs.next()) {
	 * 
	 * BasketDTO dto = new BasketDTO();
	 * 
	 * dto.setName(rs.getString("name")); dto.setValidDate("validDate");
	 * 
	 * 
	 * return dto; } } catch (Exception e) { e.printStackTrace(); } return null; }
	 */

	
}













