package travel.login;

import travel.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/**
 * DB 연결을 위한 생성자
 * @author 문지원
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
	 * @author 문지원
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

			if (rs.next()) {
				MemberDTO result = new MemberDTO();

				//인증티켓 발급 
				result.setId(rs.getString("id"));
				result.setLv(rs.getString("lv"));
				result.setName(rs.getString("name"));

				return result;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	/**
	 * @author 문지원
	 * tblmember 테이블에 회원 가입 항목 컬럼을 insert한다.
	 */
	public int signup(MemberDTO dto) {

		try {

			String sql = "insert into tblmember values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			pstat.setString(3, dto.getName());
			pstat.setString(4, dto.getNick());
			pstat.setString(5, dto.getEmail());
			pstat.setString(6, dto.getPhone());
			pstat.setString(7, dto.getZip());
			pstat.setString(8, dto.getAddress());
			pstat.setString(9, dto.getLv());
			pstat.setString(10, dto.getBirthday());
			pstat.setString(11, dto.getGender());
			return pstat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}
	
	/**
	 * @author 문지원
	 * tblmember 테이블에 회원 가입 항목 컬럼을 insert한다.
	 * 
	 * @return id
	 */
	public String findId(MemberDTO dto) {
		String id = null;
		try{
		    String sql = "select id from tblmember where name = ? and email = ?";
		    pstat = conn.prepareStatement(sql);
		    pstat.setString(1, dto.getName());
		    pstat.setString(2, dto.getEmail());

		    rs = pstat.executeQuery();

		    if(rs.next()){
		    	id = rs.getString("id");
			}
		    return id;
		    
		}catch(Exception e){
		    e.printStackTrace();
		}
		return null;
	}

	/**
	 * @author 문지원
	 * tblmember 테이블에서 name과 email을 조건으로 pw를 select하고 pw값을 반환한다.
	 * 
	 * @return pw
	 */
	public String findPw(MemberDTO dto) {
		String pw = null;
		try{
			String sql = "select pw from tblmember where id = ? and email = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getEmail());

			rs = pstat.executeQuery();

			if(rs.next()){
				pw = rs.getString("pw");
			}
			return pw;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @author 문지원
	 * tblmember 테이블에서 id를 select하여 LinkedList에 add 하여 반환한다.
	 * 
	 * @returrn list
	 */
	public LinkedList<String> getAllId() {
		try{
		    String sql = "select id from tblmember";
		    stat = conn.createStatement();
		    rs = stat.executeQuery(sql);
		    
			LinkedList<String> list = new LinkedList<String>();
		    while(rs.next()){
		    	list.add(rs.getString("id"));
			}
		    return list;
		}catch(Exception e){
		    e.printStackTrace();
		}
		return null;
	}
}
