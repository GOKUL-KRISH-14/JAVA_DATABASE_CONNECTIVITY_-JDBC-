package jdbc;
import java.sql.*;
public class DBUtil 
{
	// change the database name
	private static final String URL = "jdbc:mysql://localhost:3306/_Gokul"; 
	 // your MySQL username
    private static final String USER = "root";
    // your MySQL password
    private static final String PASSWORD = "gokul@14"; 

    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
	
	
	
	
}