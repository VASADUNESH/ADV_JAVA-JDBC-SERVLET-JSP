package classProblems.product.p2;
import java.util.*;
import java.sql.*;
/**
 * Construct JDBC Application to perform Update and delete operations on Product table based
on Product-Code. 

 CREATE TABLE PRODUCT69(
 CODE VARCHAR2(10),
 NAME VARCHAR2(10),
 PRICE NUMBER,
 QTY NUMBER,
 primary key(code));
 */
public class DBCon5 {
	static Scanner sc = new Scanner(System.in);
	public static void update_Product(PreparedStatement ps1,PreparedStatement ps2,PreparedStatement ps3 ) throws SQLException {
		System.out.println("Enter the Product-code: "); String pC = sc.nextLine();
		ps2.setString(1, pC);
		ResultSet rs = ps2.executeQuery();
		if(rs.next()) {
			System.out.println("Existing Product \nCode: "+rs.getString(1)+"\nProduct Name:"+rs.getString(2)+"\nPrice: "+rs.getInt(3)+"\nQty: "+rs.getInt(4)+"\n");
		}
		System.out.println("Enter update Price : ");
		int price= Integer.parseInt(sc.nextLine());
		System.out.println("Enter update QTY : ");
		int qty = Integer.parseInt(sc.nextLine());
		ps3.setInt(1, price); 
		ps3.setInt(2, qty); 
		ps3.setString(3, pC);
		int K = ps3.executeUpdate();
		System.out.println(K);
		if(K>0) {
			System.out.println("Product Updated Successfully.....");
		}
		else {
			System.out.println("Invalid Product");
		}
		
	}
	public static void delete_product(PreparedStatement ps2, PreparedStatement ps4) throws SQLException {
		
		System.out.println("Enter the Product-code to delete Product: ");
		String pC = sc.nextLine();
		ps2.setString(1, pC);
		ResultSet rs = ps2.executeQuery();
		
		if (rs.next()) {
			ps4.setString(1, pC);
			if(ps4.executeUpdate()>0) {
				System.out.println("Product deleted Successfully...");
			}
		}
		else {
			System.err.println("Invalid Product Code");
		}
	}
	public static void view_product(PreparedStatement ps1) throws SQLException {
		ResultSet rs= ps1.executeQuery();
		System.out.println("Product Details: ");
		while(rs.next()) {
			System.out.println("Product Code: "+rs.getString(1)+"\nProduct Name:"+rs.getString(2)+"\nPrice: "+rs.getInt(3)+"\nQty: "+rs.getInt(4)+"\n");
		}
	}

	public static void main(String[] args) {
		try {
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ADVJAVA","DUNESH");
			PreparedStatement ps1 = con.prepareStatement("select * from Product69");
			PreparedStatement ps2 = con.prepareStatement("select * from Product69 where code=?");
			PreparedStatement ps3 = con.prepareStatement("update Product69 set price=? ,qty=qty+? where code=?");
			PreparedStatement ps4 = con.prepareStatement("delete from Product69 where code=?");
			ResultSet rs =ps1.executeQuery();
			while(true) {
				System.out.println("Operations:\n1.Update\t2.Delete Product\t3.View Products\t4.Exit\nEnter your choice: ");
				switch(Integer.parseInt(sc.nextLine())) {
				case 1:
					update_Product(ps1, ps2,ps3);
					break;
				case 2:
					delete_product(ps2,ps4);
					break;
				case 3:
					view_product(ps1);
					break;
				case 4:
					System.out.println("Operations Stopped...");
					System.exit(0);
				default:
					System.err.println("Invalid choice");
				}
			}
		}
		catch(Exception e) {
			e.getMessage();
		}

	}

}
