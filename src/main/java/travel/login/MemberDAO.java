package travel.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import travel.DBUtil;

/**
 * 회원 정보 DAO
 * @author 이준희 
 *
 */

public class MemberDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	  public MemberDAO() {
	        try {
	            conn = DBUtil.open("183.100.233.88", "sist2_travel", "java1234");
//	            conn = DBUtil.open();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	  

/**
 * DB에서 회원정보 가지고 오는 메소드
 * @param dto
 * @return 회원 id, name
 */
	public MemberDTO login(MemberDTO dto) {
		try {
			
			String sql = "select * from tblmember where id= ? and pw = ?";
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				MemberDTO result = new MemberDTO();
				
				//인증티켓 발급 
				result.setId(rs.getString("id"));
				result.setPw(rs.getString("lv"));
				result.setName(rs.getString("name"));
				
				return result;
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
