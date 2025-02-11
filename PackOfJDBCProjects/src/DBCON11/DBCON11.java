package DBCON11;
import java.sql.*;
import java.util.*;
/*
 * Construct Function to display the balance of BankCustomer based on AccNo
 
create or replace function RetriveBalance69(ano number)
return number as bal number;
begin
	select balance into bal from CustDetails69 where accno = ano;
	return bal;
end;
/

 
 */

public class DBCON11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try(sc;){
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ADVJAVA","DUNESH");
			CallableStatement cs=con.prepareCall("{call ?:= RetriveBalance69(?)}");
			System.out.println("Accno: ");
			cs.setLong(2, sc.nextLong());
			cs.registerOutParameter(1, Types.INTEGER);
			cs.execute();
			
			System.out.println("Balance: "+cs.getInt(1));
			con.close();
			
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		

	}

}
