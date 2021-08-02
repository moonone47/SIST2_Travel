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
	
	
	
	
}
