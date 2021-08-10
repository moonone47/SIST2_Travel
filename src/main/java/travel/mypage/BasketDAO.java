package travel.mypage;

import travel.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Basket table의 DB작업을 위한 DAO클래스
 * 메소드	BasketDAO	DB와의 연결을 위한 생성자
 * ArrayList<BasketDTO> list(String id)	vwbasket 테이블에서 basketDTO 해당 id정보를 가져온다.
 * int del(String basketseq)	해당 seq의 basket정보를 tblbasket에서 삭제한다.
 * int insertrev(String tourseq, String id)	해당 tourseq의 정보와 id정보를 가지고 tblreservation에 예약정보를 추가한다.
 */
public class BasketDAO {

    private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private ResultSet rs;

    /**
     * DB연결을 위한 생성자
     */
    public BasketDAO() {
        try {
            conn = DBUtil.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * vwbasket 테이블에서 id를 조건으로 걸어 select * 된 정보를 BasketDTO에 담고, list.add한 최종 list를 반환한다.
     * @param id 장바구니의 식별자 역할을 하는 id
     * @return 장바구니에 있는 모든 정보를 담고있는 ArrayList<BasketDTO>를 반환한다.
     */
    public ArrayList<BasketDTO> list(String id) {

        try {

            String sql = "select * from vwbasket where id =? order by basketseq desc ";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, id);

            rs = pstat.executeQuery();

            ArrayList<BasketDTO> list = new ArrayList<BasketDTO>();


            while (rs.next()) {

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

    /**
     * 해당 seq의 basket정보를 tblbasket에서 삭제하여 장바구니에서 삭제된다.
     * @param basketseq 삭제하고 싶은 장바구니 품목
     * @return delete의 결과값을 반환한다.
     */
    public int del(String basketseq) {
        try {
            String sql = "delete from tblbasket where basketseq = ?";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, basketseq);

            System.out.println("장바구니 삭제완료");

            return pstat.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    /**
     * 해당 tourseq의 정보와 id정보를 가지고 tblreservation에 예약정보를 추가한다.
     * @param tourseq 선택한 투어의 seq 번호이다.
     * @param id 로그인한 id
     * @return insert의 결과를 반환한다.
     */
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













