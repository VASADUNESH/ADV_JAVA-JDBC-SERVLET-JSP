package classProblems.Bank_Customer;
import java.util.*;
import java.sql.*;

/**
 * 
Construct and execute Stored Procedures:

step-1 : Create the following tables related to Bank-Customer
CustDetails69(accno,name,balance,acctype)
CustAddress69(accno,hno,sname,city,state,pincode)
CustContact69(accno,mid,phno)

CREATE TABLE CUSTDETAILS69(
ACCNO NUMBER(15),
NAME VARCHAR2(15),
BALANCE NUMBER(10,2),
ACCTYPE VARCHAR2(10),
PRIMARY KEY(ACCNO));

CREATE TABLE  CUSTADDRESS69(
ACCNO NUMBER(15) REFERENCES CUSTDETAILS69(ACCNO),
HNO VARCHAR2(15),
SNAME VARCHAR2(15),
CITY VARCHAR2(15),
STATE VARCHAR2(15),
PINCODE NUMBER(10),
PRIMARY KEY(ACCNO)); 

CREATE TABLE CUSTCONTACT69(
ACCNO NUMBER(15) REFERENCES CUSTDETAILS69(ACCNO),
MAILID VARCHAR2(25),
PHNO NUMBER(15),
PRIMARY KEY (ACCNO));

step-2 : Construct Procedure to insert BankCustomer details

CREATE OR REPLACE PROCEDURE CREATECUSTOMER69
(ACCNO NUMBER, NAME VARCHAR2, BAL NUMBER, ATYPE VARCHAR2, HN VARCHAR2,
SNAME VARCHAR2, CITY VARCHAR2, STATE VARCHAR2, PINCODE NUMBER, MD VARCHAR2,
PHNO NUMBER)
IS BEGIN
	INSERT INTO CUSTDETAILS69 VALUES(ACCNO,NAME,BAL,ATYPE);
	INSERT INTO CUSTADDRESS69 VALUES(ACCNO, HN, SNAME, CITY, STATE, PINCODE);
	INSERT INTO CUSTCONTACT69 VALUES(ACCNO, MD, PHNO);
END;
/
 
step-3 : Construct JDBC Application to execute Procedure.

 */
public class DBCon9 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ADVJAVA","DUNESH");
			CallableStatement cs = con.prepareCall("{call CreateCustomer69(?,?,?,?,?,?,?,?,?,?,?)}");
			
			System.out.println("Bank-Customer Form:\nAccountNo: ");		Long aNo = Long.parseLong(sc.nextLine());
			System.out.println("Name: ");							String name = sc.nextLine();
			System.out.println("Balance: ");						Long bal = Long.parseLong(sc.nextLine());
			System.out.println("Account Type: ");					String aType = sc.nextLine();
			System.out.println("Address:\nHouseno.: ");				String hno = sc.nextLine();
			System.out.println("Stree Name: ");						String sn = sc.nextLine();
			System.out.println("City: ");							String city = sc.nextLine();
			System.out.println("State: ");							String state = sc.nextLine();
			System.out.println("PinCode: ");						Long pcode = Long.parseLong(sc.nextLine()); 
			System.out.println("MailId: ");							String MailId = sc.nextLine();
			System.out.println("PhoneNo.: ");						Long phno = Long.parseLong(sc.nextLine());
			
			cs.setLong(1, aNo);
			cs.setString(2, name);
			cs.setLong(3, bal);
			cs.setString(4, aType);
			cs.setString(5, hno);
			cs.setString(6, sn);
			cs.setString(7, city);
			cs.setString(8, state);
			cs.setLong(9, pcode);
			cs.setString(10, MailId);
			cs.setLong(11, phno);
			
			cs.execute();
			System.out.println("Customer Details added to datebase.....");
			con.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
/**
 * Check the output:
 select * from CUSTDETAILS69;
 select * from CUSTADDRESS69;
 select * from CUSTCONTACT69;
 */


