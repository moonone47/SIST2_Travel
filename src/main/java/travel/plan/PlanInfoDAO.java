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
            System.out.println("${primary_type_name}.${primary_type_name}()");
            e.printStackTrace();
        }
    }
    
    
}
