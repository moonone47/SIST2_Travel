package travel.tour;

import travel.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * 투어 예약 DB 처리 클래스
 * @author 김정은
 *
 */
public class BookTourDAO {
    private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private ResultSet rs;

    /**
     * BookTourDAO() 생성자
     */
    public BookTourDAO() {
        try {
            conn = DBUtil.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 투어 예약 추가 메소드
     * @param dto
     * @return int 질의가 실행된 레코드 개수를 반환
     */
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
