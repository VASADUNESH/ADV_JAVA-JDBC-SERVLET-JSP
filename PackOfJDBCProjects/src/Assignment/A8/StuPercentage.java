package Assignment.A8;
import java.sql.*;
import java.util.*;

/*
 * Construct and Execute Function to display percentage of Student based on rollNo.
 
create or replace function RetriveStuPer(roll varchar2)
return number as per number;
Begin
select percentage into per from stuResult69 where rollNo = roll;
return per;
end;
/
 
 
 
 */
public class StuPercentage {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		try(sc;){
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ADVJAVA","DUNESH");
			CallableStatement cs = con.prepareCall("{call ?:= RetriveStuPer(?)}");
			
			System.out.println("Roll number: ");
			cs.setString(2, sc.nextLine());
			cs.registerOutParameter(1, Types.FLOAT);
			cs.execute();
			
			
			System.out.println("Percentage: "+cs.getFloat(1));
			con.close();
		}
		catch(Exception e){
			e.getStackTrace();
		}
		
	}

}
