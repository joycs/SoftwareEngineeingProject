import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class DbConnect {
	public void dbConn(String s){
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		final String DB_URL = "jdbc:mysql://ec2-54-226-9-216.compute-1.amazonaws.com/f2016_s1_user12";
		final String USER = "f2016_s1_user12";
		final String PASS = "f2016_s1_user12";
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			//String sql;
			//sql = "SELECT Designation, HourlyRate from Designation Rate ";
			int rowNum = stmt.executeUpdate(s);
			/*ResultSet rs = stmt.executeQuery(s);
			while(rs.next()){
				String value = rs.getString("Designation");
				System.out.println("ID: "+value);
			}*/
			//rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Goodbye!");
	}
}
