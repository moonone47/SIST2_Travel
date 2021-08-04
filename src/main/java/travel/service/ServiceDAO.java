package travel.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import travel.DBUtil;

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







