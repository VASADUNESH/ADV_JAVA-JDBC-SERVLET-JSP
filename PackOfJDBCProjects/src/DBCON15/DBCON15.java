package DBCON15;
import java.util.*;
import java.sql.*;

public class DBCON15 {

	public static void main(String[] args)  {
		
		Scanner sc = new Scanner(System.in);
		try(sc;){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ADVJAVA","DUNESH");
			try(con;){
				Statement st = con.createStatement();
				try(st;){
					System.out.println("Enter the query: ");
					int k = st.executeUpdate(sc.nextLine());
					if(k>=0) {
						System.out.println("Query Executed Successfully.....");
					}
					else {
						System.out.println("invalid query");
					}
				}
			}
		}
		catch (ClassNotFoundException e) {
		    System.out.println("JDBC Driver not found.");
		    e.printStackTrace();
		} catch (SQLException e) {
		    System.out.println("Database access error: " + e.getMessage());
		    e.printStackTrace();
		} catch (Exception e) {
		    System.out.println("An unexpected error occurred: " + e.getMessage());
		    e.printStackTrace();
		}


	}

}
