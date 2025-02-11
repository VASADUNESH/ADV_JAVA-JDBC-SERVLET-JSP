package Assignment.A5.fileManagement;
import java.sql.*;
import java.util.*;
/*
 * Assignment-5:
step-1 : Create table with name UserStream69
             (phno,name,mid,resume)
             Primary Key : phno

Program-1 : Construct JDBC Application to store resume
Program-2 : Construct JDBC Application to dispaly details based on PhNO.


CREATE TABLE USERSTREAM69(
PHNO NUMBER,
NAME VARCHAR2(10),
MID VARCHAR2(20),
RESUME BLOB,
PRIMARY KEY (PHNO)
);
 */
public class UserStreamMain {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ADVJAVA","DUNESH");
			while(true) {
				System.out.println("1.Store image\t2.Extract image\t3.EXIT \n Enter your choice:");
				switch(Integer.parseInt(sc.nextLine())) {
				case 1:
					UserStream69.storeImage(con);
					break;
				case 2:
					UserStream69.extractImage(con);
					break;
				case 3:
					System.out.println("Thank you");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid choice...");
				}
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
