package travel.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import travel.DBUtil;
import travel.mypage.TravelPlanDTO;

public class ManagementDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	
	public ManagementDAO() {
		try {
			conn = DBUtil.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public ArrayList<ManagementDTO> getlist(String id) {
		try {
		
			String sql = "select * from vwTravelPlan where id=" + id;
		
				stat = conn.createStatement();
				rs = stat.executeQuery(sql);
				
				ArrayList<ManagementDTO> list = new ArrayList<ManagementDTO>();
				while(rs.next()) {
					
					ManagementDTO dto = new ManagementDTO();
					dto.setName(rs.getString("name"));
					dto.setCityname(rs.getString("cityname"));
					dto.setDaystarttravel(rs.getString("daystarttravel"));
					dto.setDayendtravel(rs.getString("dayendtravel"));
					dto.setWish(rs.getString("wish"));
					dto.setPlanseq(rs.getString("planseq"));
					
					list.add(dto);
				}
				return list;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	
	
	}
}
