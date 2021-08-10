package travel;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 * JDBC로 DB와 서블릿을 연결하는 클래스
 * @author 김정은
 *
 */
public class DBUtil {

	/**
	 * JDBC로 서블릿과 DB를 연결하는 메소드
	 * @return Connection
	 */
    public static Connection open() {

        Connection conn = null;

        String url = "jdbc:oracle:thin:@183.100.233.88:1521:XE";
        String id = "sist2_travel";
        String pw = "java1234";

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, id, pw);

            return conn;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
   
   /**
    * JDBC로 서블릿과 DB를 연결하는 메소드
    * 
    * @param server
    * @param id
    * @param pw
    * @return Connection
    */
   public static Connection open(String server, String id, String pw) {

      Connection conn = null;

      String url = "jdbc:oracle:thin:@" + server + ":1521:xe";
   
      try {

         Class.forName("oracle.jdbc.driver.OracleDriver");
         conn = DriverManager.getConnection(url, id, pw);
         
         return conn;

      } catch (Exception e) {
         e.printStackTrace();
      }
      
      return null;
   }



}



