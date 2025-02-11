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
public class Employee_Info {
	static Scanner sc = new Scanner(System.in);
	public static void addEmployee() throws SQLException {
		Connection con = DB.Connection();
		PreparedStatement ps = con.prepareStatement("insert into Employee_Info values(?,?,?,?,?,?)");
		
		System.out.println("Employee New Details: \nEMPID: "); ps.setInt(1, Integer.parseInt(sc.nextLine()));
		System.out.println("Name: ");							ps.setString(2, sc.nextLine());
		System.out.println("Salary: ");							ps.setLong(3, Long.parseLong(sc.nextLine()));
		System.out.println("Address: ");						ps.setString(4, sc.nextLine());
		System.out.println("MailID: ");							ps.setString(5, sc.nextLine());
		System.out.println("Phone no.: ");						ps.setLong(6, sc.nextLong());
		
		if(ps.executeUpdate()>0) {
			System.out.println("Employee Added Succesfully...");
		}
		
	}
	public static void ViewAllEmp() {
		
	}
	public static void ViewStartsWithS() {
		
	}
	public static void salBetween() {
		
	}
	public static void UpdateSalUSingEid() {
		
	}
	public static void delMaxsalEmp() {
		
	}
	public static void delEmpNamestartWitha() {
		
	}
}
