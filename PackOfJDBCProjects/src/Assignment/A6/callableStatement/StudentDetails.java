package Assignment.A6.callableStatement;
import java.util.*;
import java.sql.*;

/**
 *
Assignment-6:
step-1 : Construct the following table related to student.
         StuDetails69(rollno,name,branch)
         StuAddress69(rollno,hno,sname,city,state,pincode)
         StuContact69(rollno,mid,phno)
         StuMarks69(rollno,sub1,sub2,sub3,sub4,sub5,sub6)
         StuResult69(rollno,totmarks,percentage,result)

step-2 : Construct Procedure to insert Student details

step-3 : Construct JDBC application to execute procedure


create table StuDetails69(
rollno varchar2(10),
name varchar2(15),
branch varchar2(10),
primary key(rollno));

create table StuAddress69(
rollno varchar2(10) REFERENCES STUDETAILS69(ROLLNO),
hno varchar2(15),
sname varchar2(15),
city varchar2(15),
state varchar2(15),
pinCode number(10),
primary key(rollno));

create table StuContact69(
rollno varchar2(10) REFERENCES STUDETAILS69(ROLLNO),
MailId varchar2(25),
phno number(15),
primary key (rollno));

create TABLE stuMarks69(
rollno varchar2(10) REFERENCES STUDETAILS69(ROLLNO),
SUB1 NUMBER(3) CHECK(SUB1>0 AND SUB1<=100), 
SUB2 NUMBER(3) CHECK(SUB2>0 AND SUB2<=100),
SUB3 NUMBER(3) CHECK(SUB3>0 AND SUB3<=100),
SUB4 NUMBER(3) CHECK(SUB4>0 AND SUB4<=100),
SUB5 NUMBER(3) CHECK(SUB5>0 AND SUB5<=100),
SUB6 NUMBER(3) CHECK(SUB6>0 AND SUB6<=100),
PRIMARY KEY (ROLLNO));

CREATE TABLE STURESULT69(
ROLLNO VARCHAR2(10) REFERENCES STUDETAILS69(ROLLNO),
TOTMARKS NUMBER(3),
PERCENTAGE NUMBER(5,2),
RESULT VARCHAR2(5),
PRIMARY KEY(ROLLNO));

CREATE OR REPLACE PROCEDURE CREATESTUDENT69
(ROLLNO varchar2, NAME VARCHAR2, BRANCH VARCHAR2, HNO VARCHAR2, SNAME VARCHAR2,
CITY VARCHAR2, STATE VARCHAR2, PINCODE NUMBER, MAILID VARCHAR2, PHNO NUMBER,
SUB1 NUMBER, SUB2 NUMBER, SUB3 NUMBER, SUB4 NUMBER, SUB5 NUMBER, SUB6 NUMBER, TOTMARKS NUMBER, PERCENTAGE NUMBER, RESULT VARCHAR2 )
IS BEGIN
	INSERT INTO STUDETAILS69 VALUES(ROLLNO, NAME ,BRANCH);
	INSERT INTO STUADDRESS69 VALUES(ROLLNO, HNO, SNAME, CITY, STATE, PINCODE);
	INSERT INTO STUCONTACT69 VALUES(ROLLNO, MAILID, PHNO);
	INSERT INTO STUMARKS69 VALUES(ROLLNO, SUB1, SUB2, SUB3, SUB4, SUB5, SUB6);
	INSERT INTO STURESULT69 VALUES(ROLLNO, TOTMARKS, PERCENTAGE, RESULT);
END;
/



 */
public class StudentDetails {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ADVJAVA","DUNESH");
			CallableStatement cs = con.prepareCall("{call Createstudent69(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
			System.out.println("Student Details Form \nRollNumber: ");	cs.setString(1, sc.nextLine());
			System.out.println("Name: ");	 							cs.setString(2, sc.nextLine());
			System.out.println("Branch: ");	 							cs.setString(3, sc.nextLine());
			System.out.println("HNo: "); 								cs.setString(4, sc.nextLine());
			System.out.println("Sname: "); 								cs.setString(5, sc.nextLine());
			System.out.println("City: ");  								cs.setString(6, sc.nextLine());
			System.out.println("State: ");  							cs.setString(7, sc.nextLine());
			System.out.println("PinCode: "); 							cs.setLong(8, Long.parseLong(sc.nextLine()));
			System.out.println("MailId: ");	  							cs.setString(9, sc.nextLine());
			System.out.println("Phone no. : ");  						cs.setLong(10, Long.parseLong(sc.nextLine()));
			System.out.println("Sub1: ");  	int sub1 = Integer.parseInt(sc.nextLine());	cs.setInt(11, sub1);
			System.out.println("Sub2: ");  	int sub2 = Integer.parseInt(sc.nextLine());	cs.setInt(12, sub2);
			System.out.println("Sub3: ");  	int sub3 = Integer.parseInt(sc.nextLine());	cs.setInt(13, sub3);
			System.out.println("Sub4: ");  	int sub4 = Integer.parseInt(sc.nextLine());	cs.setInt(14, sub4);
			System.out.println("Sub5: ");  	int sub5 = Integer.parseInt(sc.nextLine());	cs.setInt(15, sub5);
			System.out.println("Sub6: ");  	int sub6 = Integer.parseInt(sc.nextLine());	cs.setInt(16, sub6);
			
			int total = (sub1+sub2+sub3+sub4+sub5+sub6);
			Double percentage = (double) (total/6);
			String result ="";
			if (percentage >= 90) {
				result ="A";
			}
			else if (percentage >= 80) {
				result ="B";
			}
			else if (percentage >= 70) {
				result ="C";
			}
			else if (percentage >= 60) {
				result ="D";
			}
			else {
				result ="FAIL";
			}
			
			cs.setInt(17, total);
			cs.setDouble(18, percentage);
			cs.setString(19, result);
			cs.execute();
			System.out.println("Students Details added....");
			
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
