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
public class Employee69 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ADVJAVA","DUNESH");
			
			while(true) {
				System.out.println("Employee Operations: \n1.AddEmployee\r\n"
						+ "2.ViewAllEmployees\r\n"
						+ "3.ViewEmployeeById\r\n"
						+ "4.UpdateEmployeeById(bSal,hra,da,totSal)\r\n"
						+ "5.DeleteEmployeeById\n"
						+ "6. Exit"
						+ "\nEnter your Choice: ");
				switch(Integer.parseInt(sc.nextLine())) {
				case 1:
					Employee69Operations.addEmployee(con);
					break;
				case 2:
					Employee69Operations.viewAllEmployees(con);
					break;
				case 3:
					Employee69Operations.viewEmployeeById(con);
					break;
				case 4:
					Employee69Operations.updateEmployeeById(con);
					break;
				case 5:
					Employee69Operations.deleteEmployeeById(con);
					break;
				case 6:
					System.out.println("Program Terminating...\nThank You");
					System.exit(0);
					break;
				default:
					System.err.println("Invalid choice .....  try again");
				}
				
			
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
