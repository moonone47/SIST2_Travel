package travel.management;

import travel.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * {@code
 * Management의 DB작업을 위한 DAO 클래스
 * ManagementDAO()	DB 연결을 위한 생성자
 * ArrayList<ManagementDTO> getlist(String id)	id를 받아 vwTravlePlan에서 select한 결과를 dto에 담고, ArrayList<ManagementDTO>에 add하여 작업 완료 후 list를 반환한다.
 * ArrayList<ManagementDTO> getdetail(String planseq, String id)	tblSight, tblRestaurant, tblRooms(명소, 식당, 숙박)테이블에서 planseq를 이용하여 select된 값을 ArrayList<ManagementDTO>에 저장하고 tblPlan2에 id를 이용하여 insert 작업을 완료 한 뒤 list를 반환한다.
 * ArrayList<ManagementDTO> get(String tbl, String planseq)	tbl 테이블에서 planseq에 해당하는 정보를 select * 한 결과를 ArrayList,ManagementDTO>로 반환한다.
 * ArrayList<ManagementDTO> getDetailList(String id)	tblplan2 테이블에서 id 조건의 select * 결과 값을 ArrayList<ManagementDTO>로 반환한다.
 * ManagementDTO list(String planseq)	vwTravelPlan테이블의 planseq를 조건으로 검색하여 ManagementDTO에 저장하여 반환한다.
 * void del(String id)	tblPlan2에서 id에 해당하는 컬럼을 삭제하는 메소드}
 */
