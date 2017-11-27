/**
 * 
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.User;

/**
 * @author ferna
 *
 */
public class UpdateQuery {
	
	private Connection connection;  

	
	public UpdateQuery(String dbName, String uname, String pwd) {
		
		String url = "jdbc:mysql://localhost:3306/"+ dbName;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd); 
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public void doUpdatePassword(String password, User user) {
		
		String query = "UPDATE chemistrydatabase.user SET password=? WHERE email=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			
			ps.setString(1, password);
			ps.setString(2, user.getEmail());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
