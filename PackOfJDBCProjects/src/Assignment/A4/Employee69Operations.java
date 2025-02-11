package Assignment.A4;
import java.util.*;
import java.sql.*;

/**
 * 
 Assignment-4:
step-1 : Created table with name Employee69 from SQLCommandLine
          (eid,ename,edesg,bsal,hra,da,totsal)
           primary key : eid
  Calcution:
      hra : 91% of bSal
      da  : 63% of bSal
      totSal = bSal+hra+da
step-2 : Construct JDBC Application to perform the following operations relatedto employee
         based on choice:
             1.AddEmployee
             2.ViewAllEmployees
             3.ViewEmployeeById
             4.UpdateEmployeeById(bSal,hra,da,totSal)
             5.DeleteEmployeeById

Create table EMPLOYEE69(
EID NUMBER PRIMARY KEY,
ENAME VARCHAR2(20),
EDESG VARCHAR2(20),
BSAL NUMBER,
HRA NUMBER GENERATED ALWAYS AS (BSAL * 0.91) VIRTUAL,
DA NUMBER GENERATED ALWAYS AS (BSAL * 0.63) VIRTUAL,
TOTALSAL NUMBER GENERATED ALWAYS AS (BSAL+(BSAL * 0.91)+(BSAL * 0.63)) VIRTUAL);

 */
public class Employee69Operations {
	static Scanner sc = new Scanner(System.in);
	
	public static void addEmployee(Connection con) throws SQLException {
		System.out.println("Your selected AddEmployee Opearation\nEnter Employee Id: ");
		int eid = Integer.parseInt(sc.nextLine());
		System.out.println("Name of the Employee: ");String ename=sc.nextLine();
		System.out.println("Employee Desgination: ");String edesg=sc.nextLine();
		System.out.println("Employee salary: ");int bsal = Integer.parseInt(sc.nextLine());
		
		PreparedStatement ps = con.prepareStatement("insert into EMPLOYEE69(eid,ename,edesg,bsal) values(?,?,?,?)"); 
		ps.setInt(1, eid);
		ps.setString(2, ename);
		ps.setString(3, edesg);
		ps.setInt(4, bsal);
		
		if(ps.executeUpdate()>0) {
			System.out.println("Employee added successfully\n");
		}
		else {
			System.out.println("Emp already exist");
		}
		
	}
	
	public static void viewAllEmployees(Connection con)throws SQLException{
		PreparedStatement ps = con.prepareStatement("select * from Employee69");
		ResultSet rs = ps.executeQuery();
		System.out.println("All Employee details: ");
		
		while(rs.next()) {
			System.out.println("EId: "+rs.getInt(1)+"\nEname: "+rs.getString(2)+"\nEdesg: "+rs.getString(3)+"\nSal: "+rs.getInt(4)+"\nHra:"+rs.getInt(5)+"\nda: "+rs.getInt(6)+"\ntotsal: "+rs.getInt(7)+"\n");
		}
	}
	
	public static void viewEmployeeById(Connection con) throws SQLException{
		PreparedStatement ps = con.prepareStatement("select * from Employee69 where eid=?");
		System.out.println("Your selected View Employee based on Id Opearation \nEnter the Eid: ");
		ps.setInt(1, sc.nextInt());
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			System.out.println("EId: "+rs.getInt(1)+"\nEname: "+rs.getString(2)+"\nEdesg: "+rs.getString(3)+"\nSal: "+rs.getInt(4)+"\nHra:"+rs.getInt(5)+"\nda: "+rs.getInt(6)+"\ntotsal: "+rs.getInt(7)+"\n");
		}
	}
	
	public static void updateEmployeeById(Connection con) throws SQLException{
		PreparedStatement ps = con.prepareStatement("update Employee69 set edesg=?, bsal=? where eid=?");
		System.out.println("Your selected update Employee based on Id Opearation \nEnter the Eid: ");
		ps.setInt(3, Integer.parseInt(sc.nextLine()));
		System.out.println("Enter Desgination: ");
		ps.setString(1, sc.nextLine());
		System.out.println("Enter Salary: ");
		ps.setInt(2, Integer.parseInt(sc.nextLine()));
		
		if(ps.executeUpdate()>0) {
			System.out.println("Employee Updated Successfully...");
		}
		else {
			System.err.println("not updated");
		}
		
	}
	
	public static void deleteEmployeeById(Connection con) throws SQLException {
		PreparedStatement ps = con.prepareStatement("delete Employee69 where eid=?");
		System.out.println("Your selected delete Employee based on Id Opearation \nEnter the Eid: ");
		ps.setInt(1, Integer.parseInt(sc.nextLine()));
		if(ps.executeUpdate()>0) {
			System.out.println("Employee deleted Successfully...");
		}
		else {
			System.err.println("not updated");
		}
	}
	
}
