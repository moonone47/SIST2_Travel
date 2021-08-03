package travel.mypage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import travel.DBUtil;

public class MypageDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public MypageDAO() {
		
		try {
			conn = DBUtil.open();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Editprofileok에서 내용수정
	public int edit(MypageDTO dto) {
		try {
			
			String sql = "update tblmember set id = ?, name = ?, nick = ?, email = ?, phone = ?,"
					+ "zip = ?, address = ?, birthday = ?, gender = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getName());
			pstat.setString(3, dto.getNick());
			pstat.setString(4, dto.getEmail());
			pstat.setString(5, dto.getPhone());
			pstat.setString(6, dto.getZip());
			pstat.setString(7, dto.getAddress());
			pstat.setString(8, dto.getBirthday());
			pstat.setString(9, dto.getGender());
			
			return pstat.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	//비밀번호 수정을 위한 메서드 선언.
		public boolean changePassword(String id, String newPw) {

			boolean flag = false;
			String sql = "UPDATE tblMember "
					+ "SET pw=? WHERE id=?"; 


			try {
				pstat = conn.prepareStatement(sql);
				pstat.setString(1, newPw);
				pstat.setString(2, id);

				int i = pstat.executeUpdate();

				if(i == 1) {
					flag = true;
				} else {
					flag = false;
				}			
			} catch (Exception e) {
				e.printStackTrace();
			} 

			return flag;
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
	
}
