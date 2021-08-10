package travel.mypage;

import travel.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * MypageDAO	DB 연결을 위한 생성자
 * MypageDTO get(String id)	id에 해당하는 정보를 tblMember에서 select한다.
 * int edit(MypageDTO dto)	dto의 정보로 tblMember를 update한다.
 * boolean changePassword(String id, String newPw)	해당 id의 pw를 tblMember에서update한다.
 * boolean deleteMEmber(String id)	해당 id를 tblMember에서 delete한다.
 */
public class MypageDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	/**
	 * DB 연결을 위한 생성자이다.
	 */
	public MypageDAO() {
		
		try {
			conn = DBUtil.open();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * id에 해당하는 정보를 tblMember에서 select한다.
	 * @param id id를 where절의 조건으로 걸어 select *한다.
	 * @return select *의 결과를 MypageDTO에 저장 후 반환한다.
	 */
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


	/**
	 * dto의 정보로 tblMember를 update한다.
	 * @param dto 변경된 회원 정보 값을 가지고 있는 dto이다.
	 * @return update의 결과를 반환한다.
	 */
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


	/**
	 * 해당 id의 pw를 tblMember에서 update한다.
	 * @param id update의 where절의 조건으로 사용될 id이다.
	 * @param newPw 사용자가 입력한 새로운 패스워드로 set pw의 값으로 사용된다.
	 * @return 작업의 결과를 boolean으로 반환한다.
	 */
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


	/**
	 * 해당 id를 tblMember에서 delete한다. 테이블이 꼬일까봐 현재는 pw를 바꾸는 방식으로 변경하였다.
	 * @param id update의 where 조건에 사용될 id이다.
	 * @return update의 결과를 반환한다.
	 */
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
	

