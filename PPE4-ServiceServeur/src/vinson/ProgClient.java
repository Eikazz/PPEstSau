package vinson;
import java.sql.*;

public class ProgClient {
	
	 public static void main(String args[]) {
		 
		   String url = "jdbc:odbc:TEST";
		   Connection con = null;
		   NombreAlea unNombreAlea=new NombreAlea();
		   int numAjout=unNombreAlea.getNombreAlea();
		   boolean verif=false;
		   
		   try {Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		     	con = DriverManager.getConnection(url,"","");
		        Statement requete = con.createStatement();
		        
		        ResultSet resultatDest = requete.executeQuery("select * from NombreAlea");
		        
		        while (resultatDest.next() && verif==false) {
		        	if (numAjout==resultatDest.getInt(1)){
		        		verif=true;
		        	}
                    };
			if (verif==false){
		           int  NbIns ;
		              NbIns = requete.executeUpdate("INSERT INTO NombreAlea (NombreAlea) VALUES ("+numAjout+") ");
		            System.out.println(NbIns+" ligne insérée");}
			else
			{
				
				unNombreAlea.ChangeAlea();
				numAjout=unNombreAlea.getNombreAlea();
				while(resultatDest.next() && verif==true)
				{}
			}
		            
		        	
		       }
		   
		  catch(Exception e) {  System.out.println("Exception"+e);  }
		  finally {
		     try {con.close();}
		    catch(SQLException e) {e.printStackTrace();}
		    }
		}
		}
