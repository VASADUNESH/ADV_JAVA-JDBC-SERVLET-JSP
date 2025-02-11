package classProblems.product.p1;
import java.util.*;
import java.sql.*;
/**
 * Construct JDBC Application to perform the following Operations on Product table.
 
 CREATE TABLE PRODUCT69(
 CODE VARCHAR2(10),
 NAME VARCHAR2(10),
 PRICE NUMBER,
 QTY NUMBER,
 primary key(code));
 
 */
public class DBCon4 {
	
	public static void addProduct(PreparedStatement ps1) throws SQLException {
		System.out.println("Enter the number of Product to add: ");
		int choice =Integer.parseInt(sc.nextLine());
		for(int i=1;i<=choice;i++) {
			System.out.println("Product-"+i+":");
			
			System.out.println("Enter the Product Code: ");String code = sc.nextLine();
			System.out.println("Enter the Product Name: "); String name = sc.nextLine();
			System.out.println("Enter the price: "); int price = Integer.parseInt(sc.nextLine());
			System.out.println("Enter the QTY: ");int qty = Integer.parseInt(sc.nextLine());
			

			ps1.setString(1, code);
			ps1.setString(2, name);
			ps1.setInt(3, price);
			ps1.setInt(4, qty);
			
			if (ps1.executeUpdate()>0) {
				System.out.println("Product added Successfully.....");
			}
			
		
		}
	}
	
	public static void viewProduct(PreparedStatement ps2) throws SQLException {
		ResultSet rs = ps2.executeQuery();
		System.out.println("Product Details: ");
		while(rs.next()) {
			System.out.println("Product Code: "+rs.getString(1)+"\nProduct Name:"+rs.getString(2)+"\nPrice: "+rs.getInt(3)+"\nQty: "+rs.getInt(4)+"\n");
		}
		
	}
	
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {

		
		try {
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ADVJAVA","DUNESH");
			PreparedStatement ps1 = con.prepareStatement("insert into Product69 values(?,?,?,?)");
			PreparedStatement ps2 = con.prepareStatement("select * from Product69");
			
			while(true) {
				System.out.println("Operations:\n1.AddProduct\t2.ViewProduct\t3.Exit\nEnter your Choice");
				switch(Integer.parseInt(sc.nextLine())) {
					case 1:
						addProduct(ps1);
						break;
					case 2:
						viewProduct(ps2);
						break;
					case 3:
						System.out.println("Operations Stopped......");
						System.exit(0);
						break;
					default:
						System.out.println("Invalid Choice......");
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
