package classProblems.Bank_Customer2;
import java.sql.*;
import java.util.*;

/*
 * 
 Construct Procedure to retrieve all BankCustomer-Details based on AccNo>

CustDetails69(accno,name,balance,acctype)
CustAddress69(accno,hno,sname,city,state,pincode)
CustContact69(accno,mid,phno)

step-1 : Construct the Procedure


CREATE OR REPLACE PROCEDURE RetrieveCustomer69
( ano number, name out varchar2, bal out number, accType out number, hn out varchar2, sname out varchar2, city out varchar2,
 state out varchar2, pincode out number, mid out varchar2, pno out number) is
begin
	select name, balance, acctype into name, bal, accType from CustDetails69 where accno = ano;
	select hno, sname, city, state, pincode into hn, sname, city, state, pincode from CustAddress69 where accno =ano;
	select mid, phno into mid, pno from CustContact69 where accno = ano;
end;
/


step-2 : Construct JDBC Application to execute Procedure

 */
public class DBCon10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try(sc;) {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ADVJAVA","DUNESH");
			CallableStatement cs = con.prepareCall("{call RetrieveCustomer69(?,?,?,?,?,?,?,?,?,?,?)}");
			
			System.out.println("Enter the Cust-Accno: ");
			cs.setLong(1, sc.nextLong());
			
			for(int i=2; i<=11; i++) {
				cs.registerOutParameter(i, (i==3 || i==9 || i==11)?Types.INTEGER : Types.VARCHAR);
			}
			cs.registerOutParameter(2, Types.VARCHAR);
	    	   cs.registerOutParameter(3, Types.INTEGER);
	    	   cs.registerOutParameter(4, Types.VARCHAR);
	    	   cs.registerOutParameter(5, Types.VARCHAR);
	    	   cs.registerOutParameter(6, Types.VARCHAR);
	    	   cs.registerOutParameter(7, Types.VARCHAR);
	    	   cs.registerOutParameter(8, Types.VARCHAR);
	    	   cs.registerOutParameter(9, Types.INTEGER);
	    	   cs.registerOutParameter(10, Types.VARCHAR);
	    	   cs.registerOutParameter(11, Types.INTEGER);

			cs.execute();
			
			System.out.println("CustomerDetails: ");
			for(int i=1;i<=4;i++) {
				System.out.println(cs.getString(i));
			}
		} 
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
