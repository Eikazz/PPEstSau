package vinson;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProgClient {
	
	 public static void main(String args[]) {
		 
		 
		   String url = "jdbc:odbc:TEST";
		   Connection con = null;
		   NombreAlea unNombreAlea=new NombreAlea();
		   int numAjout=unNombreAlea.getNombreAlea();
		   boolean trouver;
		   int taille=10;
		   
		   try {Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		     	con = DriverManager.getConnection(url,"","");
		        Statement requete = con.createStatement();
		        
		        ResultSet resultatDest = requete.executeQuery("select * from NombreAlea");
		        
		        ArrayList ListNombre = new ArrayList() ; 

		        while(resultatDest.next()) {

		        	ListNombre.add(resultatDest.getInt(1)); 
		        }
		        if (ListNombre.size()!=taille)
		        {
			        do
			        {
			        	trouver=false;
				        for(int i=0;i<ListNombre.size();i++)
				        {
				        	if((ListNombre.get(i).equals(numAjout)))
				        	{
				        		i=ListNombre.size();
				        		trouver=true;
				        		unNombreAlea.ChangeAlea();
								numAjout=unNombreAlea.getNombreAlea();
				        	}
				        }
			        }
			        while(trouver);  
			        int NbIns;
			        NbIns = requete.executeUpdate("INSERT INTO NombreAlea (NombreAlea) VALUES ("+numAjout+") ");
			        System.out.println(NbIns+" ligne insérée");
		        }
		        else{
		        System.out.println("Nombre d'enregistrement maximum atteint");
		        }
		            	        	
		       }
		   
		  catch(Exception e) {  System.out.println("Exception"+e);  }
		  finally {
		     try {con.close();}
		    catch(SQLException e) {e.printStackTrace();}
		    }
		}
	}
