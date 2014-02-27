package vinson;
import java.sql.*;


public class ProgClient {
	
	 public static void main(String[] args) {
         Connection conn = null;
         Statement stmt = null;
         ResultSet rs = null;
         
         ResultSet resultatDest;
         Connection con;
         String URL = "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=TEST";
         String Sql = "SELECT * FROM CLIENTS";
         try {
         	Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
                 con = DriverManager.getConnection(URL,"sa",""); 
                 Statement requete = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                 resultatDest = requete.executeQuery(Sql);}
                 
 catch (Exception e) {
               System.out.println(e.getMessage());
               e.printStackTrace();
         } finally {
               if (rs != null)
                     try { rs.close(); } catch (Exception e) { }
               if (stmt != null)
                     try { stmt.close(); } catch (Exception e) { }
               if (conn != null)
                     try { conn.close(); } catch (Exception e) { }
         	}
         }
	 }


