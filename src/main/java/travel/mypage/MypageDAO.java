package travel.mypage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
	
	//Profile.java
	public MypageDTO get(String id) {	
		try {

			String sql = "select * from tblMember where id=?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				MypageDTO dto = new MypageDTO();
				
				dto.setId("id");
				dto.setName(rs.getString("name"));
				dto.setNick(rs.getString("nick"));
				dto.setEmail(rs.getString("email"));
				dto.setPhone(rs.getString("phone"));
				dto.setZip(rs.getString("zip"));
				dto.setAddress(rs.getString("address"));
				dto.setLv(rs.getString("lv"));
				dto.setBirthday(rs.getString("birthday"));
				dto.setGender(rs.getString("gender"));
				
				return dto;			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return null;
	}	
	
	
	//Editprofileok.java
	public int edit(MypageDTO dto) {
		try {
//			java.sql.SQLException: ORA-01407: cannot update ("SIST2_TRAVEL"."TBLMEMBER"."NAME") to NULL
			String sql = "update tblmember set name = ?, nick = ?, email = ?, phone = ?,"
					+ "zip = ?, address = ?, birthday = ?, gender = ? where id = ?";
			
			pstat = conn.prepareStatement(sql);
			System.out.println(dto.getName());
			pstat.setString(1, dto.getName());
			pstat.setString(2, dto.getNick());
			pstat.setString(3, dto.getEmail());
			pstat.setString(4, dto.getPhone());
			pstat.setString(5, dto.getZip());
			pstat.setString(6, dto.getAddress());
			pstat.setString(7, dto.getBirthday());
			pstat.setString(8, dto.getGender());
			pstat.setString(9, dto.getId());
			
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
		
	
		//회원 탈퇴 
		public boolean deleteMember(String id) {

			boolean flag = false;
			String sql = "update tblMember set pw=123456789 where id=?";


			try {
				pstat = conn.prepareStatement(sql);
				pstat.setString(1, id);
				
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


}
	

