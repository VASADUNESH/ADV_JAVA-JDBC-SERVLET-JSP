package Assignment.A3;
import java.sql.*;
import java.util.*;
/*
 * Construct JDBC Application to insert Book details...
 * 
CREATE table BOOKDETAILS69(
BCODE NUMBER primary key,
BNAME VARCHAR2(10),
BAUTHOR VARCHAR2(10),
BPRICE number,
BQTY number);
 */
public class AddBooks {

	public static void main(String[] args) {

		final String url = "jdbc:oracle:thin:@localhost:1521:xe";
		final String db = "ADVJAVA";
		final String pwd = "DUNESH";
		Scanner sc = new Scanner(System.in);
		
		try {
			
			System.out.println("Book Details\nEnter the BCode: "); int BCode = sc.nextInt();sc.nextLine();
			System.out.println("Enter the Book Name: ");  String BName = sc.nextLine();
			System.out.println("Enter the Author: "); String Author = sc.nextLine();
			System.out.println("Enter the Price: "); int BPrice = sc.nextInt();sc.nextLine();
			System.out.println("Enter the Qty: "); int BQty = sc.nextInt();
			
			
			String query = "insert into BookDetails69 values("+BCode+", '"+BName+"','"+Author+"',"+BPrice+","+BQty+")";
			Connection con = DriverManager.getConnection(url,db,pwd);
			Statement st = con.createStatement();
			if(st.executeUpdate(query)>0) {
				System.out.println("Book added Successfully...");
			}
			con.close();
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		

	}

}
