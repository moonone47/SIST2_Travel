package travel.reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import travel.DBUtil;

public class ReservationDAO {
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public ReservationDAO() {
		try {
			conn = DBUtil.open("183.100.233.88", "sist2_travel", "java1234");
//            conn = DBUtil.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<ReservationDTO> list(String id) {
		try {
			
			String sql = "select * from vwreservation where id =? order by reservationseq desc ";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);
			
			rs = pstat.executeQuery();
			
			ArrayList<ReservationDTO> list = new ArrayList<ReservationDTO>();
			
			
			while(rs.next()) {
				ReservationDTO dto = new ReservationDTO();
				dto.setReservationseq(rs.getString("reservationseq"));
				dto.setIscancel(rs.getString("iscancel"));
				dto.setTourseq(rs.getString("tourseq"));
				dto.setTourname(rs.getString("tourname"));
				dto.setMembername(rs.getString("membername"));
				dto.setUse(rs.getString("use"));
				dto.setValiddate(rs.getString("validdate"));
				dto.setTourprice(rs.getString("tourprice"));
				
				list.add(dto);
				
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	public ReservationDTO get(String tourseq) {
		try {
			String sql = "select * from tbltour where tourseq = ?";
			pstat =conn.prepareStatement(sql);
			pstat.setString(1, tourseq);
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				ReservationDTO dto = new ReservationDTO();
				
				dto.setTourseq(rs.getString("tourseq"));
				dto.setTourname(rs.getString("name"));
				dto.setDetail(rs.getString("detail"));
				dto.setUse(rs.getString("use"));
				dto.setValiddate(rs.getString("validdate"));
				dto.setTourprice(rs.getString("tourprice"));
				
				return dto;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	

	public int cancel(String reservationseq) {
		
		try {
		
			String sql = "update tblreservation set iscancel = 'y' where reservationseq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, reservationseq);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return 0;
	}
}
















