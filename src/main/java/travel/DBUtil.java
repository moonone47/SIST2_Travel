package travel;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

   public static Connection open() {

      Connection conn = null;

<<<<<<< HEAD
      String url = "jdbc:oracle:thin:@183.100.233.88:1521:XE";
=======
      String url = "jdbc:oracle:thin:@localhost:1521:xe";
>>>>>>> b799a6d03ed591d19f988f6eb555f11789ae89ee
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



