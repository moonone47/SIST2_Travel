package travel.plan;

import travel.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PlanInfoDAO {
    private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private ResultSet rs;

    public PlanInfoDAO() {
        try {
            conn = DBUtil.open();
        } catch (Exception e) {
            System.out.println("PlanInfoDAO.PlanINfoDAO()");
            e.printStackTrace();
        }
    }

//    create table TBLPLAN
//            (
//                    PLANSEQ        NUMBER           not null primary key,
//                    STATUS         VARCHAR2(50)     not null check (status in ('0', '1')),
//   NAME           VARCHAR2(200)    not null,
//    DAYSTARTTRAVEL DATE             not null,
//    DAYENDTRAVEL   DATE             not null,
//    WILLSHARE      VARCHAR2(20)     not null check (willShare in ('y', 'n')),
//    WISH           NUMBER default 0 not null,
//    THEME          VARCHAR2(200),
//    ID             VARCHAR2(50)     not null references TBLMEMBER,
//    CITYSEQ        NUMBER references TBLCITY
//)
//private String planseq;
//    private String name;
//    private String daystarttravel;
//    private String dayendtravel;
//    private String willshare;
//    private String wish;
//    private String theme;
//    private String id;
//    private String cityseq;
    public int add(PlanInfoDTO dto) {
        try{
            String sql = "insert into tblPlan (planseq, status, name, daystarttravel, dayendtravel, willshare," +
                    "wish, theme, id, cityseq) values (seqPlan.nextVal, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            pstat = conn.prepareStatement(sql);

            //pstat.setString(1, dto.getPlanseq());
            pstat.setString(1, "0");//status
            pstat.setString(2, dto.getName());//
            pstat.setString(3, dto.getDaystarttravel());
            pstat.setString(4, dto.getDayendtravel());
            pstat.setString(5, dto.getWillshare());//willshare
            pstat.setString(6, "0");//wish
            pstat.setString(7, "");//theme
            pstat.setString(8, "1");//id
            pstat.setString(9, dto.getCityseq());

            return pstat.executeUpdate();

        }catch(Exception e){
            System.out.println("PlanInfoDTO.add");
            e.printStackTrace();
        }
        return 0;
    }
}









