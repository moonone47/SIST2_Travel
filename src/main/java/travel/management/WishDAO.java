package travel.management;

import travel.DBUtil;
import travel.spot.RestaurantDTO;
import travel.spot.RoomDTO;
import travel.spot.SightDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/**
 * 찜 목록 DB 작업을 위한 DAO 클래스
 */
public class WishDAO {
    private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private ResultSet rs;

    /**
     * DB 저장을 위한 생성자
     */
    public WishDAO() {
        try {
            conn = DBUtil.open();
//	            conn = DBUtil.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * tblRestaurant {{@code 테이블에서 select * 값을 LinkedList\<RestaurantDTO\>로 반환하는 메소드}
     * @return {@code select * 정보를 LinkedList\<RestaurantDTO\>로 반환한다.}
     */
    public LinkedList<RestaurantDTO> getAllRestaurant() {
        try {
            String sql = "select * from tblRestaurant";
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            LinkedList<RestaurantDTO> list = new LinkedList<RestaurantDTO>();

            while (rs.next()) {
                RestaurantDTO dto = new RestaurantDTO();
                dto.setRestaurantSeq(rs.getString("restaurantSeq"));
                dto.setName(rs.getString("name"));
                dto.setExplain(rs.getString("explain"));
                dto.setAddress(rs.getString("address"));
                dto.setImage(rs.getString("image"));
                dto.setGrade(rs.getString("grade"));
                dto.setWish(rs.getString("wish"));
                dto.setTheme(rs.getString("theme"));
                dto.setRestaurantX(rs.getString("restaurantX"));
                dto.setRestaurantY(rs.getString("restaurantY"));
                dto.setPlandate(rs.getString("plandate"));
                dto.setBudget(rs.getString("budget"));
                dto.setSeq(rs.getString("seq"));
                dto.setUrl(rs.getString("url"));
                dto.setPlanseq(rs.getString("planseq"));
                dto.setId(rs.getString("id"));
                list.add(dto);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * tblRooms {@code 테이블에서 select *한 결과를 LinkedList\<RoomDTO\> list에 add한 결과를 반환하는 메소드}
     * @return {@code select *의 결과를 LinkedList\<RoomDTO\>로 반환한다.}
     */
    public LinkedList<RoomDTO> getAllRoom() {
        try {
            String sql = "select * from tblRooms";
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            LinkedList<RoomDTO> list = new LinkedList<RoomDTO>();
            while (rs.next()) {
                RoomDTO dto = new RoomDTO();
                dto.setRoomsSeq(rs.getString("roomsSeq"));
                dto.setName(rs.getString("name"));
                dto.setExplain(rs.getString("explain"));
                dto.setAddress(rs.getString("address"));
                dto.setImage(rs.getString("image"));
                dto.setGrade(rs.getString("grade"));
                dto.setWish(rs.getString("wish"));
                dto.setTheme(rs.getString("theme"));
                dto.setRoomsX(rs.getString("roomsX"));
                dto.setRoomsY(rs.getString("roomsY"));
                dto.setPlandate(rs.getString("plandate"));
                dto.setBudget(rs.getString("budget"));
                dto.setSeq(rs.getString("seq"));
                dto.setUrl(rs.getString("url"));
                dto.setPlanseq(rs.getString("planseq"));
                dto.setId(rs.getString("id"));
                list.add(dto);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * tblSights {@code 테이블에서 select *한 정보를 LinkedList\<SightDTO\> list에 add한 결과를 반환한다.}
     * @return {@code LinkedList<SightDTO> select *의 결과를 저장한 LinkedList\<SightDTO\> 를 반환한다.}
     */
    public LinkedList<SightDTO> getAllSight() {
        try {
            String sql = "select * from tblSights";
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            LinkedList<SightDTO> list = new LinkedList<SightDTO>();
            while (rs.next()) {
                SightDTO dto = new SightDTO();
                dto.setSightsSeq(rs.getString("sightsSeq"));
                dto.setName(rs.getString("name"));
                dto.setExplain(rs.getString("explain"));
                dto.setAddress(rs.getString("address"));
                dto.setImage(rs.getString("image"));
                dto.setGrade(rs.getString("grade"));
                dto.setWish(rs.getString("wish"));
                dto.setTheme(rs.getString("theme"));
                dto.setSightsX(rs.getString("sightsX"));
                dto.setSightsY(rs.getString("sightsY"));
                dto.setPlandate(rs.getString("plandate"));
                dto.setBudget(rs.getString("budget"));
                dto.setSeq(rs.getString("seq"));
                dto.setUrl(rs.getString("url"));
                dto.setPlanseq(rs.getString("planseq"));
                dto.setId(rs.getString("id"));
                list.add(dto);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
