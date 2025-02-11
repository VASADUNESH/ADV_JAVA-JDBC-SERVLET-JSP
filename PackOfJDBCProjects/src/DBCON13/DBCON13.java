package DBCON13;
import java.sql.*;
import java.util.*;

public class DBCON13 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try(sc;){
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ADVJAVA","DUNESH");
			Statement st = con.createStatement();
			System.out.println("Enter Details:\nAccNO:");	long Accno= Long.parseLong(sc.nextLine());
			System.out.println("Cust-Name:");	String name= sc.nextLine();
			System.out.println("Balance: ");	Float bal = Float.parseFloat(sc.nextLine());
			System.out.println("AccType: "); 	String accType= sc.nextLine();
			st.addBatch("insert into Bank69 values("+Accno+",'"+name+"',"+bal+",'"+accType+"')");
			
			  System.out.println("=======Delete operation on Table:Product69=====");
	    	  System.out.println("Enter the Prod-Code to delete product details:");
	    	  String pCode = sc.nextLine();
	    	  st.addBatch("delete from Product69 where code='"+pCode+"'");
	    	  
			int k[] = st.executeBatch();
			
			
			for(int i:k) {
				System.out.println("Query Executed");
			}
			con.close();
		}
		catch(Exception e) {
			e.getStackTrace();
		}
	}
}
