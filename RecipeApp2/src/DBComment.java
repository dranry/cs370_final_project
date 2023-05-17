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

public class DBComment {
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
	public static void addComment(String comments, int recipe) throws SQLException {
		Connection con;
		try {
			con = DriverManager.getConnection(getUrl(), getUser(), getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			con = null;
		}
		String sql = " insert into comment (comments, recipe_num)"
			    + " values (?, ?)";
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		  preparedStmt.setString (2, comments);
		  preparedStmt.setInt(3, recipe);
		  preparedStmt.execute();
	}
	
}