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
            conn = DBUtil.open("183.100.233.88", "sist2_travel", "java1234");
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
            pstat.setInt(12, 1);              //pstat.setInt(12, 1);
            pstat.setInt(13, 4);
            pstat.setString(14, "2021-07-27");


//            String sql = "insert into tblPlan2(planseq, address_name, category_group_code, category_group_name, " +
//                    "category_name, id, phone, place_name, place_url, road_address_name, x, y, seq, memberid, rdate)" +
//                    "values (tplanseq.nextVal, ?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//
//            pstat = conn.prepareStatement(sql);
//            pstat.setString(1, dto.getAddress_name());
//            pstat.setString(2, dto.getCategory_group_code());
//            pstat.setString(3, dto.getCategory_group_name());
//            pstat.setString(4, dto.getCategory_name());
//            pstat.setString(5, dto.getId());
//            pstat.setString(6, dto.getPhone());
//            pstat.setString(7, dto.getPlace_name());
//            pstat.setString(8, dto.getPlace_url());
//            pstat.setString(9, dto.getRoad_address_name());
//            pstat.setString(10, dto.getX());
//            pstat.setString(11, dto.getY());
//            pstat.setInt(12, 1);
//            pstat.setInt(13, 4);
//            pstat.setString(14,"2021-07-27");

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

    //    //List 서블릿이 게시판 목록을 달라고..
//    public ArrayList<BoardDTO> list(HashMap<String, String> map) {
//
//        try {
//
//            //이 메소드 입장
//            //1. 목록보기
//            //2. 검색하기
//
//            String where = "";
//
//            if (map.get("isSearch").equals("y")) {
//                //검색
//                //where name like '%홍길동%'
//                //where subject like '%날씨%'
//                //where all like '%날씨%'
//
//                if (map.get("column").equals("all")) {
//                    where = String.format(" and subject like '%%%s%%' or content like '%%%s%%' "
//                            , map.get("search"), map.get("search"));
//                } else {
//                    where = String.format(" and %s like '%%%s%%' "
//                            , map.get("column"), map.get("search"));
//                }
//
//            }
//
//            //페이지 조건 <-> (분리) <-> 검색 조건
//            String sql = String.format("select * from vwBoard where rnum between %s and %s %s order by thread desc"
//                    , map.get("begin")
//                    , map.get("end")
//                    , where);
//
//            pstat = conn.prepareStatement(sql);
//
//            rs = pstat.executeQuery();
//
//            ArrayList<BoardDTO> list = new ArrayList<BoardDTO>(); //옮겨 담을 큰상자
//
//            while (rs.next()) {
//
//                //레코드 1줄 -> BoardDTO 1개
//                BoardDTO dto = new BoardDTO();
//
//                dto.setSeq(rs.getString("seq"));
//                //dto.setId(rs.getString("id"));
//                dto.setName(rs.getString("name"));
//                dto.setSubject(rs.getString("subject"));
//                dto.setReadcount(rs.getString("readcount"));
//                dto.setRegdate(rs.getString("regdate"));
//
//                dto.setIsnew(rs.getString("isnew")); //글쓰고 난뒤 며칠이 지났는지 시간
//
//                dto.setCcnt(rs.getString("ccnt")); //현재 글에 달린 댓글 개수
//
//                dto.setThread(rs.getInt("thread"));
//                dto.setDepth(rs.getInt("depth"));
//
//                list.add(dto);
//
//            }
//
//            return list;
//
//        } catch (Exception e) {
//            System.out.println("BoardDAO.list()");
//            e.printStackTrace();
//        }
//
//        return null;
//    }
    public ArrayList<PlanDTO> getList(int id) {
        try {

            String sql = "select * from tblPlan2 where memberid=?"; // todo:일정번호로 바꿔야함

            pstat = conn.prepareStatement(sql);

            pstat.setInt(1, id);

            rs = pstat.executeQuery(); //복붙

            ArrayList<PlanDTO> list = new ArrayList<PlanDTO>();

            while (rs.next()) {
                PlanDTO dto = new PlanDTO();

                dto.setPlanseq(rs.getString("planseq"));
                dto.setPlace_url(rs.getString("place_url"));
                dto.setPlace_name(rs.getString("place_name"));
                dto.setPhone(rs.getString("phone"));
                dto.setMemberid(rs.getString("memberid"));
                dto.setSeq(rs.getString("seq"));
                dto.setCategory_group_code(rs.getString("category_group_code"));
                dto.setCategory_group_name(rs.getString("category_group_name"));
                dto.setCategory_name(rs.getString("category_name"));
                dto.setId(rs.getString("id"));
                dto.setPlace_name(rs.getString("place_name"));
                dto.setRdate(rs.getString("rdate"));
                dto.setX(rs.getString("x"));
                dto.setY(rs.getString("y"));
                dto.setAddress_name(rs.getString("address_name"));
                list.add(dto);
            }//end while

            return list;
        } catch (Exception e) {
            System.out.println("PlanDAO.getList()");
            e.printStackTrace();
        }
        return null;
    }
    
    
    	public int addseq(ArrayList<HashMap<String, String>> seqlist) {

		try {
			
			while(rs.next()) {
				rs.get
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return 0;
	}
	
	
}









