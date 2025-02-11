package classProblems.customer.p1;
import java.sql.*;

/**
 * CREATE TABLE Customer69(
phoneno number(15),
name varchar2(15),
city varchar2(15),
mailId varchar2(25),
primary key(phoneno));

INSERT INTO CUSTOMER69(&PHONENO,'&NAME','&CITY','&MAILID');
 */

public class DB_Con1 {

	public static void main(String[] args) {
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ADVJAVA","DUNESH");
			
			Statement stm = con.createStatement();
			
			ResultSet rs = stm.executeQuery("select * from CUSTOMER69");
			
			while(rs.next()) {

				System.out.println(rs.getLong(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));

			}
        	

			con.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
