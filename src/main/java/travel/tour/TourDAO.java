package travel.tour;

import travel.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
/**
 * 투어 DB 처리 클래스
 * @author 김정은
 *
 */
public class TourDAO {
    private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private ResultSet rs;

    /**
     * TourDAO() 생성자 메소드
     */
    public TourDAO() {
        try {
            conn = DBUtil.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 투어 리스트 조회 메소드
     * @return getList() 질의 결과를 반환
     */
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
