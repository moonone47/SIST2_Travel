package travel.plan;

import travel.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CityDAO {

    private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private ResultSet rs;


 	public CityDAO() {
        try {
        	conn = DBUtil.open("183.100.233.88", "sist2_travel", "java1234");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    public ArrayList<CityDTO> list() {
        try {
            String sql = "select * from tblCity";
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);

            ArrayList<CityDTO> citys = new ArrayList<CityDTO>();

            while (rs.next()) {
                CityDTO dto = new CityDTO();
                dto.setCityseq(rs.getString("Cityseq"));
                dto.setName(rs.getString("name"));
                dto.setExplain(rs.getString("explain"));
                dto.setCityX(rs.getString("cityX"));
                dto.setCityY(rs.getString("cityY"));

                citys.add(dto);
            }
            return citys;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    
    public CityDTO getCity(String cityseq) {
        try{
            String sql = "select * from tblCity where cityseq = ? ";
            pstat = conn.prepareStatement(sql);

			pstat.setString(1,cityseq);

            rs = pstat.executeQuery();
            CityDTO dto = new CityDTO();
           if (rs.next()){

                dto.setCityseq(rs.getString("Cityseq"));
                dto.setName(rs.getString("name"));
                dto.setExplain(rs.getString("explain"));
                dto.setCityX(rs.getString("cityX"));
                dto.setCityY(rs.getString("cityY"));
            }
           return dto;

        } catch (Exception e) {
            e.printStackTrace();
        }

 	    return null;
    }
}












