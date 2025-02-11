package test;

/*
 * 
CREATE TABLE USERREG(
Username varchar2(20) primary key,
password varchar2(20),
fName varchar2(15),
lName varchar2(15),
city varchar2(15),
gmail varchar2(25),
phno number(15));

 */
import java.sql.*;

public class RegisterDAO {
	public int k=0;
	public int register(UserBean ub) {
		try {
			Connection con = DBConnection.getCon();
			
			String query="insert into UserReg values(?,?,?,?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, ub.getuName());
			ps.setString(2, ub.getpWord());
			ps.setString(3, ub.getfName());
			ps.setString(4, ub.getlName());
			ps.setString(5, ub.getCity());
			ps.setString(6, ub.getmId());
			ps.setLong(7, ub.getPhNo());
			k=ps.executeUpdate();
		}
		catch(java.sql.SQLIntegrityConstraintViolationException e) {
			System.out.println("Already Register");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return k;
	}
}
