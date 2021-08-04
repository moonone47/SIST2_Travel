package travel.mypage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import travel.DBUtil;
import travel.community.question.BoardDTO;
import travel.reservation.ReservationDTO;


public class BasketDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	
	public BasketDAO() {
		try {
			conn = DBUtil.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public ArrayList<BasketDTO> list(String id) {
		
try {
			
			String sql = "select * from vwbasket where id =? order by basketseq desc ";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);
			
			rs = pstat.executeQuery();
			
			ArrayList<BasketDTO> list = new ArrayList<BasketDTO>();
			
			
			while(rs.next()) {
				
				BasketDTO dto = new BasketDTO();
				
				dto.setBasketseq(rs.getString("basketseq"));
				dto.setMembername(rs.getString("membername"));
				dto.setTourseq(rs.getString("tourseq"));
				dto.setTourname(rs.getString("tourname"));
				dto.setUse(rs.getString("use"));
				dto.setValiddate(rs.getString("validdate"));
				dto.setTourprice(rs.getString("tourprice"));
				dto.setIspay(rs.getString("ispay"));
				dto.setImg(rs.getString("img"));
				dto.setDetail(rs.getString("detail"));
				
				list.add(dto);
				
			}
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}


	public int del(String basketseq) {
		try {
			String sql = "delete from tblbasket where basketseq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, basketseq);
			
			System.out.println("장바구니 삭제완료");
			
			return  pstat.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int insertrev(String tourseq, String id) {
		try {
			String sql = "insert into tblreservation values (seqreservation.nextval,'n',?,?,'y')";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, tourseq);
			pstat.setString(2, id);
			
			System.out.println("예약 추가 완료 ");
			
			return pstat.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	
	
	
}













