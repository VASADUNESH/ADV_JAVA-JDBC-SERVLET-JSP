package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	public static final String PATH = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String DB = "ADVJAVA";
	public static final String PWD ="DUNESH";

	public static Connection Connection() throws SQLException {
		 final Connection con = DriverManager.getConnection(PATH,DB,PWD);
		return con;
	}
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		
	}

}
