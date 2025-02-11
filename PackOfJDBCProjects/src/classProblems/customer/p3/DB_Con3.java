package classProblems.customer.p3;
import java.sql.*;
import java.util.*;

/**
 * 
 *Construct JDBC Application to read Customer details and insert into Customer69 table.
CREATE TABLE Customer69(
phoneno number(15),
name varchar2(15),
city varchar2(15),
mailId varchar2(25),
primary key(phoneno));

INSERT INTO CUSTOMER69(&PHONENO,'&NAME','&CITY','&MAILID');
 */
public class DB_Con3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		final String url = "jdbc:oracle:thin:@localhost:1521:xe";
		final String db = "ADVJAVA";
		final String pwd = "DUNESH";
		try {
			
			System.out.println("Enter the Phone Number: "); long phoneNo = sc.nextLong();sc.nextLine();
			System.out.println("Enter the Name: "); String name = sc.nextLine();
			System.out.println("Enter the city: "); String city = sc.nextLine();
			System.out.println("Enter the MailId: "); String mailId = sc.nextLine();
			
			Connection con = DriverManager.getConnection(url,db,pwd);
			Statement st = con.createStatement();
			
			String query = "insert into customer69 values("+phoneNo+",'"+name+"','"+city+"','"+mailId+"')";
			
			if (st.executeUpdate(query) >0 ) {
				System.out.println("Customer added Successfully...");
			}
		
			con.close();
			
			
		}
		catch(SQLIntegrityConstraintViolationException e) {
			System.err.println("Customer already available...");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
