package travel.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import travel.DBUtil;

/**
 * 여행 의뢰 서비스 DAO 
 * @author 이준희
 *
 */
public class ServiceDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public ServiceDAO() {
		try {
			conn = DBUtil.open("183.100.233.88", "sist2_travel", "java1234");
//            conn = DBUtil.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 해당 id의 여행 의뢰 목록 가져오기 
	 * @param id
	 * @return 여행 의뢰 정보가 담긴 list 
	 */
	public ArrayList<ServiceDTO> list(String id) {
		try {
			String sql = " select s.*, (select name from tblmember where id = s.id) as name from tblservice s where id = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);
			
			rs = pstat.executeQuery();
			
			ArrayList<ServiceDTO> list = new ArrayList<ServiceDTO>();
			
			while(rs.next()) {
				ServiceDTO dto = new ServiceDTO();
				dto.setServiceseq(rs.getString("serviceseq"));
				dto.setTravelspot(rs.getString("travelspot"));
				dto.setDaystarttravel(rs.getString("daystarttravel"));
				dto.setDayendtravel(rs.getString("dayendtravel"));
				dto.setPurpose(rs.getString("purpose"));
				dto.setNumberpeople(rs.getString("numberpeople"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				
				list.add(dto);
				
			}
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}
 
	/**
	 * 입력받은 serviceseq 레코드 여행 의뢰 취소 메소드 
	 * @param serviceseq
	 * @return delete 성공 여부 1, 0 
	 */
	public int cancel(String serviceseq) {
		try {
			
			String sql = "delete from tblservice where serviceseq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, serviceseq);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public void delAllComment(String serviceseq) {
		try {
			String sql = "delete from tblserviceplan where serviceseq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, serviceseq);

			pstat.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}

	/**
	 * 넘겨받은 dto정보를 tblService에 insert 해주는 메소드 
	 * @param dto
	 * @return insert 성공 여부 1 or 0 
	 */
	public int add(ServiceDTO dto) {
		try {
			String sql = "insert into tblservice (serviceseq, travelspot,daystarttravel, dayendtravel, purpose, numberpeople, id) values (seqservice.nextval, ?,?,?,?,?,?)";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getTravelspot() );
			pstat.setString(2, dto.getDaystarttravel());
			pstat.setString(3, dto.getDayendtravel());
			pstat.setString(4, dto.getPurpose());
			pstat.setString(5, dto.getNumberpeople());
			pstat.setString(6, dto.getId());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
}







