package travel.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import travel.DBUtil;
import travel.mypage.TravelPlanDTO;
import travel.plan.PlaceDTO;

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


			/*
				DAO 에서 할일 ---------------------------
				-> planseq -> 음식점/명소/숙소 where planseq 돌면서 -> 
					레코드 여러개 -> ArrayList<dto> 담고 바로  
			
				dto.setcategory_group_name = > 직접 담기
				음식점 -> 음식점 / 명소 -> 관광명소 / 숙소 -> 숙박
				-----------------------------------------
				
				for문 돌면서 tblPlan2에 insert하고
				
				tblPlan2에 id로 select * from tblPlan2 where id = id order by rdate, seq ; 
				날짜별로 정리되고, seq별로 정리가 된 ArrayList
			  */
			  
	public ArrayList<ManagementDTO> getdetail(String planseq, String id) {
		
		try {
			
			String tbl = "tblSights";
			
			ArrayList<ManagementDTO> tlist = new ArrayList<ManagementDTO>();
			ArrayList<ManagementDTO> list1 = get("tblSights", planseq);
			ArrayList<ManagementDTO> list2 = get("tblRooms", planseq);
			ArrayList<ManagementDTO> list3 = get("tblRestaurant", planseq);
			
			tlist.addAll(list1);
			tlist.addAll(list2);
			tlist.addAll(list3);
			
			for(ManagementDTO dto : tlist) {
				
				 String sql = "insert into tblPlan2(plan2seq, address_name, category_group_code, category_group_name, " +
		                    "category_name, id, phone, place_name, place_url, road_address_name, x, y, seq, memberid, rdate)" +
		                    "values (tplanseq.nextVal, ?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		            pstat = conn.prepareStatement(sql);
		            
		            //15
		            pstat.setString(1, dto.getAddress_name());
		            pstat.setString(2, "");
		            pstat.setString(3, dto.getCategory_group_name());
		            pstat.setString(4, "");
		            pstat.setString(5, dto.getId());
		            pstat.setString(6, "");
		            pstat.setString(7, dto.getPlace_name());
		            pstat.setString(8, dto.getPlace_url());
		            pstat.setString(9, "");
		            pstat.setString(10, dto.getX());
		            pstat.setString(11, dto.getY());
		            pstat.setString(12, dto.getSeq());    
		            pstat.setInt(13, 3);
		            pstat.setString(14, dto.getRdate());
		            
		            pstat.executeUpdate();
			}
			
			ArrayList<ManagementDTO> list = new ArrayList<ManagementDTO>();
			
	           String sql = "select * from tblPlan2 where memberid=? order by rdate asc, seq asc"; 

	            pstat = conn.prepareStatement(sql);
	            rs = pstat.executeQuery(); //복붙

	            while (rs.next()) {
	            	ManagementDTO dto = new ManagementDTO();

	                
	                dto.setPlace_url(rs.getString("place_url"));
	                dto.setPlace_name(rs.getString("place_name"));
	                dto.setMemberid(rs.getString("memberid"));
	                dto.setSeq(rs.getString("seq"));	                
	                dto.setCategory_group_name(rs.getString("category_group_name"));
	                dto.setId(rs.getString("id"));
	                dto.setRdate(rs.getString("rdate"));
	                dto.setX(rs.getString("x"));
	                dto.setY(rs.getString("y"));
	                dto.setAddress_name(rs.getString("address_name"));
	   	            
	   	            list.add(dto);
	            }//end while

	            return list;
		
		} catch (Exception e) {
			e.printStackTrace();	
		}
		return null;
	}


	private ArrayList<ManagementDTO> get(String tbl, String planseq) {
		
		try {
			
			String sql = "select * from " + tbl +" where planseq =" + planseq;
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			/*
				private String address_name;   
			    private String category_group_name;  
			    private String place_name;
			    private String place_url;
			    private String road_address_name;
			    private String x;
			    private String y;
			    private String seq;
			    private String memberid;
			    private String rdate; // 일정 날짜
			 */
			
			
			ArrayList<ManagementDTO> list = new ArrayList<ManagementDTO>();
			
			while(rs.next()) {
				
				ManagementDTO dto = new ManagementDTO();
				dto.setAddress_name("address");
				dto.setPlace_name("name");
				dto.setPlace_url("url");
				dto.setX("x");				
				dto.setY("y");
				dto.setSeq("seq");
				dto.setMemberid("id");
				dto.setRdate("plandate");
				
				if(tbl.equals("tblSights")) {
					dto.setCategory_group_name("관광명소");
				} else if(tbl.equals("tblRooms")) {
					dto.setCategory_group_name("숙박");
				} else if(tbl.equals("tblRestaurant")) {
					dto.setCategory_group_name("음식점");
				}
				
				list.add(dto);
			}
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		
		return null;
	}



}






















