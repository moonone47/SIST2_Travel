package travel.tour;

import travel.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

public class TourDAO {
    private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private ResultSet rs;


    public TourDAO() {
        try {
            conn = DBUtil.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public LinkedList<TourDTO> getList() {
        try{
            String sql = "select * from tblTour";
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            LinkedList<TourDTO> list = new LinkedList<TourDTO>();
            while(rs.next()){
                TourDTO dto = new TourDTO();
                dto.setTourseq(rs.getString("tourseq"));
                dto.setName(rs.getString("name"));
                dto.setDetail(rs.getString("detail"));
                dto.setUse(rs.getString("use"));
                dto.setValiddate("validdate");
                dto.setTourprice(rs.getString("tourprice"));
                dto.setImg(rs.getString("img"));
                list.add(dto);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
