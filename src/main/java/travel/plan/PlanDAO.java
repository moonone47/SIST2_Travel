package travel.plan;


import travel.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PlanDAO {

    private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private ResultSet rs;

    public PlanDAO() {
        try {
            conn = DBUtil.open("183.100.233.88","sist2_travel","java1234");
        } catch (Exception e) {
            System.out.println("PlanDAO.PlanDAO()");
            e.printStackTrace();
        }
    }

    public int add(PlanDTO dto) {
        try {
        	String sql = "insert into tblPlan2(planseq, address_name, category_group_code, category_group_name, " +
                    "category_name, id, phone, place_name, place_url, road_address_name, x, y, seq, memberid, rdate)" +
                    "values (tplanseq.nextVal, ?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, dto.getAddress_name());
            pstat.setString(2, dto.getCategory_group_code());
            pstat.setString(3, dto.getCategory_group_name());
            pstat.setString(4, dto.getCategory_name());
            pstat.setString(5, dto.getId());
            pstat.setString(6, dto.getPhone());
            pstat.setString(7, dto.getPlace_name());
            pstat.setString(8, dto.getPlace_url());
            pstat.setString(9, dto.getRoad_address_name());
            pstat.setString(10, dto.getX());
            pstat.setString(11, dto.getY());
            pstat.setInt(12, 1);
            pstat.setInt(13, 4);
            pstat.setString(14,"2021-07-27");

            return pstat.executeUpdate();
        } catch (Exception e) {
            System.out.println("PlanDAO.add()");
            e.printStackTrace();
        }
        return 0;

//    public void add(ArrayList<PlanDTO> list)  throws Exception{
        //		address_name: "서울 중구 을지로5가 275-3"
//		category_group_code: "AD5"
//		category_group_name: "숙박"
//		category_name: "여행 > 숙박 > 호텔 > 특급호텔 > 라마다호텔"
//		id: "13111137"
//		phone: "02-2276-3500"
//		place_name: "라마다 서울동대문"
//		place_url: "http://place.map.kakao.com/13111137"
//		road_address_name: "서울 중구 동호로 354"
//		x: "127.002698429626"
//		y: "37.5658944720562"

//        for(PlanDTO dto: list) {
//            String sql = "insert into tblPlan(planseq, address_name, category_group_code, category_group_name, " +
//                    "category_name, id, phone, place_name, place_url, road_address_name, x, y" +
//                    "values(planseq.nextVal, ?,?,?,?,?,?,?,?,?,?,?";
//
//            try{
//                pstat = conn.prepareStatement(sql);
//                pstat.setString(1, dto.getAddress_name());
//                pstat.setString(2, );
//                pstat.setString(3, );
//                pstat.setString(4, );
//                pstat.setString(5, );
//                pstat.setString(6, );
//                pstat.setString(7, );
//                pstat.setString(8, );
//                pstat.setString(9, );
//                pstat.setString(10, );
//                pstat.setString(11, );
//                pstat.setString(12, );
//            }

    }


}

