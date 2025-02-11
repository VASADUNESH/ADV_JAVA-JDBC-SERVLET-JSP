package test;
import java.sql.*;
public class DBConnection {
	private static Connection con =null;
	static {
		try {
			Class.forName(DBInfo.driver);
			con = DriverManager.getConnection(DBInfo.dbURL,DBInfo.uName,DBInfo.pwd);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	private DBConnection() {}
		
		
	public static Connection getCon() {
		return con;
	}
	
}