public class ManagementDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	/**
	 * DB 연결을 위한 생성자
	 */
	public ManagementDAO() {
		try {
			conn = DBUtil.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * {@code id를 받아 vwTravlePlan에서 select한 결과를 dto에 담고, ArrayList\<ManagementDTO\>에 add하여 작업 완료 후 list를 반환한다.}
	 * @param id where절의 조건으로 사용될 id
	 * @return select * 정보를 담고있는 ManagementDTO의 ArrayList컬렉션을 반환
	 */
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

	/**
	 * {@code tblSight, tblRestaurant, tblRooms(명소, 식당, 숙박)테이블에서 planseq를 이용하여 select된 값을 ArrayList<ManagementDTO>에 저장하고 tblPlan2에 id를 이용하여 insert 작업을 완료 한 뒤 list를 반환한다.}
	 * @param planseq 명소, 식당, 숙박테이블에서 where절에 사용 될 변수
	 * @param id tblPlan2 insert에서 id에 넣을 변수
	 * @return 명소, 식당, 숙박 테이블등의 정보를 담고 있는 {@code ArrayList\<ManagementDTO\>를 반환한다.}
	 */
	public ArrayList<ManagementDTO> getdetail(String planseq, String id) {
		
		try {
			
			String tbl = "tblSights";
			
			ArrayList<ManagementDTO> list = new ArrayList<ManagementDTO>();

			
			String sql = "select * from tblSights where planseq =" + planseq;
			
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
			
			while(rs.next()) {
				
				ManagementDTO dto = new ManagementDTO();
				dto.setAddress_name(rs.getString("address"));
				dto.setPlace_name(rs.getString("name"));
				dto.setPlace_url(rs.getString("url"));
				dto.setX(rs.getString("SightsX"));				
				dto.setY(rs.getString("SightsY"));
				dto.setSeq(rs.getString("seq"));
				dto.setMemberid(rs.getString("id"));
				dto.setRdate(rs.getString("plandate"));
				
				dto.setCategory_group_name("관광명소");
				dto.setCategory_group_code("AT4");
				
				list.add(dto);
			}
			
			
			sql = "select * from tblRestaurant where planseq =" + planseq;
			
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
			
			while(rs.next()) {
				
				ManagementDTO dto = new ManagementDTO();
				dto.setAddress_name(rs.getString("address"));
				dto.setPlace_name(rs.getString("name"));
				dto.setPlace_url(rs.getString("url"));
				dto.setX(rs.getString("Restaurantx"));				
				dto.setY(rs.getString("RestaurantY"));
				dto.setSeq(rs.getString("seq"));
				dto.setMemberid(rs.getString("id"));
				dto.setRdate(rs.getString("plandate"));
				dto.setCategory_group_name("음식점");
				dto.setCategory_group_code("FD6");
				
				list.add(dto);
			}
			
			
			
			sql = "select * from tblRooms where planseq =" + planseq;
			
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
			
			while(rs.next()) {
				
				ManagementDTO dto = new ManagementDTO();
				dto.setAddress_name(rs.getString("address"));
				dto.setPlace_name(rs.getString("name"));
				dto.setPlace_url(rs.getString("url"));
				dto.setX(rs.getString("roomsx"));				
				dto.setY(rs.getString("roomsy"));
				dto.setSeq(rs.getString("seq"));
				dto.setMemberid(rs.getString("id"));
				dto.setRdate(rs.getString("plandate"));
				dto.setCategory_group_name("숙박");
				dto.setCategory_group_code("AD5");
				list.add(dto);
			}			
			
			
			/*
			 * for(ManagementDTO dto : list) { System.out.println(dto.getRdate());
			 * System.out.println(dto.getAddress_name());
			 * System.out.println(dto.getPlace_name());; }
			 */
			
			
			
		
			for(ManagementDTO dto : list) {
				
				 String sql2 = "insert into tblPlan2(plan2seq, address_name, category_group_code, category_group_name, " +
		                    "category_name, id, phone, place_name, place_url, road_address_name, x, y, seq, memberid, rdate)" +
		                    "values (tplanseq.nextVal, ?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		            pstat = conn.prepareStatement(sql2);
		            
		            String lastCrawlDate = dto.getRdate();
		            Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(lastCrawlDate);
		            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		            
		       	            
		            //15
		            pstat.setString(1, dto.getAddress_name());
		            pstat.setString(2, dto.getCategory_group_code());
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
		            pstat.setString(13, id);
		            pstat.setDate(14, sqlDate);
		            
		            pstat.executeUpdate();
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();	
		}
		return null;
	}

	/**
	 * tbl 테이블에서 planseq에 해당하는 정보를 select * 한 결과를 ArrayList,ManagementDTO>로 반환한다.
	 * @param tbl from에 해당하는 테이블을 지정하는 변수
	 * @param planseq tbl 테이블의 조건으로 사용될 변수
	 * @return select * 의 결과 값을 ArrayList<ManagementDTO>로 반환한다.
	 */
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

	/**
	 * tblplan2 테이블에서 id 조건의 select * 결과 값을 {@code ArrayList\<ManagementDTO\>로 반환한다.}
	 * @param id tblPlan2의 where 조건에 사용될 변수
	 * @return {@code stblPlan2의 select * 결과를 저장하고 있는 ArrayList\<ManagementDTO\>를 반환한다.}
	 */
	public ArrayList<ManagementDTO> getDetailList(String id) {
		try {
			ArrayList<ManagementDTO> dlist = new ArrayList<ManagementDTO>();
			
	           String sql3 = "select * from tblPlan2 where memberid= ? order by rdate asc, seq asc"; 

	            pstat = conn.prepareStatement(sql3);
	            pstat.setString(1, id);
	            
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
	   	            
	                dlist.add(dto);
	            }//end while

	            return dlist;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * vwTravelPlan테이블의 planseq를 조건으로 검색하여 ManagementDTO에 저장하여 반환한다.
	 * @param planseq  vwTravelPlan의 검색 조건
	 * @return select *의 결과를 저장하는 ManagementDTO를 반환한다.
	 */
	public ManagementDTO list(String planseq) {
		
		try {
			
			String sql = "select * from vwTravelPlan where planseq=" + planseq;
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			ManagementDTO dto = new ManagementDTO();
			
			if(rs.next()) {
				
				dto.setName(rs.getString("name"));
				dto.setCityname(rs.getString("cityname"));
				dto.setDaystarttravel(rs.getString("daystarttravel"));
				dto.setDayendtravel(rs.getString("dayendtravel"));
				dto.setWish(rs.getString("wish"));
				dto.setPlanseq(rs.getString("planseq"));
				dto.setWriternick(rs.getString("nick"));
				dto.setCityX(rs.getString("cityX"));
				dto.setCityY(rs.getString("cityY"));
			}
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	/**
	 * tblPlan2에서 id에 해당하는 컬럼을 삭제하는 메소드
	 * @param id 컬럼 삭제를 원하는 where절의 조건
	 */
	public void del(String id) {
		try {
			
			String sql = "delete from tblPlan2 where memberid=" + id;
			
			stat = conn.createStatement();
			
			stat.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}



}






















