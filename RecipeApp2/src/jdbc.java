
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc {
	//variables
	private static String url = "jdbc:mysql:///webrecipe";
	private static String user = "root";
	private static String password = "password";
	
	public static String getUrl() {
		return url;
	}
	
	public static String getUser() {
		return user;
	}
	
	public static String getPassword() {
		return password;
	}
	
	public void connect() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Connection con;
		try {
			con = DriverManager.getConnection(getUrl(), getUser(), getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			con = null;
		}
	
		if (con == null) {
			System.out.println("JDBC connection is not established");
			return;
		} else
			System.out.println("Congrats, " + "JDBC connenction is established successfully.\n");
	
	}
	public static void createUser(String user, String pass) throws SQLException {
		Connection con;
		try {
			con = DriverManager.getConnection(getUrl(), getUser(), getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			con = null;
		}
		String sql = " insert into user_name (id, user_name, user_password)"
			    + " values (?, ?, ?)";
		String s = String.valueOf(RecipeApp.id);
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		  preparedStmt.setString (1, s);
		  preparedStmt.setString (2, user);
		  preparedStmt.setString (3, pass);
		
		RecipeApp.id ++;
	}
	
	public static int checkUser(String user, String pass) throws SQLException {
		Connection con;
		try {
			con = DriverManager.getConnection(getUrl(), getUser(), getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			con = null;
		}
		Statement s = con.createStatement();
		
		
		
		if (user.length()>0 && pass.length()>0)
		{
		    String query = "Select * from user_name Where user_name='" + user + "' and user_password='" + pass + "'";

		    ResultSet rs = s.executeQuery(query);
		    
		   if (rs.next()) 
		   {

		        return 1;
		   } 
		   else 
		   {
		       return 0;
		   }
		}
		else
		{
		      JOptionPane.showMessageDialog(null,"please field username and password ");
		}
		return 0;
		
		
	}
	
		/*Properties p = new Properties();
		p.put("user", "sampleuser");
		p.put("password", "letmein");
		con = DriverManager.getConnection(con,p);
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select * from foodmenu");
		while (rs.next()) {
		System.out.println(rs.getString("item"));
		}
		System.out.println("It works");
		con.close();*/
		

	
	
}
