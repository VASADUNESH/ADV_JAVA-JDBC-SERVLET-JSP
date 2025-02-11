package classProblems.customer.p2;
import java.sql.*;
import java.util.Scanner;

/*
 * Construct JDBC Application to display Customer details based on PhoneNo.
 
CREATE TABLE Customer69(
phoneno number(15),
name varchar2(15),
city varchar2(15),
mailId varchar2(25),
primary key(phoneno));

INSERT INTO CUSTOMER69(&PHONENO,'&NAME','&CITY','&MAILID');
 */
public class DB_Con2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		try(sc;) {
			
			System.out.println("Enter PhoneNo: ");
			long phoneNo = sc.nextLong();
			sc.nextLine();
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ADVJAVA","DUNESH");
			Statement st = con.createStatement();
			String query="select * from Customer69 where phoneno="+phoneNo+"";
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				System.out.println("Name: "+rs.getString(2)+"\nCity: "+rs.getString(3)+"\nmailId: "+rs.getString(4));
			}
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
