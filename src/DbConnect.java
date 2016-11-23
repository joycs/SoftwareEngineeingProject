import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class DbConnect {
	public void dbConn(String s,String type){
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		final String DB_URL = "jdbc:mysql://ec2-54-226-9-216.compute-1.amazonaws.com/f2016_s1_user12";
		final String USER = "f2016_s1_user12";
		final String PASS = "f2016_s1_user12";
		Connection conn = null;
		Statement stmt = null;
		try{
			//-----Register JDBC driver
			Class.forName(JDBC_DRIVER);
			
			//-----Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			
			//-----Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			stmt.executeUpdate(s);
			if(type=="insert"){
				System.out.println("Inserted records into the table...");
			}else if(type=="delete"){
				System.out.println("Record deleted...");
			}
			stmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Goodbye!");
	}
}
