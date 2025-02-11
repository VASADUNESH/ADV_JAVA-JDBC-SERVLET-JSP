package DBCON14;
import java.util.*;
import java.sql.*;
public class DBCON14 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try(sc;){
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ADVJAVA","DUNESH");
			
			System.out.println("DataBase MetaData");
			DatabaseMetaData dmd = con.getMetaData();
			System.out.println("DB ProductName: "+dmd.getDatabaseProductName());
			System.out.println("DB Major Version: "+dmd.getDriverMajorVersion());
			
			
			System.out.println("\nParameter MetaData");
			PreparedStatement ps = con.prepareStatement("update product69 set price=?,qty=? where code=?");
			ParameterMetaData pmd = ps.getParameterMetaData();
			System.out.println("Paramenter Count: "+pmd.getParameterCount());
			
			System.out.println("\nResultSet MetaData");
			PreparedStatement ps2 = con.prepareStatement("select code,price,qty from product69");
			ResultSet rs = ps2.executeQuery();
			System.out.println("-----data from ResultSet----");
        	while(rs.next()) {
        		System.out.println(rs.getString(1)+"\t"+rs.getFloat(2)+"\t"+rs.getInt(3));
        	}//end of loop
        	System.out.println("******ResultSetMetaData******");
        	ResultSetMetaData rsmd = rs.getMetaData();
        	System.out.println("Column Count : "+rsmd.getColumnCount());
        	System.out.println("2nd Column Name : "+rsmd.getColumnName(2));
        	con.close();

			
			
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		
	}

}
