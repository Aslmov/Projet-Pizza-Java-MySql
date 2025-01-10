package pizzaInnodbConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Pizza_connect2 {
	
		

	public static void main(String[] args) {
		 
		System.out.println("********recup�ration des datas de la base mysql***");
		//recup�ration des datas de la base mysql
		System.out.println("connection a mysql pizzaboxinnodb");
			
		String url = "jdbc:mysql://localhost/pizzaboxinnodb";
		
		String login = "root";
		String passwd = "";
		
		Connection cn =null; 
		
		Statement st =null;
		ResultSet rs =null;
 
		try {
			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			
			// Etape 2 : r�cup�ration de la connexion
			cn = DriverManager.getConnection(url, login, passwd);

			// Etape 3 : Cr�ation d'un statement
			st = cn.createStatement();

			String sql = "SELECT * FROM PIZZA"   ;

			// Etape 4 : ex�cution requ�te
			rs = st.executeQuery(sql);
			
			// Si r�cup donn�es alors �tapes 5 (parcours Resultset)
			System.out.println(rs);
			
			while (rs.next()) {
				System.out.println("-----------recup data from mysql------------------------");
				System.out.println(rs.getString("DESIGNPIZZ"));
				System.out.println(rs.getFloat("TARIFPIZZ"));
				System.out.println(rs.getInt("NROPIZZ"));
				System.out.println(rs.getString("image1_chemin"));
				
				//Pizza(String nomPizza, double prixPizza, Integer numeroPizza, String cheminImage)
				 Pizza p1= new Pizza(rs.getString("DESIGNPIZZ"),rs.getFloat("TARIFPIZZ"),rs.getInt("NROPIZZ"),rs.getString("image1_chemin"));
			     System.out.println(p1);//appel a la fonction tostring
			   
			}
			 
			
		} catch (ClassNotFoundException e) {//si il y un probleme de driver
		 
			e.printStackTrace();
			
			
		} catch (SQLException e) {//si il y un probleme de sql
	 
			e.printStackTrace();
		}
		

			
		
		
	}//fin du main 

}//fin de la classe
