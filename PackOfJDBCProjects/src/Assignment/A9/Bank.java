package Assignment.A9;

import java.util.*;
import java.sql.*;

/*
 * 
 * Transaction : Transfer amt:5000/- from accNo:8921 to accNo:8922

       Statement-1 : Subtract 5000/- from accNo:8921
       Statement-2 : Add 5000/- to accNo:8922

Create Table : Bank69(accNo,name,balance,AccType)
               Primary Key : accNo

create table Bank69(
accno number(10),
name varchar2(20),
balance number(10),
accType varchar2(10),
primary key(accno));

insert into Bank69 values(8921,'Alex',12000,'savings');
insert into Bank69 values(8922,'Ram',500,'savings');


 */
public class Bank {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		try(sc;){
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ADVJAVA","DUNESH");
			PreparedStatement ps1 = con.prepareStatement("select * from Bank69 where accno=?");
			PreparedStatement ps2 = con.prepareStatement("update Bank69 set balance=balance+? where accno=?");
			
			System.out.println("Status of Commit: "+con.getAutoCommit()); // default commit: true
			con.setAutoCommit(false);
			System.out.println("Status of Commit: "+con.getAutoCommit()); //set commit false
			
			
			Savepoint sp = con.setSavepoint();
			
			System.out.println("Enter the HomeAccNo: ");
			long hAccNo = sc.nextLong();
			ps1.setLong(1, hAccNo);
			ResultSet rs1 = ps1.executeQuery();
			
			if(rs1.next()) {
				float bal = rs1.getFloat(3);
				System.out.println("Enter The benficiallAccNo: ");
				long bAccNo = sc.nextLong();
				ps1.setLong(1, bAccNo);
				ResultSet rs2 = ps1.executeQuery();
				
				if(rs2.next()) {
					System.out.println("Enter the amount to be transferred: ");
					float amt = sc.nextFloat();
					if(amt<=bal) {
						//Accno2
						ps2.setFloat(1, -amt);
						ps2.setLong(2, bAccNo);
						int done1 = ps2.executeUpdate();
						//AccNo1
						ps2.setFloat(1, amt);
						ps2.setLong(2, hAccNo);
						int done2 = ps2.executeUpdate();
						
						if(done1==1 && done2==1) {
							con.commit();
							System.out.println("Transaction Successfull");
						}
						else {
							System.err.println("Transaction failed...");
							con.rollback(sp);
						}
					}
					else {
						System.out.println("Insufficient Balance");
					}
					
				}
				else {
					System.out.println("Invalid bAccNo");
				}
				
			}
			else {
				System.out.println("Invalid HAccNo");
			}

		}
		catch(Exception e) {
			e.getStackTrace();
		}

	}

}
