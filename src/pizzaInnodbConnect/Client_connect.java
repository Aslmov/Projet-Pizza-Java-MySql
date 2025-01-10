package pizzaInnodbConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Client_connect {
	
	public static void main(String[] args) {
		 	
		System.out.println("connection a mysql pizzaboxinnodb");
			
		String url = "jdbc:mysql://localhost:3306/pizzaboxinnodb?allowPublicKeyRetrieval=true&useSSL=false";
		
		String login = "root";
		String passwd = "";
		
		Connection cn =null; 
		Statement st =null;
		ResultSet rs =null;
 
		try {
	
			Class.forName("com.mysql.cj.jdbc.Driver");

			cn = DriverManager.getConnection(url, login, passwd);

	
			st = cn.createStatement();

			String sql = "SELECT * FROM CLIENT  "   ;

	
			rs = st.executeQuery(sql);
			
			
			System.out.println(rs);
			
			while (rs.next()) {
				System.out.println("-----------------------------------");
			/*	System.out.println(rs.getString("NOMCLIE"));
				System.out.println(rs.getString("PRENOMCLIE"));
				System.out.println(rs.getString("ADRESSECLIE"));*/
				Client cl = new Client(null,rs.getString("NOMCLIE"),rs.getString("NOMCLIE"),rs.getString("NOMCLIE"),null,null,null);
				System.out.println(cl);
			}
			
			
		} catch (ClassNotFoundException e) {
		 
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
