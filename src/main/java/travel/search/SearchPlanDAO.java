package travel.search;

import travel.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

public class SearchPlanDAO {
    private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private ResultSet rs;

    public SearchPlanDAO() {

        try {
            conn = DBUtil.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public LinkedList<SearchPlanDTO> getAll(String word) {

        try {
            //id 가져오기
            String sql = "select distinct id from tblPlan";
            String id = "";
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            if (rs.next()) {
                id = rs.getString("id");
            }


            //일정에서 id와 쿼리로 찾기
//            sql = "select  from tblplan T inner join TBLCITY T2 on T2.CITYSEQ = T.CITYSEQ where t2.name=? and id=?";
            sql = "select planseq, status, t.name , daystarttravel, dayendtravel, willshare, wish, theme, id, t.cityseq, t2.name as name2, t2.cityy, t2.cityx from tblplan T inner join TBLCITY T2 on T2.CITYSEQ = T.CITYSEQ where t2.name=? and id=?";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, word);
            pstat.setString(2, id);
            rs = pstat.executeQuery();
            LinkedList<SearchPlanDTO> list = new LinkedList<SearchPlanDTO>();
//            planseq status t.name daystarttravel dayendtravel willshare wish theme id t.cityseq t2.name t2.cityy t2.cityx
            while (rs.next()) {
                SearchPlanDTO dto = new SearchPlanDTO();
                dto.setPlanseq(rs.getString("planseq"));
                dto.setStatus(rs.getString("status"));
                dto.setName(rs.getString("name"));
                dto.setDaystarttravel(rs.getString("daystarttravel"));
                dto.setDayendtravel(rs.getString("dayendtravel"));
                dto.setWillshare(rs.getString("willshare"));
                dto.setWish(rs.getString("wish"));
                dto.setTheme("");
                dto.setId(rs.getString("id"));
                dto.setCityseq(rs.getString("cityseq"));
                dto.setCityname(rs.getString("name2"));
                dto.setCityx(rs.getString("cityx"));
                dto.setCityy(rs.getString("cityy"));
                list.add(dto);
                System.out.println((rs.getString("planseq")));
                System.out.println((rs.getString("status")));
                System.out.println((rs.getString("name")));
                System.out.println((rs.getString("daystarttravel")));
                System.out.println((rs.getString("dayendtravel")));
                System.out.println((rs.getString("willshare")));
                System.out.println((rs.getString("wish")));
                System.out.println((rs.getString("theme")));
                System.out.println((rs.getString("id")));
                System.out.println((rs.getString("cityseq")));
                System.out.println((rs.getString("name2")));
                System.out.println((rs.getString("cityx")));
                System.out.println((rs.getString("cityy")));
                System.out.println();
            }
            return list;
        } catch (Exception e) {

            e.printStackTrace();
        }
        return null;
    }
}
