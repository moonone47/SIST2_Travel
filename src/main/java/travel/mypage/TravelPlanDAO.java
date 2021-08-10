package travel.mypage;

import travel.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * TravelPlan의 DB작업을 위한 DAO 클래스
 * TravelPlanDAO	DB연결을 위한 생성자
 * {@code ArrayList<TravelPlanDTO> getlist(String id, String category)	vwPlanWish테이블에서 id와 category에 해당하는 정보를 select하여 ArrayList<TravelPlanDTO>로 반환한다.}
 * int del(String planseq)	tblPlan에서 planseq에 해당하는 컬럼을 삭제한다.
 */
public class TravelPlanDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	/**
	 *  DB 연결을 위한 생성자이다.
	 */
	public TravelPlanDAO() {
		try {
			conn = DBUtil.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * {@code vwPlanWish테이블에서 id와 category에 해당하는 정보를 select하여 ArrayList\<TravelPlanDTO\>로 반환한다.}
	 * @param id where절의 조건으로 사용될 변수이다.
	 * @param category category where절의 조건으로 사용될 변수이다.
	 * @return {@code ArrayList{@code<TravelPlanDTO>} vwPlanWish 테이블에서 where절의 조건을 만족하는 정보를 select*하여 TravelPlanDTO에 저장하고, list.add를 완료한 ArrayList\<TravelPlanDTO\>를 반환한다.}
	 */
	public ArrayList<TravelPlanDTO> getlist(String id, String category) {
	
		try {
			String where = "";
			if(category == null || category.equals("") || category.equals("ing")) {
				//where = "where id=3 and(dayendtravel > sysdate) order by daystarttravel desc";
				where = String.format("where id=%s and (dayendtravel > sysdate)", id);
			} else if(category.equals("end")) {
				//where = "where id=3 and(dayendtravel < sysdate) order by daystarttravel desc";
				where = String.format("where id=%s and (dayendtravel < sysdate)", id);
			} else if(category.equals("wish")) {
				//where = " where wisherid=3 order by daystarttravel desc";
				where = String.format("where wisherid = %s", id);
				
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
					dto.setWriternick(rs.getString("nick"));
					list.add(dto);
				}
				return list;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * tblPlan에서 planseq에 해당하는 컬럼을 삭제한다.
	 * @param planseq 삭제할 일정 번호이다.
	 * @return delete 작업 결과를 반환한다.
	 */
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
