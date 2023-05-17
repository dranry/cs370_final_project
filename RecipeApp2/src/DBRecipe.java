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

public class DBRecipe {
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
	public static void addRecipe(String rN, String rD, String rI) throws SQLException {
		Connection con;
		try {
			con = DriverManager.getConnection(getUrl(), getUser(), getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			con = null;
		}
		String sql = " insert into recipe (name, ingredients, instructions, user_name)"
			    + " values (?, ?, ?, ?)";
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		  preparedStmt.setString (1, rN);
		  preparedStmt.setString (2, rD);
		  preparedStmt.setString (3, rI);
		  preparedStmt.setString (4, RecipeApp.Username);
		  preparedStmt.execute();
	}
	//returns string array, first node is name, second is description, third is instructions, fourth is username
	public static String[] pullRecipe(int x) throws SQLException {
		Connection con;
		try {
			con = DriverManager.getConnection(getUrl(), getUser(), getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			con = null;
		}
		Statement s = con.createStatement();
		String query = "Select * from recipe Where id='" + RecipeApp.recipeNumber + "'";
	    ResultSet rs = s.executeQuery(query);
		String name = null, ingredients = null , instructions = null, user_name = null;
	    while (rs.next()) {
			name = rs.getString(2);
			ingredients = rs.getString(3);
			instructions = rs.getString(4);
			user_name = rs.getString(5);
		}
		String[] strArray = new String[] {name, ingredients, instructions, user_name};	
		return strArray;
		}
	
}
