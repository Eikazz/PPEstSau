package vinson;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProgClient {
	
	 public static void main(String args[]) {
		 
	
		   NombreAlea unNombreAlea=new NombreAlea();
		   int numAjout=unNombreAlea.getNombreAlea();
		   boolean trouver;
		   int taille=1000000;
		   
		     	try{
		     		Statement requete =getConnexion().createStatement();
		        
		        ResultSet resultatDest = requete.executeQuery("select * from PALETTE");
		        
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
			        NbIns = requete.executeUpdate("INSERT INTO PALETTE (NUMPAL,NUMCLI) VALUES ("+numAjout+",'C1') ");
			        System.out.println(NbIns+" ligne insérée");
		        }
		        else{
		        System.out.println("Nombre d'enregistrement maximum atteint");
		        }
		            	        	
		       }
		   
		  catch(Exception e) {  System.out.println("Exception"+e);  }
		
		}
	 public static Connection getConnexion() {
	        Connection laConnexion = null;
	 
	        // Charger le driver pour SQL Server 2005
	        try {
	            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            // Etablir la connexion vers la base de données
	            String url = "jdbc:sqlserver://HOS5UC18BIS;database=BDD_PPE4_GESTPALETTE;integratedSecurity=true;";
	                        // "user=test;password=testtest;";
	            
	                laConnexion = DriverManager.getConnection(url);
			        }
	      
	         catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			
	        return laConnexion;
	    }
	}
