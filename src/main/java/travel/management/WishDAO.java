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

public class WishDAO {
    private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private ResultSet rs;

    public WishDAO() {
        try {
            conn = DBUtil.open();
//	            conn = DBUtil.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public LinkedList<RestaurantDTO> getAllRestaurant() {
        try{
            String sql="select * from tblRestaurant";
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            LinkedList<RestaurantDTO> list = new LinkedList<RestaurantDTO>();

            while(rs.next()){
                RestaurantDTO dto = new RestaurantDTO();
                dto.setRestaurantSeq(rs.getString("restaurantseq"));
                dto.setName(rs.getString("name"));
                dto.setAddress(rs.getString("address"));
                dto.setImage(rs.getString("image"));
                dto.setWish(rs.getString("wish"));
                dto.setTheme(rs.getString("theme"));
                dto.setRestaurantX(rs.getString("restaurantX"));
                dto.setRestaurantY(rs.getString("restaurantY"));
                list.add(dto);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public LinkedList<RoomDTO> getAllRoom() {
        try{
            String sql="select * from tblRooms";
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            LinkedList<RoomDTO> list = new LinkedList<RoomDTO>();
            while(rs.next()){
              RoomDTO dto = new RoomDTO();
              dto.setRoomsSeq(rs.getString("roomsSeq"));
              dto.setName(rs.getString("name"));
              dto.setExplain(rs.getString("explain"));
              dto.setAddress(rs.getString("address"));
              dto.setType(rs.getString("type"));
              dto.setRank(rs.getString("rank"));
              dto.setPrice(rs.getString("price"));
              dto.setGrade(rs.getString("grade"));
              dto.setRoomsX(rs.getString("roomsX"));
              dto.setRoomsY(rs.getString("roomsY"));
              dto.setWish(rs.getString("wish"));
              list.add(dto);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;

    }


    public LinkedList<SightDTO> getAllSight() {
        try{
            String sql = "select * from tblSights";
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            LinkedList<SightDTO> list = new LinkedList<SightDTO>();
            while(rs.next()){
                SightDTO dto = new SightDTO();
                dto.setSightsSeq(rs.getString("sightsSeq"));
                dto.setName(rs.getString("name"));
                dto.setAddress(rs.getString("address"));
                dto.setImage(rs.getString("image"));
                dto.setWish(rs.getString("wish"));
                dto.setTheme(rs.getString("theme"));
                dto.setSightsX(rs.getString("sightsX"));
                dto.setSightsY(rs.getString("sightsY"));
                list.add(dto);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
