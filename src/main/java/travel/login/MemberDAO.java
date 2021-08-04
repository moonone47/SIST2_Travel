package travel.login;

import travel.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

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
	 *
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
				result.setPw(rs.getString("lv"));
				result.setName(rs.getString("name"));

				return result;

			}


		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public int signup(MemberDTO dto) {


		try {
//			dto.setId(req.getParameter("id"));
//			dto.setPw(req.getParameter("pwsd1"));
//			dto.setName(req.getParameter("name"));
//			dto.setNick(req.getParameter("nick"));
//			String year = req.getParameter("year");
//			String month = req.getParameter("month");
//			String day = req.getParameter("day");
//			dto.setBirthday(year+month+day);
//
//			dto.setEmail(req.getParameter("email"));
//			dto.setGender("gender");
//			dto.setPhone(req.getParameter("mobile"));

			String sql = "insert into tblmember values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			pstat = conn.prepareStatement(sql);
//			id pw name nic email phone zip address lv birthday gender
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
