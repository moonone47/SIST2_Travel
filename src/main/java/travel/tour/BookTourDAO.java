package travel.tour;

import travel.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BookTourDAO {
    private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private ResultSet rs;


    public BookTourDAO() {
        try {
            conn = DBUtil.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int insertTour(BookTourDTO dto) {
//        private String name;
//        private String regdate;
//        private String personnel;
//        private String contact;
//        private String email;
//        private String moredetail;
//        private String tourseq;
        try{
            String sql = "insert into tblBookTour values(seqBookTour.nextVal, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, dto.getId());
            pstat.setString(2, dto.getName());
            pstat.setString(3, dto.getRegdate());
            pstat.setString(4, dto.getPersonnel());
            pstat.setString(5, dto.getContact());
            pstat.setString(6, dto.getEmail());
            pstat.setString(7, dto.getMoredetail());
            pstat.setString(8, dto.getTourseq());
            return pstat.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
