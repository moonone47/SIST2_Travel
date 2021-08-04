package travel.mypage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import travel.DBUtil;

public class TravelPlanDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	
	public TravelPlanDAO() {
		try {
			conn = DBUtil.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public ArrayList<TravelPlanDTO> getlist(String id, String category) {
	
		try {
			String where = "";
			if(category == null || category.equals("") || category.equals("ing")) {
				where = "where id=3 and(dayendtravel > sysdate) order by daystarttravel desc";
				//where = String.format("where id=%s and (dayendtravel > sysdate)", id);
			} else if(category.equals("end")) {
				where = "where id=3 and(dayendtravel < sysdate) order by daystarttravel desc";
				//where = String.format("where id=%s and (dayendtravel < sysdate)", id);
			} else if(category.equals("wish")) {
				where = " where wisherid=3 order by daystarttravel desc";
				//where = String.format("where wisherid = %s", id);
				
			}
			
			String sql = "";
			if(category.equals("wish")) {
				sql = String.format("select * from vwPlanWish %s", where);
				stat = conn.createStatement();
				rs = stat.executeQuery(sql);
				ArrayList<TravelPlanDTO> list = new ArrayList<TravelPlanDTO>();
				while(rs.next()) {
					TravelPlanDTO dto = new TravelPlanDTO();
					dto.setName(rs.getString("name"));
					dto.setCityname(rs.getString("cityname"));
					dto.setDaystarttravel(rs.getString("daystarttravel"));
					dto.setDayendtravel(rs.getString("dayendtravel"));
					dto.setWish(rs.getString("wish"));
					dto.setPlanseq(rs.getString("planseq"));
					dto.setWriternick(rs.getString("writernick"));
					list.add(dto);
				}
				return list;
			} else {
				sql = String.format("select * from vwTravelPlan %s", where);
				stat = conn.createStatement();
				rs = stat.executeQuery(sql);
				ArrayList<TravelPlanDTO> list = new ArrayList<TravelPlanDTO>();
				while(rs.next()) {
					TravelPlanDTO dto = new TravelPlanDTO();
					dto.setName(rs.getString("name"));
					dto.setCityname(rs.getString("cityname"));
					dto.setDaystarttravel(rs.getString("daystarttravel"));
					dto.setDayendtravel(rs.getString("dayendtravel"));
					dto.setWish(rs.getString("wish"));
					dto.setPlanseq(rs.getString("planseq"));
					list.add(dto);
				}
				return list;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}


	public int del(String planseq) {
		
		try {
			
			String spl = "delete from tblPlan where planseq=" + planseq;
			
			stat = conn.createStatement();
			return stat.executeUpdate(spl);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
}
