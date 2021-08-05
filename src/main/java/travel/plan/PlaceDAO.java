package travel.plan;

import travel.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PlaceDAO {

    private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private ResultSet rs;

    public PlaceDAO() {
        try {
            conn = DBUtil.open("183.100.233.88", "sist2_travel", "java1234");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int add(PlaceDTO dto, String userId) {
        try {
            String sql = "insert into tblPlan2(plan2seq, address_name, category_group_code, category_group_name, " +
                    "category_name, id, phone, place_name, place_url, road_address_name, x, y, seq, memberid, rdate)" +
                    "values (tplanseq.nextVal, ?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//            at travel.plan.PlaceDAO.add(PlaceDAO.java:52) java.sql.SQLIntegrityConstraintViolationException: ORA-01400: cannot insert NULL into ("SIST2_TRAVEL"."TBLPLAN2"."PLACE_NAME")

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
            pstat.setString(13, userId);
            pstat.setString(14, dto.getRdate());
            return pstat.executeUpdate();

//            sql = "select max(plan2seq) from tblPlan2";
//
//            stat = conn.createStatement();
//            rs = stat.executeQuery(sql);
//
//            if(rs.next()){
//                return rs.getInt("plan2seq");
//            }
//            return 0;
        } catch (Exception e) {
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
//            e.printStackTrace();
//        }
//
//        return null;
//    }
    public ArrayList<PlaceDTO> getList(String userId) {
        try {

            String sql = "select * from tblPlan2 where memberid=?"; // todo:일정번호로 바꿔야함

            pstat = conn.prepareStatement(sql);

            pstat.setString(1, userId);

            rs = pstat.executeQuery(); //복붙

            ArrayList<PlaceDTO> list = new ArrayList<PlaceDTO>();

            while (rs.next()) {
                PlaceDTO dto = new PlaceDTO();

                dto.setPlan2seq(rs.getString("plan2seq"));
                dto.setPlace_url(rs.getString("place_url"));
                dto.setPlace_name(rs.getString("place_name"));
                dto.setPhone(rs.getString("phone"));
                dto.setMemberid(rs.getString("memberid"));
                dto.setSeq(rs.getString("seq"));
                dto.setCategory_group_code(rs.getString("category_group_code"));
                dto.setCategory_group_name(rs.getString("category_group_name"));
                dto.setCategory_name(rs.getString("category_name"));
                dto.setId(rs.getString("id"));
                dto.setRdate(rs.getString("rdate"));
                dto.setX(rs.getString("x"));
                dto.setY(rs.getString("y"));
                dto.setAddress_name(rs.getString("address_name"));
                dto.setRoad_address_name(rs.getString("road_address_name"));
                list.add(dto);
            }//end while

            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    public int del(String plan2seq) {
        try {
            String sql = "delete from tblPlan2 where plan2seq =" + plan2seq;
            stat = conn.createStatement();
            return stat.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<PlaceDTO> getList(String rdate, String memberid) {
        try {
//            String str_date = "11-June-07";
//            DateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
//            Date date = formatter.parse(str_date);
//            String from = rdate;
//            DateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
//            Date to = transFormat.parse(from); //Unparseable date: ""
//            String sql = "select * from tblPlan2 where rdate = '"+to+"'" + "and memberid =" + memberid ;
            String sql = "select * from tblPlan2 where rdate = ? and memberid = ?"; //2초
            pstat = conn.prepareStatement(sql);

            pstat.setString(1, rdate);
            pstat.setString(2, memberid);

            rs = pstat.executeQuery(); //SQL command not properly ended
//            java.sql.SQLSyntaxErrorException: ORA-00932: inconsistent datatypes: expected DATE got NUMBER
            ArrayList<PlaceDTO> list = new ArrayList<PlaceDTO>();
            while (rs.next()) {
                PlaceDTO dto = new PlaceDTO();

                dto.setPlan2seq(rs.getString("plan2seq"));
                dto.setPlace_url(rs.getString("place_url"));
                dto.setPlace_name(rs.getString("place_name"));
                dto.setPhone(rs.getString("phone"));
                dto.setMemberid(rs.getString("memberid"));
                dto.setSeq(rs.getString("seq"));
                dto.setCategory_group_code(rs.getString("category_group_code"));
                dto.setCategory_group_name(rs.getString("category_group_name"));
                dto.setCategory_name(rs.getString("category_name"));
                dto.setId(rs.getString("id"));
                dto.setRdate(rs.getString("rdate"));
                dto.setX(rs.getString("x"));
                dto.setY(rs.getString("y"));
                dto.setAddress_name(rs.getString("address_name"));
                list.add(dto);
            }


            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //tblPlan2 seq를 seq[i]로 변경
    public void update(String plan2seq, String seq) {
        try {

            String sql = "update tblPlan2 set seq = ? where plan2seq = ?";

            pstat = conn.prepareStatement(sql);

            pstat.setString(1, seq);
            pstat.setString(2, plan2seq);

            int result = pstat.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
/*

 */
    public PlaceDTO split(String planseq) {
        try {
            String sql = "select * from tblPlan2 where plan2seq = ?";
            pstat = conn.prepareStatement(sql);//"PLANSEQ": invalid identifier
            pstat.setString(1, planseq);
            rs = pstat.executeQuery();

            PlaceDTO dto = new PlaceDTO();
            if (rs.next()) {
                dto.setPlan2seq(rs.getString("plan2seq"));
                dto.setPlace_url(rs.getString("place_url"));
                dto.setPlace_name(rs.getString("place_name"));
                dto.setPhone(rs.getString("phone"));
                dto.setMemberid(rs.getString("memberid"));
                dto.setSeq(rs.getString("seq"));
                dto.setCategory_group_code(rs.getString("category_group_code"));
                dto.setCategory_group_name(rs.getString("category_group_name"));
                dto.setCategory_name(rs.getString("category_name"));
                dto.setId(rs.getString("id"));
                dto.setRdate(rs.getString("rdate"));
                dto.setX(rs.getString("x"));
                dto.setY(rs.getString("y"));
                dto.setAddress_name(rs.getString("address_name"));
                dto.setRoad_address_name(rs.getString("road_address_name"));
            }
            return dto;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

/*
tblSights
SIGHTSSEQ	NUMBER
NAME	VARCHAR2(100 BYTE)                         1
EXPLAIN	VARCHAR2(2000 BYTE) @                      2
ADDRESS	VARCHAR2(500 BYTE)                         3
null IMAGE	VARCHAR2(1000 BYTE) ----? 삭제 @       4
GRADE	NUMBER ----? 삭제 @                        5
WISH	VARCHAR2(10 BYTE)@                         6
THEME	VARCHAR2(100 BYTE) ---?@                   7
SIGHTSX	NUMBER                                     8
SIGHTSY	NUMBER                                     9
PLANDATE	DATE rdate                             10
null BUDGET	NUMBER -----? 삭제 @                   11
SEQ	NUMBER                                         12
URL	VARCHAR2(200 BYTE)                             13
PLANSEQ	NUMBER -> session 전체 일정 planseq        14
ID	VARCHAR2(50 BYTE)                              15
*/

//2021-07-05 00:00:00
//INSERT INTO TEST (DATE) VALUES(     TO_DATE('   20061221000000     ', 'yyyyMMddhh24miss')     )
public void addAD5(PlaceDTO dto, String tblplanseq, String memberid) {
    try {
        String sql = "insert into tblrooms values(seqrooms.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?," +
                " ?, ?, ?)";
//        java.sql.SQLIntegrityConstraintViolationException: ORA-02290: check constraint (SIST2_TRAVEL.SYS_C008957) violated
        String lastCrawlDate = dto.getRdate();
        Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(lastCrawlDate);
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());


        pstat = conn.prepareStatement(sql);

        pstat.setString(1, dto.getPlace_name());
        pstat.setString(2, "");
        pstat.setString(3, dto.getAddress_name());
        pstat.setString(4, "");
        pstat.setString(5, "");
        pstat.setString(6, "y");
        pstat.setString(7, "");
        pstat.setString(8, dto.getX());
        pstat.setString(9, dto.getY());
        pstat.setDate(10, sqlDate);
        pstat.setString(11, "");
        pstat.setString(12, dto.getSeq());
        pstat.setString(13, dto.getPlace_url());
        pstat.setString(14, tblplanseq);
        pstat.setString(15, memberid); // todo: 로그인 구현시 memberid로 바꾸기

        pstat.executeUpdate();

    } catch (Exception e) {
        e.printStackTrace();
    }

}
    public void addAT4(PlaceDTO dto, String tblplanseq, String  memberid) {
        try {
            String sql =
                    "insert into tblSights values(seqSights.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? , " +
                    "?, ?, ?, ?, ?)";

            String lastCrawlDate = dto.getRdate();
            Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(lastCrawlDate);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());


            pstat = conn.prepareStatement(sql);

            pstat.setString(1, dto.getPlace_name());
            pstat.setString(2, "");
            pstat.setString(3, dto.getAddress_name());
            pstat.setString(4, "");
            pstat.setString(5, "");
            pstat.setString(6, "y");
            pstat.setString(7, "");
            pstat.setString(8, dto.getX());
            pstat.setString(9, dto.getY());
            pstat.setDate(10, sqlDate);
            pstat.setString(11, "");
            pstat.setString(12, dto.getSeq());
            pstat.setString(13, dto.getPlace_url());
            pstat.setString(14, tblplanseq);
            pstat.setString(15, memberid); // todo: 로그인 구현시 memberid로 바꾸기

            pstat.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*
    ROOMSSEQ	NUMBER
    NAME	VARCHAR2(50 BYTE)					1
    EXPLAIN	VARCHAR2(4000 BYTE)					2
    ADDRESS	VARCHAR2(200 BYTE)					3
    IMAGE	VARCHAR2(1000 BYTE)					4
    GRADE	NUMBER					            5
    WISH	VARCHAR2(10 BYTE)					6
    THEME	VARCHAR2(100 BYTE)					7
    ROOMSX	NUMBER          					8
    ROOMSY	NUMBER			            		9
    PLANDATE	DATE				        	10
    BUDGET	NUMBER				            	11
    SEQ	NUMBER				                	12
    URL	VARCHAR2(200 BYTE)					    13
    PLANSEQ	NUMBER					            14
    ID	VARCHAR2(50 BYTE)					    15
    */
    //AD5 숙박


/*
RESTAURANTSEQ	NUMBER
NAME	VARCHAR2(100 BYTE)
EXPLAIN	VARCHAR2(2000 BYTE)
ADDRESS	VARCHAR2(500 BYTE)
IMAGE	VARCHAR2(1000 BYTE)
GRADE	NUMBER
WISH	VARCHAR2(10 BYTE)
THEME	VARCHAR2(500 BYTE)
RESTAURANTX	NUMBER
RESTAURANTY	NUMBER
PLANDATE	DATE
BUDGET	NUMBER
SEQ	NUMBER
URL	VARCHAR2(500 BYTE)
PLANSEQ	NUMBER
ID	VARCHAR2(50 BYTE)*/


    //FD6 음식점
    public void addFD6(PlaceDTO dto, String tblplanseq, String memberid) {
        try {

            String sql = "insert into tblrestaurant values(seqrestaurant.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?," +
                    " ?, ?, ?)";
            pstat = conn.prepareStatement(sql);

            String lastCrawlDate = dto.getRdate();
            Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(lastCrawlDate);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());


            pstat = conn.prepareStatement(sql);

            pstat.setString(1, dto.getPlace_name());
            pstat.setString(2, "");
            pstat.setString(3, dto.getAddress_name());
            pstat.setString(4, "");
            pstat.setString(5, "");
            pstat.setString(6, "y");
            pstat.setString(7, "");
            pstat.setString(8, dto.getX());
            pstat.setString(9, dto.getY());
            pstat.setDate(10, sqlDate);
            pstat.setString(11, "");
            pstat.setString(12, dto.getSeq());
            pstat.setString(13, dto.getPlace_url());
            pstat.setString(14, tblplanseq);
            pstat.setString(15, memberid); // todo: 로그인 구현시 memberid로 바꾸기

            pstat.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeAll(String plan2seq) {
        try{
            String sql = "delete from tblPlan2 where plan2seq="+ plan2seq;
            stat = conn.createStatement();

            stat.executeUpdate(sql);

            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}







