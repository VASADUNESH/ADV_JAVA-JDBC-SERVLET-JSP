package DAY1;
import java.util.*;
import java.sql.*;
import DB.DB;
/**
 * 
Assignment::Write a jdbc program as follows:
===========
Table Name:Employee_Info.
Table Columns:-empId,empName,empSalary,empAddress,empMailId,empPhNo.

CREATE TABLE Employee_Info(
empId number(5),
empName varchar2(15),
empSalary number(10,2),
empAddress varchar2(20),
empMailId varchar2(20),
empPhno number(15),
primary key (empId));

Note:-

Create table Employee_Info from database directly and perform operations based on user choice.(Use Scanner class to take input from user)
       1.Insert data into Employee Table.
       2.Retrieve all Employee data.
       3.Retrieve employee whose name stats with 'S'.
       4.Retrieve employees whose salary between 10000 to 20000.
       5.Update employee salary with the help of eid.
       6.delete employee who is getting maximum salary.
       7.delete employee whose name ends with 'a';
       8.Exit.
Note:Perform these operations contineously until user press 8(Exit). 
 */


public class EmployeeServices {
	
	public static void CreateTable(Connection con) throws SQLException {
		
		String createTable = "CREATE TABLE Employee_Info("
				+ "empId number(5),"
				+ "empName varchar2(15),"
				+ "empSalary number(10,2),"
				+ "empAddress varchar2(20),"
				+ "empMailId varchar2(20),"
				+ "empPhno number(15),"
				+ "primary key (empId))";
		Statement st = con.createStatement();
		st.executeUpdate(createTable);
	}
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		try {
			Connection con = DB.Connection();
			//CreateTable(con);
			while(true) {
				System.out.println("EmployeeServices \n1.AddEmployee \n2.ViewEmployee \n3.ViewEmployee Names starts with s \n4.Retrieve employees whose salary between 10000 to 20000 \n5.Update employee salary with the help of eid \n6.delete employee who is getting maximum salary \n7.delete employee whose name ends with 'a' \n8.Exit.\nEnter your choice: ");
				switch(Integer.parseInt(sc.nextLine())) {
				
				case 1: Employee_Info.addEmployee();	break;
				case 2: Employee_Info.ViewAllEmp(); 	break;
				case 3: Employee_Info.ViewStartsWithS();break;
				case 4: Employee_Info.salBetween(); 	break;
				case 5: Employee_Info.UpdateSalUSingEid();break;
				case 6: Employee_Info.delMaxsalEmp(); 	break;
				case 7: Employee_Info.delEmpNamestartWitha();break;
				case 8: 
					System.err.println("Employee Services Terminating...");
					Thread.sleep(2000);
					System.out.println("ThankYou");
					System.exit(0);
				default: System.out.println("Invalid Input");
				}
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
